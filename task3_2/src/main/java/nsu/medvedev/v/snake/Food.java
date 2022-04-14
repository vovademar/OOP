package nsu.medvedev.v.snake;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.awt.*;
import java.util.List;

public class Food {
    private Image foodImage;
    private int foodX;
    private int foodY;
    List<Point> snakeBody = new Snake().getSnakeBody();
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
        //start:
       // while (true) {
            setFoodX((int) (Math.random() * field.getROWS()));
            setFoodY((int) (Math.random() * field.getCOLUMNS()));
            System.out.println(getFoodX());
            System.out.println(getFoodY());
            System.out.println(" ");

//            for (Point snake : snakeBody) {
//                if (snake.getX() == foodX && snake.getY() == foodY) {
//                    continue start;
//                }
//            }
          //  break;
       // }
//        int[] mas = {0,0};
//        mas[0] = foodX;
//        mas[1] = foodY;
//        return mas;
    }

    public void drawFood(GraphicsContext gc) {
        //int [] coords = generateFood();
        Image image = new Image(String.valueOf(getClass().getResource("apple.png")));
        System.out.println(getFoodX() * field.getSQUARE_SIZE());
        System.out.println(getFoodY() * field.getSQUARE_SIZE());
        gc.drawImage(image, (getFoodX() * field.getSQUARE_SIZE()) - 5, (getFoodY() * field.getSQUARE_SIZE()) - 5);
    }
}
