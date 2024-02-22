package Classes;

import Interfaces.iActorBehaviour;
import Interfaces.iReturnOrder;
/*
     * @apiNote Покупатель
     * name - имя покупателя
     * isTakeOrder - заказ был получен
     * isMakeOrder - заказ был создан
     * isReturnOrder - заказ был возвращен
     */
public abstract class Actor implements iActorBehaviour{
    protected String name;
    protected boolean isTakeOrder;//заказ забран
    protected boolean isMakeOrder;//заказ сделан
    protected boolean isReturnOrder;//заказ возвращен

    public Actor(String name) {
        this.name = name;
    }

    public abstract String getName();
    public abstract void setName(String name);
}





