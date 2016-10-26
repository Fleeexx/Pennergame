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
        super(name,kosten,grundDamage,lvl);
        String []attake = {"Faustschlag", " ", " ", "Zermetzler"};
        setAttakenname(attake);
    }
//    @Override
//    public double getDamage1(){   //80%treffersicherheit    normalschaden
//        double damage = getGrundDamage() + (0.5 + getLvl());
//        int rnd = rnd(10);
//        if (rnd < 9){
//        }
//        else{
//            damage = 0;
//        }
//        damage = rnd(damage);
//        return damage;
//    }
//
//    @Override
//    public double getDamage4() {
//        double damage = (getGrundDamage() + (0.5 + getLvl()));
//        if (getSpezialattake()){
//            damage = damage * 3;
//        }
//        damage = rnd(damage);
//        return damage;
//    }

}
