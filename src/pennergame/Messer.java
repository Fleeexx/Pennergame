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
public class Messer extends Waffe{
    
    public Messer(String name, int kosten, double grundDamage, int lvl){
        super(name, kosten, grundDamage, lvl, new Attacke("Werfen", 0.4, 0.8), new Attacke("Schlitzen", 0.7, -0.3, "Schnittwunde", 0.1, 0.04)
                , new Attacke("Stich", 1, -0.1), new Attacke("Puls Aufschneiden", 1, 3));
    }
    
}
