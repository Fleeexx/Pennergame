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
        
    public Pennerleben(Penner penner){
        this.penner = penner;
        read = new Read();
        r = new Random();
    }
    
    public void intro()
    {
        System.out.print("\n|----------- Intro -----------|\n");
        System.out.printf("Oh! Hallo %s! Ich bins wieder, Guenther.\nWie ich sehe willst du auch mal was anderes machen ausser kaempfen.\n", penner.getName());
        System.out.print("\nWie waerts denn wenn wir ein paar PF sammeln gehen?\nEingabe: (j/n) j\nAlles klar! Ich erklaer dir kurz wie das funktioniert.\n");
        System.out.print("Je laenger du draussen bleibst, desto mehr kannst du finden. \nAber aufpassen! Dies ist ein wichtiger Rat von Guenther!\nDu bist nicht allein da draussen..");
        System.out.print("\n|-----------------------------|\n\n\n");
        start();
    }
    
    public void start()
    {
        System.out.print("\n|----------- Pennerleben -----------|\n");
        startTrip(askHowLong());
        System.out.print("\n|-----------------------------------|\n\n\n");
    }
    
    public int askHowLong(){
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
    
    public void startTrip(int zeit)
    {
        int fps;
        int totalfps = 0;
        for(int i = 0; i < zeit; i++)
        {
            fps = rnd(15);
            totalfps += fps;
            if (rnd(10) == 1) // wenn 1 ist ist Kampf
            {
                street = new Arena();
                pennerKampf();
            }
            System.out.printf("\n%d. Stunde: %d PF\n", i + 1, fps);
            penner.addMoney(fps);
            System.out.printf("Aktuelle PF-Anzahl: %d\n", penner.getMoney());
            System.out.printf("\nGesamte Anzahl gesammelter PF: %d", totalfps);
        }
    }
    
    public void pennerKampf(){    //wahl zwischen netten oder agressieven Penner
        if (rnd(2) == 1){   //friedlicher Penner
            friedlichePenner();
            System.out.print("[1] JA\n[2] NEIN\n Eingabe: ");
            int zahl = read.zahl();
            if (zahl == 1){    //angriff
                penner.setHp(50);
                street.inizalizeFreizeitKampf(penner); 
            }
            else
            {
                System.out.print("Du gehst weiter auf die Suche!\n");
            }
        }
        else{   //agressieve
            aggressivePenner();
            penner.setHp(50);
            street.inizalizeFreizeitKampf(penner);    //Andere Methode weil das "ein wilder penner namens ..." nicht sein darf
        }
    }
            
    public String friedlichePenner(){
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
    }
    
    /*public void nachHauseOderNicht(){
        System .out.printf("Du hast &d Pfandflaschen gefunden!\n willst du nach Hause gehen oder noch weiter rummluemmeln?\n[1] soffort nach Hause!\n[2] lieber noch ne Runde machen\nEingabe: ", pf);
        int zahl = read.zahl();
        if (zahl == 1){
            System.out.print("|------------- Nach Hause ----------|\n\n\n");
            haus = new Haus();
            haus.menu();
        }
        else{
            start();
        }
    }*/
    
    public int rnd(int i)
    {
        return r.nextInt(i) + 1;
    }
            
}
