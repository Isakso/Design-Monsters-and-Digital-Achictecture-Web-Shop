package Interfaces;
import Builder.SkirtBuilder;
import BusinessObjects.Skirt;

import java.beans.PropertyChangeListener;

import static Interfaces.UserGUI.getInputInRange;
public class SkirtInterface {
    public Skirt SkirtDisplay(PropertyChangeListener listener) {
        SkirtBuilder skirtBuilder = new SkirtBuilder(listener);
            skirtBuilder
                    .addMaterial(material())
                    .addWaistLine(waist())
                    .addPattern(pattern());
            return skirtBuilder.build();
        }
        public int waist(){
            System.out.println("Choose waist Size");
            System.out.println("1:50cm    2:75cm");
            System.out.println("3:100cm");
            int waist;
            switch (getInputInRange (1,3)){
                case 1: waist = 60;
                    break;
                case 2: waist = 90;
                    break;
                default: waist = 100;
            }
            return waist;
        }
        public String material(){
            String material;
            System.out.println("Choose Material");
            System.out.println("1:Cotton    2:Silk");
            if(getInputInRange(1,2) == 1){
                material = "Cotton";
            }else material = "Silk";
            return material;
        }
        public String pattern(){
            System.out.println("Choose Pattern");
            System.out.println("1:Boxes   2:Dots");
            System.out.println("3:Checked");
            String pattern;
            switch (getInputInRange(1,3)){
                case 1: pattern = "Boxes";
                    break;
                case 2: pattern = "Dots";
                    break;
                default: pattern = "Checked";
            }
            return pattern;
        }
}
