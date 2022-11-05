package view;

import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ViewRenters {
    public ViewRenters() {
    }

    public void display(Scanner sc, Renters user, ArrayList<Room> listRoom, ManagerHome manager) {
        System.out.println("....Please Wait for us a moment");
        System.out.println("Welcome " + user.getFullName());
        System.out.println("You Are logged in as User");
        boolean flag = true;
        while (flag) {
            int choose = 0;
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t========Select Function======");
            boolean checkEx = true;
            while (checkEx){
                try {
                    System.out.println("1.Change Personal Information\t\t\t\t\t\t2.See Information of Manager Home\t\t\t\t\t\t3.Look Room Based On Price \t\t\t\t4.Look For Room based on Rank");
                    System.out.println("\t\t\t\t\t5.In the Compound Room \t\t\t\t\t 6.See Contract\t\t\t\t\t7.See Bill of Month \t\t\t\t\t\t8.Log Out ");
                    System.out.println("=>> Your Choose");
                    choose = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (choose) {
                case 1:
                    System.out.println("...........Back to home screen");
                    break;
                case 2:
                    System.out.println("Information About People Home Manager");
                    System.out.println(manager.toString());
                    System.out.println("...........Back to home screen");
                    break;
                case 3:
                    System.out.println("...........Back to home screen");
                    break;
                case 4:
                    System.out.println("...........Back to home screen");
                    break;
                case 5:
                    System.out.println("...........Back to home screen");
                    break;
                case 6:
                    System.out.println("...........Back to home screen");
                    break;
                case 7:
                    System.out.println("...........Back to home screen");
                    break;
                case 8:
                    System.out.println("Logging out..");
                    System.out.println("Thank You For Using Our Service !!! ");
                    flag = false;
                    break;
                default:
                    System.out.println("Number that You Enter not Vail , Please Input reset Oncee ");
                    break;
            }
        }
    }
}
