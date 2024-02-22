package Classes;

import Interfaces.iActorBehaviour;

public class TaxInspector implements iActorBehaviour {
    private String name;
    private boolean isTakeOrder;
    private boolean isMakeOrder;
    private boolean isReturnOrder;
    
/*
 * @apiNote Конструктор
 */
    public TaxInspector() {
        this.name = "Tax Audit";
    }
/*
 * @apiNote Возвращает имя клиента
 */
    public String getName()
    {
        return name;
    }
  /*
 * @apiNote Возвращает получен ли заказ
 */
    public boolean isTakeOrder() {
        return isTakeOrder;
    }
/*
 * @apiNote Возвращает сделан ли заказ
 */
    public boolean isMakeOrder() {
        return isMakeOrder; 
    }
/*
 * @apiNote Устанавливает флаг - заказ получен
 */
    public void setTakeOrder(boolean val) {
        isTakeOrder = val;
    }
    /*
 * @apiNote Устанавливает флаг - заказ сделан
 */
    public void setMakeOrder(boolean val) {
        isMakeOrder = val;        
    }
/*
 * @apiNote Возвращает объект клиента
 */
    @Override
    public Actor geActor() {
        return new OrdinaryClient(name);
    }
    /*
 * @apiNote Клиент возвращает заказ при условии, что заказ сделан, получен, но не возвращен
 */
    @Override
     public void setReturnOrder(boolean val){
        if (isMakeOrder && isTakeOrder && !isReturnOrder){
            isReturnOrder = val;
            System.out.println(name + " клиент вернул свой заказ ");
        }
     }
     /*
 * @apiNote Возвращает возвращен ли заказ
 */
     @Override
     public boolean getReturnOrder(){
         return isReturnOrder;
     }
     /*
 * @apiNote Возврат заказа при условии, что заказ сделан, получен и не возвращен
 *  */
     @Override
     public void returnOrder(iActorBehaviour actor){
        if (isMakeOrder && isTakeOrder && !isReturnOrder){
            actor.setReturnOrder(true);
        }
    }
    
}
