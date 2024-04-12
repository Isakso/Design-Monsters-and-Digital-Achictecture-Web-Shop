package BusinessObjects;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Pants  {
    private  String color;
    private double length;
    private  int itemId;
    private String size;
    private int price;

    private String material;
    private String name = "Pants";
    private String fit;
    private String itemType;

     private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

     public void setColor(String color) {
        this.color = color;
        this.changeSupport.firePropertyChange("color",false, true);

    }
    public void setLength(double length){

        this.length = length;

    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void setType(String itemType) {
        this.itemType= itemType;
    }

    public void setFit(String fit) {
        this.fit = fit;
        this.changeSupport.firePropertyChange("fit",false, true);

    }
    public void SetItemId(int itemId) {
        this.itemId = itemId;
    }
    public String getName() {
        return name;
    }
    public String getFit() {
        return fit;
    }
    public int getPrice() {
        return price;
    }
    public String getType() {
        return itemType;
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
}
