/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smd_q2;

/**
 *
 * @author Dell Pc
 */
public class member implements client_t{
   final int annual=300;
   static boolean submit;
   member(){
       submit=false;
   }
   member(boolean fee){
       submit=false;
   }
   @Override
   public String type(){
        return "member";
    }
   @Override
   public boolean submitted(){
       return submit;
   }
   static void fee(boolean f){
       submit=f;
   }
}
