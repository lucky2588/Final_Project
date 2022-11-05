package model;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonModel {
    public PersonModel(){}
    public boolean checkUsernameReady(Scanner sc, ArrayList<Person> listUser , String username){ // tạo pt để ktra tk vs mk đã tồn tại chưa ?
        for (Person user: listUser){
            if(username.equals(user.getAccount().getUserName())){
              return true;
            }
        }
        return false;
    }
    // tạo hàm check CCCD
    public boolean checkCCCD(Scanner sc, ArrayList<Person> listUser ,int cCCD){ // tạo pt để ktra tk vs mk đã tồn tại chưa ?
        for (Person user: listUser){
            if(cCCD == user.getcCCD()){
                return true;
            }

        }
        return false;
    }
    public Person input(Scanner sc){
       Person user = new Person();
        int numberPhone=0;
        String address = "";
        String fullName = "";
        String username ="";
        String password="";
        int cCCD =0;
        boolean flag = true;
        while (flag){
            try{
                System.out.println("Import fullName of You ");
                fullName = sc.nextLine();
                System.out.println("Import Number Phone of You ");
                numberPhone = Integer.parseInt(sc.nextLine());
                System.out.println("Import Address of You ");
                address = sc.nextLine();
                System.out.println("Import Username ");
                username = sc.nextLine();
                System.out.println("Import Password ");
                password = sc.nextLine();
                System.out.println("Import CCCD ");
                cCCD = Integer.parseInt(sc.nextLine());
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
