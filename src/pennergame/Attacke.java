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
    
    private String name;
    private double genauigkeit;
    private double schaden;
    private String zusatzschadenName;
    private double zusatzschaden;
    private double multiplikator;
    //multiplikator
    
    public Attacke(String name, double genauigkeit, double schaden)
    {
        this.name = name;
        this.genauigkeit = genauigkeit;
        this.schaden = schaden;
        
    }
    
    public Attacke(String name, double genauigkeit, double schaden, String zusatzschadenName, double zusatzschaden, double multiplikator)
    {
        this.name = name;
        this.genauigkeit = genauigkeit;
        this.schaden = schaden;
        this.zusatzschadenName = zusatzschadenName;
        this.zusatzschaden = zusatzschaden;
    }
    public String getName() {
        return name;
    }
    public double getGenauigkeit() {
        return genauigkeit;
    }
    public double getSchaden() {
        return schaden;
    }
    public String getZusatzschadenName() {
        return zusatzschadenName;
    }
    public double getZusatzschaden() {
        return zusatzschaden;
    }
    
}
