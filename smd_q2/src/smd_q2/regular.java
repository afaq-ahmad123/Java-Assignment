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
public class regular implements client_t{
    regular(){}
    @Override
    public String type(){
        return "regular";
    }
    @Override
    public boolean submitted(){
        return true;
    }
}
