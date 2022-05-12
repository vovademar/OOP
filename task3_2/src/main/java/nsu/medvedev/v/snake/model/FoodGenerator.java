package nsu.medvedev.v.snake.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FoodGenerator {

    private List<Point> foodList = new ArrayList<>();
    private int foodOnField;
    private int foodGenerated = 0;
    private int sizeForWin;
    private int foodX;
    private int foodY;
    public FoodGenerator(int count, int score) {
        setFoodOnField(count);
        setSizeForWin(score);
    }

    public int getFoodOnField() {
        return foodOnField;
    }

    public void setFoodOnField(int foodOnField) {
        this.foodOnField = foodOnField;
    }

    public int getFoodGenerated() {
        return foodGenerated;
    }

    public int getSizeForWin() {
        return sizeForWin;
    }

    public void setSizeForWin(int sizeForWin) {
        this.sizeForWin = sizeForWin;
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
        while (foodGenerated < sizeForWin) {
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
                        while (newX == barriers.get(j).getX() && newY == barriers.get(j).getY()) {
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
                        foodList.set(j, new Point(newX, newY));
                    }

                }
            }
            foodGenerated++;
            break;
        }
    }
}
