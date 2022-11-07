package model;

import java.util.ArrayList;

public class ManagerHome extends Person{
    private ArrayList<Room> listRoom;
    private ArrayList<Renters> listRenters;

    public ManagerHome(int cCCD, String fullName, int numberPhone, String address, Account account){
        super(cCCD, fullName, numberPhone, address, account);
    }

    public ArrayList<Room> getListRoom() {
        return listRoom;
    }

    public void setListRoom(ArrayList<Room> listRoom) {
        this.listRoom = listRoom;
    }

    public ArrayList<Renters> getListRenters() {
        return listRenters;
    }

    public void setListRenters(ArrayList<Renters> listRenters) {
        this.listRenters = listRenters;
    }



    @Override
    public String toString() {
        return "FullName: "+getFullName()+"\t\t -NumbersPhone: "+getNumberPhone()+"\t\t -Address: "+getAddress()+"\t\t CCCD: "+getcCCD();
    }
}
