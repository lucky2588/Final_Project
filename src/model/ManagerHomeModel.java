package model;
import java.util.Scanner;
public class ManagerHomeModel {
    public ManagerHomeModel() {}
    public void displayRoom(Scanner sc, ManagerHome manager) { // Xử lí Case 3
        boolean check = true;
        endProCase3:
        while (check) {
            int chooseCase3 = 0;
            boolean checkExCase3 = true;
            while (checkExCase3) {
                try {
                    System.out.println("You Want choose Room base on:");
                    System.out.println("1.Prince of Room \t\t\t 2.Rank of Room \t\t\t 3.Area of Room \t\t\t 4.Exit");
                    System.out.println("Your Choose:");
                    chooseCase3 = Integer.parseInt(sc.nextLine());
                    checkExCase3 = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (chooseCase3) {
                case 1:
                    roomBasePrince(sc, manager); // Case 3.1
                    break;
                case 2:
                    roomBaseRank(sc,manager);
                    break;
                case 3:
                    roomBaseArea(sc, manager);
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

    public void roomBasePrince(Scanner sc, ManagerHome manager) {
        boolean check = true;
        endPro:
        while (check) {
            double choose = 0;
            boolean checkEx = true;
            while (checkEx) {
                try {
                    System.out.println("You want to find a room in the price Range, Import Prince:");
                    choose = Double.parseDouble(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            System.out.println("Please wait for us for a few minutes");
            for (int i = 0; i < manager.getListRoom().size(); i++) {
                if (manager.getListRoom().get(i).getPrinceRoom() >= (choose - (choose / 1.5))) {
                    System.out.println(manager.getListRoom().get(i).toString());
                } else {
                    if (i < manager.getListRoom().size() - 1)
                        continue;
                    System.out.println("Couldn't find a Suitable Room");
                }
            }
            System.out.println("Do You Want Continue Look for Room base Price ? \n1.Continue \t\t 2.Exit");
            boolean checkEx1 = true;
            int chooseContinue = 0;
            while (checkEx1) {
                try {
                    System.out.println("==> Your Choose:");
                    chooseContinue = Integer.parseInt(sc.nextLine());
                    checkEx1 = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (chooseContinue) {
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

    public void roomBaseRank(Scanner sc, ManagerHome manager) {
        boolean check = true;
        endPro:while (check) {
            int choose = 0;
            boolean checkEx = true;
            while (checkEx) {
                try {
                    System.out.println("\t\t\t\t========Our Evaluation Criteria==========");
                    System.out.println("\t\t\t\t\t-Rank A : Good Price , Large Area , Full Utilities ");
                    System.out.println("\t\t\t\t\t-Rank B : Enough to use Area , Full Utilities ");
                    System.out.println("\t\t\t\t\t-Rank C : Good Price , Large Area Small ");
                    System.out.println("You Look for Rank for Room ? \n 1.Rank A \t\t\t 2.Rank B \t\t 3.Rank C ");
                    System.out.println("=>> Choose: ");
                    choose = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (choose) {
                case 1:
                    String checkRank ="A";
                    for (int i = 0; i < manager.getListRoom().size(); i++) {
                        if(checkRank.equals(manager.getListRoom().get(i).getRankRoom())){
                            System.out.println(manager.getListRoom().get(i));
                        }else{
                            if(i < manager.getListRoom().size()-1)
                                continue;
                            System.out.println("This Home have not Room rank A ");
                        }
                    }
                    break;
                case 2:
                    String checkRankB ="B";
                    for (int i = 0; i < manager.getListRoom().size(); i++) {
                        if(checkRankB.equals(manager.getListRoom().get(i).getRankRoom())){
                            System.out.println(manager.getListRoom().get(i));
                        }else{
                            if(i > manager.getListRoom().size()-2)
                            System.out.println("This Home have not Room rank B ");
                        }
                    }
                    break;
                case 3:
                    String checkRankC ="C";
                    for (int i = 0; i < manager.getListRoom().size(); i++) {
                        if(checkRankC.equals(manager.getListRoom().get(i).getRankRoom())){
                            System.out.println(manager.getListRoom().get(i));
                        }else{
                            if(i < manager.getListRoom().size()-1)
                                continue;
                            System.out.println("This Home have not Room rank C ");
                        }
                    }
                    break;
                default:
                    System.out.println("Import Numbers Olther !!! ");
                    break;
            }
            System.out.println("Do You Want Continue Look for Room base on Rank ? ? \n1.Continue \t\t 2.Exit");
            boolean checkEx1 = true;
            int chooseContinue = 0;
            while (checkEx1) {
                try {
                    System.out.println("==> Your Choose:");
                    chooseContinue = Integer.parseInt(sc.nextLine());
                    checkEx1 = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (chooseContinue) {
                case 1:
                    break;
                case 2:
                    System.out.println("...........Back to home screen");
                    break endPro;
                default:
                    System.out.println("Import Numbers Olther !!! ");
                    break;
            }
        }
    }
    // Case 3.3 :
    public void roomBaseArea(Scanner sc , ManagerHome manager){
        boolean check = true;
       endPro: while (check){
            double choose = 0.0;
            boolean checkEx= true;
            while (checkEx){
                try{
                    System.out.println("Are you Want Room have Area ? \n Import here:");
                    choose = Double.parseDouble(sc.nextLine());
                    checkEx = false;
                }catch (Exception ex){
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            System.out.println("Wait for us a moment....");
            for (int i = 0; i <manager.getListRoom().size() ; i++){
                if(manager.getListRoom().get(i).getAreaRoom() >= choose){
                    System.out.println(manager.getListRoom().get(i).toString());
                }else{
                    if(i < manager.getListRoom().size()-1)
                        continue;
                    System.out.println(" There is no room for you");
                }
            }
            boolean checkEx2 = true;
            int choose1 =0;
            while (checkEx2){
                try{
                    System.out.println("Do you Want Continue look for Room base on Area ? \n 1.Continue  \t\t\t 2.Exit");
                    choose1 = Integer.parseInt(sc.nextLine());
                    checkEx2 = false;
                }catch (Exception ex){
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (choose1){
                case 1:
                    break;
                case 2:
                    System.out.println("...........Back to home screen");
                    break endPro;
                default:
                    System.out.println("Import Numbers Olther !! ");
                    break;
            }
        }
    }
    // Xong chức năng Case 3 in Sreen Main User....




}
