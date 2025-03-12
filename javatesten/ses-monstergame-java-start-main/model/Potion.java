package model;

import java.util.Random;

public class Potion {
  private static final Random random = new Random();

  public static void drink(Player player, Monster monster) {
    int outcome = random.nextInt(100);
    if (outcome < 10) {
      player.hp += 4;
      System.out.println("De potion is super krachtig! +4 HP!");
    } else if (outcome < 20) {
      monster.hp += 2;
      System.out.println("Oeps! Je hebt het monster genezen! +2 HP voor het monster!");
    } else if (outcome < 30) {
      player.hp -= 2;
      System.out.println("De potion was giftig! -2 HP!");
    } else {
      player.hp += 2;
      System.out.println("De potion werkt! +2 HP!");
    }
  }
}