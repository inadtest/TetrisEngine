import java.io.IOException;

public class Tetris {
    public static void main(String[] args) {
        TetrisEngine engine = new TetrisEngine();
        try {
            engine.start();
        } catch (IOException e) {
            System.out.println("Error reading the input");
        }
    }
}
