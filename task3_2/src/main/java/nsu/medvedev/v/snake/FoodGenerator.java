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
    int foodNeeded = 6;
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
    public void erase(int i){
        foodList.remove(i);
    }

    //todo: разобраться с этой суетой
    public void generateFood(List<Point> snakeBody, int rows, int columns) {
        System.out.println(666);
        while (foodGenerated < foodNeeded) {
            System.out.println(777);
            for(int i = foodList.size(); i < foodOnField; i++) {
                System.out.println(888);
                setFoodX((int) (Math.random() * rows));
                setFoodY((int) (Math.random() * columns));
                int x = (int) foodX;
                int y = (int) foodY;
                foodList.add(new Point(x,y));
                System.out.println(999);
            }


            for (int i = 0; i < snakeBody.size(); i++) {
                System.out.println(101010);
                Point snake = snakeBody.get(i);
                System.out.println(11);
                for(int j = 0; j < foodOnField; j++){
                    //System.out.println(11);

                    if (snake.getX() == foodList.get(j).getX() && snake.getY() == foodList.get(j).getY()) {
                        int newX = (int) (Math.random() * rows);
                        int newY = (int) (Math.random() * columns);
                        foodList.set(j,new Point(newX, newY));
                        System.out.println(12);
                    }

                }
            }
            foodGenerated++;
            break;
        }
        System.out.println(foodGenerated);
        System.out.println(foodList + "asdasd");
    }

//    public void generateFood(int rows, int columns) {
//        setFoodX((int) (Math.random() * rows));
//        setFoodY((int) (Math.random() * columns));
//    }


}
