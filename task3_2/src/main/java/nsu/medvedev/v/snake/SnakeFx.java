package nsu.medvedev.v.snake;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import static nsu.medvedev.v.snake.Direction.*;

public class SnakeFx extends javafx.application.Application {

    private ParametersForGame parametersForGame = new SettingsController().tellParameters();
    private Direction currentDirection = UP;
    private FoodGenerator foodGenerator = new FoodGenerator(parametersForGame.getFoodOnField(), parametersForGame.getFoodGoal());
    private Snake snake = new Snake();
    private FieldInfo field = new FieldInfo(parametersForGame.getFieldSize());
    private GraphicWork graphicWork = new GraphicWork();
    private BarrierGenerator barrierGenerator = new BarrierGenerator(parametersForGame.getBarriersAmount());

    private Timeline timeline;

    public SnakeFx() {
    }

    public SnakeFx(ParametersForGame parametersForGame) {
        this.foodGenerator = new FoodGenerator(parametersForGame.getFoodOnField(), parametersForGame.getFoodGoal());
        this.snake = new Snake();
        this.field = new FieldInfo(parametersForGame.getFieldSize());
        this.barrierGenerator = new BarrierGenerator(parametersForGame.getBarriersAmount());
    }

    @Override
    public void start(Stage stage) throws IOException {
        Group root = new Group();
        Canvas canvas = new Canvas(800, 800);
        InputStream iconStream = getClass().getResourceAsStream("snake.png");
        assert iconStream != null;
        Image image = new Image(iconStream);
        stage.getIcons().add(image);
        stage.setTitle("Snake game3000!");
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
        barrierGenerator.generateBarriers(field.getROWS(), field.getCOLUMNS());
        foodGenerator.generateFood(snake.getSnakeBody(), field.getROWS(), field.getCOLUMNS(), barrierGenerator.getBarriers());
        snake.initSnake(field.getROWS());
        timeline = new Timeline(new KeyFrame(Duration.millis(120), e -> {
            try {
                run(gc, stage);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void run(GraphicsContext gc, Stage stageStart) throws InterruptedException {
        if (snake.isGameOver(field.getSQUARE_SIZE(), field.getWIDTH(), field.getHEIGHT(), barrierGenerator.getBarriers())) {
            timeline.stop();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("you-lose.fxml"));
            transitionToNewFxml(stageStart, loader);
        }
        if (victory()) {
            timeline.stop();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("you-win.fxml"));
            transitionToNewFxml(stageStart, loader);
        }
        graphicWork.drawBackground(gc, field.getROWS(), field.getCOLUMNS(), field.getSQUARE_SIZE());
        graphicWork.drawBarriers(gc, field.getSQUARE_SIZE(), barrierGenerator.getBarriers());
        graphicWork.drawFood(gc, field.getSQUARE_SIZE(), foodGenerator.getFoodList());
        eatFood();
        graphicWork.drawSnake(gc, snake.getSnakeHead(), snake.getSnakeBody(), field.getSQUARE_SIZE());
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
    }

    private void transitionToNewFxml(Stage stageStart, FXMLLoader loader) throws InterruptedException {
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
        TimeUnit.SECONDS.sleep(1);
        stageStart.close();
    }

    public boolean victory() {
        return foodGenerator.getFoodGenerated() == foodGenerator.getSizeForWin();
    }

    public void eatFood() {
        for (int i = 0; i < foodGenerator.getFoodOnField(); i++) {
            if (snake.getSnakeHead().getX() == foodGenerator.getFoodList().get(i).getX() && snake.getSnakeHead().getY() == foodGenerator.getFoodList().get(i).getY()) {
                snake.getSnakeBody().add(new Point(-1, -1));
                foodGenerator.eraseElemFromFoodList(i);
                foodGenerator.generateFood(snake.getSnakeBody(), field.getROWS(), field.getCOLUMNS(), barrierGenerator.getBarriers());
            }
        }
    }
}