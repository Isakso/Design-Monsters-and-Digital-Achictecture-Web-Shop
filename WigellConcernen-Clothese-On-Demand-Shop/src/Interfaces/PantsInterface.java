package Interfaces;

import Builder.PantsBuilder;
import BusinessObjects.Pants;

import java.beans.PropertyChangeListener;

import static Interfaces.UserGUI.getInputInRange;

public class PantsInterface {

    public Pants pantsDisplay(PropertyChangeListener listener) {
        PantsBuilder builder = new PantsBuilder(listener);

        builder.addMaterial(material())
                .addType(type())
                .addFit(fit());

        return builder.build();
    }
    public String material(){
        String material;
        System.out.println("Choose Material");
        System.out.println("1:Cotton    2:Polyester");
        if(getInputInRange(1,2) == 1){
            material = "Cotton";
        }else material = "Polyester";
        return material;
    }
    // take in type inputs
    public String type(){
        String type;
        System.out.println("Choose type");
        System.out.println("1:Regular    2:Shorts"+'\n'+"3:LongShorts");
        switch (getInputInRange(1,3)){
            case 1: type = "Regular";
                break;
            case 2: type = "Shorts";
                break;
            default: type = "LongShorts";
        }
        return type;
    }
    public String fit() {

        String fit;

            System.out.println("Choose fitting");
            System.out.println("1:Small  2: Medium" + '\n' + "3: X-traLarge");
            int input = getInputInRange(1, 3);
            if (input == 1) {
                fit = "Small";
            } else if (input == 2) {
                fit = "Medium";
            } else {
                fit = "X-traLarge";
            }
            return fit;
        }
}


