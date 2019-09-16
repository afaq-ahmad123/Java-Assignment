/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smd_q2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Dell Pc
 */
public class Smd_q2 {

    /**
     * @param args the command line arguments
     */
    static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }
    static void menu(){
         System.out.print("1. Press 1 for registration.\n"
                + "2. Press 2 for Upgrade client.\n"
                + "3. Press 3 for downgrade client.\n"
                + "4. Press 4 for check fee of any client.\n"
                 + "5. Press 5 to submit fee.\n"
                 + "6. Press 6 to exit.\n");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        fitness_center f=new fitness_center();
        menu();
        Scanner s=new Scanner(System.in);
        int i=-1;
        while (!s.hasNextInt()) {
            System.out.println("Enter Valid input!");
            s.next();
        }
        i=s.nextInt();
        while(i!=6){
        switch(i){
            case 1:
                clearScreen();
                f.registration();
                break;
            case 2:
                clearScreen();
                f.upgrade();
                break;
            case 3:
                clearScreen();
                f.downgrade();
                break;
            case 4:
                clearScreen();
                f.calculate_fee();
                break;
            case 5:
                f.submit_fee();
                break;
            default:
                clearScreen();
                System.out.print("Enter Valid input:");
                break;
        }
        menu();
        while (!s.hasNextInt()) {
            System.out.println("Enter Valid input!");
            s.next();
        }
        i=s.nextInt();
        }
        System.exit(0);
    }

    
}
