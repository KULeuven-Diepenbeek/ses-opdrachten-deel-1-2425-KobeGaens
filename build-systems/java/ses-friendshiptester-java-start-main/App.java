import model.FriendshipTester;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean decimal = false;

    // Controleer of de flag -dec is meegegeven
    if (args.length > 0 && "-dec".equals(args[0])) {
      decimal = true;
    }

    // Vraag de eerste naam
    System.out.print("Voer de eerste naam in: ");
    String name1 = scanner.nextLine().trim();

    // Vraag de tweede naam
    System.out.print("Voer de tweede naam in: ");
    String name2 = scanner.nextLine().trim();

    // Bereken de vriendschapsscore
    double score = FriendshipTester.calculateFriendship(name1, name2);

    // Toon de score volgens de gekozen flag
    if (decimal) {
      System.out.printf("De vriendschapscore is: %.2f%n", score);
    } else {
      System.out.printf("De vriendschapscore is: %d%n", (int) score);
    }

    scanner.close();
  }
}
