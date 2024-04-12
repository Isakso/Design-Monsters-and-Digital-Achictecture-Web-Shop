package BusinessObjects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class TShirt   {
    private String name;
    private String size;
    private int price;
    private int itemId;
    private final PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private int neckSize;
    private String material;
    private String color;

    private int sleeveLength;

    public TShirt() {
        name = "Shirt";
    }
    public void setColor(String color) {
        String oldColor = this.color;
        this.color = color;
        changeSupport.firePropertyChange("color", oldColor, color);
    }

    public void setSize(String size) {
        String oldSize = this.size;
        this.size = size;
        changeSupport.firePropertyChange("size", oldSize, size);
    }

    public void setPrice(int price) {
        int oldPrice = this.price;
        this.price  = price;
        changeSupport.firePropertyChange("price", oldPrice, price);
    }

    public void setItemId(int itemId) {
        int oldItemId = this.itemId;
        this.itemId = itemId;
        changeSupport.firePropertyChange("itemId", oldItemId, itemId);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        this.changeSupport.addPropertyChangeListener(listener);
    }

    public void setSleeves(int sleeveLength) {
        int oldSleeveLength = this.sleeveLength;
        this.sleeveLength = sleeveLength;
        changeSupport.firePropertyChange("sleeveLength", oldSleeveLength, sleeveLength);
    }
    public void setNeck(int neckSize) {
        int oldNeckSize = this.neckSize;
        this.neckSize = neckSize;
        changeSupport.firePropertyChange("neckSize", oldNeckSize, neckSize);
    }
    public void setMaterial(String material) {
        String oldMaterial = this.material;
        this.material = material;
        changeSupport.firePropertyChange("material", oldMaterial, material);
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }
    public double getPrice() {
        return price;
    }
    public String getMaterial() {
        return material;
    }
    public String getSize() {
        return size;
    }
    public String getColor() {
        return color;
    }
    public int getItemId() {
        return itemId;
    }
    public int getNeckSize() {
        return neckSize;
    }
    public int getSleeveLength() {
        return sleeveLength;
    }
}


