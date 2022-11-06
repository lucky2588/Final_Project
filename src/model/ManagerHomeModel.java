package model;

import java.util.Scanner;

public class ManagerHomeModel {
    public ManagerHomeModel(){}
    public void displayRoom(Scanner sc, ManagerHome manager){ // Xử lí Case 3
        boolean check = true;
        endProCase3: while (check){
            int chooseCase3 =0;
            boolean checkExCase3 = true;
            while(checkExCase3){
                try{
                    System.out.println("You Want choose Room base on:");
                    System.out.println("1.Prince of Room \t\t\t 2.Rank of Room \t\t\t 3.Area of Room \t\t\t 4.Exit");
                    System.out.println("Your Choose:");
                    chooseCase3 = Integer.parseInt(sc.nextLine());
                    checkExCase3 = false;
                }catch (Exception ex){
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (chooseCase3){
                case 1:
                        roomBasePrince(sc,manager); // Case 3.1
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break endProCase3;
                default:
                    System.out.println("Import numbers Olther !!! ");
                    break;
            }
        }
        System.out.println("...........Back to home screen");
    }
    public void roomBasePrince(Scanner sc, ManagerHome manager){
        boolean check = true;
       endPro: while (check){
            double choose = 0;
            boolean checkEx = true;
            while (checkEx){
                try{
                    System.out.println("You want to find a room in the price Range, Import Prince:");
                    choose = Double.parseDouble(sc.nextLine());
                    checkEx= false;
                }catch (Exception ex){
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            System.out.println("Please wait for us for a few minutes");
            for (int i = 0; i <manager.getListRoom().size();i++){
                if(manager.getListRoom().get(i).getPrinceRoom() >= (choose-(choose/2.0))   ){
                    System.out.println(manager.getListRoom().get(i).toString());
                }else{
                    if(i < manager.getListRoom().size()-1)
                        continue;
                    System.out.println("Couldn't find a Suitable Room");
                }
            }
            System.out.println("Do You Want Continue Look for Room base Price ? \n1.Continue \t\t 2.Exit");
            boolean checkEx1 = true;
           int chooseContinue = 0;
            while (checkEx1){
                try{
                    System.out.println("==> Your Choose:");
                    chooseContinue = Integer.parseInt(sc.nextLine());
                    checkEx1 = false;
                }catch (Exception ex){
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch(chooseContinue){
                case 1:
                    break;
                case 2:
                    break endPro;
                default:
                    System.out.println("Import Numbers Olther !!! ");
                    break;
            }
        }
    }

    public void roomBaseRank(Scanner sc, ManagerHome manager){
        boolean check = true;
        System.out.println("\n\n\n\n========Our Evaluation Criteria==========");
        System.out.println("\t\t\t\t\t-Rank A : Good Price , Large Area , Full Utilities ");
        System.out.println("\t\t\t\t\t-Rank B : Enough to use Area , Full Utilities ");
        System.out.println("\t\t\t\t\t-Rank B- : Good Price , Large Area Small ");




    }



}
