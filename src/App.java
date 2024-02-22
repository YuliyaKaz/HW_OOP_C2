import Classes.Actor;
import Classes.Market;

import java.io.FileWriter;
import java.io.IOException;

import Classes.Action;
import Classes.ActionClient;
import Classes.OrdinaryClient;
import Classes.SpecialClient;
import Classes.TaxInspector;
import Interfaces.iActorBehaviour;

import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class App {
    
    public static void main(String[] args) throws Exception {

            Market magnit = new Market();

            iActorBehaviour client1 = new OrdinaryClient("boris");
            iActorBehaviour client2 = new OrdinaryClient("masha");
            iActorBehaviour client3 = new SpecialClient("prezident", 1);
            iActorBehaviour client4 = new TaxInspector();

            Action action4price3 = new Action("Четыре товара по цене трех");
            iActorBehaviour client5 = new ActionClient("Vera", action4price3);
            iActorBehaviour client6 = new ActionClient("Nikolai", action4price3);
            iActorBehaviour client7 = new ActionClient("Victor", action4price3);

            magnit.acceptToMarket(client1);
            magnit.acceptToMarket(client2);
            magnit.acceptToMarket(client3);
            magnit.acceptToMarket(client4);
            magnit.acceptToMarket(client5);
            magnit.acceptToMarket(client6);
            magnit.acceptToMarket(client7);

            magnit.update();
            magnit.returnOrder(client1);
            magnit.returnOrder(client5);
        
           // magnit.getLog();
    }
}
