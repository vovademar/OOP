package nsu.medvedev.v.snake.model;

public class ParametersForGame {
    private int fieldSize;
    private int foodOnField;
    private int barriersAmount;
    private int foodGoal;

    public ParametersForGame(int fieldSize, int foodOnField, int barriersAmount, int foodGoal) {
        this.fieldSize = fieldSize;
        this.foodOnField = foodOnField;
        this.barriersAmount = barriersAmount;
        this.foodGoal = foodGoal;
    }

    public ParametersForGame() {
        this.fieldSize = 20;
        this.foodOnField = 5;
        this.barriersAmount = 13;
        this.foodGoal = 10;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public int getFoodOnField() {
        return foodOnField;
    }

    public void setFoodOnField(int foodOnField) {
        this.foodOnField = foodOnField;
    }

    public int getBarriersAmount() {
        return barriersAmount;
    }

    public void setBarriersAmount(int barriersAmount) {
        this.barriersAmount = barriersAmount;
    }

    public int getFoodGoal() {
        return foodGoal;
    }

    public void setFoodGoal(int foodGoal) {
        this.foodGoal = foodGoal;
    }
}
