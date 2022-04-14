package nsu.medvedev.v.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Field {
    private final int WIDTH;
    private final int HEIGHT;
    private final int ROWS;
    private final int COLUMNS;
    private final int SQUARE_SIZE;


    public Field() {
        this.WIDTH = 800;
        this.HEIGHT = 800;
        this.ROWS = 20;
        this.COLUMNS = ROWS;
        this.SQUARE_SIZE = this.WIDTH / this.ROWS;

    }

    public Field(int width, int height, int rows, int columns) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.ROWS = rows;
        this.COLUMNS = columns;
        this.SQUARE_SIZE = width / columns;
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


    public void drawBackground(GraphicsContext gc) {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLUMNS; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web("31BF2C"));
                } else {
                    gc.setFill(Color.web("18C812"));
                }
                gc.fillRect(i * SQUARE_SIZE, j * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }


}
