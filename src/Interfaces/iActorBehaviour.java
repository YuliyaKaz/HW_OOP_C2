package Interfaces;

import Classes.Actor;

public interface iActorBehaviour extends iReturnOrder {
    public boolean isTakeOrder();
    public boolean isMakeOrder();
    public void setTakeOrder(boolean val); 
    public void setMakeOrder(boolean val); 
    public Actor geActor(); 
}
