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
public class Handy extends Waffe {
    
    public Handy(String name, int kosten, double grundDamage, int lvl){
        super(name, kosten, grundDamage, lvl, new Attacke("Samsung(explosion)", 0.8, 1, "Ätzen", 0.1, 0.04)
                , new Attacke("Apple(Splittergranate)", 0.9, 1), new Attacke("Nokia(Erdbeben)", 1, 3));
    }
    
}
