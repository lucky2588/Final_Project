package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ManagerHomeModel {
    public ManagerHomeModel() {
    }

    public void displayRoom(Scanner sc, ManagerHome manager) {
        boolean flag = true;
        endPro:
        while (flag) {
            int choose = 0;
            boolean checkEx = true;
            while (checkEx) {
                try {
                    System.out.println("Look for Room base On ? \n 1.Your Resquet \t\t 2.List Sort \t\t3.Exit\n=>>import here:");
                    choose = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (choose) {
                case 1:
                    displayRoom1(sc, manager);
                    break;
                case 2:
                    sortList(sc, manager);
                    break;
                case 3:
                    System.out.println("...........Back to home screen");
                    break endPro;
                case 4:
                    System.out.println("Import olther number !!!! ");
                    System.out.println("...........Back to home screen");
                    break;
            }
        }
    }


    // Case 3.1
    public void displayRoom1(Scanner sc, ManagerHome manager) { // Xử lí Case 3
        boolean check = true;
        endProCase3:
        while (check) {
            int chooseCase3 = 0;
            boolean checkExCase3 = true;
            while (checkExCase3) {
                try {
                    System.out.println("You Want choose Room base on:");
                    System.out.println("1.Prince Room \t\t\t 2.Rank Room \t\t\t 3.Area Room \t\t\t 4.Exit");
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
                    roomBaseRank(sc, manager);
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
            int checkFor = 0;
            for (int i = 0; i < manager.getListRoom().size(); i++) {
                if (manager.getListRoom().get(i).getPrinceRoom() >= (choose - (choose / 1.5))) {
                    checkFor += 1;
                    System.out.println(manager.getListRoom().get(i).toString());
                } else {
                    if (i < manager.getListRoom().size() - 1)
                        continue;
                    if (i == (manager.getListRoom().size() - 1) && checkFor == 0) {
                        System.out.println("Couldn't find a Suitable Room");
                    }
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
                    System.out.println(".... Back to Sreen Main");
                    break endPro;
            }
        }
    }

    public void roomBaseRank(Scanner sc, ManagerHome manager) {
        boolean check = true;
        endPro:
        while (check) {
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
                    int checkFor1 = 0;
                    String checkRank = "A";
                    for (int i = 0; i < manager.getListRoom().size(); i++) {
                        if (checkRank.equals(manager.getListRoom().get(i).getRankRoom())) {
                            checkFor1 += 1;
                            System.out.println(manager.getListRoom().get(i));
                        } else {
                            if (i < manager.getListRoom().size() - 1)
                                continue;
                            if (i == manager.getListRoom().size() - 1 && checkFor1 == 0) {
                                System.out.println("This Home have not Room rank A ");
                            }
                        }
                    }
                    break;
                case 2:
                    int checkFor2 = 0;
                    String checkRankB = "B";
                    for (int i = 0; i < manager.getListRoom().size(); i++) {
                        if (checkRankB.equals(manager.getListRoom().get(i).getRankRoom())) {
                            checkFor2 += 1;
                            System.out.println(manager.getListRoom().get(i));
                        } else {
                            if (i < manager.getListRoom().size() - 1)
                                continue;
                            if (i == (manager.getListRoom().size() - 1) && checkFor2 == 0) {
                                System.out.println("This Home have not Room rank B ");
                            }
                        }
                    }
                    break;
                case 3:
                    String checkRankC = "C";
                    int checkFor3 = 0;
                    for (int i = 0; i < manager.getListRoom().size(); i++) {
                        if (checkRankC.equals(manager.getListRoom().get(i).getRankRoom())) {
                            checkFor3 += 1;
                            System.out.println(manager.getListRoom().get(i));
                        } else {
                            if (i < manager.getListRoom().size() - 1)
                                continue;
                            if (i == (manager.getListRoom().size() - 1) && checkFor3 == 0) {
                                System.out.println("This Home have not Room rank C ");
                            }
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
    public void roomBaseArea(Scanner sc, ManagerHome manager) {
        boolean check = true;
        endPro:
        while (check) {
            double choose = 0.0;
            boolean checkEx = true;
            while (checkEx) {
                try {
                    System.out.println("Are you Want Room have Area ? \n Import here:");
                    choose = Double.parseDouble(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            System.out.println("Wait for us a moment....");
            int checkFor = 0;
            for (int i = 0; i < manager.getListRoom().size(); i++) {
                if (manager.getListRoom().get(i).getAreaRoom() >= choose) {
                    checkFor += 1;
                    System.out.println(manager.getListRoom().get(i).toString());
                } else {
                    if (i < manager.getListRoom().size() - 1)
                        continue;
                    if (i == manager.getListRoom().size() - 1 && checkFor == 0) {
                        System.out.println(" There is no room for you");
                    }
                }
            }
            boolean checkEx2 = true;
            int choose1 = 0;
            while (checkEx2) {
                try {
                    System.out.println("Do you Want Continue look for Room base on Area ? \n 1.Continue  \t\t\t 2.Exit");
                    choose1 = Integer.parseInt(sc.nextLine());
                    checkEx2 = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (choose1) {
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

    // Xong chức năng Case 3.1 in Sreen Main User....
    //Chức nắng Case 3.2 in Sreen Main User
    public void sortList(Scanner sc, ManagerHome manager) {
        boolean check = true;
        endProCase3:
        while (check) {
            int chooseCase3 = 0;
            boolean checkExCase3 = true;
            while (checkExCase3) {
                try {
                    System.out.println("What criteria would you like to see the list based on?,\ninput here:");
                    System.out.println("1.Prince Room \t\t\t 2.Rank Room \t\t\t 3.Area Room \t\t\t 4.Exit");
                    System.out.println("Your Choose:");
                    chooseCase3 = Integer.parseInt(sc.nextLine());
                    checkExCase3 = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (chooseCase3) {
                case 1:
                    sortPrinceRoom(manager);
                    break;
                case 2:
                    sortRankRoom(manager);
                    break;
                case 3:
                    sortAreaRoom(manager);
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

    //Case 3.2 : Xếp theo giá tiền
    public void sortPrinceRoom(ManagerHome manager) {
        System.out.println("List Room Sort by price decrease");
        Collections.sort(manager.getListRoom(), new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o1.getPrinceRoom() > o2.getPrinceRoom() ? -1 : 1;
            }
        });
        System.out.println("ID Rooom\t\t\tArea Room\t\t Price Room ");
        for (Room room : manager.getListRoom()) {
            System.out.println(room.getRoomNumber() + "\t\t\t\t\t " + room.getAreaRoom() + "m2" + "\t\t\t\t " + room.getPrinceRoom() + "00K");
        }
    }

    // Chucc năng 3.2.3
    public void sortAreaRoom(ManagerHome manager) {
        System.out.println("List Room Sort by Area decrease");
        Collections.sort(manager.getListRoom(), new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o1.getAreaRoom() > o2.getAreaRoom() ? -1 : 1;
            }
        });
        System.out.println("ID Rooom\t\t\tArea Room\t\t Price Room ");
        for (Room room : manager.getListRoom()) {
            System.out.println(room.getRoomNumber() + "\t\t\t\t\t" + room.getAreaRoom() + "m2" + "\t\t\t\t" + room.getPrinceRoom() + "00K");
        }
    }

    // chức năng 3.2.2
    public void sortRankRoom(ManagerHome manager) {
        System.out.println("\t\t\t===========List Room Sort by Rank========");
        System.out.println("ID Room\t\t\tArea Room\t\t\tPrince\t\t\t\t Rank");
        Collections.sort(manager.getListRoom(), new Comparator<Room>() {
            @Override
            public int compare(Room o1, Room o2) {
                return o1.getRankRoom().compareTo(o2.getRankRoom());
            }
        });
        for (Room room : manager.getListRoom()) {
            System.out.println(room.getRoomNumber() + "\t\t\t\t  " + room.getAreaRoom() + "m2" + "\t\t\t " + room.getPrinceRoom() + "00K\t\t\t\t " + room.getRankRoom());
        }
    }

    // chức năng case 4 màn hình Screen Main User
    public void listRoom(Scanner sc, ManagerHome manager) {
        var check = checkLookroom(manager);
        if (check) {

        System.out.println("Here Are the rooms You can share........");
        System.out.println("\t\t\t\t\t===========List Room==========");
        System.out.println("ID Room\t\t\tPrince Room\t\t\t Numbers Of People in room");
        for (Room room : manager.getListRoom()) {
            if (room.getUserAtRoom().size() < 3 && room.getUserAtRoom().size() > 0)
                System.out.println(room.getRoomNumber() + "\t\t\t\t\t" + room.getPrinceRoom() + "00K" + "\t\t\t\t\t\t" + room.getUserAtRoom().size());
        }
        System.out.println("contact with Manager with numberPhone :" + manager.getNumberPhone());

    } else {
            System.out.println("There is no room for 1 or 2 people ");
        }
    }

    //Check case 4
    public boolean checkLookroom(ManagerHome manager){
        int checkFor =0;
        boolean check = true;
       endPro: for (int i = 0; i < manager.getListRoom().size(); i++){
            if (manager.getListRoom().get(i).getUserAtRoom().size() == 1 || manager.getListRoom().get(i).getUserAtRoom().size() == 2){
                checkFor+=1;
                check = true;
                break;
            }else{
                if(i == manager.getListRoom().size()-1 && checkFor== 0){
                    check = false;
                }
            }
        }
        return check;
    }

}




