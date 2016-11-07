/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennergame;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Simon-Larcher
 */
public class Kampf {
    private Random r = new Random();
    private Scanner eingabe = new Scanner(System.in);
    private boolean[] spezialschadenbekommen = new boolean [2];
    private double[] oldDamage = new double[2];
    private double[] spezialschadenProzent = new double[2];
    private double[] leben = new double[2];
    private String[][] name = new String[2][4];
    private double[][] genauigkeit = new double[2][4];
    private double[][] zusatzschaden = new double[2][4];
    private double[][] multiplikator = new double[2][4];
    private double[][] spezialschaden = new double[2][4];
    private int i = -1, ii; // i = user     ii = kampfwahl
    
    
    
    private Kampf(Vector a1, Vector a2, double[] leben){
        this.leben = leben;
        
    }
    
    private void start(){
        while(leben[0] < 1 || leben[1] < 1){
            i = i + 1;
            if (i == 3){
                i = 1;
            }
            for (int x = 0; x < 4; x++){
                if (name[i][x] != null){ 
                }
                else {
                    System.out.printf("[%d] %s", x, name[i][x]);
                }
            }
            System.out.print("Eingabe: ");
            ii = eingabe.nextInt();
            if(i == 0){
                leben[1] = leben[1] - getSpezialschaden(10);
            } 
            else{
                leben[0] = leben[0] - getSpezialschaden(10);
            }
        }
        
        
    }
    public double getSpezialschaden(double damage){ //mit spezialschaden 
            // lokale variable in klasse Kampf für spezialschadenbekommen und spezialschadenProzent 

            int rnd = rnd(100);
            if (rnd < (genauigkeit[i][ii] * 100)){ //getroffen
                damage = damage + (damage * zusatzschaden[i][ii]);
                if(spezialschadenbekommen[i]){
                    if(spezialschadenProzent[i] > 0){
                    oldDamage[i] = oldDamage[i] + (oldDamage[i] * spezialschadenProzent[i]);
                    spezialschadenProzent[i] = spezialschadenProzent[i] + multiplikator[i][ii];
                    }
                    else{
                    spezialschadenProzent[i] = spezialschaden[i][ii];
                    damage = damage + oldDamage[i];
                    }
                }
                if (!spezialschadenbekommen[i] && spezialschadenProzent[i] > 0){
                    oldDamage[i] = oldDamage[i] + (oldDamage[i] * spezialschadenProzent[i]);
                    damage = damage + oldDamage[i];
                }
             }        
            else{ //verfehlt
                damage = 0; 
            }
            spezialschadenbekommen[i] = false;  
              //damage = rnd(damage); // toleranz vom effektifen damage 
              return damage;
          }
    public int rnd(int i){
        return r.nextInt(i) + 1;
    }
}
