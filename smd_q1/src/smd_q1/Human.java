/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smd_q1;

/**
 *
 * @author Dell Pc
 */

abstract class Human implements Character{
    final String name;
    
    protected int health;
    private int players=0;
    Human(String n)
    {
        this.name=n;
        
        try {
            name_chk();
        } catch (Exception e) {
            System.out.println("Enter the player name without special characters");
            return;
        }
        this.health=100;
        try {
            player_chk();
           
        } catch (Exception e) {
            System.out.println("You cannot choose more players.");
            return;
        }
        
    }
    
    @Override
    public void attack(){
    }

    @Override
    public int calculateHealth() {
        try {
            health_chk();
        } catch (ArithmeticException e) {
             System.out.println("You have been wasted");
             System.exit(0);
        }
        catch(NullPointerException e)
        {
            this.health=100;
        }
        return this.health;
     }

    @Override
    public void jump() {
        System.out.println("Character jumped");
        }

    @Override
    public void defend() {
        System.out.println("Character Defended!!");
        }

    @Override
    public void speak() {
        System.out.println("Character speak");
        }
    private void player_chk() throws ArithmeticException{
        if(++players==5)
            throw new ArithmeticException();
    }
    private void name_chk() throws ArithmeticException{
        for (int i = 0; i < this.name.length(); i++) {
            if(!((this. name.charAt(i) >='A' && this. name.charAt(i)<='Z') || (this. name.charAt(i)>='a' && this. name.charAt(i)<='z')|| (this. name.charAt(i)>='0' && this. name.charAt(i)<='9')))
                    throw new ArithmeticException();
               }
 
    }
     private void health_chk() throws ArithmeticException,NullPointerException{
        if(this.health<=0)
            throw new ArithmeticException();
        else if(this.health>100)
            throw new NullPointerException();
    }
    void explore(){}
}
