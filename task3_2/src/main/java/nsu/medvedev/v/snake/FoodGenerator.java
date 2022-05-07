package nsu.medvedev.v.snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FoodGenerator {

    FoodGenerator(int count) {
        setFoodOnField(count);
    }

    FoodGenerator() {
        setFoodOnField(5);
    }

    int foodOnField;
    int foodGenerated = 0;
    int foodNeeded = 23;
    private int foodX;
    private int foodY;
    List<Point> foodList = new ArrayList<>();

    public int getFoodOnField() {
        return foodOnField;
    }

    public void setFoodOnField(int foodOnField) {
        this.foodOnField = foodOnField;
    }

    public int getFoodGenerated() {
        return foodGenerated;
    }

    public void setFoodGenerated(int foodGenerated) {
        this.foodGenerated = foodGenerated;
    }

    public int getFoodNeeded() {
        return foodNeeded;
    }

    public void setFoodNeeded(int foodNeeded) {
        this.foodNeeded = foodNeeded;
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

    public List<Point> getFoodList() {
        return foodList;
    }

    public void setFoodList(List<Point> foodList) {
        this.foodList = foodList;
    }

    public void eraseElemFromFoodList(int i) {
        foodList.remove(i);
    }

    public void generateFood(List<Point> snakeBody, int rows, int columns, List<Point> barriers) {
        while (foodGenerated < foodNeeded) {
            for (int i = foodList.size(); i < foodOnField; i++) {
                setFoodX((int) (Math.random() * rows));
                setFoodY((int) (Math.random() * columns));
                int x = foodX;
                int y = foodY;
                for (int j = 0; j < foodList.size(); j++) {
                    if (x == foodList.get(j).getX() && foodList.get(j).getY() == y) {
                        x = ((int) (Math.random() * rows));
                        y = ((int) (Math.random() * columns));
                    }
                }
                foodList.add(new Point(x, y));
            }

            for (int i = 0; i < foodOnField; i++) {
                for (int j = 0; j < barriers.size(); j++) {
                    if (foodList.get(i).getX() == barriers.get(j).getX() && foodList.get(i).getY() == barriers.get(j).getY()) {
                        int newX = ((int) (Math.random() * rows));
                        int newY = ((int) (Math.random() * columns));
                        while (newX == barriers.get(j).getX() && newY == barriers.get(j).getY()){
                            newX = ((int) (Math.random() * rows));
                            newY = ((int) (Math.random() * columns));
                        }
                        foodList.set(i, new Point(newX, newY));

                    }
                }
            }

            for (int i = 0; i < snakeBody.size(); i++) {
                Point snake = snakeBody.get(i);
                for (int j = 0; j < foodOnField; j++) {

                    if (snake.getX() == foodList.get(j).getX() && snake.getY() == foodList.get(j).getY()) {

                        int newX = ((int) (Math.random() * rows));
                        int newY = ((int) (Math.random() * columns));
                        while (newX == barriers.get(j).getX() && newY == barriers.get(j).getY() && snake.getX() == newX && snake.getY() == newY){
                            newX = ((int) (Math.random() * rows));
                            newY = ((int) (Math.random() * columns));
                        }
                        foodList.set(j, new Point(newX, newY));
                    }

                }
            }
            foodGenerated++;
            break;
        }
    }
}
