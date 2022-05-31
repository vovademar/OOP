package ru.nsu.medvedev.v.json;

public class JsonBaker {
    private int cookingTime;

    public JsonBaker(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    /**
     * method to get cooking time
     *
     * @return cooking time
     */

    public int getCookingTime() {
        return cookingTime;
    }

    /**
     * method to set cooking time
     *
     * @param cookingTime - time to cook pizza
     */
    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }
}
