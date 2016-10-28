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
    
    private Attacke a1 = new Attacke("Betonschelle", 0.8, 0);
    private Attacke a2 = new Attacke("Pussyschlag", 1, -0.3);
    private Attacke a3 = new Attacke("Zermetzler", 1, 3);
    
    
    public Faust(String name, int kosten, double grundDamage, int lvl){
        super(name,kosten,grundDamage,lvl,a1,a2,a3);
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
    /*
    
    
    public double getDamege2(){ //70% treffen 10% zusatzschaden pro Runde pro weiteren Stich 4%
          double damage = getGrundDamage() + (0.5 + getLvl());
          int rnd = rnd(10);
          if (rnd < 8){
              if (getLangzeitSchaden() > 0){
                  setLangzeitSchaden(getLangzeitSchaden() + (damage * 0.04));
              }
              setLangzeitSchaden(damage * 0.1);
          }
          else{
              damage = 0;
          }
          damage = rnd(damage);
          return damage;
      }
    
    
    
    
    
    */
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
