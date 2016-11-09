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
    private Random r = new Random();
    private Penner penner;
    private Arena arena;
    private Haus haus;
    private Read read = new Read();
    
    private int zeit;
    private int pf;
        
    public Pennerleben(Penner penner){
        this.penner = penner;
    }
    
    public void intro(){
        System.out.print("\n|----------- Pennerleben -----------|\n");
        System.out.printf("Hallo %s! Ich bins wieder! Guenther.\nDu willst jetzt zu den Pennern gehen aber zuerst muss ich dier diese Welt erklähren!\n", penner.getName());
        System.out.print("Du bist in dieser Welt als Penner aufgewachsen und das wird sich nicht aendern! Deswegen bist du gerade im freien und kannst Pf sammeln gehen!\n");
        System.out.print("Je länger du drausen bleibst, desto mehr kannst du finden. \nAber aufpassen! Dies ist ein wichtiger Rat von Guenther! Du kannst auf friedliche oder aggressive Penner treffen!\n");
        System.out.print("|------------- Intro zuende ----------|\n\n\n");
        start();
    }
    
    public void start(){
         fragenWieLange();  // suchsstunden holen
         sucheGehen();
         
    }
    
    public void fragenWieLange(){
        System.out.print("\n|----------- Pennerleben -----------|\n");
        boolean ende = false;
        while (!ende)
            System.out.print("Wie lange bleibst du?\n[1] 1 Stunde\n[2] 2 Stunden\n[3] 5 Sunden\n[4] 10 Stunden\n");
            int zahl = read.zahl();
            if(zeit == 1){
                zeit = 1;
                ende = true;
            }
            else if(zeit == 2){
                zeit = 2;
                ende = true;
            }
            else if(zeit == 3){
                zeit = 5;
                ende = true;
            }
            else{
                zeit = 10;
                ende = true;
            }
    }
    
    public void sucheGehen(){
        int flascheProStunde;
        pf = 0;
        for(int i = 0; i < zeit; i++){    //jede Stunde durchgehen
            flascheProStunde = rnd(15);           //pro stunde kann man 1 - 15 pf finden
            if (rnd(10) == 1){   //wenn 1 ist ist Kampf
                arena = new Arena();
                pennerKampf();
            }
            System.out.printf("%d. Stunde: %d!",i, flascheProStunde);
            pf = pf + flascheProStunde;
        }
    }
    
    public void pennerKampf(){    //wahl zwischen netten oder agressieven Penner
        if (rnd(2) == 1){   //friedlicher Penner
            friedlichePenner();
            System.out.print("[1] JA\n[2] NEIN\n Eingabe: ");
            int zahl = read.zahl();
            if (zahl == 1){    //angriff
                penner.setHp(50);
                arena.inizalizeFreizeitKampf(penner); 
            }
            else{
                System.out.print("Du gehst weiter auf die Suche!\n");
            }
        }
        else{   //agressieve
            aggressivePenner();
            penner.setHp(50);
            arena.inizalizeFreizeitKampf(penner);    //Andere Methode weil das "ein wilder penner namens ..." nicht sein darf
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
            "Ein Penner springt aus den Busch und will Pfandflaschen stehlen. Du hast in als Hunnensohn bezeichnet und er macht sich kampfbereit\n",   // muss man angreifen
            "Du und ein anderer Penner haben Gleichzeitig eine Pfandflasche gefunden! Ihr streitet euch um die Pfandflasche und es entsteht ein Krieg\n",  //beim verlieren verliert man 10% der hauptpfandflaschen
            "Du hast einen Penner kennengelernt der sich CostaGay nennt aber anderst heist. Wegen den Namen hast du ihn so sehr ausgelacht, dass er einen kampf auffordert!\n",
        };
        return namen[rnd(namen.length - 1)];
    }
    
    public void nachHauseOderNicht(){
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
    }  
    
    public int rnd(int i){
        return r.nextInt() + 1;
    }
            
}
