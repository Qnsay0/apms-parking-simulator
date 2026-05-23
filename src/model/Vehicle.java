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
    private final int length;
    private final int width;
    private final int offsetX;
    private final int offsetY;

    //konstruktor
    public Vehicle(VehicleType type, Brand brand, Color color, String LicensePlate){
        this.type=type;
        this.brand=brand;
        this.color=color;
        this.LicensePlate = LicensePlate;

        //ustalanie wymiarow pojazdu, latwiejsze zmienianie kierunku polozenia w symulacji
        switch (type){
            case osobowy:
                this.length =40;
                this.width=20;
                break;

            case ciezarowy:
                this.length =50;
                this.width=25;
                break;

            case motocykl:
                this.length =25;
                this.width=15;
                break;

            default:
                this.length=40;
                this.width=20;
        }
        this.offsetX = (50 - this.width) / 2;
        this.offsetY = (75 - this.length) / 2;
    }

    //odczytywanie danych auta przez inne pliki; Gettery
    public VehicleType getType(){return type;}
    public Brand getBrand(){return brand;}
    public Color getColor(){return color;}
    public String getLicensePlate(){return LicensePlate;}
    public int getLength() { return length; }
    public int getWidth() { return width; }
    public int getOffsetX() { return offsetX; }
    public int getOffsetY() { return offsetY; }
}