/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smd_q2;

import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Dell Pc
 */
public class fitness_center {
    List<client> clients;
    fitness_center(){
        clients= new ArrayList<client>(); 
    }
    boolean registration(){
        Smd_q2.clearScreen();
        System.out.print("Enter Name: ");
        Scanner s=new Scanner(System.in);
        String name;
        try{
            name=s.nextLine();
        }catch(Exception e){
            System.out.print("Wrong input.\n");
            return false;
        }
        int id=clients.size();
        System.out.print("Enter Facilities you want to avail: ");
        String facility;
        try{
        facility=s.nextLine();
        }catch(Exception e){
            System.out.print("Wrong input.\n");
            return false;
        }
        List<facilities> f=new ArrayList<facilities>();
        while(!facility.equals("no")){
            switch(facility){
                case "gym":
                    f.add(new gym());
                    break;
                case "yoga":
                    f.add(new yoga());
                    break;
                case "swimming":
                    f.add(new swimming());
                    break;
                case "tennis":
                    f.add(new tennis());
                    break;
                case "no":
                    //continue;
                    break;
                default:
                    System.out.println("No such facility exist!");
                    break;
            }
            System.out.print("Any other facility? Enter \"no\" otherwise: ");
            try{
            facility=s.next();
            }catch(Exception e){
            System.out.print("Wrong input.\n");
            return false;
            }
        }
        System.out.print("Enter credit card number: ");
        long card_no;
        try{
        card_no=s.nextLong();
        }catch(Exception e){
            System.out.print("Wrong input.\n");
            return false;
            }
        System.out.print("Is fee submitted? true/false :");
        boolean fee=false;
        try{
            fee=s.nextBoolean();
        }catch(Exception e){
            System.out.print("Wrong input.\n");
            return false;
            }
        client n=new client(id, name, card_no, new Date(),fee);
        n.add_fac(f);
        System.out.print("Member/regular client? ");
        try{
        name=s.next();
        }catch(Exception e){
            System.out.print("Wrong input.\n");
            return false;
            }
        if(name.equals("member")){
            System.out.print("Submitted membership fee? yes/no :");
            String ans=s.next();
            if(ans.equals("yes"))
                fee=true;
            else fee=false;
        }
        if((name.equals("member")&&fee==true)||name.equals("regular"))
            n.client_type(name);
        else{
            System.out.print("First Submit your fee!You are only regular client till then. \n");
            n.client_type("regular");
        }
        clients.add(n);
        System.out.print("Client Created with id = "+id+"\n");
        smd_q2.Smd_q2.clearScreen();
        //Smd_q2.menu();
        return true;
    }
    void calculate_fee(){
        System.out.print("Enter Client Id : ");
        Scanner s=new Scanner(System.in);
        int id;
        try{
        id=s.nextInt();
        }catch(Exception e){
            System.out.print("Wrong input.\n");
            return;
            }
        if(id>=clients.size()){
            System.out.print("This id doesn't exist.\n");
            return;
        }
        
        System.out.print("Remaining fee : $"+clients.get(id).fee()+"\n");
    }
    void submit_fee(){
        System.out.print("Enter Client Id : ");
        Scanner s=new Scanner(System.in);
        int id;
        try{
        id=s.nextInt();
        }catch(Exception e){
            System.out.print("Wrong input.\n");
            return;
            }
        if(id>=clients.size()){
            System.out.print("This id doesn't exist.\n");
            return;
        }
        clients.get(id).fee_submit();
        System.out.print("Fee Submitted.\n");
    }
    void upgrade(){
        System.out.print("Enter Client Id : ");
        Scanner s=new Scanner(System.in);
        int id;
        try{
        id=s.nextInt();
        }catch(Exception e){
            System.out.print("Wrong input.\n");
            return;
            }
        //clients.get(id).client_type("member");
        if(id>=clients.size()){
            System.out.print("This id doesn't exist.\n");
            return;
        }
        System.out.print("Enter Facilities you want to add: ");
        String facility;
        try{
        facility=s.next();
        }catch(Exception e){
            System.out.print("Wrong input.\n");
            return;
        }
        List<facilities> f=new ArrayList<facilities>();
        while(!facility.equals("no")){
            switch(facility){
                case "gym":
                    f.add(new gym());
                    break;
                case "yoga":
                    f.add(new yoga());
                    break;
                case "swimming":
                    f.add(new swimming());
                    break;
                case "tennis":
                    f.add(new tennis());
                    break;
                case "member":
                    System.out.print("Is membership fee submitted? true/false ");
                    if(s.nextBoolean()==true){
                        clients.get(id).client_type("member");
                        System.out.print("Upgraded to member. ");
                    }
                    else{
                        System.out.print("Submit fee first!");
                    }
                    break;
                default:
                    System.out.println("No such facility exist!");
                    break;
            }
            System.out.print("Any other facility? Enter \"no\" otherwise: ");
            try{
            facility=s.next();
            }catch(Exception e){
            System.out.print("Wrong input.\n");
            return;
            }
        }
        clients.get(id).add_fac(f);
        System.out.print("Upgraded.\n");
    }
    void downgrade(){
        System.out.print("Enter Client Id : ");
        Scanner s=new Scanner(System.in);
        int id;
        try{
        id=s.nextInt();
        }catch(Exception e){
            System.out.print("Wrong input.\n");
            return;
            }
        //clients.get(id).client_type("member");
        if(id>=clients.size()){
            System.out.print("This id doesn't exist.\n");
            return;
        }
        System.out.print("Enter Facilities you want to avail: ");
        String facility=null;
        try{
            facility=s.next();
        }catch(Exception e){
            System.out.print("Wrong input.\n");
            return;
        }
        List<facilities> f=new ArrayList<facilities>();
        while(!facility.equals("no")){
            switch(facility){
                case "gym":
                    f.add(new gym());
                    break;
                case "yoga":
                    f.add(new yoga());
                    break;
                case "swimming":
                    f.add(new swimming());
                    break;
                case "tennis":
                    f.add(new tennis());
                    break;
                case "regular":
                    clients.get(id).client_type("regular");
                    break;
                default:
                    System.out.println("No such facility exist!");
                    break;
            }
            System.out.print("Any other facility? Enter \"no\" otherwise: ");
            try{
            facility=s.next();
            }catch(Exception e){
            System.out.print("Wrong input.\n");
            return;
            }
        }
        clients.get(id).remo_fac(f);
        System.out.print("Downgraded.\n");
    }
}
