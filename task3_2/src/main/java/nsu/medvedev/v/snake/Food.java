package nsu.medvedev.v.snake;

import java.awt.*;
import java.util.List;

public class Food {
    private Image foodImage;
    private int foodX;
    private int foodY;
    Snake snake = new Snake();
    List<Point> snakeBody = snake.getSnakeBody();
    Field field = new Field();

    public Image getFoodImage() {
        return foodImage;
    }

    public void setFoodImage(Image foodImage) {
        this.foodImage = foodImage;
    }

    public int getFoodX() {
        return foodX;
    }

    public void setFoodX(int foodX) {
        this.foodX = foodX;
    }

    public int getFoodY() {
        return foodY;
    }

    public void setFoodY(int foodY) {
        this.foodY = foodY;
    }

    public void generateFood() {
        start:
        while (true) {
            setFoodX((int) (Math.random() * field.getROWS()));
            setFoodY((int) (Math.random() * field.getCOLUMNS()));
            System.out.println(getFoodX());
            System.out.println(getFoodY());
            System.out.println(" ");

            for (Point snake : snakeBody) {
                if (snake.getX() == foodX && snake.getY() == foodY) {
                    continue start;
                }
            }
            break;
        }
    }

}
