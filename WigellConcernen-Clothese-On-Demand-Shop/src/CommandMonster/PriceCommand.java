package CommandMonster;

import BusinessObjects.Pants;
import BusinessObjects.Skirt;
import BusinessObjects.TShirt;
public class PriceCommand extends Production implements CommandLine {
    private TShirt tshirt = new TShirt();
    private Skirt skirt = new Skirt();
    private int price;
    private int itemNo = 0;
    private Pants pants = new Pants();
    //pass in an object and a price string
    public void setPrice(Pants pants, int price) {
        this.pants = pants;
        this.price = price;
        itemNo = 3;
    }
    public void setPrice(Skirt skirt, int price) {
        this.skirt = skirt;
        this.price = price;
        itemNo = 2;
    }
    public void setPrice(TShirt tshirt, int price) {
        this.tshirt = tshirt;
        this.price = price;
        itemNo = 1;
    }
    @Override
    public void processCommand() {
        // methods from object classes
        if (itemNo == 3) {
            pants.setPrice(price);
            System.out.println(price + " " + "Pants");
        } else if (itemNo == 1) {
            tshirt.setPrice(price);
            System.out.println(price + " " + "t-shirt");
        } else if (itemNo == 2) {
            skirt.setPrice(price);
            System.out.println(price + " " + "skirt");
        }
    }
}
