/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennergame;

import java.util.Random;

/**
 *
 * @author Andere
 */
class Pennerleben {
    //Objekte
    private Random r = new Random();
    private Penner penner;
    private Read read = new Read();
    
    
    private int zeit;
    private boolean pennerkampf;
        
    
    
    public Pennerleben(Penner penner){
        this.penner = penner;
    }
    public void intro(){
        System.out.print("\n|----------- Pennerleben -----------|\n");
        System.out.printf("Hallo %s! Ich bins wieder! Guenther.\nDu willst jetzt zu den Pennern gehen aber zuerst muss ich dier diese Welt erklähren!\n", penner.getName());
        System.out.print("Du bist in dieser Welt als Penner aufgewachsen und das wird sich nicht aendern! Deswegen bist du gerade im freien und kannst Pf sammeln gehen!\n");
        System.out.print("Je länger du drausen bleibst, desto mehr kannst du finden. \nAber aufpassen! Dies ist ein wichtiger Rat von Guenther! Du kannst auf friedliche oder aggressive Penner treffen!\n");
        System.out.print("|------------- Intro zuende ----------|\n\n\n");
    }
    public void start(){
         
    }
    public void fragenWieLange(){
        System.out.print("\n|----------- Pennerleben -----------|\n");
        System.out.print("Wie lange bleibst du?\n[1] 1 Stunde\n[2] 2 Stunden\n[3] 5 Sunden\n[4] 10 Stunden\n");
        zeit = read.zahl();
        if(zeit == 1){
            zeit = 1;
        }
        else if(zeit == 2){
            zeit = 2;
        }
        else if(zeit == 3){
            zeit = 5;
        }
        else{
            zeit = 10;
        }
    }
}
