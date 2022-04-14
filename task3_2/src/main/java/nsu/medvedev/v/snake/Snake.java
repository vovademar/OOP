package nsu.medvedev.v.snake;

import javafx.scene.canvas.GraphicsContext;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.paint.Color;

public class Snake {
    public List<Point> snakeBody = new ArrayList<>();
    private Point snakeHead;
    boolean gameOver;
    Field field = new Field();


    Snake() {
        List<Point> snakeBody = new ArrayList<>();
        Point snakeHead;
    }

    Snake(List<Point> snakeBody, Point snakeHead) {
        this.snakeBody = snakeBody;
        this.snakeHead = snakeHead;
    }

    public List<Point> getSnakeBody() {
        return snakeBody;
    }

    public Point getSnakeHead() {
        return snakeHead;
    }

    public void setSnakeHead(Point snakeHead) {
        this.snakeHead = snakeHead;
    }

    public void setSnakeBody(List<Point> snakeBody) {
        this.snakeBody = snakeBody;
    }

    public void drawSnake(GraphicsContext gc) {
        initSnake();
        gc.setFill(Color.web("4674E9"));
        gc.fillRoundRect(snakeHead.getX() * field.getSQUARE_SIZE(), snakeHead.getY() * field.getSQUARE_SIZE(), field.getSQUARE_SIZE() - 1, field.getSQUARE_SIZE() - 1, 35, 35);

        for (int i = 1; i < snakeBody.size(); i++) {
            gc.fillRoundRect(snakeBody.get(i).getX() * field.getSQUARE_SIZE(), snakeBody.get(i).getY() * field.getSQUARE_SIZE(), field.getSQUARE_SIZE() - 1,
                    field.getSQUARE_SIZE() - 1, 20, 20);
        }
    }

    private void initSnake() {
        for (int i = 0; i < 3; i++) {
            snakeBody.add(new Point(5, field.getROWS() / 2));
        }
        snakeHead = snakeBody.get(0);
    }

    void moveRight() {
        snakeHead.x++;
    }

    void moveLeft() {
        snakeHead.x--;
    }

    void moveUp() {
        snakeHead.y--;
    }

    void moveDown() {
        snakeHead.y++;
    }

    public void gameOver() {
        if (snakeHead.x < 0 || snakeHead.y < 0 || snakeHead.x * field.getSQUARE_SIZE() >= field.getWIDTH() || snakeHead.y * field.getSQUARE_SIZE() >= field.getHEIGHT()) {
            gameOver = true;
        }

        //destroy itself
        for (int i = 1; i < snakeBody.size(); i++) {
            if (snakeHead.x == snakeBody.get(i).getX() && snakeHead.getY() == snakeBody.get(i).getY()) {
                gameOver = true;
                break;
            }
        }
    }

}
