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
        room.getBillRoom().setPrinceRoom(princeRoom);
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
    public void addRegisterJoinRoom(Scanner sc, ManagerHome manager, Room room){

        boolean flag = true;
        int checkCCCD = 0;
        endPro:
        while (flag) {
            if(room.getUserAtRoom().size() ==3){
                room.getListRegister().clear();
                System.out.println("This Room have three People , so No one will be able to add anyone to this room from the registration list anymore ");
                System.out.println("List Register of This Room is Clear ");
                break endPro;
            }
            System.out.println("======List People Register this Room=====");
            System.out.println("fullName \t\tUsername\t\t CCCD");
            for (int i = 0; i < room.getListRegister().size(); i++) {
                System.out.println(room.getListRegister().get(i).getFullName() + "\t\t\t\t" + room.getListRegister().get(i).getAccount().getUserName()+"\t\t\t "+room.getListRegister().get(i).getcCCD());
            }
            boolean checkEx = true;
            while (checkEx) {
                try {
                    System.out.println("Import ID/CCCD of People that You agree to join this Room !!!,input here:");
                    checkCCCD = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
                int checkFor = 0;
            for (int i = 0; i < room.getListRegister().size(); i++){
                if (checkCCCD == room.getListRegister().get(i).getcCCD()){
                    checkFor+=1;
                    room.getListRegister().get(i).setRoom(room); // set phòng cho user
                    System.out.println("");
                    System.out.println("Add\t" +room.getListRegister().get(i).getFullName() + " this Room " + room.getRoomNumber() + "\tSuccessful");
                    room.getListRegister().get(i).setStatusRoom("Full"); // đổi trạng thái cho user
                    room.getUserAtRoom().add(room.getListRegister().get(i)); // thêm user vào danh sách phòng
                    room.getContract().inputDayContract(sc, room.getContract()); // Làm hợp động cho user
                    System.out.println("\t\t\t\t\t\t=======Contract of two Parties========");
                    System.out.println(room.getContract().toString(room.getListRegister().get(i)));
                    romoveUserfromList(room.getListRegister().get(i),manager); // Xóa tất cả thằng user có mặt ở phòng chờ khác
                    break;
                } else {
                    if (i == room.getListRegister().size() - 1 && checkFor==0) {
                        System.out.println("not for look User have ID that You Enter !!! ");
                        break endPro;
                    }
                }
            }
            if (!room.getListRegister().isEmpty()) {
                boolean checkEx1 = true;
                int choose = 0;
                while (checkEx1) {
                    try {
                        System.out.println("Do You Want Continue agree for People Olther in List register This Room ? \n 1.Continue \t\t\t 2.Exit ");
                        choose = Integer.parseInt(sc.nextLine());
                        checkEx1 = false;
                    } catch (Exception ex) {
                        System.out.println("You have entered wrong Input data type, please re-enter it");
                    }
                }
                switch (choose) {
                    case 1:
                        break;
                    case 2:
                        break endPro;
                    default:
                        System.out.println("..............Back to Sreen Home ....");
                        break endPro;
                }
            } else {
                System.out.println("The registration list of the room has expired");
                System.out.println("..............Back to Sreen Home ....");
                break endPro;
            }
        }
    }

    // Phương thức xóa User khỏi phòng
    public void removeUser(Scanner sc, ManagerHome manager, Room room){
        boolean flag = true;
       endPro: while (flag) {
            System.out.println("=============list People live in Room " + room.getRoomNumber() + "==========");
            System.out.println("\t\tfullName\t\t\tAddress\t\tUsername");
            for (int i = 0; i < room.getUserAtRoom().size(); i++){
                System.out.println("\t\t\t" + room.getUserAtRoom().get(i).getFullName() + "\t\t\t  " + room.getUserAtRoom().get(i).getAddress() + "\t\t\t " + room.getUserAtRoom().get(i).getAccount().getUserName());
            }
            System.out.println("now enter username of People that You want Remove this Room");
            String usernamCheck = sc.nextLine();
            int checkFor = 0;
            for (int i = 0; i < room.getUserAtRoom().size(); i++) {
                if (usernamCheck.equals(room.getUserAtRoom().get(i).getAccount().getUserName())) {
                    room.getUserAtRoom().get(i).setStatusRoom("null");
                    room.getUserAtRoom().remove(room.getUserAtRoom().get(i));
                    System.out.println("Remove successful ");
                    break;
                } else {
                    if (i == room.getUserAtRoom().size()- 1 && checkFor == 0)
                        System.out.println("You Input not vail username of People in Live Room, please Rs Input");
                }
            }
            if(room.getUserAtRoom().isEmpty()){
                break endPro;
            }
            boolean checkEx = true;
            int choose = 0;
            while (checkEx){
                try{
                    System.out.println("Do you Want Continue Remove People live in This Room ?? \n 1.Continue  \t\t 2.Exit");
                    choose = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                }catch (Exception ex){
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (choose){
                case 1:
                    break;
                case 2:
                    System.out.println("...........Back to home screen");
                    break endPro;
                default:
                    System.out.println("Import Numbers Olther !!!! ");
                    break;
            }
        }
    }
// Xử lí Case 7 của Sreen Main User
    public void seeContract(Room room, Renters user){
        System.out.println(room.getContract().toString(user));
    }
// Xét Phòng Rỗng hay không
    public boolean checkRoomEmpty(ManagerHome manager){
        if(!manager.getListRoom().isEmpty()){
            return true;
        }
        return false;
    }
    // Xóa User khỏi danh sách hàng đợi
    public void romoveUserfromList(Renters user,ManagerHome manager){
        for (int i = 0; i <manager.getListRoom().size() ; i++){
            for (int j = 0; j <manager.getListRoom().get(i).getListRegister().size();j++){
                if(manager.getListRoom().get(i).getListRegister().get(j) ==user) {
                    manager.getListRoom().get(i).getListRegister().remove(manager.getListRoom().get(i).getListRegister().get(j));
                }
            }
            }
        }



}


