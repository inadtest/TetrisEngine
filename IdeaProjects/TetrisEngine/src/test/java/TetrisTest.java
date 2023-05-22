import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TetrisTest {
    @Test
    public void testPiecePlacementAndBottomRowClearing() {
        String input = "I0,I4,Q8";
        String expectedOutput = "1";

        String actualOutput = runTetrisWithInput(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testPiecePlacementNoRowClearing() {
        String input = "T1,Z3,I4";
        String expectedOutput = "4";

        String actualOutput = runTetrisWithInput(input);
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testPlaceMultiplePieces() {
        String input = "Q0,I2,I6,I0,I6,I6,Q2,Q4";
        String expectedOutput = "3";

        String actualOutput = runTetrisWithInput(input);
        assertEquals(expectedOutput, actualOutput);
    }

    private String runTetrisWithInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        System.setIn(inputStream);
        System.setOut(new PrintStream(outputStream));

        Tetris.main(new String[]{});

        System.setIn(System.in);
        System.setOut(System.out);
        return outputStream.toString().trim();
    }
}
