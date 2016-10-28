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
    private int hp;
    private int level;
    private int xp;
    private Vector inventar = new Vector();


    public Penner(String name)
    {
        this.name = name;
        hp = 50;
        level = 1;
        xp = 0;
    }
    
    public void showPennerStats()
    {
        //Zeige alle Stats
    }
    
    public void showInventar()
    {
        
    }
    
    // GETTER & SETTER
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getHp() {
        return hp;
    }
    
    public void setHp(int hp) {
        this.hp = hp;
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

    /**
     * @return the inventar
     */
    public Vector getInventar() {
        return inventar;
    }

    /**
     * @param inventar the inventar to set
     */
    public void setInventar(Vector inventar) {
        this.inventar = inventar;
    }
    
}
