/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennergame;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Simon-Larcher
 */
public class Arena {
    
    private Penner spieler;
    private Penner bot;
    private Read read;
    private Waffe spieler_waffe;
    private Waffe bot_waffe;
    
    private Random r = new Random();
    private Scanner eingabe = new Scanner(System.in);
    private boolean[] spezialschadenbekommen = new boolean [2];
    private double[] oldDamage = new double[2];
    private double[] spezialschadenProzent = new double[2];
    private double[] leben = new double[2];
    private String[][] name = new String[2][4];
    private double[][] genauigkeit = new double[2][4];
    private double[][] zusatzschaden = new double[2][4];
    private double[][] multiplikator = new double[2][4];
    private double[][] spezialschaden = new double[2][4];
    private int i = -1, ii; // i = user     ii = kampfwahl
    
    
    
    public Arena()
    {
        read = new Read();
    }
    
    public void initializeFight(Penner spieler)
    {
        int waffenslot = -1;
        Boolean r = false;
        this.spieler = spieler;
        bot = new Penner(getRndName());
        System.out.printf("\n|---------- Kampf-Arena ----------|\n\nEin wilder Penner namens %s ist aufgetaucht!\nBitte waehle eine Waffe mit der du kaempfen moechtest!\n");
        spieler.showInventar();
        do {
            System.out.print("Eingabe: ");
            waffenslot = read.zahl() - 1;
            if (waffenslot <= spieler.getInventar().size())
            {
                r = true;
            }
        } while(r == false);
        spieler_waffe = (Waffe) spieler.getInventar().get(waffenslot);
        System.out.printf("Waffe %s (Level: %d) ausgewaehlt!\nMach dich bereit fuer die erste Runde.\n", spieler_waffe.getName(), spieler_waffe.getLvl());
        bot_waffe = getWaffe(spieler_waffe);
        startFight();
    }
    
    private String getRndName()
    {
        String[] namen = {
            "Olaf",
            "Guenther",
            "Vladimir",
            "Vlad",
            "Rohrer",
            "Mustafa",
            "Reinhold",
            "Rizz",
            "Martl",
            "Hons",
            "Garbur",
            "Etl",
            "Trump",
            "Clinton",
            "Baruck Obuma",
            "Spodermen",
            "Luis Durnwalder",
            "Motschuner Peppn",
            "Gilette Abdi",
            "Murat",
            "Osama",
            "Smith"
        };
        return namen[rnd(namen.length - 1)];
    }
    
    private Waffe getWaffe(Waffe waffe)
    {
        int rnd = rnd(2);
        if (rnd == 1)
        {
            return new Faust("Gnackfotz", 666, waffe.getDamage() + 1, waffe.getLvl());
        }
        else
        {
            return new Messer("Kuchlmesser", 666, waffe.getDamage() + 1, waffe.getLvl());
        }
    }
    
    private void startFight()
    {
        for (int i = 1; spieler.getHp() > 0 && bot.getHp() > 0; i++) {
            System.out.printf("-------| Runde %d |-------\n\n", i);
            System.out.printf("%s HP: %i\n%s HP: %i", spieler.getName(), spieler.getHp(), bot.getName(), bot.getHp());
            runde(i);
            
            // TO DOOOOOOOOOO
            
            
            // SPIELER AM ZUG ODER BOT AM ZUG; ANGRIFFSAUSWAHL; BOT-KI; SCHADENSBERECHNUNG!!
        }
        
    }
    
    private void runde(int runde)
    {
        Attacke a;
        if (runde % 2 != 0)
        {
            a = getPlayerAttacke();
        }
        else
        {
            
            a = getBotAttacke();
        }
    }
    
    private Attacke getPlayerAttakce()
    {
        System.out.println("\nMit welcher Attacke moechten Sie angreifen?");
        spieler_waffe.//showAttack
    }
    
    private Attacke getBotAttacke()
    {
        
    }
    
    private void start(){
        while(leben[0] < 1 || leben[1] < 1){
            i = i + 1;
            if (i == 3){
                i = 1;
            }
            for (int x = 0; x < 4; x++){
                if (name[i][x] != null){ 
                }
                else {
                    System.out.printf("[%d] %s", x, name[i][x]);
                }
            }
            System.out.print("Eingabe: ");
            ii = eingabe.nextInt();
            if(i == 0){
                leben[1] = leben[1] - getSpezialschaden(10);
            } 
            else{
                leben[0] = leben[0] - getSpezialschaden(10);
            }
        }
        
        
    }
    
    public double getSpezialschaden(double damage){ //mit spezialschaden 
            // lokale variable in klasse Kampf für spezialschadenbekommen und spezialschadenProzent 

            int rnd = rnd(100);
            if (rnd < (genauigkeit[i][ii] * 100)){ //getroffen
                damage = damage + (damage * zusatzschaden[i][ii]);
                if(spezialschadenbekommen[i]){
                    if(spezialschadenProzent[i] > 0){
                    oldDamage[i] = oldDamage[i] + (oldDamage[i] * spezialschadenProzent[i]);
                    spezialschadenProzent[i] = spezialschadenProzent[i] + multiplikator[i][ii];
                    }
                    else{
                    spezialschadenProzent[i] = spezialschaden[i][ii];
                    damage = damage + oldDamage[i];
                    }
                }
                if (!spezialschadenbekommen[i] && spezialschadenProzent[i] > 0){
                    oldDamage[i] = oldDamage[i] + (oldDamage[i] * spezialschadenProzent[i]);
                    damage = damage + oldDamage[i];
                }
             }        
            else{ //verfehlt
                damage = 0; 
            }
            spezialschadenbekommen[i] = false;  
              //damage = rnd(damage); // toleranz vom effektifen damage 
              return damage;
          }
    
    public int rnd(int i){
        return r.nextInt(i) + 1;
    }
}
