package model;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomModel {
    public RoomModel() {
    }

    public void creatRoom(Scanner sc, Room room) {
        double areaRoom = 0.0;
        String rankRoom = "";
        double princeRoom = 0.0;
        String describeRoom = "";
        boolean checkEx = true;
        while (checkEx) {
            try {
                System.out.println("Enter some information about the room");
                System.out.println("The frist, Input rank of Room , Input here:");
                rankRoom = sc.nextLine();
                System.out.println("Input prince Room , Input here:");
                princeRoom = Double.parseDouble(sc.nextLine());
                System.out.println("Next, fill in the Area of Room:");
                areaRoom = Double.parseDouble(sc.nextLine());
                System.out.println("Finally, describe your room");
                describeRoom = sc.nextLine();
                checkEx = false;
            } catch (Exception ex) {
                System.out.println("You have entered wrong Input data type, please re-enter it");
            }
        }
        room.setRankRoom(rankRoom);
        room.setPrinceRoom(princeRoom);
        room.setAreaRoom(areaRoom);
        room.setDescribeRoom(describeRoom);
        Contract contract = new Contract(room.getRoomNumber(), room.getPrinceRoom());
        room.setContract(contract);
        System.out.println("Add a new room successfully");
    }

    // tạo phương thức check xem User đã có trong danh sách đăng kí hay chưa
    public boolean checkListRegister(Renters user, Room room) {
        for (Renters user1 : room.getListRegister()) {
            if (user1 == user)
                return true;
        }
        return false;
    }
    // Phương thức thêm mới 1 user vào phòng
    public void addRegisterJoinRoom(Scanner sc, ManagerHome manager, Room room) {
        boolean flag = true;
        int checkCCCD=0;
        endPro:while (flag){
            System.out.println("======List People Register this Room=====");
            System.out.println("fullName \t\t\t Username \t\t\tCCCD");
            for (int i = 0; i < room.getListRegister().size(); i++) {
                System.out.println(room.getListRegister().get(i).getFullName() + "\t\t\t\t" + room.getListRegister().get(i).getAccount().getUserName() + "\t\t\t" + room.getListRegister().get(i).getcCCD());
            }
               boolean checkEx =true;
            while (checkEx){
                try {
                    System.out.println("Import ID/CCCD of People that You agree to join this Room !!!,input here:");
                    checkCCCD = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }

                for (int i = 0; i <room.getListRegister().size(); i++){
                    if(checkCCCD == room.getListRegister().get(i).getcCCD()){
                        manager.getListRenters().get(i).setRoom(room); // set phòng cho user
                        System.out.println("Add"+manager.getListRenters().get(i).getFullName()+" this Room "+room.getRoomNumber()+"Successful");
                        manager.getListRenters().get(i).setStatusRoom("Full"); // đổi trạng thái cho user
                        room.getUserAtRoom().add(manager.getListRenters().get(i)); // thêm user vào danh sách phòng
                        room.getContract().inputDayContract(sc, room.getContract()); // Làm hợp động cho user
                        System.out.println("\t\t\t\t\t\t=======Contract of two Parties========");
                        System.out.println(room.getContract().toString(manager.getListRenters().get(i)));
                        for (int j = 0; j <manager.getListRoom().size() ; j++){
                            manager.getListRoom().get(j).getListRegister().remove(manager.getListRenters().get(i));
                        }
                        break;
                    }else{
                      if(i < room.getListRegister().size()-2)
                          continue;
                        System.out.println("not for look User have ID that You Enter !!! ");
                        break endPro;
                    }
                }
            if(!room.getListRegister().isEmpty()){
                boolean checkEx1 = true;
                int choose = 0;
                while (checkEx1){
                    try{
                        System.out.println("Do You Want Continue agree for People Olther in List register This Room ? \n 1.Continue \t\t\t 2.Exit ");
                        choose = Integer.parseInt(sc.nextLine());
                        checkEx1 = false;
                    }catch (Exception ex){
                        System.out.println("You have entered wrong Input data type, please re-enter it");
                    }
                }
                switch (choose){
                    case 1:
                        break;
                    case 2:
                        break endPro;
                    default:
                        System.out.println("..............Back to Sreen Home ....");
                        break endPro;
                }
            }else {
                System.out.println("..............Back to Sreen Home ....");
                break endPro;
            }
            }
        }

    }


