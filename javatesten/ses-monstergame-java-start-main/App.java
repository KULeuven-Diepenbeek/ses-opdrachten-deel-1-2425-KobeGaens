import java.util.Random;
import java.util.Scanner;
import model.Monster;
import model.Player;
import model.Potion;

public class App {
  private static final Random random = new Random();

  public static void playTurn(Player player, Monster monster, int choice) {
    int monsterAttack = random.nextInt(4) + 1; // Monster doet tussen 1 en 4 schade

    switch (choice) {
      case 1 -> { // Aanvallen
        int attackDamage = random.nextInt(2) + 1; // 1 of 2 schade
        monster.hp -= attackDamage;
        System.out.println("Je valt aan en doet " + attackDamage + " schade!");
      }
      case 2 -> { // Blokkeren
        if (random.nextInt(100) < 80) {
          monsterAttack = 0;
          System.out.println("Je blokkeert de aanval succesvol!");
        } else {
          System.out.println("Je blokkeerpoging faalt!");
        }
      }
      case 3 -> Potion.drink(player, monster); // Lucky potion drinken
      default -> {
        System.out.println("Ongeldige keuze, probeer opnieuw!");
        return;
      }
    }

    // Monster valt aan als het nog leeft
    if (monster.hp > 0) {
      player.hp -= monsterAttack;
      System.out.println("Het monster valt aan en doet " + monsterAttack + " schade!");
    }
  }

  public static void main(String[] args) {
    int startingHp = 10;

    // Controleer of er een --hp argument is opgegeven
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("--hp") && i + 1 < args.length) {
        try {
          startingHp = Integer.parseInt(args[i + 1]);
        } catch (NumberFormatException e) {
          System.out.println("Ongeldige HP waarde, standaard 10 wordt gebruikt.");
        }
        break;
      }
    }

    Player player = new Player(startingHp);
    Monster monster = new Monster(10);

    System.out.println("Welkom bij het gevechtsspel!");
    System.out.println("Jouw start HP is: " + player.hp);

    Scanner scanner = new Scanner(System.in);
    while (player.hp > 0 && monster.hp > 0) {
      System.out.println("\nJouw HP: " + player.hp + " | Monster HP: " + monster.hp);
      System.out.println("Kies een actie:");
      System.out.println("1. Aanvallen");
      System.out.println("2. Blokkeren");
      System.out.println("3. Lucky Potion drinken");
      System.out.print("Voer je keuze in: ");

      int keuze;
      if (scanner.hasNextInt()) {
        keuze = scanner.nextInt();
        playTurn(player, monster, keuze);
      } else {
        System.out.println("Ongeldige invoer, probeer opnieuw.");
        scanner.next(); // Verwijder ongeldige invoer
      }
    }
    scanner.close();

    if (player.hp > 0) {
      System.out.println("\nGefeliciteerd! Je hebt het monster verslagen!");
    } else {
      System.out.println("\nHelaas! Het monster heeft jou verslagen...");
    }
  }
}
