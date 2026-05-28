package model;

public class ParkingSpace {
    int x;
    int y;
    Vehicle.VehicleType typ;
    boolean occupied;

    public ParkingSpace(int x, int y, Vehicle.VehicleType typ, boolean occupied){
        this.x=x;
        this.y=y;
        this.typ=typ;
        this.occupied=occupied;
    }
}
