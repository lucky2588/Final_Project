package model;

import java.util.ArrayList;
import java.util.Scanner;

public class RentersModel {
    public RentersModel() {
    }

    public Renters input(Scanner sc, String username, int cCCD, String password) {
        Renters user = new Renters();
        int numberPhone = 0;
        String address = "";
        String fullName = "";
        boolean flag = true;
        while (flag) {
            try {
                System.out.println("Import fullName of You");
                fullName = sc.nextLine();
                System.out.println("Import Number Phone of You");
                numberPhone = Integer.parseInt(sc.nextLine());
                System.out.println("Import Address of You");
                address = sc.nextLine();
                flag = false;
            } catch (Exception ex) {
                System.out.println("You have entered wrong Input data type, please re-enter it");
            }
        }
        user.setAccount(new Account(username, password, "user"));
        user.setAddress(address);
        user.setNumberPhone(numberPhone);
        user.setFullName(fullName);
        user.setcCCD(cCCD);
        return user;
    }

    public void changleInfor(Scanner sc, Renters user) {
        boolean check = true;
        endPro:while (check) {
            int choose = 0;
            int numbers = 0;
            boolean checkEx = true;
           while (checkEx){
               try {
                   System.out.println("Choose Infor that You Want Changle:");
                   System.out.println("1.NumbersPhone \t\t\t 2.Password \t\t\t 3.Exit");
                   System.out.println("=>> Your Choose:");
                   choose = Integer.parseInt(sc.nextLine());
                   checkEx = false;
               } catch (Exception ex) {
                   System.out.println("You have entered wrong Input data type, please re-enter it");
               }
           }
                switch (choose){
                    case 1:
                        boolean checkEx1 = true;
                        while (checkEx1) {
                            try {
                                System.out.println("Import numberPhone New that you Want Changle: ");
                                numbers = Integer.parseInt(sc.nextLine());
                                checkEx1 = false;
                            } catch (Exception ex) {
                                System.out.println("You have entered wrong Input data type, please re-enter it");
                            }
                        }
                       user.setNumberPhone(numbers);
                        System.out.println("Changle Numbers Phone successful !!! ");
                        break;
                    case 2:
                        System.out.println("Import PassWord new ");
                        String passWord = sc.nextLine();
                        user.getAccount().setPassWord(passWord);
                        System.out.println("Changle PassWord Seccress !! ");
                        break;
                    case 3:
                        System.out.println("...........Back to home screen");
                        break endPro;
                    default:
                        System.out.println("Import Number Olther !! ");
                        break;
                }
            }
        }
        

    }



