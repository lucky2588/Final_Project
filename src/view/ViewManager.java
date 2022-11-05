package view;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;
public class ViewManager {
    public ViewManager(){}
    public void display(Scanner sc, ManagerHome user, ArrayList<Renters> listRenters, ArrayList<Room> listRoom, ArrayList<Contract> listContract) {
        System.out.println("....Please Wait for us a moment");
        System.out.println("Welcome " + user.getFullName());
        System.out.println("You Are logged in as Manager Home");
        boolean flag = true;
        while (flag) {
            int choose = 0;
            boolean checkEx = true;
            while (checkEx) {
                try {
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t========Manager Home functions=======");
                    System.out.println("1.Create,Update,Delete Room\t\t2.Agree The Room Rental\t\t3.See Contract\t\t4.House Revenue of Month\t\t5.Cancel Contract of Renters\t\t6.Log Out ");
                    System.out.println("=>> Your Choose : ");
                    choose = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please Re-Enter it");
                }
            }
            switch (choose) {
                case 1:
                    System.out.println("...........Back to home screen");
                    break;
                case 2:
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
                    System.out.println("Logging out..");
                    System.out.println("Thank You For Using Our Service !!! ");
                    flag = false;
                    break;
            }
        }
    }



}


