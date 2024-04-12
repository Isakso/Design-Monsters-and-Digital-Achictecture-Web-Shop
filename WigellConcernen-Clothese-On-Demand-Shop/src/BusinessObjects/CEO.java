package BusinessObjects;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CEO implements PropertyChangeListener {
    private String name;
    private int id;
    public CEO() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    @Override
    public void propertyChange(PropertyChangeEvent event) {

        System.out.println("Production"+event.getPropertyName() );

    }
}
