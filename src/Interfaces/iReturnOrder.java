package Interfaces;

import Classes.Actor;
/*
 * @apiNote интерфейс, реализующий возврат товара
 */
public interface iReturnOrder {
    public boolean getReturnOrder();
    public void setReturnOrder(boolean val); 
    public void returnOrder(iActorBehaviour actor);
} 
