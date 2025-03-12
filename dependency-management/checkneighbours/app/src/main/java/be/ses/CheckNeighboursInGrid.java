package be.ses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckNeighboursInGrid {
    public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid, int width, int height, int indexToCheck) {
        // Hier moet je de logica implementeren om buren te vinden
        List<Integer> result = new ArrayList<>();

        // Converteer grid naar een lijst om er makkelijker mee te werken
        List<Integer> gridList = new ArrayList<>();
        for (Integer num : grid) {
            gridList.add(num);
        }

        // Waarde op de gegeven index
        int targetValue = gridList.get(indexToCheck);

        // Rijen en kolommen berekenen
        int row = indexToCheck / width;
        int col = indexToCheck % width;

        // Check de 4 buren (boven, onder, links, rechts)
        int[][] directions = {
            {-1, 0},  // boven
            {1, 0},   // onder
            {0, -1},  // links
            {0, 1}    // rechts
        };

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width) {
                int newIndex = newRow * width + newCol;
                if (gridList.get(newIndex) == targetValue) {
                    result.add(newIndex);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Testgrid
        List<Integer> grid = Arrays.asList(
            1, 2, 3,
            4, 1, 6,
            7, 8, 1
        );

        int width = 3;
        int height = 3;
        int indexToCheck = 4; // het middelste getal (1)

        // Methode aanroepen en resultaat printen
        Iterable<Integer> neighbours = getSameNeighboursIds(grid, width, height, indexToCheck);
        System.out.println("Gelijke buren op indexen: " + neighbours);
    }
}
