package Builder;
import BusinessObjects.Skirt;
import java.beans.PropertyChangeListener;

public class SkirtBuilder { // build class for skirt
    private final String [] validMaterials = {"Cotton","Silk"};
    private final String [] validPatterns = {"Boxes","Dots", "Checked"};
    private final int [] validWaistS = {60,90,120};
    private  boolean  validWaist, validPattern, validMaterial;
    public boolean isValidWaist() {
        return validWaist;
    }
    public boolean isValidPattern() {
        return validPattern;
    }
    public boolean isValidMaterial() {
        return validMaterial;
    }
    private Skirt skirt;
    public SkirtBuilder(){
        validWaist = false;
        validPattern = false;
        validMaterial = false;
         this.skirt = new Skirt();
    }
    public SkirtBuilder(PropertyChangeListener listener){
        validWaist = false;
        validPattern = false;
        validMaterial = false;
        skirt = new Skirt();
        this.skirt.addPropertyChangeListener(listener);
    }
    public SkirtBuilder addMaterial(String material){
        for (String s : validMaterials) {
            if (material.equalsIgnoreCase(s)) {
                skirt.setMaterial(material);
                validMaterial = true;
            }
        }
        return this;
    }
    public SkirtBuilder addWaistLine(int waist){
        for (int x : validWaistS) {
            if (waist == x) {
                skirt.setWaistline(waist);
                validWaist = true;
            }
        }
        return this;
    }
    public SkirtBuilder addPattern(String pattern){
        for (String s : validPatterns) {
            if (pattern.equalsIgnoreCase(s)) {
                skirt.setPattern(pattern);
                validPattern = true;
            }
        }
        return  this;
    }
    public Skirt build(){
        if( validWaist && validPattern && validMaterial){
            validWaist = false;
            validPattern = false;
            validMaterial = false;
            return skirt;

        }else
            throw new IllegalArgumentException("Invalid Process data");
    }
}


