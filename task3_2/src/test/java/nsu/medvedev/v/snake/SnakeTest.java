package nsu.medvedev.v.snake;

import nsu.medvedev.v.snake.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnakeTest {


    @Test
    public void snakeTestOutOfBounds(){
        ParametersForGame parametersForGame = new ParametersForGame();
        Snake snake = new Snake();
        BarrierGenerator barrierGenerator = new BarrierGenerator(0);
        FieldInfo fieldInfo = new FieldInfo();
        snake.initSnake(parametersForGame.getFieldSize());
        snake.setSnakeHead(new Point(-1,1));
        Assertions.assertTrue(snake.isGameOver(fieldInfo.getSQUARE_SIZE(), fieldInfo.getWIDTH(), fieldInfo.getHEIGHT(), barrierGenerator.getBarriers()));
    }
    @Test
    public void snakeTestInBounds(){
        ParametersForGame parametersForGame = new ParametersForGame();
        Snake snake = new Snake();
        BarrierGenerator barrierGenerator = new BarrierGenerator(0);
        FieldInfo fieldInfo = new FieldInfo();
        snake.initSnake(parametersForGame.getFieldSize());
        snake.setSnakeHead(new Point(1,1));
        Assertions.assertFalse(snake.isGameOver(fieldInfo.getSQUARE_SIZE(), fieldInfo.getWIDTH(), fieldInfo.getHEIGHT(), barrierGenerator.getBarriers()));
    }
    @Test
    public void snakeBumpsIntoBarrier(){
        ParametersForGame parametersForGame = new ParametersForGame();
        Snake snake = new Snake();
        BarrierGenerator barrierGenerator = new BarrierGenerator(1);
        FieldInfo fieldInfo = new FieldInfo();
        snake.initSnake(parametersForGame.getFieldSize());
        snake.setSnakeHead(new Point(1,1));
        List<Point> barrier = new ArrayList<>();
        barrier.add(new Point(1,1));
        Assertions.assertTrue(snake.isGameOver(fieldInfo.getSQUARE_SIZE(), fieldInfo.getWIDTH(), fieldInfo.getHEIGHT(), barrier));
    }


}
