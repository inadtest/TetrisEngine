public class Shape {
    public static int[][] getShape(char shape) {
        switch (shape) {
            case 'Q':
                return new int[][]{{1, 1}, {1, 1}};
            case 'Z':
                return new int[][]{{1, 1, 0}, {0, 1, 1}};
            case 'S':
                return new int[][]{{0, 1, 1}, {1, 1, 0}};
            case 'T':
                return new int[][]{{1, 1, 1}, {0, 1, 0}};
            case 'I':
                return new int[][]{{1, 1, 1, 1}};
            case 'L':
                return new int[][]{{1, 0}, {1, 0}, {1, 1}};
            case 'J':
                return new int[][]{{0, 1}, {0, 1}, {1, 1}};
            default:
                return new int[0][0];
        }
    }
}
