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
public class Alien implements Character{
    int health;
    Alien()
    {
        this.health=100;
    }
    @Override
    public void defend(){
        System.out.println("Alien Defended the attack!");
    }

    @Override
    public int calculateHealth() {
        try {
            chek_health();
        } catch (ArithmeticException e) {
             System.out.println("Wow! You won");
             System.exit(0);
        }
        
        return health;
     }

    @Override
    public void jump() {
        System.out.println("Alien jumps");
          }

    @Override
    public void speak() {
        System.out.println("Alien speaks");
          }

    @Override
    public void attack() {
        System.out.println("Alien attacked");
         }
    private void chek_health() throws ArithmeticException{
        if(this.health<=0)
            throw new ArithmeticException();
    }
}
