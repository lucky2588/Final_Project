package model;
import java.util.Scanner;
public class RoomModel{
    public RoomModel(){}
    public void creatRoom(Scanner sc, Room room){
        double areaRoom = 0.0;
        String rankRoom ="";
        double princeRoom = 0.0;
        String describeRoom="";
        boolean checkEx = true;
        while (checkEx){
            try{
                System.out.println("Enter some information about the room");
                System.out.println("The frist, Input rank of Room , Input here:");
                rankRoom = sc.nextLine();
                System.out.println("Input prince Room , Input here:");
                princeRoom = Double.parseDouble(sc.nextLine());
                System.out.println("Next, fill in the Area of Room:");
                areaRoom = Double.parseDouble(sc.nextLine());
                System.out.println("Finally, describe your room");
                describeRoom = sc.nextLine();
                checkEx=false;
            }catch (Exception ex){
                System.out.println("You have entered wrong Input data type, please re-enter it");
            }
        }
        room.setRankRoom(rankRoom);
        room.setPrinceRoom(princeRoom);
        room.setAreaRoom(areaRoom);
        room.setDescribeRoom(describeRoom);
        Contract contract = new Contract(room.getRoomNumber(),room.getPrinceRoom());
        room.setContract(contract);
        System.out.println("Add a new room successfully");
    }

}
