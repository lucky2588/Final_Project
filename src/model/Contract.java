package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Contract {
    private int conTractRoom;
    private LocalDate dayRent;
    private LocalDate dateEnd;
    private String statusContract;
    private double priceRoom;
    private ArrayList<Renters> listRentersAtContract;

    public Contract(int conTractRoom, double priceRoom) {
        ArrayList<Renters> listRentersAtContract = new ArrayList<>();
        this.listRentersAtContract = listRentersAtContract;
        this.conTractRoom = conTractRoom;
        this.priceRoom = priceRoom;
    }

    public double getPriceRoom() {
        return priceRoom;
    }

    public ArrayList<Renters> getListRentersAtContract() {
        return listRentersAtContract;
    }

    public int getConTractRoom() {
        return conTractRoom;
    }


    public LocalDate getDayRent() {
        return dayRent;
    }

    public void setDayRent(LocalDate dayRent) {
        this.dayRent = dayRent;
    }

    public LocalDate getDateEnd() {
        return this.dayRent.plusYears(1);
    }

    public String getStatusContract() {
        return statusContract;
    }

    public void setStatusContract(String statusContract) {
        this.statusContract = statusContract;
    }

    public void inputDayContract(Scanner sc, Contract contract){
        int monthContract = 1;
        int dayContract = 1;
        boolean check = true;
        while (check){
            boolean checkEx = true;
            while (checkEx){
                try{
                    System.out.println("Import Day Have A Contract");
                    dayContract = Integer.parseInt(sc.nextLine());
                    System.out.println("Import Month Have A Contract");
                    monthContract = Integer.parseInt(sc.nextLine());
                    checkEx = false;
                }catch (Exception ex){
                    System.out.println("You have entered wrong Input data type, please re-enter it");
                }
            }
            if(monthContract > 0 && monthContract <= 12 && dayContract > 0 && dayContract <= 31){
                check = false;
            }else{
                System.out.println("Day or Month not vail , Please Rs Input ");
                check = true;
            }
        }
        LocalDate localDate = LocalDate.of(2022, monthContract, dayContract);
        contract.setDayRent(localDate);
        System.out.println("Day Have a Contract : "+getDayRent());
        System.out.println("Day End Contract : "+getDateEnd());
        System.out.println("Complete The Contract");
    }

    public String displayContract(){
        return "\n\n \t\t\t\t\t\t\t HOP DONG THUE PHONG "+getConTractRoom()+"\n Nguoi Cho Thue Phong : NGUYEN DUC THANG"
                +"\nDia Chi : 125 Luong The Vinh , Q.Thanh Xuan\n"+"Ngay Sinh : 29/10/2001"+"\n \t\t\t\t\t\t========Dieu Kien Hop Dong======="+""+
                "\n1.Dat Coc 1 Thang Tien Nha \n2.Thanh Toan Day Du Tien Nha vao mung 5 hang Thang \n3.Giu Gin Do Dac Chung (thang may , cau thang ,...)" +
                "\n4. Thue toi thieu it nhat 1 nam ke tu khi lam hop dong"+
                "\n\n\t\t\t\t=====Chi Phi Dich Vu khi SD phong======"
                +"\n-Tien Nha : "+getPriceRoom()+"00K"+"\n-Wifi : 100k/Phong \n-Tien Nuoc : 25k/Khoi \n-Tien Dien : 3.5k/So (Dung Tren 50 So =>> 4k/So)"+
                "\n\n\t\t\tDai Dien ben cho Thue \n\t\t\tNguyen Duc Thang";
    }
    public String toString(Renters user){
        return "\n\n \t\t\t\t\t\t\t HOP DONG THUE PHONG "+getConTractRoom()+"\n Nguoi Cho Thue Phong : NGUYEN DUC THANG"
                +"\nDia Chi : 125 Luong The Vinh , Q.Thanh Xuan\n"+"Ngay Sinh : 29/10/2001"+"\n \t\t\t\t\t\t========Dieu Kien Hop Dong======="+""+
                "\n1.Dat Coc 1 Thang Tien Nha \n2.Thanh Toan Day Du Tien Nha vao mung 5 hang Thang \n3.Giu Gin Do Dac Chung (thang may , cau thang ,...)" +
                "\n4.O toi thieu it nhat 1 nam ke tu khi lam hop dong"+
                "\n\n\t\t\t\t=====Chi Phi Dich Vu khi SD phong======"
                +"\n-Tien Nha : "+getPriceRoom()+"00K"+"\n-Wifi : 100k/Phong \n-Tien Nuoc : 25k/Khoi \n-Tien Dien : 3.5k/So (Dung Tren 50 So =>> 4k/So)"+
                "\n Date have A contract : "+getDayRent()+"\n Date end Contrat : "+getDateEnd()+
                "\n\n\t\t\t Manager Home \t\t\t\t\t Renters Room "+"\n\t\tNguyen Duc Thang\t\t\t\t"+user.getFullName();
    }



}
