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
        endPro:
        while (check) {
            int choose = 0;
            int numbers = 0;
            boolean checkEx = true;
            while (checkEx) {
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
            switch (choose) {
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

    // Xử lí Case 6 của Sreen Main User
    public void displayBill(Scanner sc, Renters user) {
        boolean flag = true;
        endPro:
        while (flag) {
            int choose = 0;
            boolean checkEx = true;
            while (checkEx) {
                try {
                    System.out.println("You Want Watch the Bill ? \n1. Electricity \t\t2.Water \t\t3.Total Money of Room\t\t4.Exit\nInput here");
                    choose = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (choose) {
                case 1:
                    boolean checkExCase1 = true;
                    double numbersElectric = 0.0;
                    while (checkExCase1) {
                        try {
                            System.out.println("Check the meter and enter the number of electricity you use this month");
                            numbersElectric = Double.parseDouble(sc.nextLine());
                            checkExCase1 = false;
                        } catch (Exception ex) {
                            System.out.println("You have entered wrong Input data type, please re-enter it");
                        }
                    }
                    user.getRoom().getBillRoom().setPrinceElectricity(numbersElectric);
                    System.out.println("This month's electricity bill of the Room : " + user.getRoom().getBillRoom().getPrinceElectricity() + "0K");
                    System.out.println("...........Back to home screen");
                    break;
                case 2:
                    boolean checkExCase2 = true;
                    double numbersWater = 0.0;
                    while (checkExCase2) {
                        try {
                            System.out.println("look at the water meter and write down the volume of water used this month");
                            numbersWater = Double.parseDouble(sc.nextLine());
                            checkExCase2 = false;
                        } catch (Exception ex) {
                            System.out.println("You have entered wrong Input data type, please re-enter it");
                        }
                    }
                    user.getRoom().getBillRoom().setPrinceWater(numbersWater);
                    System.out.println("This month's Water  bill of the Room : " + user.getRoom().getBillRoom().getPrinceWater() + "0K");
                    System.out.println("...........Back to home screen");
                    break;
                case 3:
                    if (user.getRoom().getBillRoom().getPrinceWater() == 0 && user.getRoom().getBillRoom().getPrinceElectricity() == 0) {
                        System.out.println("Enter 2 electricity and water bills before using this function ");
                    } else {
                        System.out.println("============Bill of Month============");
                        System.out.println("Room " + user.getRoom().getRoomNumber());
                        System.out.println("Service prices\t\t\t Value");
                        System.out.println("Room\t\t\t" + user.getRoom().getPrinceRoom() + "00K");
                        System.out.println("Electricity\t\t" + user.getRoom().getBillRoom().getPrinceElectricity() + "K");
                        System.out.println("Water\t\t\t" + user.getRoom().getBillRoom().getPrinceWater() + "K");
                        System.out.println("Internet\t\t 100K");
                    }
                    break;
                case 4:
                    System.out.println("...........Back to home screen");
                    break endPro;
            }
        }
    }


}



