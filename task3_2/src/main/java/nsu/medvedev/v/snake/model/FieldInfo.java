package nsu.medvedev.v.snake.model;

public class FieldInfo {
    private final int WIDTH;
    private final int HEIGHT;
    private final int ROWS;
    private final int COLUMNS;
    private final int SQUARE_SIZE;

    public FieldInfo() {
        this.WIDTH = 800;
        this.HEIGHT = 800;
        this.ROWS = 20;
        this.COLUMNS = ROWS;
        this.SQUARE_SIZE = this.WIDTH / this.ROWS;

    }

    public FieldInfo(int width, int height, int rows, int columns) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.ROWS = rows;
        this.COLUMNS = columns;
        this.SQUARE_SIZE = width / columns;
    }
    public FieldInfo(int rows) {
        this.WIDTH = 800;
        this.HEIGHT = 800;
        this.ROWS = rows;
        this.COLUMNS = rows;
        this.SQUARE_SIZE = this.WIDTH / rows;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    public int getSQUARE_SIZE() {
        return SQUARE_SIZE;
    }

}
