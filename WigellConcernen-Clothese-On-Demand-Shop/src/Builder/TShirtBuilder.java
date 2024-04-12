package Builder;

import BusinessObjects.TShirt;

import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.List;

public class TShirtBuilder {
    private TShirt tShirt;
    private static final int MIN_SLEEVE_LENGTH = 10;
    private static final int MAX_SLEEVE_LENGTH = 20;
    private static final int MIN_NECK_SIZE = 20;
    private static final int MAX_NECK_SIZE = 60;
    private static final List<String> VALID_MATERIALS = Arrays.asList("Cotton", "Polyester");
    private boolean validSleeve, validNeck, validMaterial;

    public TShirtBuilder(PropertyChangeListener listener){
        this(); // Calling the no-arg constructor to initialize the boolean flags
        tShirt = new TShirt();
        tShirt.addPropertyChangeListener(listener);
    }
    public TShirtBuilder(){
        tShirt = new TShirt(); // Initialize the TShirt object
        validSleeve = false;
        validNeck = false;
        validMaterial = false;
    }
    public TShirtBuilder addSleeve(int sleeveLength){
        if(sleeveLength >= MIN_SLEEVE_LENGTH && sleeveLength <= MAX_SLEEVE_LENGTH){
            tShirt.setSleeves(sleeveLength);
            validSleeve = true;
        }
        return this;
    }
    public TShirtBuilder addNeck(int neckSize){
        if(neckSize >= MIN_NECK_SIZE && neckSize <= MAX_NECK_SIZE){
            tShirt.setNeck(neckSize);
            validNeck = true;
        }
        return this;
    }

    public TShirtBuilder addMaterial(String material){
        if (VALID_MATERIALS.contains(material)) {
            tShirt.setMaterial(material);
            validMaterial = true;
        }
        return this;
    }

    public TShirt build(){
        if(validNeck && validSleeve && validMaterial) {
            return tShirt;
        } else {
            throw new IllegalArgumentException("Invalid T-shirt configuration. Please ensure valid sleeve length, neck size, and material.");
        }
    }


}
