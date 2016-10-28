/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennergame;

import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Simon-Larcher
 */
public class Waffe {
    
    private Random rnd = new Random();
    private String name;
    private int kosten;
    private int lvl;
    private double damage;
    
    private Vector attacken = new Vector();
    
    // Konstruktoren
    
    public Waffe(String name, int kosten, double grundDamage, int lvl, Attacke a1){
        this.name = name;
        this.kosten = kosten;
        this.damage = grundDamage + (0.5 * lvl);
        this.lvl = lvl;
        attacken.add(a1);
    }
    
    public Waffe(String name, int kosten, double grundDamage, int lvl, Attacke a1, Attacke a2){
        this.name = name;
        this.kosten = kosten;
        this.damage = grundDamage + (0.5 * lvl);
        this.lvl = lvl;
        attacken.add(a1);
        attacken.add(a2);
    }
    
    public Waffe(String name, int kosten, double grundDamage, int lvl, Attacke a1, Attacke a2, Attacke a3){
        this.name = name;
        this.kosten = kosten;
        this.damage = grundDamage + (0.5 * lvl);
        this.lvl = lvl;
        attacken.add(a1);
        attacken.add(a2);
        attacken.add(a3);
    }
    
    public Waffe(String name, int kosten, double grundDamage, int lvl, Attacke a1, Attacke a2, Attacke a3, Attacke a4){
        this.name = name;
        this.kosten = kosten;
        this.damage = grundDamage + (0.5 * lvl);
        this.lvl = lvl;
        attacken.add(a1);
        attacken.add(a2);
        attacken.add(a3);
        attacken.add(a4);
    }
    
    public Waffe(String name, int kosten, double grundDamage, int lvl, Attacke a1, Attacke a2, Attacke a3, Attacke a4, Attacke a5){
        this.name = name;
        this.kosten = kosten;
        this.damage = grundDamage + (0.5 * lvl);
        this.lvl = lvl;
        attacken.add(a1);
        attacken.add(a2);
        attacken.add(a3);
        attacken.add(a4);
        attacken.add(a5);
    }
    
    public int rnd(int zahl){
        return getRnd().nextInt(zahl) + 1;
    }
    
//    abstract public double getDamage1();
//    abstract public double getDamage4();
//    
//    public double rnd(double zahl){
//        /*
//        double r = zahl + (zahl * 0.05), rnd; 
//        zahl = zahl - (zahl * 0.05);
//        this.rnd.double(r);
//        while (rnd < zahl){
//          this.rnd.double(r);  
//        }
//        */
//        return zahl;
//    }
    //getter und setter 
    public Random getRnd() {
        return rnd;
    }
    public void setRnd(Random rnd) {
        this.rnd = rnd;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getKosten() {
        return kosten;
    }

    public void setKosten(int kosten) {
        this.kosten = kosten;
    }
    public int getLvl() {
        return lvl;
    }
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
    public double getDamage() {
        return damage;
    }
}
