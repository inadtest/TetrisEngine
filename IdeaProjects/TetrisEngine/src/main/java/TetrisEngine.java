import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TetrisEngine {
    private static final int GRID_WIDTH = 10;
    private static final int GRID_HEIGHT = 100;

    private Grid grid;

    public TetrisEngine() {
        grid = new Grid(GRID_HEIGHT, GRID_WIDTH);
    }

    public void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            int result = processShape(line);
            System.out.println(result);
            grid.reset();
        }
    }

    private int processShape(String line) {
        String[] entries = line.split(",");
        for (String entry : entries) {
            char shape = entry.charAt(0);
            int column = Integer.parseInt(entry.substring(1));
            grid.placeShape(shape, column);
            grid.clearFilledRows();
        }
        return grid.getRowHeight();
    }
}
