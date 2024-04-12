package WigellsAB;
import BusinessObjects.*;
import CommandMonster.*;
import Interfaces.SkirtInterface;
import Interfaces.TshirtInterface;
import Interfaces.UserGUI;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Objects;

import Interfaces.PantsInterface;

public class Cart {
    // fields of the shoppingCart
    private Customer customer;
    private int itemId;
    private String receipt;
    private CEO ceo = new CEO();

    // Array list instance to add objects to cart
    private final ArrayList<Object> items = new ArrayList<>();
    private final Production production = new Production();
    private UserGUI userGUI = new UserGUI();

    public Cart() {
        //incomingCustomer = true;
    }

    public void createCustomer() {
        //if(incomingCustomer){
        customer = new Customer();
        customer.setId(1);
        customer.setName(userGUI.customerName());// sets to 1 for first customer;

        //}
    }

    public void StartShopping() {
        int choice = UserGUI.displayStartMenu(); // interact with user
        if (choice == 1) {
            newItem(UserGUI.ItemsList()); // display items
        } else if (choice == 2) {
            disPlayShoppingCart(); // display the shopping basket
            StartShopping();
        } else if (choice == 3) {
            exit();
        } else {
            System.out.println("Invalid selection:");
        }
    }

    public void exit() {
        System.out.println("Exiting!!!!!!");
        System.exit(0);
    }

    // checking that it is not empty and then add items using string builder
    // displays products in the cart
    public void disPlayShoppingCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty");
            return;
        }
        int i = 1;
        StringBuilder stringOut = new StringBuilder("Cart:\n");

        for (Object item : items) {
            if (item instanceof Pants) {
                Pants pants = (Pants) item;
                stringOut.append(i).append(": ").append(pants.getName()).append(" ").append(pants.getFit()).append("\n");
            } else if (item instanceof Skirt) {
                Skirt skirt = (Skirt) item;
                stringOut.append(i).append(": ").append(skirt.getName()).append(" ").append(skirt.getPattern()).append("\n");
            } else if (item instanceof TShirt) {
                TShirt tShirt = (TShirt)item;
                stringOut.append(i).append(": ").append(tShirt.getName()).append(" ").append(tShirt.getMaterial()).append("\n");
            }
            i++;
        }
        System.out.println(stringOut);
    }

    public void newItem(int selected) {
        // increase i tem id by 1
        itemId++;

        // calling commands
        ColorCommand colorCommand = new ColorCommand();
        PriceCommand priceCommand = new PriceCommand();
        SizeCommand sizeCommand = new SizeCommand();
        LengthCommand selectLengthCommand = new LengthCommand();
        Object item = ChosenItemInterface(selected, ceo);
        String productType = item.getClass().getName().substring(item.getClass().getName().indexOf('.') + 1);
        switch (productType) {
            case "TShirt":
                TShirt shirt;
                shirt = new TShirt();
                shirt.setItemId(itemId);
                colorCommand.setColor(shirt, UserGUI.selectColor());
                sizeCommand.setSize(shirt, UserGUI.chooseSize());
                priceCommand.setPrice(shirt, 140);
                addItem(shirt);
                break;
            case "Skirt":
                Skirt skirt = new Skirt();
                skirt.setItemId(itemId);
                colorCommand.setColor(skirt, UserGUI.selectColor());
                sizeCommand.setSize(skirt, UserGUI.chooseSize());
                priceCommand.setPrice(skirt, 200);
                addItem(skirt);
                break;
            case "Pants":
                Pants pants = new Pants();
                pants.SetItemId(itemId);
                selectLengthCommand.setLength(pants, UserGUI.selectLength());
                colorCommand.setColor(pants, UserGUI.selectColor());
                sizeCommand.setSize(pants, UserGUI.chooseSize());
                priceCommand.setPrice(pants, 300);
                production.addCommand(selectLengthCommand);
                addItem(pants);
                break;
        }

        production.addCommand(colorCommand);
        production.addCommand(sizeCommand);
        production.addCommand(priceCommand);

        if (UserGUI.finaliseShopping(items.size()) == 1) {
            end();
        } else {
            StartShopping();
        }
    }

    private void end() {
        production.processCommand();
        processReceipt();
        System.out.println("------------------------");
        writeReceipt();
        items.clear();
    }

    public void processReceipt() {
        int i = 1;
        StringBuilder out = new StringBuilder("Shopping cart" + '\n');
        // Pants pants;
        // Skirt skirt;
        //TShirt tShirt;
        for (Object product : items) {
            String productType = product.getClass().getName().substring(product.getClass().getName().indexOf('.')+1);
            switch (productType) {
                case "Pants":
                    Pants pants = (Pants) product;
                    out.append(i).append(": ").append(pants.getColor()).append(" ").append(pants.getName()).append(" ").append('\n');
                    break;
                case "Skirt":
                    Skirt skirt = (Skirt) product;
                    out.append(i).append(": ").append(skirt.getPattern()).append(" ").append(skirt.getName()).append(" ").append('\n');
                    break;
                case "TShirt":
                    TShirt tShirt = (TShirt) product;
                    out.append(i).append(": ").append(tShirt.getMaterial()).append(" ").append(tShirt.getName()).append(" ").append('\n');
                    break;
            }
            i++;
        }
        if (out.length() == 0) {
            out = new StringBuilder("Your cart is empty");
        }
        System.out.println(out);
    }
    // returns objects
    public Object ChosenItemInterface(int selected, PropertyChangeListener listener) {
        if (selected == 1) {
            TshirtInterface tshirtInterface = new TshirtInterface();
            TShirt tShirt;
            tShirt = tshirtInterface.tShirtDisplay(listener);
            return tShirt;
        } else if (selected == 2) {
            SkirtInterface skirtInterFace = new SkirtInterface();
            Skirt skirt;
            skirt = skirtInterFace.SkirtDisplay(listener);
            return skirt;
        }
        PantsInterface pantsInterface = new PantsInterface();
        Pants pants;
        pants = pantsInterface.pantsDisplay(listener);
        return pants;
    }

    public void addItem(Object item) {
        items.add(item);
    }

    public void writeReceipt() {
        StringBuilder receiptBuilder = new StringBuilder();
        receiptBuilder.append("Wigells Webshop\n");
        if (customer != null && customer.getName() != null) {
            receiptBuilder.append(customer.getName()).append('\n');
        }
        double totalCost = 0;
        for (Object item : items) {
            if (item instanceof Pants) {
                Pants pants = (Pants) item;
                receiptBuilder.append(pants.getName()).append(" ")
                        .append(pants.getType()).append(" ")
                        .append(pants.getMaterial()).append(" ")
                        .append(pants.getSize()).append(" ")
                        .append(pants.getFit()).append(" ")
                        .append(pants.getColor()).append(" Price: ")
                        .append(pants.getPrice()).append('\n');
                totalCost += pants.getPrice();
            } else if (item instanceof TShirt) {
                TShirt tshirt = (TShirt) item;
                receiptBuilder.append(tshirt.getName()).append(" ")
                        .append(tshirt.getMaterial()).append(" ")
                        .append(tshirt.getSize()).append(" ")
                        .append(tshirt.getColor()).append(" Price: ")
                        .append(tshirt.getPrice()).append('\n');
                totalCost += tshirt.getPrice();
            } else if (item instanceof Skirt) {
                Skirt skirt = (Skirt) item;
                receiptBuilder.append(skirt.getName()).append(" ")
                        .append(skirt.getMaterial()).append(" ")
                        .append(skirt.getSize()).append(" ")
                        .append(skirt.getPattern()).append(" ")
                        .append(skirt.getColor()).append(" Price: ")
                        .append(skirt.getPrice()).append('\n');
                totalCost += skirt.getPrice();
            }
        }
        double salesTaxRate = 0.10;
        double salesTax = totalCost * salesTaxRate;
        double totalPriceWithTax = totalCost + salesTax;

        receiptBuilder.append("Price before taxes: ").append(totalCost).append('\n');
        receiptBuilder.append("Sales tax: ").append(salesTax).append('\n');
        receiptBuilder.append("Total Price: ").append(totalPriceWithTax);

        this.receipt = receiptBuilder.toString();
        System.out.println(customer.getName() + ", below is your receipt\n---------------");
        System.out.println(this.receipt);
    }
}

