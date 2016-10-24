/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennergame;

import java.util.Random;

/**
 *
 * @author Simon-Larcher
 */
public class Waffe {
    
    private Random rnd = new Random();
    private String name;
    private int kosten;
    private int lvl;
    private double grundDamege;
    
    public Waffe(String name, int kosten, double grundDamage, int lvl){
        this.name = name;
        this.kosten = kosten;
        this.grundDamege = grundDamage;
        this.lvl = lvl;
    }
    public double getDamege(){
        double damage = getGrundDamege() + (0.5 + getLvl());
        int rnd = rnd(10);
        if (rnd < 7){
            
        }
        else if (rnd < 9){
            damage = damage / 2.5;
        }
        else{
            damage = damage * 2;
        }
        damage = rnd(damage);
        return damage;
    }
    public int rnd(int zahl){
        return getRnd().nextInt(zahl) + 1;
    }
    public double rnd(double zahl){
        /*
        double r = zahl + (zahl * 0.05), rnd; 
        zahl = zahl - (zahl * 0.05);
        this.rnd.double(r);
        while (rnd < zahl){
          this.rnd.double(r);  
        }
        */
        return zahl;
    }

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
    public double getGrundDamege() {
        return grundDamege;
    }
    public void setGrundDamege(double grundDamege) {
        this.grundDamege = grundDamege;
    }
    
}
