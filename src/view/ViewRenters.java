package view;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;
public class ViewRenters {
    public ViewRenters(){}
    public void display(Scanner sc, Renters user, ArrayList<Room> listRoom, ManagerHome manager){
        RentersModel rentersModel = new RentersModel();
        RoomModel roomModel = new RoomModel();
        ManagerHomeModel managerHomeModel = new ManagerHomeModel();
        System.out.println("....Please Wait for us a moment");
        System.out.println("Log in successful !!! ");
        System.out.println("Welcome " + user.getFullName());
        System.out.println("You Are logged in as User");
        boolean flag = true;
        while (flag) {
            int choose = 0;
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t========Select Function======");
            boolean checkEx = true;
            while (checkEx) {
                try {
                    System.out.println("1.Change Personal Information\t\t\t\t2.See Information of Manager Home\t\t\t\t3.Look for Room base on Resquet\t\t\t\t\t4.Look For a Shared Room");
                    System.out.println("\t\t\t\t\t5.Room Registration\t\t\t\t\t6.See Bill of Month \t\t\t\t\t\t7.See Contract \t\t\t\t\t8.Log Out ");
                    System.out.println("=>> Your Choose");
                    choose = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (choose) {
                case 1:
                    rentersModel.changleInfor(sc, user);
                    System.out.println("...........Back to home screen");
                    break;
                case 2: // chức năng xem thông tin của Chủ trọ
                    System.out.println("Information About People Home Manager");
                    System.out.println(manager.toString());
                    System.out.println("...........Back to home screen");
                    break;
                case 3: // Chức năng tìm phòng theo yêu cầu
                    if(roomModel.checkRoomEmpty(manager)){
                    managerHomeModel.displayRoom(sc, manager);
                    }else {
                        System.out.println("No rooms have been added by Manager Home ");
                        System.out.println("...........Back to home screen");
                    }
                    break;
                case 4:
                    if(roomModel.checkRoomEmpty(manager)){
                    int checkForcase4 =0;
                    for (int i = 0; i <manager.getListRoom().size();i++){
                        if(!manager.getListRoom().get(i).getUserAtRoom().isEmpty()){
                            checkForcase4+=1;
                            managerHomeModel.listRoom(sc,manager);
                        }else {
                            if(checkForcase4 ==0 && i == manager.getListRoom().size()-1)
                                System.out.println("All of Room is Empty people ");
                        }
                    }
                    System.out.println("...........Back to home screen");
                    }else {
                        System.out.println("No rooms have been added by Manager Home ");
                        System.out.println("...........Back to home screen");
                    }
                    break;
                case 5:
                    if(!manager.getListRoom().isEmpty()) {
                        if (user.getStatusRoom().equals("null")) {
                            registerRoom(sc, manager, user, roomModel);
                        }else{
                            System.out.println("You already have a room, if you want to book another room, please cancel the contract with the current room ");
                        }
                    }else {
                        System.out.println("No rooms have been added by Manager Home ");
                    }
                    System.out.println("...........Back to home screen");
                    break;
                case 6:
                    if(user.getStatusRoom().equals("null")){
                        System.out.println("Please sign up for a room. If approved, you will be able to use this fuction !! ");
                    }else{
                            rentersModel.displayBill(sc,user);
                    }
                    System.out.println("...........Back to home screen");
                    break;
                case 7:
                    if (user.getStatusRoom().equals("null")) {
                        System.out.println("Please sign up for a room. If approved, you will be able to use this fuction !! ");
                    } else {
                       roomModel.seeContract(user.getRoom(),user);
                    }
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

    // Xử lí Luồng chính : Đăng kí Phòng
    public void registerRoom(Scanner sc, ManagerHome manager, Renters user,RoomModel roomModel) {
        boolean checkEx = true;
        int choose = 0;
        while (checkEx) {
            try {
                System.out.println("If You do not know the information about the room, go back to the main screen of the User and select function 3 or 4 to view the room list information");
                System.out.println("1.Register Room \t\t 2.Back \nInput Here:");
                choose = Integer.parseInt(sc.nextLine());
                checkEx = false;
            } catch (Exception ex) {
                System.out.println("You have entered wrong Input data type, please re-enter it");
            }
        }
        endPro:switch (choose) {
            case 1:
                int idRoom = 0;
                boolean checkExxxx = true;
                while (checkExxxx){
                    try{
                        System.out.println("Input Number Room that You Want register in here:");
                        idRoom = Integer.parseInt(sc.nextLine());
                        checkExxxx = false;
                    }catch (Exception ex){
                        System.out.println("You have entered wrong Input data type, please re-enter it");
                    }
                }
                for (int i = 0; i < manager.getListRoom().size(); i++){
                    if (idRoom == manager.getListRoom().get(i).getRoomNumber() && manager.getListRoom().get(i).getUserAtRoom().size() < 3){
                        if(roomModel.checkListRegister(user,manager.getListRoom().get(i))){
                            System.out.println("You have already signed up for this room , Please register for the living room");
                            break endPro;
                        }
                        registerRentesRoom(sc, manager, user, manager.getListRoom().get(i));
                        break;
                    }else if((idRoom == manager.getListRoom().get(i).getRoomNumber() && manager.getListRoom().get(i).getUserAtRoom().size() == 3)) {
                        System.out.println(" This room is Full of people !!! ");
                        System.out.println("...........Back to home screen");
                        break;
                    }else{
                        if(i < manager.getListRoom().size()-1)
                            continue;
                        if(i == manager.getListRoom().size()-1)
                            System.out.println("No Room have Number Room that you Input @@ Please Rs Input  ");
                    }
                }
                System.out.println("...........Back to home screen");
                break;
            case 2:
                System.out.println("...........Back to home screen");
                break;
            default:
                System.out.println("Inpomt Numbers Olther !!! ");
                break;
        }
    }


    //Xử lí phương thức đăng kí Phòng
    public void registerRentesRoom(Scanner sc, ManagerHome manager, Renters user, Room room) {
        System.out.println("Before registering, please preview the contract of our Department");
        System.out.println(room.getContract().displayContract());
        int choose = 0;
        boolean flag = true;
        endPro:
        while (flag) {
            boolean checkEx = true;
            while (checkEx) {
                try {
                    System.out.println("Do You agree with the terms of this contract?");
                    System.out.println("1.I Agree  \t\t\t 2.I Disagree");
                    choose = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (choose) {
                case 1:
                    room.getListRegister().add(user);
                    System.out.println("You have successfully registered, thank you. Please wait for information from the room owner");
                    break endPro;
                case 2:
                    System.out.println("Check out our other rooms !! ");
                    break endPro;
                default:
                    System.out.println("Import Numbers Olther !!! ");
                    break;
            }
        }
    }




}
