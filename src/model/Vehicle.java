package model;

public class Vehicle{

    public enum VehicleType{osobowy, ciezarowy, motocykl}
    public enum Brand{toyota, skoda, honda, bmw, audi, mercedes, ford}
    public enum Color{czerwony, niebieski, bialy, czarny, szary}

    // przypisanie do konkretnego auta
    //final sprawia ze danych auta nie da sie pozniej zmienic
    private final VehicleType type;
    private final Brand brand;
    private final Color color;
    private final String LicensePlate;

    //konstruktor
    public Vehicle(VehicleType type, Brand brand, Color color, String LicensePlate){
        this.type=type;
        this.brand=brand;
        this.color=color;
        this.LicensePlate = LicensePlate;
    }

    //odczytywanie danych auta przez inne pliki; Gettery
    public VehicleType getType(){return type;}
    public Brand getBrand(){return brand;}
    public Color getColor(){return color;}
    public String getLicensePlate(){return LicensePlate;}

}