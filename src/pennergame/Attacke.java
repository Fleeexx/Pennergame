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
public class Attacke {
    
    private String name; //attackenname
    private double genauigkeit; //treffergenauigkeit
    private double zusatzschaden; //Jede Attacke macht anderen Schaden von Grundschaden aus
    private String spezialschadenName; //Attackenname wie z.b. Schnittwunde oder Verbrennen
    private double spezialschaden; //Schaden von spezialschadenName
    private double multiplikator; //Wenn man den spezialschaden noch einmal einsetzt    
    public Attacke(String name, double genauigkeit, double schaden)
    {
        this.name = name;
        this.genauigkeit = genauigkeit;
        this.zusatzschaden = schaden;
        
    }
    
    public Attacke(String name, double genauigkeit, double zusatzschaden, String spezialschadenName, double spezialschaden)
    {
        this.name = name;
        this.genauigkeit = genauigkeit;
        this.zusatzschaden = zusatzschaden;
        this.spezialschadenName = spezialschadenName;
        this.spezialschaden = spezialschaden;
    }
    public Attacke(String name, double genauigkeit, double zusatzschaden, String spezialschadenName, double spezialschaden, double multiplikator)
    {
        this.name = name;
        this.genauigkeit = genauigkeit;
        this.zusatzschaden = zusatzschaden;
        this.spezialschadenName = spezialschadenName;
        this.spezialschaden = spezialschaden;
        this.multiplikator = multiplikator;
    }
    
    
    public String getName() {
        return name;
    }
    public double getGenauigkeit() {
        return genauigkeit;
    }
    public double getZusatzschaden() {
        return zusatzschaden;
    }
    public String getSpezialschadenName() {
        return spezialschadenName;
    }
    public double getSpezialschaden() {
        return spezialschaden;
    }
    /*
    
    
    public double getDamege(double damage){ 
          
          int rnd = rnd(100);
          if (rnd < (genauigkeit * 100){ //getroffen
              damage = damage + (damage * zusatzschaden);
          else{ //verfehlt
              damage = 0; 
          }
          damage = rnd(damage); // toleranz vom effektifen damage 
          return damage;
      }*/
    
        public double getSpezialschaden(double damage){ //mit spezialschaden 
            // lokale variable in klasse Kampf für spezialschadenbekommen und spezialschadenProzent 
            int rnd = rnd(100);
            if (rnd < (genauigkeit * 100){ //getroffen
                damage = damage + (damage * zusatzschaden);
                if(spezialschadenbekommen){
                    if(spezialschadenProzent > 0){
                    oldDamage = oldDamage + (oldDamage * spezialschadenProzenr);
                    spezialschadenProzent = spezialschadenProzent + multiplikator;
                    }
                    else{
                    spezialschadenProzent = spezialschaden;
                    damage = damage + oldDamage;
                    }
                }
                if (!spezialschadenbekommen && spezialschadenProzent > 0){
                    oldDamage = oldDamage + (oldDamage * spezialschadenProzenr);
                    damage = damage + oldDamage;
                }
             }        
            else{ //verfehlt
                damage = 0; 
            }
            spezialschadenbekommen = false;  
              damage = rnd(damage); // toleranz vom effektifen damage 
              return damage;
          }
    
    
    
    
    
    
}
