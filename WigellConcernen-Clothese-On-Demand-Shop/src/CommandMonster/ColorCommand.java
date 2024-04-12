package CommandMonster;
import BusinessObjects.Pants;
import BusinessObjects.Skirt;
import BusinessObjects.TShirt;
public class ColorCommand extends Production implements CommandLine {
    private TShirt tshirt = new TShirt();
    private Skirt skirt = new Skirt();
    private String color;
    private int itemNo = 0;
    private Pants pants = new Pants();
    //pass in an object and a color string
    public void setColor(Pants pants, String color) {
        this.pants = pants;
        this.color = color;
        itemNo = 3;
    }
    public void setColor(Skirt skirt, String color) {
        this.skirt = skirt;
        this.color = color;
        itemNo = 2;
    }
    public void setColor(TShirt tshirt, String color) {
        this.tshirt = tshirt;
        this.color = color;
        itemNo = 1;
    }
    @Override
    public void processCommand() {
        // methods from object classes
        if (itemNo == 3) {
            pants.setColor(color);
            System.out.println(color + " " + "Pants");
        } else if (itemNo == 1) {
            tshirt.setColor(color);
            System.out.println(color + " " + "t-shirt");
        } else if (itemNo == 2) {
            skirt.setColor(color);
            System.out.println(color + " " + "skirt");
        }
    }
}
