package Classes;

import Interfaces.iActorBehaviour;

/*
 * @apiNote Акционный клиент
 */
public class ActionClient extends Actor {
    private int idActionClient; //id клиента
/*
 * @apiNote name - имя клиента
 * action - акция, в которой клиент участвует
 */
    public ActionClient(String name, Action action) {
        super(name);
        if (action.getNumsActionParticipant()+1 <= action.getMaximumNumsParticipant()){
            this.idActionClient = action.geIdActionClient();
        } else {
            Market.log.info("Клиент " + name + " не является участником акции " + action.getName() + ". Отказано в обслуживании по акции");
        }
    }
   /*
 * @apiNote Возвращает был ли заказ получен
 */
    public boolean isTakeOrder() {
        return super.isTakeOrder;
    }
/*
 * @apiNote Возвращает был ли заказ создан
 */
    public boolean isMakeOrder() {
        return super.isMakeOrder; 
    }
/*
 * @apiNote Устанавливает флаг-заказ получен
 */
    public void setTakeOrder(boolean val) {
        super.isTakeOrder = val;
    }
    /*
 * @apiNote Устанавливает флаг - заказ создан
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
 */
    @Override
    public void setName(String name) {
        super.name = name;
    }
    /*
 * @apiNote При возврате заказа устанавливается флаг isReturnOrder
 */
    @Override
    public void setReturnOrder(boolean val){
        super.isReturnOrder = val;
        Market.log.info(super.name + " клиент вернул свой заказ ");
    }
    /*
 * @apiNote Возвращает вернули ли заказ
 */
    @Override
    public boolean getReturnOrder(){
        return super.isReturnOrder;
    }
/*
 * @apiNote Возврат заказа. Заказ может быть возвращен, если он создан, получен, но не возвращен ранее
 */
    @Override
    public void returnOrder(iActorBehaviour actor){
        if (this.isMakeOrder && this.isTakeOrder && !this.isReturnOrder){
            actor.setReturnOrder(true);
        }
    }
   
}
