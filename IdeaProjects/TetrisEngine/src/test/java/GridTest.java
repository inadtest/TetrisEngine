import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class GridTest {
    @Test
    public void testPiecePlacement() {
        Grid grid = new Grid(5, 5);

        grid.placeShape('Q', 0);
        int[][] expectedGridState = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0}
        };
        assertArrayEquals(expectedGridState, grid.getGrid());
        grid.reset();

        grid.placeShape('T', 2);
        int[][] expectedGridState2 = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 1, 1, 1},
                {0, 0, 0, 1, 0}
        };
        assertArrayEquals(expectedGridState2, grid.getGrid());
    }

    @Test
    public void testRowClearing() {
        Grid grid = new Grid(4, 4);

        // Fill a row with pieces and clear it
        grid.placeShape('Q', 0);
        grid.placeShape('Q', 2);
        grid.clearFilledRows();
        int[][] expectedGridState = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        assertArrayEquals(expectedGridState, grid.getGrid());
    }
    
    @Test
    public void testGetRowHeight() {
        Grid grid = new Grid(5, 5);

        // empty grid
        int rowHeight1 = grid.getRowHeight();
        assertEquals(0, rowHeight1);

        // Fill some rows and test the row height
        grid.placeShape('Q', 0);
        grid.placeShape('Q', 1);
        grid.placeShape('T', 2);
        int rowHeight2 = grid.getRowHeight();
        assertEquals(5, rowHeight2);
    }

}
