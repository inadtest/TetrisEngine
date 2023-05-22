import java.util.Arrays;

public class Grid {
    private int[][] grid;

    public Grid(int height, int width) {
        grid = new int[height][width];
    }

    public void placeShape(char shape, int col) {
        int[][] shapeValue = Shape.getShape(shape);
        int numRows = shapeValue.length;
        int numCols = shapeValue[0].length;
        int row = 0;

        while (row < grid.length - numRows + 1 && canPlaceShape(row, col, shapeValue)) {
            row++;
        }
        row--;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (shapeValue[i][j] != 0) {
                    grid[row + i][col + j] = shapeValue[i][j];
                }
            }
        }
    }

    private boolean canPlaceShape(int row, int col, int[][] shape) {
        int numRows = shape.length;
        int numCols = shape[0].length;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (shape[i][j] != 0 && (row + i >= grid.length || grid[row + i][col + j] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }

    public int getRowHeight() {
        int height = grid.length;
        int width = grid[0].length;
        int rowHeight = 0;

        for (int row = 0; row < height; row++) {
            boolean hasNonZero = false;
            for (int col = 0; col < width; col++) {
                if (grid[row][col] != 0) {
                    hasNonZero = true;
                    break;
                }
            }
            if (hasNonZero) {
                rowHeight++;
            }
        }
        return rowHeight;
    }

    public void clearFilledRows() {
        int height = grid.length;
        int width = grid[0].length;

        for (int row = height - 1; row >= 0; row--) {
            boolean isFilled = true;
            for (int col = 0; col < width; col++) {
                if (grid[row][col] == 0) {
                    isFilled = false;
                    break;
                }
            }
            if (isFilled) {
                removeRow(row);
                shiftRowsDown(row);
                row++;
            }
        }
    }

    private void removeRow(int row) {
        Arrays.fill(grid[row], 0);
    }

    private void shiftRowsDown(int startRow) {
        for (int row = startRow; row > 0; row--) {
            System.arraycopy(grid[row - 1], 0, grid[row], 0, grid[0].length);
        }
        Arrays.fill(grid[0], 0);
    }

    public void reset() {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                grid[i][j] = 0;
            }
        }
    }
}
