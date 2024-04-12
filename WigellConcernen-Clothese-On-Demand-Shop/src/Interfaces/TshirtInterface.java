package Interfaces;

import Builder.TShirtBuilder;
import BusinessObjects.TShirt;

import java.beans.PropertyChangeListener;

import static Interfaces.UserGUI.getInputInRange;
public class TshirtInterface {  // class for choosing materials
    public TShirt tShirtDisplay(PropertyChangeListener listener) {
        TShirtBuilder tshirtBuilder = new TShirtBuilder(listener);
        tshirtBuilder
                .addMaterial(material())
                .addSleeve(sleeveLength())
                .addNeck(neckSize());
        return tshirtBuilder.build();
    }
    private int sleeveLength() {
        System.out.println("Choose sleeve Length ");
        System.out.println("1: 10cm    2: 15cm");
        System.out.println("3: 20cm");
        int choice = UserGUI.getInputInRange(1, 3);
        switch (choice) {
            case 1:
                return 10;
            case 2:
                return 15;
            case 3:
                return 20;
            default:
                return 0; // if it is out of scope
        }
    }
    private int neckSize() {
        System.out.println("Choose Neck Length");
        System.out.println("1: 30cm    2: 40cm");
        System.out.println("3: 50cm");
        int choice = UserGUI.getInputInRange(1, 3);
        switch (choice) {
            case 1:
                return 30;
            case 2:
                return 40;
            case 3:
                return 60;
            default:
                return 0; // handles invalid inputs
        }
    }
    private String material() {
        System.out.println("Choose Material");
        System.out.println("1: Cotton    2: Polyester");
        int choice = UserGUI.getInputInRange(1, 2);
        return choice == 1 ? "Cotton" : "Polyester";
    }
}
