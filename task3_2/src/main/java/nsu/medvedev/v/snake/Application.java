package nsu.medvedev.v.snake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import static nsu.medvedev.v.snake.Direction.*;

public class Application extends javafx.application.Application {
    Direction currentDirection = UP;
    Food food = new Food();
    Snake snake = new Snake();
    Field field = new Field();


    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Canvas canvas = new Canvas(800, 800);
        InputStream iconStream = getClass().getResourceAsStream("snake.png");
        assert iconStream != null;
        Image image = new Image(iconStream);
        stage.getIcons().add(image);
        stage.setTitle("Hello!");
        root.getChildren().add(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        GraphicsContext gc = canvas.getGraphicsContext2D();

        scene.setOnKeyPressed(event -> {
            KeyCode code = event.getCode();
            if (code == KeyCode.RIGHT || code == KeyCode.D) {
                if (currentDirection != LEFT) {
                    currentDirection = RIGHT;
                }
            } else if (code == KeyCode.LEFT || code == KeyCode.A) {
                if (currentDirection != RIGHT) {
                    currentDirection = LEFT;
                }
            } else if (code == KeyCode.UP || code == KeyCode.W) {
                if (currentDirection != DOWN) {
                    currentDirection = UP;
                }
            } else if (code == KeyCode.DOWN || code == KeyCode.S) {
                if (currentDirection != UP) {
                    currentDirection = DOWN;
                }
            }
        });

        food.generateFood();
        //run(gc);
        snake.initSnake();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(120), e -> run(gc)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void run(GraphicsContext gc) {
        if (snake.isGameOver()) {
            gc.setFill(Color.web("E73213"));
            gc.setFont(new Font("BOLD", 70));
            System.out.println("gg");
            gc.fillText("Game Over", field.getWIDTH() / 3.5, field.getHEIGHT() / 2.0);
            return;
        }
        field.drawBackground(gc);
        food.drawFood(gc);

        snake.drawSnake(gc);

        for (int i = snake.getSnakeBody().size() - 1; i >= 1; i--) {
            snake.getSnakeBody().get(i).x = snake.getSnakeBody().get(i - 1).x;
            snake.getSnakeBody().get(i).y = snake.getSnakeBody().get(i - 1).y;
        }

        switch (currentDirection) {
            case RIGHT -> snake.moveRight();
            case LEFT -> snake.moveLeft();
            case UP -> snake.moveUp();
            case DOWN -> snake.moveDown();
        }

        eatFood();
        snake.gameOver();
    }

    public void eatFood() {
        if (snake.getSnakeHead().getX() == food.getFoodX() && snake.getSnakeHead().getY() == food.getFoodY()) {
            snake.getSnakeBody().add(new Point(-1, -1));
            food.generateFood();
            //score += 5;
        }
    }


    public static void main(String[] args) {
        launch();
    }
}