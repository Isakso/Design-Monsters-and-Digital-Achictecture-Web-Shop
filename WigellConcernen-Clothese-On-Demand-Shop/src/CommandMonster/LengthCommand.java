package CommandMonster;
import BusinessObjects.Pants;
import BusinessObjects.Skirt;
import BusinessObjects.TShirt;

public class LengthCommand extends Production implements CommandLine{
    private Pants pants = new Pants();
    private TShirt tShirt;
    private Skirt skirt;
    private double length;

    public void setLength(Pants pants, double length){
        this.length = length;
        this.pants = pants;
    }
    @Override
    public void processCommand() {
        pants.setLength(length);
        System.out.println("Pants " + length + " " + "inches");
    }
}
