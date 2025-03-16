package be.ses;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.*;

public class CheckNeighboursInGridTest {

    private List<Integer> toList(Iterable<Integer> iterable) { //omzetten naar list
        List<Integer> list = new ArrayList<>();
        iterable.forEach(list::add);
        return list;
    }

    @Test
    public void gegevenEnkelElement_wanneerGetNeighbours_danLegeLijst() {
        // Arrange
        List<Integer> grid = Collections.singletonList(1);

        // Act
        Iterable<Integer> neighbours = CheckNeighboursInGrid.getSameNeighboursIds(grid, 1, 1, 0);

        // Assert
        assertThat(toList(neighbours)).isEmpty();
    }

    @Test
    public void gegevenHoekElement_wanneerGetNeighbours_danEenBuur() {
        // Arrange
        List<Integer> grid = Arrays.asList(
                1, 2, 3,
                4, 1, 6,
                7, 8, 1
        );

        // Act
        Iterable<Integer> neighbours = CheckNeighboursInGrid.getSameNeighboursIds(grid, 3, 3, 0);

        // Assert
        assertThat(toList(neighbours)).containsExactlyInAnyOrder(4);
    }

    @Test
    public void gegevenRandElement_wanneerGetNeighbours_danTweeBuren() {
        // Arrange
        List<Integer> grid = Arrays.asList(
                1, 1, 3,
                4, 1, 6,
                7, 8, 1
        );

        // Act
        Iterable<Integer> neighbours = CheckNeighboursInGrid.getSameNeighboursIds(grid, 3, 3, 1);

        // Assert
        assertThat(toList(neighbours)).containsExactlyInAnyOrder(0, 4);
    }

    @Test
    public void gegevenMiddenElement_wanneerGetNeighbours_danSchuinBuren() {
        // Arrange
        List<Integer> grid = Arrays.asList(
                1, 2, 3,
                4, 1, 6,
                7, 8, 1
        );

        // Act
        Iterable<Integer> neighbours = CheckNeighboursInGrid.getSameNeighboursIds(grid, 3, 3, 4);

        // Assert
        assertThat(toList(neighbours)).containsExactly(0,8);
    }

    @Test
    public void gegevenGeenOvereenkomendeBuren_wanneerGetNeighbours_danLegeLijst() {
        // Arrange
        List<Integer> grid = Arrays.asList(
                1, 2, 3,
                4, 5, 6,
                7, 8, 9
        );

        // Act
        Iterable<Integer> neighbours = CheckNeighboursInGrid.getSameNeighboursIds(grid, 3, 3, 4);

        // Assert
        assertThat(toList(neighbours)).isEmpty();
    }

    @Test
    public void gegevenAlleWaardenGelijk_wanneerGetNeighbours_danAlleBuren() {
        // Arrange
        List<Integer> grid = Arrays.asList(
                1, 1, 1,
                1, 1, 1,
                1, 1, 1
        );

        // Act
        Iterable<Integer> neighbours = CheckNeighboursInGrid.getSameNeighboursIds(grid, 3, 3, 4);

        // Assert
        assertThat(toList(neighbours)).containsExactlyInAnyOrder(0,1,2,3,5,6,7,8);
    }

    @Test
    public void gegevenIndex9_wanneerGetNeighbours_danIndexOutOfBoundsException(){
        //arrange
        List<Integer> grid = Arrays.asList(
                1, 5, 7,
                3, 8, 4,
                6, 5, 1
        );
        // when
        Throwable thrown = catchThrowable(() -> {
            Iterable<Integer> neighbours = CheckNeighboursInGrid.getSameNeighboursIds(grid, 3, 3, 9);
        });

        // then
        assertThat(thrown)
            .isInstanceOf(IndexOutOfBoundsException.class)
            .hasMessageContaining("index");
    }

    @Test
    public void gegevenGroteArray_wanneerGetNeighbours_danGeenBuren(){
        //arrange
        List<Integer> grid = Arrays.asList(
                1, 5, 7, 1, 9,
                3, 8, 4, 6, 3,
                6, 5, 1, 8, 0,
                5, 3, 7, 0 ,7,
                1, 7, 6, 4, 3
        );
        // when
            Iterable<Integer> neighbours = CheckNeighboursInGrid.getSameNeighboursIds(grid, 5, 5, 24);
        //assert
        assertThat(toList(neighbours)).isEmpty();

    }

    @Test
    public void gegevenOnevenArray_wanneerGetNeighbours_danEenBuur(){
        //arrange
        List<Integer> grid = Arrays.asList(
                1, 5, 7, 4, 9,
                3, 8, 4, 6, 3
        );
        // when
            Iterable<Integer> neighbours = CheckNeighboursInGrid.getSameNeighboursIds(grid, 5, 2, 3);
        //assert
        assertThat(toList(neighbours)).containsExactlyInAnyOrder(7);
    }
}
