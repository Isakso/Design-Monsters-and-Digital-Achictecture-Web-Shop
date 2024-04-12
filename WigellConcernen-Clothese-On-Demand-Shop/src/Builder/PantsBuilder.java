package Builder;
import BusinessObjects.Pants;

import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.util.List;

public class PantsBuilder {
    private boolean isValidMaterial;
    private boolean isFitting;
    private boolean isValidType;
    private final Pants pants;

    // fields for the pants
    private final List<String> validMaterials = Arrays.asList("Cotton", "Silk", "Polyester");
    private final List<String> validTypes = Arrays.asList("Regular", "Shorts", "LongShorts");
    private final List<String> validFits = Arrays.asList("Small", "Medium", "X-traLarge");

    public PantsBuilder() {
        isValidMaterial = false;
        isFitting = false;
        isValidType = false;
        this.pants = new Pants();

    }
    public PantsBuilder(PropertyChangeListener listener) {
        isValidMaterial = false;
        isFitting = false;
        isValidType = false;
        pants = new Pants();
        pants.addPropertyChangeListener(listener);
    }
    public boolean isValidMaterial(String material) {
        return validMaterials.contains(material);
    }
    public boolean isValidType(String type) {
        return validTypes.contains(type);
    }
    public boolean isValidFit(String fit) {
        return validFits.contains(fit);
    }
    public PantsBuilder addMaterial(String material) {
        if (isValidMaterial(material)) {
            pants.setMaterial(material);
            isValidMaterial = true;
        } else {
            throw new IllegalArgumentException("Invalid material: " + material);
        }
        return this;
    }
    public PantsBuilder addType(String type) {
        if (isValidType(type)) {
            pants.setType(type);
            isValidType = true;
        } else {
            throw new IllegalArgumentException("Invalid type: " + type);
        }
        return this;
    }
    public void addFit(String fit) {
        if (isValidFit(fit)) {
            pants.setFit(fit);
            isFitting = true;
        } else {
            throw new IllegalArgumentException("Invalid fit: " + fit);
        }
    }
    public Pants build() {
        if (isValidMaterial && isFitting && isValidType) {
            return pants;
        } else {
            throw new IllegalStateException("Build unsuccessful due to invalid choices!");
        }
    }
}