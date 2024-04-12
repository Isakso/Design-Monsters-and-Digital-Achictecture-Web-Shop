import WigellsAB.Cart;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        boolean nextCustomer = true;
        while(nextCustomer) {
            Cart cart = new Cart(); // initialise a shopping basket
            cart.createCustomer();
            cart.StartShopping();
            nextCustomer = false;  // call the start Shopping method on the cart
       }
          // If not New customer?
    }
}