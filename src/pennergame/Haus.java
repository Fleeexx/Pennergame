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
public class Haus {
    
    // Objekte
    
    private Penner penner;
    private Read read;
    
    // Shop-Shit
    
    private Faust shop_faust;
    private Messer shop_messer;
    
    // Do werd jeweils oan verfügbars Woffenobjekt deklariert welches donn noch jedem Kompf editiert werd
    

    public Haus()
    {
        read = new Read();
    }
    
    public void menu()
    {
        
        pennerprofil();
        
        Boolean r = true;
        
        do {
            
            // Shop-Shit
            
            shop_faust = new Faust("Betonwatsche", 10, 10, 1); // Instanzierung 
            
            // Menü
            
            if (penner == null)
                pennerprofil();
            
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
    
    private void pennerprofil()
    {
        
        if (penner == null)
        {
            System.out.print("Na da schau einer her!\nHallo und herzlich willkommen in unserem Unterschlupf!\nDu bist herzlich eingeladen bei uns zu bleiben da wir noch einige gute Kaempfer brauchen.\nVerraetst du mir deinen Namen?\n[Dein Name] ");
            String eingabe = read.zeichen();
            penner = new Penner(eingabe);
            System.out.printf("Alles klar! Du heisst also %s.\nMein Name ist uebrigens Guenther. Ich zeige dir wie hier alels bei uns funktioniert.\n", penner.getName());
            penner.showPennerStats();
            System.out.println("Hier bekommst du erstmal ein paar Pfandflaschen (10). Pfandflaschen(PF) sind unsere Waehrug.\nDu kannst sie gegen Ausruestung im Shop eintauschen.\n\nDamit du nun aber kaempfen kannst, brauchst du erstmal eine Waffe.\nDiese kannst du dir im Shop kaufen ([0] Spezialangebote)");   
            shop();
            System.out.println();
        }
        else
        {
            penner.showPennerStats();
        }
        
    }
    
    private void shop()
    {
        Boolean r = true;
        do
        {
            System.out.print("[1] Waffen\n[2] Schutz\n[3] Zurück\nEingabe: ");
            int eingabe = read.zahl();
            if (eingabe == 1)
            {
                System.out.println("[0] Faust\n[1] Messer\nEingabe:");
                eingabe = read.zahl();
                if (eingabe == 0)
                {
                    shop_faust.showWeaponStats();
                    System.out.println("");
                }
                else if (eingabe == 1)
                {
                    
                }
            }
            else if(eingabe == 2)
            {
                System.out.println("Coming soon...");
            }
            else
            {
                r = false;
            }
        } while (r);
    }
    
    
}