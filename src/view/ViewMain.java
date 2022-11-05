package view;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;
public class ViewMain {
    public ViewMain() {};
    // Phương thức hiện thị ban đầu
    public void display(Scanner sc, ArrayList<Person> listUser,ArrayList<Renters> listRenters,ManagerHome manager,ArrayList<ManagerHome> listManager,ArrayList<Room> listRoom,ArrayList<Contract> listContract) {
        while (true){
            int choose = 0;
            boolean checkEx = true;
            while (checkEx) {
                try{
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tFinal Project");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tCoder: Nguyen Duc Thang ");
                    System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tClass: Java FullStack Spring Boots K15 ");
                    System.out.println("\t\t\t\t\t\tHousing management software \t\t\t");
                    System.out.println("\t\t\t\t\t 1.Log In\t\t\t\t\t\t 2.Register");
                    System.out.println("=>> Your choice: ");
                    choose = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                } catch (Exception ex) {
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            switch (choose) {
                case 1:
                    logIn(sc, listUser,listRenters,manager,listManager,listRoom,listContract);
                    break;
                case 2:
                    register(sc, listUser,listRenters);
                    break;
                default:
                    System.out.println("Import Number Olther !!!! ");
                    System.out.println("...........Back to home screen");
            }
        }
    }
    // Xử lí phương thức đăng nhập
    public void logIn(Scanner sc, ArrayList<Person> listUser, ArrayList<Renters> listRenters , ManagerHome manager,ArrayList<ManagerHome> listManager,ArrayList<Room> listRoom,ArrayList<Contract> listContract) {
        boolean flag = true;
        endPro:
        while (flag) {
            System.out.println("Enter Username:");
            String username = sc.nextLine();
            System.out.println("Enter PassWord:");
            String passWord = sc.nextLine();
            for (int i = 0; i < listUser.size(); i++) {
                if (username.equals(listUser.get(i).getAccount().getUserName()) && passWord.equals(listUser.get(i).getAccount().getPassWord())) {
                    logInsuccessful(listUser.get(i), sc,listUser,listRenters,manager,listManager,listRoom,listContract);
                    break endPro;
                } else {
                    if (i < listUser.size() - 1)
                        continue;
                    System.out.println("Username or PassWord incorrect !!! ");
                    int choose = 0;
                    boolean checkEx = true;
                    while (checkEx) {
                        try {
                            System.out.println("1.Re-login \t\t 2. Forgot password \t\t 3.Exit ");
                            System.out.println("Your Choose: ");
                            choose = Integer.parseInt(sc.nextLine());
                            checkEx = false;
                        } catch (Exception ex) {
                            System.out.println("You have entered wrong Input data type, please re-enter it");
                        }
                    }
                    switch (choose) {
                        case 1:
                            flag = true;
                            break;
                        case 2:
                            forgotPassWord(sc, listUser);
                            break endPro;
                        case 3:
                            break endPro;
                        default:
                            System.out.println("Import number 1 or 2 and 3 , Please !!!! ");
                            System.out.println("...........Back to home screen");
                            break endPro;
                    }
                }
            }
        }
    }
    //đăng Kí Thành Công
    public void logInsuccessful(Person user, Scanner sc,ArrayList<Person> listUser,ArrayList<Renters> listRenters,ManagerHome manager,ArrayList<ManagerHome> listManager,ArrayList<Room> listRoom,ArrayList<Contract> listContract){
        if (user.getAccount().getRole().equals("admin")) {
            ViewAdmin view = new ViewAdmin();
            view.display(sc,listUser,listManager);
        } else if (user.getAccount().getRole().equals("manager")) {
            ViewManager viewManager = new ViewManager();
            viewManager.display(sc,manager,listRenters,listRoom,listContract);
        } else {
            ViewRenters viewRenters = new ViewRenters();
            // lỗi xử lí logicc ở đây
            for (int i = 0; i <listRenters.size();i++){
                if(user == listRenters.get(i)){
                    viewRenters.display(sc, listRenters.get(i),listRoom,manager);
                }else{
                    if(i < listUser.size()-1)
                        continue;
                }
            }
        }
    }
    //Xử lí phương thức quên mật khẩu
    public void forgotPassWord(Scanner sc, ArrayList<Person> listUser) {
        boolean check = true;
        endPro: while (check){
            boolean checkEx = true;
            int checkCCCD=0;
            while (checkEx){
                try{System.out.println("Import CCCD of You ");
                    checkCCCD = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                }catch (Exception ex){
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            PersonModel personModel = new PersonModel();
            var checkCCCD1 = personModel.checkCCCD(sc, listUser, checkCCCD);
            if (checkCCCD1) {
                for (int i = 0; i < listUser.size(); i++) {
                    if (checkCCCD == listUser.get(i).getcCCD()) {
                        System.out.println("Looking for CCCD of You ... ");
                        System.out.println("Hello " + listUser.get(i).getFullName());
                        System.out.println("Please Import PassWord New ");
                        System.out.println("Import New PassWord ");
                        String passWordNew = sc.nextLine();
                        listUser.get(i).getAccount().setPassWord(passWordNew);
                        System.out.println("Changle PassWd successful");
                        System.out.println("...........Back to home screen");
                        break endPro;
                    }
                }
            } else {
                System.out.println("Number of CCCD that You Re-Enter not look for , please retry !!! ");
                boolean checkEx1 = true;
                int choose = 0;
                while (checkEx1) {
                    try {
                        System.out.println("Do You Want Continue ?\n 1.Yes\t\t     2.Exit");
                        choose = Integer.parseInt(sc.nextLine());
                        checkEx1 = false;
                    } catch (Exception ex) {
                        System.out.println("You have entered wrong Input data type, please Re-enter it");
                    }
                }
                switch (choose){
                    case 1:
                        break;
                    case 2:
                        break endPro;
                    default:
                        System.out.println("Import number 1 or 2 , Please !!!! ");
                }
            }
        }
    }
    // Phần 2 : Xử lí chức năng đăng kí Tài Khoản
    public void register(Scanner sc, ArrayList<Person> listUser, ArrayList<Renters> listRenters){
      boolean flag = true;
        endPro :while(flag){
            boolean checkEx = true;
            int cCCD = 0;
            String username = "";
            while (checkEx){
                try{
                    System.out.println("First, Enter Your ID card here");
                    System.out.println("Import CCCD of You ");
                    cCCD = Integer.parseInt(sc.nextLine());
                    System.out.println("Import Usernew ");
                    username = sc.nextLine();
                    checkEx = false;
                }catch(Exception ex){
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            PersonModel user = new PersonModel();
            if(!user.checkCCCD(sc,listUser,cCCD) && !user.checkUsernameReady(sc,listUser,username)){
                System.out.println("CCCD and Username valid !! Congratulation ");
                System.out.println("Import PassWord of You ... ");
                String password = sc.nextLine();
                boolean check = true;
                RentersModel userr = new RentersModel();
              endPro1:  while(check){
                    Renters user5 =  userr.input(sc,username,cCCD,password);
                    listUser.add(user5);
                    listRenters.add(user5);
                    boolean checkContinue = true;
                    int choose =0;
                    while (checkContinue){
                        try{
                            System.out.println("Do you Want Continue Register ? \n 1.Continue \t\t\t 2.Exit");
                            choose = Integer.parseInt(sc.nextLine());
                            checkContinue = false;
                        }catch(Exception ex){
                            System.out.println("You have entered wrong Input data type, please re-enter it");
                        }
                    }
                    switch (choose){
                        case 1:
                            break endPro1;
                        case 2:
                            break endPro;
                        default:
                            break endPro;
                    }
                }
                // Xử lí phương thức thêm thông tin cho user
            }else{
                System.out.println("Username Or CCCD already exists @@ , please Re-Enter Once ");
                boolean checkEx1 = true;
                int choose = 0;
                while(checkEx1){
                    try{
                        System.out.println("Do You Want Re-Enter Username and CCCD Olther ? \n 1.Continue \t\t 2.Exit ");
                        choose = Integer.parseInt(sc.nextLine());
                        checkEx1=false;
                    }catch(Exception ex){
                        System.out.println("You have entered wrong Input data type, please re-enter it");
                    }
                }
                switch(choose){
                    case 1:
                        break;
                    case 2:
                        break endPro;
                }
            }
        }
    }


}







