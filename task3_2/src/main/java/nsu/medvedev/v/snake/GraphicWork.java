package nsu.medvedev.v.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.List;

public class GraphicWork {

    public void drawBarriers(GraphicsContext gc, int squareSize, List<Point> barriers) {
        gc.setFill(Color.web("000000"));
        for (int i = 0; i < barriers.size(); i++) {
            gc.fillRoundRect(barriers.get(i).getX() * squareSize, barriers.get(i).getY() * squareSize, squareSize - 1, squareSize - 1, 20, 20);
        }
    }

    public void drawBackground(GraphicsContext gc, int rows, int columns, int squareSize) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web("B7E114"));
                } else {
                    gc.setFill(Color.web("18C812"));
                }
                gc.fillRect(i * squareSize, j * squareSize, squareSize, squareSize);
            }
        }
    }

    public void drawFood(GraphicsContext gc, int squareSize, List<Point> foodList) {
        Image image = new Image(String.valueOf(getClass().getResource("apple.png")));
        System.out.println(foodList);
        for (int j = 0; j < foodList.size(); j++) {
            gc.drawImage(image, (foodList.get(j).getX() * squareSize) - 5, (foodList.get(j).getY() * squareSize) - 5);
        }
    }

    public void drawSnake(GraphicsContext gc, Point snakeHead, List<Point> snakeBody, int squareSize) {
        gc.setFill(Color.web("4674E9"));
        gc.fillRoundRect(snakeHead.getX() * squareSize, snakeHead.getY() * squareSize, squareSize - 1, squareSize - 1, 35, 35);

        for (int i = 1; i < snakeBody.size(); i++) {
            gc.fillRoundRect(snakeBody.get(i).getX() * squareSize, snakeBody.get(i).getY() * squareSize, squareSize - 1,
                    squareSize - 1, 20, 20);
        }
    }

}

