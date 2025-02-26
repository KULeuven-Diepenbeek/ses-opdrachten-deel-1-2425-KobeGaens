#include <stdio.h>
#include <string.h>
#include "friendshiptester.h"

int main(int argc, char *argv[]) {
    char name1[100];
    char name2[100];
    int decimal = 0;

    // Controleer of de flag -dec is meegegeven
    if (argc > 1) {
        if (strcmp(argv[1], "-dec") == 0) {
            decimal = 1;
        }
    }

    // Vraag de eerste naam
    printf("Voer de eerste naam in: ");
    if (fgets(name1, sizeof(name1), stdin) == NULL) {
        printf("Fout bij het lezen van de naam.\n");
        return 1;
    }
    name1[strcspn(name1, "\n")] = '\0';  // verwijder newline

    // Vraag de tweede naam
    printf("Voer de tweede naam in: ");
    if (fgets(name2, sizeof(name2), stdin) == NULL) {
        printf("Fout bij het lezen van de naam.\n");
        return 1;
    }
    name2[strcspn(name2, "\n")] = '\0';  // verwijder newline

    // Bereken de vriendschapscore
    double score = calculate_friendship(name1, name2);

    // Toon de score volgens de gekozen flag
    if (decimal) {
        printf("De vriendschapscore is: %.2f\n", score);
    } else {
        printf("De vriendschapscore is: %d\n", (int)score);
    }

    return 0;
}
