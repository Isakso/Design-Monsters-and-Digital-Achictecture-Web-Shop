package CommandMonster;

import java.util.ArrayList;
public class Production {
    private final ArrayList<Production> production = new ArrayList<>();
    public void addCommand(Production commandProduction) {
        production.add(commandProduction);
    }
    public void processCommand() {
        for (Production commandProduction: production) {
            commandProduction.processCommand();
            sleepSeconds(1); // Pause for 1 second
        }
        production.clear();
    }
    private static void sleepSeconds(int seconds) {
        try {
            Thread.sleep(seconds * 1000L); // Convert seconds to milliseconds
        } catch (InterruptedException ex) {
            ex.printStackTrace();
            Thread.currentThread().interrupt(); // Restore interrupted status
        }
    }
}
