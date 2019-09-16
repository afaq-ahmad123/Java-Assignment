/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smd_q2;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Dell Pc
 */
public class client{
    List<facilities> faci;
    private int id;
    private String name;
    private long card_no;
    String registration_date;
    boolean fee=false;
    client_t c;
    client(int id, String name, long card_no, Date d, boolean f){
        this.id=id;
        this.card_no=card_no;
        this.name=name;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.registration_date=sdf.format(d);
        //System.out.print();
        this.fee=f;
        this.faci=new ArrayList<facilities>();
        this.c=new regular();
    }
    void fee_submit(){
        fee=true;
    }
    void fee_due(){
        fee=false;
    }
    void client_type(String c){
        if(this.c.type().equals(c)){
            ;
        }else{
            if(c.equals("regular")){
                this.c=new regular();
            }else{
                this.c=new member();
                member.fee(true);
            }
        }
    }
    void add_fac(List<facilities>faci){
        
        for(facilities f:faci){
            if(!this.faci.contains(f))
                this.faci.add(f);
            else 
                System.out.print("Client already have "+f.get_fac()+" facility.\n");
        }
    }
    void remo_fac(List<facilities>faci){
        for(facilities f:faci){
            if(this.faci.contains(f))
                this.faci.remove(f);
            else 
                System.out.print("Client doesn't have "+f.get_fac()+" facility.\n");
        }
    }
    public int fee(){
        int fee=0;
        /*int today=(new Date())-(this.registration_date);
        System.out.print(today);
        if(today>0){
            
        } else {
            ;
        }*/
        if(!this.fee){
        for(facilities f:faci){
            fee+=f.registration_fee;
        }
        if(this.c.type().equals("member")&&!this.c.submitted())
            fee+=300;
        }
        return fee;
    }
}
