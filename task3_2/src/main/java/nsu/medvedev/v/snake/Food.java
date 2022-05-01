package nsu.medvedev.v.snake;

import java.awt.*;
import java.util.List;

public class Food {
    private int foodX;
    private int foodY;
    Field field = new Field();


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

    public void generateFood(List<Point> snakeBody) {
        start:
        while (true) {
            setFoodX((int) (Math.random() * field.getROWS()));
            setFoodY((int) (Math.random() * field.getCOLUMNS()));
            System.out.println(getFoodX());
            System.out.println(getFoodY());
            System.out.println(" ");

            for (int i = 0; i < snakeBody.size(); i++) {
                Point snake = snakeBody.get(i);
                if (snake.getX() == getFoodX() && snake.getY() == getFoodY()) {
                    continue start;
                }
            }
            break;
        }
    }

    public void generateFood() {
        setFoodX((int) (Math.random() * field.getROWS()));
        setFoodY((int) (Math.random() * field.getCOLUMNS()));
    }


}
