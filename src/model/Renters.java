package model;
public class Renters extends Person{
    private Room room;
    private int id;
    private static int nextId = 100;
    private String statusRoom;

    public Renters(){
        statusRoom ="null";
        nextId++;
        this.id = nextId;
    }

    public String getStatusRoom() {
        return statusRoom;
    }

    public void setStatusRoom(String statusRoom) {
        this.statusRoom = statusRoom;
    }

    public Renters(int cCCD, String fullName, int numberPhone, String address){
        super(cCCD, fullName, numberPhone, address);
    }

    public Room getRoom(){
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "\n-Username: "+ getAccount().getUserName()+"\t -CCCD: "+getcCCD()+"\t FullName: "+getFullName();
    }
}
