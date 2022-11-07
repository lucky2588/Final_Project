package model;

import java.util.ArrayList;

public class Room {
    private int roomNumber;
    private static int nextRoomNumber = 100;
    private double areaRoom;
    private double princeRoom;
    private String rankRoom;
    private Bill billRoom;
    private String describeRoom;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    private ArrayList<Renters> UserAtRoom;
    private ArrayList<Renters> listRegister;
    private Contract contract;

    public Room(){
        nextRoomNumber++;
        this.roomNumber = nextRoomNumber;
         ArrayList<Renters> listAtRoom = new ArrayList<>();
         ArrayList<Renters> listUserRegister = new ArrayList<>();
    }

    public void setAreaRoom(double areaRoom) {
        this.areaRoom = areaRoom;
    }

    public void setPrinceRoom(double princeRoom) {
        this.princeRoom = princeRoom;
    }

    public void setRankRoom(String rankRoom) {
        this.rankRoom = rankRoom;
    }

    public void setBillRoom(Bill billRoom) {
        this.billRoom = billRoom;
    }

    public String getDescribeRoom() {
        return describeRoom;
    }

    public void setDescribeRoom(String describeRoom) {
        this.describeRoom = describeRoom;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public double getAreaRoom() {
        return areaRoom;
    }

    public double getPrinceRoom() {
        return princeRoom;
    }

    public String getRankRoom() {
        return rankRoom;
    }

    public Bill getBillRoom() {
        return billRoom;
    }

    public ArrayList<Renters> getUserAtRoom() {
        return UserAtRoom;
    }

    public ArrayList<Renters> getListRegister() {
        return listRegister;
    }

    @Override
    public String toString() {
        return "\n-Room : "+getRoomNumber()+"\t\t-Area : "+getAreaRoom()+"m2"+
                "\t\t-Describe : "+getDescribeRoom()+"\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t=>>Rank : "+getRankRoom()+"\t\t -Prince Room : "+getPrinceRoom()+"000K";
    }


}
