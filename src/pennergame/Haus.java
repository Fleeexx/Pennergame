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
    private Arena arena;
    private Pennerleben leben;
    
    // Shop-Shit
    
    private Faust shop_faust;
    private Messer shop_messer;
    private Handy shop_handy;
    
    // Do werd jeweils oan verfügbars Woffenobjekt deklariert welches donn noch jedem Kompf editiert werd
    

    public Haus()
    {
        read = new Read();
        arena = new Arena();
    }
    
    public void menu()
    {
        
        Boolean r = true;
        
        do {
            
            // Shop-Shit
            
            shop_faust = new Faust("Betonwatsche", 10, 10, 1); // Instanzierung
            shop_messer = new Messer("Butterfly", 20, 15, 1);
            shop_handy = new Handy("Modelle", 100, 30, 1);
            
            // Menü
            
            if (penner == null)
                pennerprofil();
            
            System.out.print("\n\n[1] Mein Penner\n[2] Shop\n[3] Wildnis\n[4] Kämpfen\n[0] Exit\nEingabe: ");
            int eingabe = read.zahl();
            if (eingabe == 1) // Mein Penner
            {
                pennerprofil();
            }
            else if (eingabe == 2) // Shop
            {
                shop();
            }
            else if (eingabe == 3)
            {
                pennerleben();
            }
            else if (eingabe == 4) // Arena
            {
                kampf();
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
            System.out.print("Na da schau einer her!\nHallo und herzlich willkommen in unserem Unterschlupf!\nDu bist herzlich eingeladen bei uns zu bleiben da wir noch einige gute Kämpfer brauchen.\nVerrätst du mir deinen Namen?\n[Dein Name] ");
            String eingabe = read.zeichen();
            penner = new Penner(eingabe);
            System.out.printf("Alles klar! Du heisst also %s.\nMein Name ist übrigens Günther. Ich zeige dir wie hier alles bei uns funktioniert.\n", penner.getName());
            penner.showPennerStats();
            System.out.println("Hier bekommst du erstmal ein paar Pfandflaschen (15). Pfandflaschen(PF) sind unsere Währung.\nDu kannst sie gegen Ausrüstung im Shop eintauschen.\n\nDamit du nun aber kämpfen kannst, brauchst du erstmal eine Waffe.\nDiese kannst du dir im Shop kaufen ([0] Faust)");
            penner.addMoney(15);
            Boolean r = false;
            do
            {
                shop();
                if (penner.getInventar().isEmpty())
                {
                    System.out.println("\nOhne eine Waffe kannst du nicht kämpfen!");
                }
                else
                {
                    r = true;
                    System.out.println("\nDa du dir nun deine Waffe gekauft hast wird es nun Zeit für deinen ersten Kampf!\n");
                }
            } while(r == false);
            kampf();
        }
        else
        {
            penner.showPennerStats();
        }
        
    }
    
    private void shop()
    {
        Boolean r = true;
        Waffe cart;
        do
        {
            System.out.print("\n\n[1] Waffen\n[2] Schutz\n[3] Zurück\nEingabe: ");
            int eingabe = read.zahl();
            if (eingabe == 1)
            {
                System.out.print("\n\n[0] Faust\n[1] Messer\n[2] Handy\nEingabe: ");
                eingabe = read.zahl();
                if (eingabe == 0)
                {
                    cart = shop_faust;
                }
                else if (eingabe == 1)
                {
                    cart = shop_messer;
                }
                else
                {
                    cart = shop_handy;
                }
                cart.showWeaponStats();
                System.out.println("\nKaufen? (j/n)");
                String kaufen = read.zeichen();
                if (kaufen.toUpperCase().equals("J"))
                {
                    if (penner.getMoney() >= cart.getKosten())
                    {
                        penner.addMoney(cart.getKosten() * -1);
                        penner.addInventar(cart);
                    }
                    else
                    {
                        System.out.println("Du kannst dir das nicht leisten!\n");
                    }
                }
            }
            else if(eingabe == 2)
            {
                System.out.println("\nComing soon...");
            }
            else
            {
                r = false;
            }
        } while (r);
    }
    
    private void pennerleben()
    {
        if (leben == null)
        {
            leben = new Pennerleben(penner);
            leben.intro();
        }
        else
        {
            leben.start();
        }
    }
    
    private void kampf()
    {
        System.out.println("\n|---------- Kampf-Arena ----------|\n");
        String botname = arena.getRndName();
        System.out.printf("\nEin wilder Penner namens %s ist aufgetaucht!\n", botname);
        arena.initializeFight(penner, botname);
    }
    
    
}