package model;
import javax.xml.crypto.Data;

import ui.dateWindow.*;
public class Vehicle{

    public enum VehicleType{osobowy, ciezarowy, motocykl}
    public enum Brand{toyota, skoda, honda, bmw, audi, mercedes, ford}
    public enum Color{czerwony, niebieski, bialy, czarny, szary}

    // przypisanie do konkretnego auta
    //final sprawia ze danych auta nie da sie pozniej zmienic
    private final VehicleType type;
    private final Brand brand;
    private final Color color;

    private final int length;
    private final int width;
 
    
    
    //konstruktor
    public Vehicle(VehicleType type, Brand brand, Color color){
        this.type=type;
        this.brand=brand;
        this.color=color;
     

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
       
    }

    //odczytywanie danych auta przez inne pliki; Gettery
    public VehicleType getType(){return type;}
    public Brand getBrand(){return brand;}
    public Color getColor(){return color;}
    
    public int getLength() { return length; }
    public int getWidth() { return width; }
 
}