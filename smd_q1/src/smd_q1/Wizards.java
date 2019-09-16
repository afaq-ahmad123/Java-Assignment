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
public class Wizards extends Human{
    Wizards(String n)
    {
        super(n);
    }
    void heal(){
         System.out.println(super.name + " is healed");
         
    }
   void explore(){}
    public void attack()
    {
        System.out.println(super.name +" attacked using fireballs");
    }
    
    
}
