/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennergame;

/**
 *
 * @author Andere
 */
public class Faust extends Waffe{

    public Faust(String name, int kosten, double grundDamage, int lvl){
        super(name,kosten,grundDamage,lvl,new Attacke("Betonschelle", 0.8, 0),new Attacke("Pussyschlag", 1, -0.3),new Attacke("Zermetzler", 1, 3));   
    }


}
