package view;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ViewManager {
    public ViewManager() {
    }
    public void display(Scanner sc, ManagerHome manager, ArrayList<Renters> listRenters, ArrayList<Room> listRoom, ArrayList<Contract> listContract) {
        ManagerHomeModel managerHomeModel = new ManagerHomeModel();
        RoomModel roomModel = new RoomModel();
        System.out.println("....Please Wait for us a moment");
        System.out.println("Welcome " + manager.getFullName());
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
                    caseOne(sc, manager, roomModel);
                    System.out.println("...........Back to home screen");
                    break;
                case 2:
                    for (int i = 0; i <manager.getListRoom().size() ; i++) {
                        System.out.println(manager.getListRoom().get(i).getListRegister());
                    }
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

    // case 1 in SreenMain Manager
    public void caseOne(Scanner sc, ManagerHome manager, RoomModel roomModel) {
        boolean check = true;
       endPro: while (check) {
            int choose = 0;
            boolean checkEx = true;
            while (checkEx) {
                try {
                    System.out.println("What function Do You want to perform? \n1.Create A Room new \t\t2.Update Room \t\t3.Delete Room \t\t4.Exit\nImport Here:");
                    choose = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (choose) {
                case 1:
                    boolean flag = true;
                    endPro1:
                    while (flag){
                        Room room = new Room();
                        roomModel.creatRoom(sc, room);
                        manager.getListRoom().add(room);
                        boolean checkExCase1 = true;
                        int chooseCase1 = 0;
                        while (checkExCase1) {
                            try {
                                System.out.println("Do You Want Continue Creat New Room ? \n1.Continue \t\t 2.Exit \nInput here:");
                                chooseCase1 = Integer.parseInt(sc.nextLine());
                                checkExCase1 = false;
                            } catch (Exception ex) {
                                System.out.println("You have entered wrong Input data type, please re-enter it");
                            }
                        }
                        switch (chooseCase1) {
                            case 1:
                                break;
                            case 2:
                                System.out.println("...........Back to home screen");
                                break endPro1;
                            default:
                                System.out.println("Import Number Other !!!! ");
                                break;
                        }
                    }
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break endPro;
                default:
                    System.out.println("Import numbers Olther !!! ");
            }
        }
    }


}


