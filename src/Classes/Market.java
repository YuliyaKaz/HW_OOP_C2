package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import Interfaces.iActorBehaviour;
import Interfaces.iMarcketBehaviour;
import Interfaces.iQueueBehaviour;
import Interfaces.iReturnOrder;
import java.io.IOException;

public class Market implements iMarcketBehaviour,iQueueBehaviour, iReturnOrder {
//Очередь клиентов
    private List<iActorBehaviour> queue;
    public static Logger log = Logger.getLogger(Market.class.getName());
    FileHandler fh;
/*
 * @apiNote Конструктор - создает очередь клиентов
 */
    public Market() {
        this.queue = new ArrayList<iActorBehaviour>();
        try{fh = new FileHandler("LogFile.log");
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch(IOException e) {

        }
    }
/*
 * @apiNote Клиент пришел в магазин и добавлен в очередь
 */
    @Override
    public void acceptToMarket(iActorBehaviour actor) {
        log.info(actor.geActor().getName() + " клиент пришел в магазин ");
        takeInQueue(actor);
    }
/*
 * @apiNote Клиент добавлен в очередь
 */
    @Override
    public void takeInQueue(iActorBehaviour actor) {
        this.queue.add(actor);
        log.info(actor.geActor().getName() + " клиент добавлен в очередь ");
    }
/*
 * @apiNote ушел из магазина - выбывает из списка очереди
 */
    @Override
    public void releseFromMarket(List<Actor> actors) {
        for (Actor actor : actors) {
            log.info(actor.getName() + " клиент ушел из магазина ");
            queue.remove(actor);
        }

    }
/*
 * @apiNote Обновление данных клиента после получения заказа - получил заказ, ушел из очереди, ушел из магазина
 */
    @Override
    public void update() {
        takeOrder();
        giveOrder();
        releaseFromQueue();
    }
/*
 * @apiNote Клиент получает сделанный заказ
 */
    @Override
    public void giveOrder() {
        for (iActorBehaviour actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                log.info(actor.geActor().getName() + " клиент получил свой заказ ");
            }
        }
    }
/*
 * @apiNote Очередь из клиентов. Сделавший заказ клиент уходит из очереди
 */
    @Override
    public void releaseFromQueue() {
        List<Actor> releaseActors = new ArrayList<>();
        for (iActorBehaviour actor : queue) {
            if (actor.isTakeOrder()) {
                releaseActors.add(actor.geActor());
                log.info(actor.geActor().getName() + " клиент ушел из очереди ");
            }
        }
        releseFromMarket(releaseActors);
    }
/*
 * @apiNote Клиент сделал заказ
 */
    @Override
    public void takeOrder() {
        for (iActorBehaviour actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                log.info(actor.geActor().getName() + " клиент сделал заказ ");
            }
        }

    }
    @Override
    public void geActor() {
    };
/*
 * @apiNote Клиент возвращает заказ - заходит в магазин, встает в очередь, оформляет возврат, выходит из очереди и из магазина
 * @param actor - клиент
 */
    @Override
    public void returnOrder(iActorBehaviour actor) {
        acceptToMarket(actor);
        actor.setReturnOrder(true);
        releaseFromQueue();        
    }
    /*
    * @apiNote Возврат заказа. Возврат заказа возможен только если заказ сделан и получен, но не возаращен
    */
    @Override
    public void setReturnOrder(boolean val) {
         for (iActorBehaviour actor : queue) {
         if (actor.isMakeOrder() && actor.isTakeOrder() && !actor.getReturnOrder() ) {
                actor.setReturnOrder(val);
                log.info(actor.geActor().getName() + " клиент вернул свой заказ ");
             }
         }
        
    }
    /*
 * @apiNote Клиент сделал заказ
 */
    @Override
    public boolean getReturnOrder(){
        return true;
    }
    public static Logger getLog(){
        return log;
    }
}
    

