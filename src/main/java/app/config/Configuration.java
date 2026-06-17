package app.config;

public class Configuration {

    // Parametry do modyfikacji symulacji
    public static int MOVE_ALL_VEHICLES_DELAY = 10;
    public static int SPAWN_VEHICLE_DELAY = 100;
    public static final int VEHICLE_ROTATION = 90;
    public static final int STATS_UPDATE_DELAY = 200;
    public static int SPOT_OCCUPATING_TIME = 10000;
    
    // Parametry okna DataView
    public static final int[] DATA_SCREEN_SIZE = {300, 200};
    public static final String DATA_SCREEN_NAME = "DataView";

    // Parametry docelowych y (destinationY) -> zmienić jak auta nie będą wjezdzały
    public static final int[] PARKING_SPACE_Y_CARS = {30, 220, 300, 480};
    public static final int[] PARKING_SPACE_Y_MOTO = {45, 215, 315, 485};

    // Parametry okna Simulator (SimulatorView)
    public static final int[] SIMULATOR_SCREEN_SIZE = {1000, 600};
    public static final String SIMULATOR_SCREEN_NAME = "APMS - Parking Lot Simulator";
}
