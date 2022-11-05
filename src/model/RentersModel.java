package model;

import java.util.ArrayList;
import java.util.Scanner;

public class RentersModel{
    public RentersModel(){
    }
    public Renters input(Scanner sc,String username , int cCCD, String password){
        Renters user = new Renters();
        int numberPhone=0;
        String address = "";
        String fullName = "";
        boolean flag = true;
        while (flag){
            try{
                System.out.println("Import fullName of You");
                fullName = sc.nextLine();
                System.out.println("Import Number Phone of You");
                numberPhone = Integer.parseInt(sc.nextLine());
                System.out.println("Import Address of You");
                address = sc.nextLine();
                flag = false;
            }catch (Exception ex){
                System.out.println("You have entered wrong Input data type, please re-enter it");
            }
        }
        user.setAccount(new Account(username,password,"user"));
        user.setAddress(address);
        user.setNumberPhone(numberPhone);
        user.setFullName(fullName);
        user.setcCCD(cCCD);
        return user;
    }


}
