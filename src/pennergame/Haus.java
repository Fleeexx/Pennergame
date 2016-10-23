/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennergame;

import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author Simon-Larcher
 */
public class Haus {
    private Scanner zahl = new Scanner(System.in);
    private Scanner zeichen = new Scanner(System.in);
    private Penner penner;
    

    public Haus(){
          
    }
    public void menu(){
        a("[1] Mein Penner\n[2] Schop\n[3] Kämpfen\n[4] Ende\nEingabe: ");
        int eingabe = zahl.nextInt();
        if (eingabe == 1){ //Pennerprofil
            pennerprofil();
        }
        else if(eingabe == 2){ //Waffenkauf
            waffenkauf();
        }
        else if(eingabe == 3){ //Arena
            arena();
        }
        else{
            
        }
    }
    private void pennerprofil(){
        //pennerdaten anzeigen      wenn nicht vorhnden neuen Penner ersteollen
    }
    private void waffenkauf(){
        a("[1] Waffen\n[2] Schutz\n[3] Zurück\nEingabe: ");
        int eingabe = zahl.nextInt();
        if (eingabe == 1){ //
            
        }
        else if(eingabe == 2){ //
            
        }
        else {
            
        }
        
    }
    private void arena(){
        //in arena gehen
    }
    private void a(String z){
        System.out.print(z);
    }
    
    
}
