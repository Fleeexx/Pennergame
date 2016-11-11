/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennergame;

import java.util.Random;

/**
 *
 * @author Andere
 */
class Pennerleben {
    //Objekte
    private Random r;
    private Penner penner;
    private Read read;
    private Arena street;
        
    public Pennerleben(Penner penner)
    {
        this.penner = penner;
        read = new Read();
        street = new Arena();
        r = new Random();
    }
    
    public void intro()
    {
        System.out.print("\n|----------- Intro -----------|\n");
        System.out.printf("Oh! Hallo %s! Ich bins wieder, Günther.\nWie ich sehe willst du auch mal was anderes machen ausser kämpfen.\n", penner.getName());
        System.out.print("\nWie wärts denn wenn wir ein paar PF sammeln gehen?\nEingabe: (j/n) j\nAlles klar! Ich erklär dir kurz wie das funktioniert.\n");
        System.out.print("Je länger du draussen bleibst, desto mehr kannst du finden. \nAber aufpassen! Dies ist ein wichtiger Rat von Günther!\nDu bist nicht allein da draussen..");
        System.out.print("\n|-----------------------------|\n\n\n");
        start();
    }
    
    public void start()
    {
        System.out.print("\n|----------- Pennerleben -----------|\n");
        startTrip(askHowLong());
        System.out.print("\n|-----------------------------------|\n\n\n");
    }
    
    private int askHowLong(){
        boolean ende = false;
        int zeit;
        do
        {
            System.out.print("Wie lange bleibst du?\n[1] 1 Stunde\n[2] 2 Stunden\n[3] 5 Sunden\n[4] 10 Stunden\nEingabe: ");
            zeit = read.zahl();
            if(zeit == 1)
            {
                zeit = 1;
                ende = true;
            }
            else if(zeit == 2)
            {
                zeit = 2;
                ende = true;
            }
            else if(zeit == 3)
            {
                zeit = 5;
                ende = true;
            }
            else if (zeit == 4)
            {
                zeit = 10;
                ende = true;
            }
        } while(ende == false);
        return zeit;
    }
    
    private void startTrip(int zeit)
    {
        int fps;
        int totalfps = 0;
        for(int i = 0; i < zeit; i++)
        {
            fps = rnd(15);
            totalfps += fps;
            if (rnd(10) == 5) // wenn rnd = 1 dann wird ein Kampf gestartet
            {
                System.out.println("\n\n\n|---------- Steet-Fight ----------|\n");
                streetFight();
            }
            System.out.printf("\n%d. Stunde: %d PF\n", i + 1, fps);
            penner.addMoney(fps);
            System.out.printf("Aktuelle PF-Anzahl: %d\n", penner.getMoney());
            System.out.printf("\nGesamte Anzahl gesammelter PF: %d", totalfps);
        }
    }
    
    // STREETFIGHT
    
    private void streetFight()
    {
        if (rnd(2) == 1) // Angreifen: Optional
        {
            String botname = street.getRndName();
            System.out.printf(getFriendlyPennerMessage(), botname);
            String eingabe = read.zeichen();
            if (eingabe.toUpperCase().equals("J") || eingabe.toUpperCase().equals("JA"))
            {
                street.initializeFight(penner, botname); // Angriff
            }
            else
            {
                System.out.print("Du gehst weiter auf die Suche!\n");
            }
        }
        else // Angreifen: Muss
        {
            getAngryPennerMessage();
            street.initializeFight(penner, street.getRndName()); // Angriff
        }
    }
    
    private String getFriendlyPennerMessage()
    {
        String[] msg = {
            "Du siehst einen pädophilen Penner der sich hinter einem Baum versteckt und kleine Kinder beobachtet.\nDu erkennst sein Gesicht und er sieht aus wie %s!\nMoechtest du ihn angreifen?\n"
        };
        return msg[rnd(msg.length) - 1];
    }
    
    private String getAngryPennerMessage()
    {
        return "Ein Penner hält dich fest und will eine PF stehlen!\n Somit entsteht ein Kampf!\n";
    }
            
    /*public String friedlichePenner(){
        String[] namen = {
            "Ein Penner namens Rizzolli nennt dich durchaus Geier! Willst du ihn angreifen oder gehen lassen?\n",  // ja = angreifen     nein = gehen
        };
        return namen[rnd(namen.length - 1)];
    }
    
    public String aggressivePenner(){
        String[] namen = {
            "Ein Penner springt aus den Busch und will dir PF stehlen. Du hast ihn als Hunnensohn bezeichnet und er macht sich kampfbereit\n",   // muss man angreifen
            "Du und ein anderer Penner haben Gleichzeitig eine Pfandflasche gefunden! Ihr streitet euch um die Pfandflasche und es entsteht ein Krieg\n",  //beim verlieren verliert man 10% der hauptpfandflaschen
            "Du hast einen Penner kennengelernt der sich CostaGay nennt aber anderst heist. Wegen den Namen hast du ihn so sehr ausgelacht, dass er einen kampf auffordert!\n",
        };
        return namen[rnd(namen.length - 1)];
    }*/
    
    public int rnd(int i)
    {
        return r.nextInt(i) + 1;
    }
            
}
