package nsu.medvedev.v.snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    public List<Point> snakeBody = new ArrayList<>();
    private Point snakeHead;
    public boolean gameOver;
    Field field = new Field();

    public boolean isGameOver() {
        return gameOver;
    }

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

    public void initSnake() {
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

        for (int i = 1; i < snakeBody.size(); i++) {
            if (snakeHead.x == snakeBody.get(i).getX() && snakeHead.getY() == snakeBody.get(i).getY()) {
                gameOver = true;
                break;
            }
        }
    }

}
