package model;

public class Vehicle{

    public enum VehicleType{osoby, ciezarowy, motocykl}
    public enum Brand{toyota, skoda, honda, bmw, audi, mercedes, ford}
    public enum Color{czerwony, niebieski, bialy, czarny, srebrny}

    // przypisanie do konkretnego auta
    //final sprawia ze danych auta nie da sie pozniej zmienic
    private final VehicleType type;
    private final Brand brand;
    private final Color color;

    //konstruktor
    public Vehicle(VehicleType type, Brand brand, Color color){
        this.type=type;
        this.brand=brand;
        this.color=color;
    }

    //odczytywanie danych auta przez inne pliki; Gettery
    public VehicleType getType(){return type;}
    public Brand getBrand(){return brand;}
    public Color getColor(){return color;}


}