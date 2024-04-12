package Interfaces;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserGUI {

    // interact with the user to choose properties
    public UserGUI() {
    }
        public static int displayStartMenu() {
            System.out.println("1: Display item list" + '\n'+ "2: Show Cart" +
                    '\n' + "3: Exit");
            return getInputInRange(1, 3);
        }
    public static int ItemsList() {
        System.out.println("1: Tshirt    2: Skirt");
        System.out.println("3: Pants");
        return getInputInRange (1,3);
    }
    public static String selectColor() {
        System.out.println("Choose color");
        System.out.println("1:Blue   2:Black");
        String color = "";
        switch (getInputInRange (1,2)){
            case 1: color = "Blue";
                break;
            case 2: color = "Black";
                break;
        }
        return color;
    }
    public static String chooseSize() {
        System.out.println("Choose Size");
        System.out.println("1: Small   2:Large");
        String size = "";
        switch (getInputInRange(1,2)){
            case 1: size = "Small";
                break;
            case 2: size = "Large";
        }
        return size;
    }
    public static double selectLength() {
        int length;
        System.out.println("Choose Length");
        System.out.println("1:110cm    2:130cm" + '\n'+"3:180cm");
        switch (getInputInRange(1,3)){
            case 1: length = 110;
                break;
            case 2: length = 130;
                break;
            default: length = 180;
        }
        return length;
    }
    public static int finaliseShopping(int items) {
        System.out.println("Selected " + items + " items ");
        System.out.println("1: To Confirm your Order    2: Continue Shopping");
        return getInputInRange(1,2);
    }
    public String customerName()
        {  Scanner scanner = new Scanner(System.in);
            System.out.print("Enter userName: ");
            while (!scanner.hasNext("[A-Za-z]+")) {
                System.out.println("Enter a valid String!");
                scanner.next();
            }
            return scanner.nextLine();
        }
        public static int getInputInRange ( int min, int max) {
            Scanner scanner = new Scanner(System.in);
            int userInput;

            while (true) {
                System.out.println("Please Make a choice between " + min + " and " + max + ":");
                try {
                    userInput = scanner.nextInt();
                    if (userInput >= min && userInput <= max) {
                        break;
                    } else {
                        System.out.println("Input is out of range. Please try again.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid integer.");
                    scanner.next(); // Clear invalid input
                }
            }
            //scanner.close();
            return userInput;
    }
}
