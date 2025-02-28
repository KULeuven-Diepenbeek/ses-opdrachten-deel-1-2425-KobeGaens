package model;

public class FriendshipTester {
  public static double calculateFriendship(String name1, String name2) {
    int sum = 0;
    // Tel de ASCII-waarden van de karakters in name1 op
    for (int i = 0; i < name1.length(); i++) {
      sum += name1.charAt(i);
    }
    // Tel de ASCII-waarden van de karakters in name2 op
    for (int i = 0; i < name2.length(); i++) {
      sum += name2.charAt(i);
    }
    // Bereken een score tussen 0 en 100 (inclusief 100, dus modulo 101)
    double score = sum % 101;
    return score;
  }
}
