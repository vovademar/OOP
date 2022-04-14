package nsu.medvedev.v.snake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import static nsu.medvedev.v.snake.Direction.*;

public class Application extends javafx.application.Application {
    Direction currentDirection = UP;
    Food food = new Food();


    @Override
    public void start(Stage stage) throws IOException {
        // FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        // Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
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
        Field field = new Field();
        Snake snake = new Snake();

//        for (int i = 0; i < 3; i++) {
//            snake.getSnakeBody().add(new Point(5, field.getROWS() / 2));
//        }

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
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
            }
        });

        Point head = snake.getSnakeHead();
        //head = snake.getSnakeBody().get(0);
        //Food food = new Food();
        food.generateFood();
        //run(gc);

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(130), e -> run(gc)));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void run(GraphicsContext gc) {
        Snake snake = new Snake();
        Field field = new Field();
        field.drawBackground(gc);
        food.drawFood(gc);
        snake.drawSnake(gc);

        for (int i = snake.getSnakeBody().size() - 1; i >= 1; i--) {
            snake.getSnakeBody().get(i).x = snake.getSnakeBody().get(i - 1).x;
            snake.getSnakeBody().get(i).y = snake.getSnakeBody().get(i - 1).y;
        }

        switch (currentDirection) {
            case RIGHT:
                snake.moveRight();
                break;
            case LEFT:
                snake.moveLeft();
                break;
            case UP:
                snake.moveUp();
                break;
            case DOWN:
                snake.moveDown();
                break;
        }

    }


    public static void main(String[] args) {
        launch();
    }
}