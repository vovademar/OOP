package nsu.medvedev.v.snake.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

            // food not spawning in another food and inside snake
            Random r = new Random();
            for(int i = foodList.size(); i < foodOnField; i++){
                Point randomPoint;
                do {
                    randomPoint = new Point(r.nextInt(rows), r.nextInt(columns));
                } while (foodList.contains(randomPoint) && snakeBody.contains(randomPoint));
                foodList.add(randomPoint);
            }

            // food not spawning in barriers
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

            foodGenerated++;
            break;
        }
    }
}
