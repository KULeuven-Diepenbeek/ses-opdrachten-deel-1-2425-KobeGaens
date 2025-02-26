#include "friendshiptester.h"
#include <string.h>

double calculate_friendship(const char *name1, const char *name2)
{
  int sum = 0;
  // Tel de ASCII-waarden van de karakters in name1 op
  for (int i = 0; name1[i] != '\0'; i++)
  {
    sum += (int)name1[i];
  }
  // Tel de ASCII-waarden van de karakters in name2 op
  for (int i = 0; name2[i] != '\0'; i++)
  {
    sum += (int)name2[i];
  }
  // Bereken een score tussen 0 en 100
  double score = sum % 101;
  return score;
}
