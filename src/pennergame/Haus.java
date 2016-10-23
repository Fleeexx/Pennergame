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
    
    private Scanner zahl;
    private Scanner zeichen;
    private Penner penner;
    

    public Haus()
    {
        zahl = new Scanner(System.in);
        zeichen = new Scanner(System.in);
    }
    
    public void menu(){
        
        Boolean r = true;
        
        do {
            System.out.println("[1] Mein Penner\n[2] Shop\n[3] Kämpfen\n[4] Ende\n[0] Exit\nEingabe: ");
            int eingabe = zahl.nextInt();
            if (eingabe == 1) // Mein Penner
            {
                pennerprofil();
            }
            else if (eingabe == 2) // Shop
            {
                waffenkauf();
            }
            else if (eingabe == 3) // Arena
            {
                
            }
            else if (eingabe == 0)
            {
                r = false;
            }
        } while (r);
    }
    private void pennerprofil(){
        
        if (penner == null)
        {
            System.out.println("Erste Erstellung");
            penner = new Penner("Spast");
        }
        else
        {
            System.out.println("Stammkunde");
        }
        
    }
    private void waffenkauf(){
        System.out.print("[1] Waffen\n[2] Schutz\n[3] Zurück\nEingabe: ");
        int eingabe = zahl.nextInt();
        if (eingabe == 1)
        {
            
        }
        else if(eingabe == 2)
        {
            
        }
        else
        {
            
        }
        
    }
    
    
}
