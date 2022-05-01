package nsu.medvedev.v.snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Point> snakeBody = new ArrayList<>();
    private Point snakeHead;
    Field field = new Field();

    Snake() {
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
        snakeBody.add(new Point(5, field.getROWS() / 2));
        snakeHead = snakeBody.get(0);
    }

    public void moveRight() {
        snakeHead.x++;
    }

    public void moveLeft() {
        snakeHead.x--;
    }

    public void moveUp() {
        snakeHead.y--;
    }

    public void moveDown() {
        snakeHead.y++;
    }

    public boolean gameOver() {
        if (snakeHead.x < 0 || snakeHead.y < 0 || snakeHead.x * field.getSQUARE_SIZE() >= field.getWIDTH() || snakeHead.y * field.getSQUARE_SIZE() >= field.getHEIGHT()) {
            return true;
        }

        for (int i = 1; i < snakeBody.size(); i++) {
            if (snakeHead.x == snakeBody.get(i).getX() && snakeHead.getY() == snakeBody.get(i).getY()) {
                return true;
            }
        }
        return false;
    }

}
