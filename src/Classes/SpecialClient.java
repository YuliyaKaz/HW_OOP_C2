package Classes;

import Interfaces.iActorBehaviour;
/*
 * @apiNote Специальный клиент
 */
public class SpecialClient extends Actor {
//номер VIP клиента
    private int idVIP;
/*
 * @apiNote Конструктор
 * @param name - имя специального клиента
 * @param idVIP - номер специального клиента
 */
    public SpecialClient(String name, int idVIP) {
        super(name);
        this.idVIP = idVIP;
    }

   /*
 * @apiNote Возвращает получен ли заказ
 */
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }
/*
 * @apiNote Возвращает сдела ли заказ
 */
    public boolean isMakeOrder() {
        return super.isMakeOrder; 
    }
/*
 * @apiNote Подтверждение - заказ получен
 */
    public void setTakeOrder(boolean val) {
        super.isTakeOrder = val;
    }
    /*
 * @apiNote Подтверждение - заказ сделан
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
 * @apiNote Устанавливает имя специального клиента
 */
    @Override
    public void setName(String name) {
        super.name = name;
    }
    /*
 * @apiNote Возврат клиентом заказа - установка флага заказ возвращен
 */
    @Override
    public void setReturnOrder(boolean val){
            super.isReturnOrder = val;
    }
    /*
 * @apiNote Возвращен ли заказ
 */
    @Override
    public boolean getReturnOrder(){
        return super.isReturnOrder;
    }
    /*
 * @apiNote Возврат заказа. Возврат заказа возможен, если заказ был создан, получен, но не был возвращен
 */
    @Override
    public void returnOrder(iActorBehaviour actor){
        if (this.isMakeOrder && this.isTakeOrder && !super.isReturnOrder){
            actor.setReturnOrder(true);
            Market.log.info(super.name + " клиент вернул свой заказ ");
        }
    }
}
