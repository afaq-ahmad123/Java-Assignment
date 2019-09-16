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
public class Warrior extends Human{
    Warrior(String n)
    {
        super(n);
    }
    void explore(){}
    public void capture(){
        System.out.println("Alien has captured");
    }
    
    public void attack()
    {
        System.out.println(super.name +" attacked by swords");
    }

    
    
    

    
}
