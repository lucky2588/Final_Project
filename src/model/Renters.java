package model;
public class Renters extends Person{
    private Room room;
    private Contract hopDong;
    private int id;
    private static int nextId = 100;

    public Renters(){
        nextId++;
        this.id = nextId;
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

    public Contract getHopDong() {
        return hopDong;
    }

    public void setHopDong(Contract hopDong){
        this.hopDong = hopDong;
    }

    @Override
    public String toString() {
        return "\n-Username: "+ getAccount().getUserName()+"\t -CCCD: "+getcCCD()+"\t FullName: "+getFullName();
    }
}
