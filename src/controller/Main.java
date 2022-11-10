package controller;
import model.*;
import view.ViewMain;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Person> listUser = new ArrayList<>();
        ArrayList<ManagerHome> listManager = new ArrayList<>();
        //Tạo các tài khoản mặc định là Admin ( quản lí hệ thông ) . manager : Chủ nhà trọ
        Admin admin = new Admin(00000, "ADMIN", 833, "Ha Noi", new Account("admin", "123", "admin"));
        admin.setListUser(listUser);
        ManagerHome manager = new ManagerHome(1000, "Nguyen Duc Thang", 8386, "Ha Noi", new Account("123", "123", "manager"));
        Renters user= new Renters(2000,"Dat",033,"Ha Noi");
        user.setStatusRoom("null");
        user.setAccount(new Account("user","123","user"));
        //tạo 3 thuộc tính của Manager
        ArrayList<Room> listRoom = new ArrayList<>();
//        Room room1 = new Room();room1.setPrinceRoom(1);listRoom.add(room1);room1.setRankRoom("A");
//        Room room2 = new Room();room2.setPrinceRoom(8.5);listRoom.add(room2);room2.setRankRoom("B");
        ArrayList<Renters> listRenters = new ArrayList<>();listRenters.add(user);
        ArrayList<Contract> listContract = new ArrayList<>();
        manager.setListRenters(listRenters);
        manager.setListRoom(listRoom); // add thuộc tính của Manager .. manager được quyền quản lí tất cả các phòng , những người thuê và cả hợp đồng
        listUser.add(admin);listUser.add(manager);listUser.add(user); // Set 3 loại role vào 1 tài khoản
        ViewMain viewMain = new ViewMain();
        viewMain.display(sc,listUser,listRenters,manager,listManager,listRoom,listContract);








    }
}
