package nsu.medvedev.v.snake;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<Point> snakeBody = new ArrayList<>();
    private Point snakeHead;

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


    public void initSnake(int rows) {
        snakeBody.add(new Point(5, rows / 2));
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

    public boolean isGameOver(int squareSize, int width, int height, List<Point> barriers) {
        if (snakeHead.x < 0 || snakeHead.y < 0 || snakeHead.x * squareSize >= width || snakeHead.y * squareSize >= height) {
            return true;
        }

        for (int i = 1; i < snakeBody.size(); i++) {
            if (snakeHead.x == snakeBody.get(i).getX() && snakeHead.getY() == snakeBody.get(i).getY()) {
                return true;
            }
        }

        for (int i = 0; i < barriers.size(); i++) {
            if (snakeHead.x == barriers.get(i).getX() && snakeHead.y == barriers.get(i).getY()) {
                return true;
            }
        }
        return false;
    }

}
