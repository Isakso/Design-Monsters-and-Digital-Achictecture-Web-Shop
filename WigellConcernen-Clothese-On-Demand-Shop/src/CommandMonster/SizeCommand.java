package CommandMonster;
import BusinessObjects.Pants;
import BusinessObjects.Skirt;
import BusinessObjects.TShirt;

public class SizeCommand extends Production {
    private TShirt tshirt = new TShirt();
    private Skirt skirt = new Skirt();
    private String size;
    private int itemNo = 0;

    private Pants pants = new Pants();
    //pass in an object and a size string
    public void setSize(Pants pants, String size) {
        this.pants = pants;
        this.size = size;
        itemNo = 3;
    }
    public void setSize(Skirt skirt, String size) {
        this.skirt = skirt;
        this.size = size;
        itemNo = 2;
    }
    public void setSize(TShirt tshirt, String size) {
        this.tshirt = tshirt;
        this.size = size;
        itemNo = 1;
    }
    @Override
    public void processCommand() {
        // methods from object classes
        if (itemNo == 3) {
            pants.setSize(size);
            System.out.println(size + " " + "Pants");
        } else if (itemNo == 1) {
            tshirt.setSize(size);
            System.out.println(size + " " + "t-shirt");
        } else if (itemNo == 2) {
            skirt.setSize(size);
            System.out.println(size + " " + "skirt");
        }
    }
}
