package ru.nsu.medvedev.v.json;

public class JsonDeliverer {
    private int deliveryTime;
    private int trunkSize;

    public JsonDeliverer(int deliveryTime, int trunkSize) {
        this.deliveryTime = deliveryTime;
        this.trunkSize = trunkSize;
    }

    /**
     * method to return delivery time
     *
     * @return time to deliver pizza
     */
    public int getSpeed() {
        return deliveryTime;
    }

    /**
     * method to return trunk size
     *
     * @return size of the trunk
     */
    public int getTrunkSize() {
        return trunkSize;
    }
}
