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
    private boolean[] spezialschadenbekommen = new boolean[2];
    private double[] oldDamage = new double[2];
    private double[] spezialschaden = new double[2];
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
        System.out.printf("\n|---------- Kampf-Arena ----------|\n\nEin wilder Penner namens %s ist aufgetaucht!\nBitte waehle eine Waffe mit der du kaempfen moechtest!\n", bot.getName());
        spieler.showInventar();
        do {
            System.out.print("Eingabe: ");
            waffenslot = read.zahl() - 1;
            if (waffenslot <= spieler.getInventar().size() && waffenslot >= 0)
            {
                r = true;
            }
        } while(r == false);
        spieler_waffe = (Waffe) spieler.getInventar().get(waffenslot);
        System.out.printf("Waffe %s (Level: %d) ausgewaehlt!\nMach dich bereit fuer die erste Runde.", spieler_waffe.getName(), spieler_waffe.getLvl());
        bot_waffe = getWaffe(spieler_waffe);
        startFight();
    }
    public void inizalizeFreizeitKampf(Penner spieler){
        int waffenslot = -1;
        Boolean r = false;
        this.spieler = spieler;
        bot = new Penner(getRndName());
        spieler.showInventar();
        do {
            System.out.print("Eingabe: ");
            waffenslot = read.zahl() - 1;
            if (waffenslot <= spieler.getInventar().size() && waffenslot >= 0)
            {
                r = true;
            }
        } while(r == false);
        spieler_waffe = (Waffe) spieler.getInventar().get(waffenslot);
        System.out.printf("Waffe %s (Level: %d) ausgewaehlt!\nMach dich bereit fuer die erste Runde.", spieler_waffe.getName(), spieler_waffe.getLvl());
        bot_waffe = getWaffe(spieler_waffe);
        startFight();
    }
    private String getRndName()
    {
        String[] namen = {
            "Olaf",
            "Guenther",
            "Vladimir",
            "Kuen Penner",
            "Vlad",
            "Rohrer",
            "Kuen Penner",
            "Mustafa",
            "Reinhold",
            "Rizz",
            "Martl",
            "Kuen Penner",
            "Hons",
            "Garbur",
            "Kuen Penner",
            "Etl",
            "Trump",
            "Kuen Penner",
            "Clinton",
            "Baruck Obuma",
            "Spodermen",
            "Luis Durnwalder",
            "Kuen Penner",
            "Motschuner Peppn",
            "Kuen Penner",
            "Gilette Abdi",
            "Murat",
            "Osama",
            "Smith",
            "Kuen Penner",
            "Loop",
            "Herr der Illuminaten",
            "xX3Illuminati3Xx",
            "Billiboy Gates",
            "Kuen Penner"
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
        for (int i = 1; spieler.getHp() > 0 && bot.getHp() > 0; i++)
        {
            System.out.printf("\n\n-------| Runde %d |-------\n\n", i);
            System.out.printf("%ss HP: %f\n%ss HP: %f\n\n", spieler.getName(), spieler.getHp(), bot.getName(), bot.getHp());
            runde(i);
            
            // TO DOOOOOOOOOO
            
            
            // XP + Penner losst PF folln
        }
        int reward = (rnd(8) + 1) * 10;
        //int xp = spieler.getLevel() * ;
        if (bot.getHp() <= 0)
        {
            System.out.printf("%s wurde besiegt!\nDu erhaelst %d",bot.getName(), reward);
            spieler.addMoney(reward);
        }
        else
        {
            System.out.printf("Du wurdest besiegt!\nDu verlierst waehrend du fluechtest %d PF.", reward / 2);
            spieler.addMoney((reward / 2) * -1);
        }
    }
    
    private void runde(int runde)
    {
        Attacke a;
        double schaden;
        if (runde % 2 != 0)
        {
            a = getPlayerAttacke();
            if (a.getSpezialschaden() > 0)
                spezialschadenbekommen[0] = true;
            schaden = getSpezialschaden(a, spieler_waffe.getDamage(), 0);
            bot.addHp(schaden);
            // Abfrage ob Schaden = 0 ==== verfehlt!
            System.out.printf("Du hast %s eingesetzt.\n", a.getName());
            if (schaden < 0)
            {
                System.out.printf("Die Attacke traf %s und richtete %f Schaden an.", bot.getName(), schaden * -1);
            }
            else
            {
                System.out.println("Hoppla! Du hast nicht getroffen.");
            }
        }
        else
        {
            a = getBotAttacke();
            if (a.getSpezialschaden() > 0)
                spezialschadenbekommen[1] = true;
            schaden = getSpezialschaden(a, bot_waffe.getDamage(), 1);
            spieler.addHp(schaden);
            System.out.printf("%s hat %s eingesetzt.\n", bot.getName(), a.getName());
            if (schaden < 0)
            {
                System.out.printf("Die Attacke traf dich und richtete %f Schaden an.", schaden * -1);
            }
            else
            {
                System.out.printf("Hah! %s ist ausgerutscht und hat sich selbst verletzt.", bot.getName());
                bot.addHp(rnd(10) * -1);
            }
        }
    }
    
    private Attacke getPlayerAttacke()
    {
        System.out.println("\nMit welcher Attacke moechten Sie angreifen?");
        spieler_waffe.showWeaponAttacks();
        int attackenslot = -1;
        Boolean r = false;
        do {
            System.out.print("Eingabe: ");
            attackenslot = read.zahl() - 1;
            if (attackenslot <= spieler_waffe.getAttacken().size() && attackenslot >= 0)
            {
                r = true;
            }
        } while(r == false);
        return (Attacke) spieler_waffe.getAttacken().get(attackenslot);
    }
    
    private Attacke getBotAttacke()
    {
        return (Attacke) bot_waffe.getAttacken().get(rnd(bot_waffe.getAttacken().size() - 1));
    }
    
    private double getSpezialschaden(Attacke a, double damage, int i){ //mit spezialschaden 
            // lokale variable in klasse Kampf für spezialschadenbekommen und spezialschadenProzent 
            
            int rnd = rnd(100);
            if (rnd < (a.getGenauigkeit() * 100)){ //getroffen
                damage = damage + (damage * a.getZusatzschaden());
                if(spezialschadenbekommen[i]) {
                    if(a.getSpezialschaden() > 0){
                    oldDamage[i] = oldDamage[i] + (oldDamage[i] * spezialschaden[i]);
                    spezialschaden[i] = spezialschaden[i] + a.getMultiplikator();
                    }
                    else{
                    spezialschaden[i] = a.getSpezialschaden();
                    damage = damage + oldDamage[i];
                    }
                }
                else if (!spezialschadenbekommen[i] && spezialschaden[i] > 0) {
                    oldDamage[i] = oldDamage[i] + (oldDamage[i] * spezialschaden[i]);
                    damage = damage + oldDamage[i];
                }
            }
            else
            { //verfehlt
                damage = 0;
            }
            spezialschadenbekommen[i] = false;
            //damage = rnd(damage); // toleranz vom effektifen damage 
            return damage * -1;
          }
    
    public int rnd(int i){
        return r.nextInt(i) + 1;
    }
}
