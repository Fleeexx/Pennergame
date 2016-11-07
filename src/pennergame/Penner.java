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
public class Penner {
    
    private String name;
    private double hp;
    private int level;
    private int xp;
    private int money;
    private Boolean spezialschadenBekomen;
    private Vector<Waffe> inventar = new Vector();


    public Penner(String name)
    {
        this.name = name;
        hp = 50;
        level = 1;
        xp = 0;
    }
    
    public void showPennerStats()
    {
        System.out.printf("\n|---------- Mein Penner ----------|\nName: %s\nLevel: %d\nXP: %d/100\nPF: %d\n|---------------------------------|\n", name, level, xp, money);
        showInventar();
    }
    
    public void showInventar()
    {
        System.out.print("\n|----------- Inventory -----------|\n");
        for (int i = 0; i < inventar.size(); i++)
        {
            System.out.printf("(%d) Name: %s\n", i + 1,inventar.get(i).getName());
            System.out.printf("(%d) Level: %d\n", i + 1,inventar.get(i).getLvl());
            System.out.printf("(%d) Damage: %f\n\n\n", i + 1,inventar.get(i).getDamage());
        }
        System.out.print("\n|---------------------------------|\n");
    }
    
    // GETTER & SETTER
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getHp() {
        return hp;
    }
    
    public void setHp(double hp) {
        this.hp = hp;
    }
    
    public void addHp(double hp) {
        this.hp += hp;
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
    public int getXp() {
        return xp;
    }
    
    public void setXp(int xp) {
        this.xp = xp;
    }
    
    public int getMoney() {
        return money;
    }
    
    public void setMoney(int money) {
        this.money = money;
    }
    
    public void addMoney(int money) {
        this.money += money;
    }
    
    public Vector getInventar() {
        return inventar;
    }
    
    public void addInventar(Waffe o) {
        inventar.add(o);
    }
    
}
