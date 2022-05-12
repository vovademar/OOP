package nsu.medvedev.v.snake.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

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
        for (int i = 0; i < amount; i++) {

            int x = ((int) (Math.random() * rows));
            int y = ((int) (Math.random() * columns));
            for (int j = 0; j < barriers.size(); j++) {
                if (x == barriers.get(j).getX() && barriers.get(j).getY() == y) {
                    x = ((int) (Math.random() * rows));
                    x = ((int) (Math.random() * columns));
                    while (x == barriers.get(j).getX() && y == barriers.get(j).getY()){
                        x = ((int) (Math.random() * rows));
                        y = ((int) (Math.random() * columns));
                    }
                }
            }
            barriers.add(new Point(x, y));
        }
    }



}
