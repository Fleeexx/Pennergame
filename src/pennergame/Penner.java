/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennergame;

/**
 *
 * @author Simon-Larcher
 */
public class Penner {
    
    private String name;
    private int hp;
    private int level;
    private int xp;


    public Penner(String name)
    {
        this.name = name;
        hp = 500;
        level = 1;
        xp = 0;
    }
    
    public Penner(String name, int hp, int level, int xp)
    {
        this.name = name;
        this.hp = hp;
        this.level = level;
        this.xp = xp;
    }
    
    
    private void neuSchutz()
    {
        
    }
    private void minusSchutz()
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
    
    
}
