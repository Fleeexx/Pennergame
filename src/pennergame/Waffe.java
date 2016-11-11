/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennergame;

import java.util.Vector;

/**
 *
 * @author Simon-Larcher
 */
public class Waffe {
    
    private String name;
    private int kosten;
    private int lvl;
    private double damage;
    
    private Vector<Attacke> attacken = new Vector();
    
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

    public void showWeaponStats()
    {
        System.out.printf("\n|------------------------------|\nName: %s\nKosten: %d\nDamage: %f\n|------------------------------|\n", name, kosten, damage);
    }
    
    public void showWeaponAttacks()
    {
        System.out.print("\n|----------- Attacken -----------|\n");
        for (int i = 0; i < attacken.size(); i++)
        {
            System.out.println("");
            System.out.printf("(%d) Name: %s\n", i + 1,attacken.get(i).getName());
            System.out.printf("(%d) Genauigkeit: %.0f%s\n", i + 1,(attacken.get(i).getGenauigkeit() * 100), "%");
            System.out.printf("(%d) Damage: %.0f%s\n", i + 1,(attacken.get(i).getZusatzschaden()) * 100, "%");
            if (attacken.get(i).getSpezialschadenName() != null)
            {
                System.out.printf("(%d) Spezialschaden: %s\n", i + 1,attacken.get(i).getSpezialschadenName());
                System.out.printf("(%d) Spezial-Damage: %.0f%s\n", i + 1,(attacken.get(i).getSpezialschaden()) * 100, "%");
            }
            System.out.println("");
        }
        System.out.print("|---------------------------------|\n");
    }
    
    public Vector getAttacken() {
        return attacken;
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
