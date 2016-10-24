/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pennergame;

import java.util.Scanner;

/**
 *
 * @author Felix
 */
public class Read {
    
    private Scanner zeichen;
    private Scanner zahl;
    
    public Read()
    {
        zeichen = new Scanner(System.in);
        zahl = new Scanner(System.in);
    }
    
    public String zeichen()
    {
        return zeichen.nextLine();
    }
    
    public int zahl()
    {
        return zahl.nextInt();
    }
    
}
