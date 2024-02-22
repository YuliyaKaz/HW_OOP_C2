package Classes;

import Interfaces.iActorBehaviour;

public class OrdinaryClient extends Actor {
/*
 * @apiNote Присваивает имя клиенту
 * @param name имя клиента
 */
    public OrdinaryClient(String name) {
        super(name);
    }
/*
 * @apiNote Возвращает получен ли заказ
 */
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }
/*
 * @apiNote Возвращает сделан ли заказ
 */
    public boolean isMakeOrder() {
        return super.isMakeOrder; 
    }
/*
 * @apiNote Устанавливает статус - заказ получен
 */
    public void setTakeOrder(boolean val) {
        super.isTakeOrder = val;
    }
    /*
 * @apiNote Устанавливает статус заказ сделан
 */
    public void setMakeOrder(boolean val) {
        super.isMakeOrder = val;        
    }
/*
 * @apiNote Возвращает объект клиента
 */
    public Actor geActor() {
        return this;
    }
/*
 * @apiNote Возвращает имя клиента
 */
    public String getName() {
        return super.name;
    }
/*
 * @apiNote Устанавливает имя клиента
 * @param имя клиента
 */
    @Override
    public void setName(String name) {
        super.name = name;
    }
    /*
 * @apiNote устанавливается флаг - возврат заказа
 */
    @Override
    public void setReturnOrder(boolean val){
        super.isReturnOrder = val;
    }
    
    /*
 * @apiNote возвращает статус возврата
 */
    @Override
    public boolean getReturnOrder(){
        return super.isReturnOrder;
    }
    /*
 * @apiNote Клиент делает возврат. Возврат возможен, если заказ сделан, получен, но возврат еще не оформлен
 */
    @Override
    public void returnOrder(iActorBehaviour actor){
        if (this.isMakeOrder && this.isTakeOrder && !this.isReturnOrder){
            actor.setReturnOrder(true);
            Market.log.info(super.name + " клиент вернул свой заказ ");
        }
    }
}