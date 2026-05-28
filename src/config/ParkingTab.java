package config;
import model.ParkingSpace;
import model.Vehicle;

import java.lang.classfile.constantpool.PackageEntry;

public class ParkingTab {
    public ParkingSpace generateSpaces(){
        int i=4;
        int j=21;


        ParkingSpace[][] spaces = new ParkingSpace[i][j];

        //przypisanie wartosci dla miejsc dla samochodow i ciezarowek, typ dla osobowych i ciezarowych to null
        for(int poziom=0; poziom<16; poziom++){
            spaces[0][poziom] = new ParkingSpace((poziom+1)*25, 37, null, false);
            spaces[1][poziom] = new ParkingSpace((poziom+1)*25, 232, null, false);
            spaces[2][poziom] = new ParkingSpace((poziom+1)*25, 308, null, false);
            spaces[3][poziom] = new ParkingSpace((poziom+1)*25, 502, null, false);
        }

        //przypisanie wartosci dla motocykli
        for(int poziom=16; poziom<j; poziom++){
            spaces[0][poziom] = new ParkingSpace((poziom+1)*25, 50, Vehicle.VehicleType.motocykl, false);
            spaces[1][poziom] = new ParkingSpace((poziom+1)*25, 220, Vehicle.VehicleType.motocykl, false);
            spaces[2][poziom] = new ParkingSpace((poziom+1)*25, 320, Vehicle.VehicleType.motocykl, false);
            spaces[3][poziom] = new ParkingSpace((poziom+1)*25, 490, Vehicle.VehicleType.motocykl, false);
        }



        return null;
    }
}
