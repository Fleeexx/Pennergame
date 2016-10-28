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
    
    
    private double langzeitSchaden;
    private Attacke a1 = new Attacke("Werfen", 0.4, 0.8);
    private Attacke a2 = new Attacke("Schlitzen", 0.7, -0.3, "Schnittwunde", 0.1, 0.04);
    private Attacke a3 = new Attacke("Stich", 1, -0.1);
    private Attacke a4 = new Attacke("Puls Aufschneiden", 1, 3);
    
    public Messer(String name, int kosten, double grundDamage, int lvl){
        super(name,kosten,grundDamage,lvl,a1,a2,a3,a4);   
    }
//    @Override
//    public double getDamage1(){   //60% verfehlen   //80%mehr Schaden
//        double damage = getGrundDamage() + (0.5 + getLvl());
//        int rnd = rnd(10);
//        if (rnd < 7){
//            damage = 0;
//        }
//        else{
//            damage = damage + (damage * 0.8);
//        }
//        damage = rnd(damage);
//        return damage;
//    }
//    @Override
//    public double getDamage4() {
//        double damage = (getGrundDamage() + (0.5 + getLvl()));
//        if (getSpezialattake()){
//            damage = damage * 3;
//            langzeitSchaden = langzeitSchaden + (damage * 0.2);
//        }
//        damage = rnd(damage);
//        
//        return damage;
//    }
//    public double getDamege2(){ //70% treffen 10% zusatzschaden pro Runde pro weiteren Stich 4%
//        double damage = getGrundDamage() + (0.5 + getLvl());
//        int rnd = rnd(10);
//        if (rnd < 8){
//            if (getLangzeitSchaden() > 0){
//                setLangzeitSchaden(getLangzeitSchaden() + (damage * 0.04));
//            }
//            setLangzeitSchaden(damage * 0.1);
//        }
//        else{
//            damage = 0;
//        }
//        damage = rnd(damage);
//        return damage;
//    }
//    public double getDamege3(){ //100% treffen 10% weniger Schaden
//        double damage = (getGrundDamage() + (0.5 + getLvl()));
//        damage = damage - (damage * 0.1);
//        damage = rnd(damage);
//        return damage;
//    }
//    
    //getter und setter
    public double getLangzeitSchaden() {
        return langzeitSchaden;
    }
    public void setLangzeitSchaden(double langzeitSchaden) {
        this.langzeitSchaden = langzeitSchaden;
    }

    
    
    
}
