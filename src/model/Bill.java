package model;

public class Bill {
    private double princeRoom;
    private double princeElectricity;
    private double princeWater;

    public Bill(){
    }

    public double getPrinceRoom() {
        return princeRoom;
    }

    public void setPrinceRoom(double princeRoom) {
        this.princeRoom = princeRoom;
    }

    public double getPrinceElectricity() {
        return princeElectricity;
    }

    public void setPrinceElectricity(double princeElectricity) {
        if (princeElectricity > 50.0) {
            this.princeElectricity = (princeElectricity - 50.0) * 4.0 + (50.0 * 3.5);
        } else {
            this.princeElectricity = princeElectricity * 3.5;
        }
    }

    public double getPrinceWater() {
        return princeWater;
    }

    public void setPrinceWater(double princeWater) {
        this.princeWater = princeWater * 25.0;
    }

}
