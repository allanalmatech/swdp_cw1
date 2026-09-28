import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunAll {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String choice = "";
        while (!choice.equals("0")) {
            printMenu();
            choice = in.readLine().trim();

            if (choice.equals("1")) {
                System.out.println();
                milestone1_strategy.Main.run();
            } else if (choice.equals("2")) {
                System.out.println();
                milestone2_observer.Main.run();
            } else if (choice.equals("3")) {
                System.out.println();
                milestone3_decorator.Main.run();
            } else if (choice.equals("4")) {
                System.out.println();
                milestone4_factory.Main.run();
            } else if (choice.equals("5")) {
                System.out.println();
                milestone5_singleton.Main.run();
            } else if (choice.equalsIgnoreCase("s")) {
                System.out.println();
                stretch.Main.run();
            } else if (!choice.equals("0")) {
                System.out.println("Unknown choice, try again.");
            }

            if (!choice.equals("0")) {
                System.out.println("Press Enter to return to the menu...");
                in.readLine();
            }
        }
        System.out.println("Bye.");
    }

    static void printMenu() {
        System.out.println();
        System.out.println("=== BrewHub Coursework 1: Software Design Patterns ===");
        System.out.println("  1 - Milestone 1: Strategy");
        System.out.println("  2 - Milestone 2: Observer");
        System.out.println("  3 - Milestone 3: Decorator");
        System.out.println("  4 - Milestone 4: Factory Method + Abstract Factory");
        System.out.println("  5 - Milestone 5: Singleton");
        System.out.println("  S - Stretch goal: Observer + Singleton wired together");
        System.out.println("  0 - Quit");
        System.out.print("Choose: ");
    }
}