package nsu.medvedev.v.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.awt.*;
import java.util.List;

public class GraphicWork {
    Field field = new Field();

    public void drawBackground(GraphicsContext gc) {
        for (int i = 0; i < field.getROWS(); i++) {
            for (int j = 0; j < field.getCOLUMNS(); j++) {
                if ((i + j) % 2 == 0) {
                    gc.setFill(Color.web("B7E114"));
                } else {
                    gc.setFill(Color.web("18C812"));
                }
                gc.fillRect(i * field.getSQUARE_SIZE(), j * field.getSQUARE_SIZE(), field.getSQUARE_SIZE(), field.getSQUARE_SIZE());
            }
        }
    }

    public void drawFood(GraphicsContext gc, int foodX, int foodY) {
        Image image = new Image(String.valueOf(getClass().getResource("apple.png")));
        System.out.println(foodX * field.getSQUARE_SIZE());
        System.out.println(foodY * field.getSQUARE_SIZE());
        gc.drawImage(image, (foodX * field.getSQUARE_SIZE()) - 5, (foodY * field.getSQUARE_SIZE()) - 5);
    }

    public void drawSnake(GraphicsContext gc, Point snakeHead, List<Point> snakeBody) {
        gc.setFill(Color.web("4674E9"));
        gc.fillRoundRect(snakeHead.getX() * field.getSQUARE_SIZE(), snakeHead.getY() * field.getSQUARE_SIZE(), field.getSQUARE_SIZE() - 1, field.getSQUARE_SIZE() - 1, 35, 35);

        for (int i = 1; i < snakeBody.size(); i++) {
            gc.fillRoundRect(snakeBody.get(i).getX() * field.getSQUARE_SIZE(), snakeBody.get(i).getY() * field.getSQUARE_SIZE(), field.getSQUARE_SIZE() - 1,
                    field.getSQUARE_SIZE() - 1, 20, 20);
        }
    }

}

