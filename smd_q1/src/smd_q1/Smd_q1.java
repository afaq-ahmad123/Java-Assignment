/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smd_q1;

import java.util.Scanner;

/**
 *
 * @author Dell Pc
 */
public class Smd_q1 {

    /**
     * @param args the command line arguments
     */
    static public void menu(){
            System.out.println("Select one character: Enter 1 for Warrior and 2 for Wizard:");
            System.out.println("Press 11 any time to exit to lobby");
            System.out.println("Note: During playing press 9 to attack, 8 to attack&speak, 7 to jump, 6 to speak by alien.");
    }
    public static void main(String[] args) {
        String name;
        int flag = 0, done=0,players=0;
        Alien alien = null;
        Human H_type = null;
        int move;
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in);
        while (true) {
            menu();
            int pl = s.nextInt();
            if (pl == 1) {
                alien = new Alien();
                System.out.println("You have selected Warrior.");
                System.out.print("Name your character: ");
                name = s1.nextLine();
                H_type = new Warrior(name);
            } else if (pl == 2) {
                alien = new Alien();
                System.out.println("You have selected Wizard");
                System.out.print("Name your character:");
                name = s1.nextLine();
                 players++;
                if(players==5){
                    System.out.println("You have reached player limit!");
                    return;
                }
                H_type = new Wizards(name);
               

            }
            //System.out.println();
            /*if (H_type instanceof Warrior) {
                flag = 1;
            } else {
                flag = 2;
            }*/
            while(true){
            System.out.println("Press 1 to attack");
            System.out.println("Press 2 to defend");
            System.out.println("Press 3 to capture/heal");
            System.out.println("Press 4 to jump");
            System.out.println("Press 5 to speak");
            move = s.nextInt();

            if (move == 1) {
                System.out.print("Enter Aliens' move: ");
                pl = s.nextInt();
                if (pl != 8) {
                    done=1;
                    H_type.attack();
                    alien.attack();
                    if (H_type instanceof Warrior) {
                        alien.health -= 20;
                        
                    } else {
                        alien.health -= 15;
                    }
                    H_type.health-=5;
                    H_type.calculateHealth();
                    alien.calculateHealth();
                }
            } else if (move == 2) {
                H_type.defend();
            } else if (move == 3){
                if (H_type instanceof Warrior) {
                    Warrior war = (Warrior) H_type;
                    war.capture();
                    alien.health -= 10;
                    alien.calculateHealth();
                }else{
                    Wizards war = (Wizards) H_type;
                    war.heal();
                    H_type.health += 10;
                    H_type.calculateHealth();
                }
                    
            } else if (move == 4) {
                H_type.jump();
            } else if (move == 5) {
                H_type.speak();
            }else if (move == 11) {
                break;
            }else
                done=2;
            if(done==2)
                pl = s.nextInt();
            if (pl == 9) {
                if (move == 2) {
                    alien.attack();
                    H_type.defend();
                } else {
                    H_type.health -= 5;
                    if (H_type.calculateHealth() <= 0) {
                        System.out.println("You loss!");
                        return;
                    }
                }
            } else if (pl == 6) {
                alien.speak();
            }else if (pl == 7) {
                alien.jump();
            } 

        }
        }
    }

}
