package nsu.medvedev.v.snake.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BarrierGenerator {
    private List<Point> barriers = new ArrayList<>();

    private int amount;

    public BarrierGenerator(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public List<Point> getBarriers() {
        return barriers;
    }

    public void setBarriers(List<Point> barriers) {
        this.barriers = barriers;
    }

    public void generateBarriers(int rows, int columns) {
        Random r = new Random();
        while (barriers.size() < amount) {
            Point randomPoint;
            do {
                randomPoint = new Point(r.nextInt(rows), r.nextInt(columns));
            } while (barriers.contains(randomPoint));
            barriers.add(randomPoint);
        }
    }



}
