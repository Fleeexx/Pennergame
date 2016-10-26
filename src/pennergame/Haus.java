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
    
    private Penner penner;
    private Read read;
    

    public Haus()
    {
        read = new Read();
    }
    
    public void menu(){
        
        pennerprofil();
        
        Boolean r = true;
        
        do {
            System.out.println("[1] Mein Penner\n[2] Shop\n[3] Kämpfen\n[0] Exit\nEingabe: ");
            int eingabe = read.zahl();
            if (eingabe == 1) // Mein Penner
            {
                pennerprofil();
            }
            else if (eingabe == 2) // Shop
            {
                shop();
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
            System.out.print("Na da schau einer her!\nHallo und herzlich willkommen in unserem kleinen Huettchen. Du willst doch sicherlich hier wohnen oder?\nDamit du hier aber wohnen kannst musst du mir aber deinen Namen verraten.\n[Name] ");
            String eingabe = read.zeichen();
            penner = new Penner(eingabe);
            System.out.printf("Alles klar! Du heisst also %s.\nWir haben fuer dich schon mal ein Profil bei uns erstellt.\n", penner.getName());
            penner.showPennerStats();
            System.out.print("Nachdem du jetzt bei uns wohnst hast du auch Aufgaben die du erfuellen musst!\nNun, da du relativ stark aussiehst wirst du unser Haus verteidigen!\nAusruestung bekomsmt du in unserem Shop.\nSobald du ");
        }
        else
        {
            System.out.println("Stammkunde");
        }
        
    }
    
    private void shop(){
        System.out.print("[1] Waffen\n[2] Schutz\n[3] Zurück\nEingabe: ");
        int eingabe = read.zahl();
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