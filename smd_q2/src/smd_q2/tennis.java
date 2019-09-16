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
public class tennis extends facilities{
    final boolean special_gear=true;
    tennis(){
        super.registration_fee=45;
        super.start_time=1000;
        super.end_time=0500;
    }
    @Override
    String get_fac(){
        return "tennis";
    }
}
