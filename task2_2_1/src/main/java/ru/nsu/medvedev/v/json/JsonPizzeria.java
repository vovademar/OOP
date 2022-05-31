package ru.nsu.medvedev.v.json;

public class JsonPizzeria {
    private final int bakersAmount;
    private final int deliverersAmount;
    private final int storageSize;
    private final int ordersDelay;
    private final JsonBaker[] bakers;
    private final JsonDeliverer[] deliverers;

    public JsonPizzeria(int bakersAmount, int deliverersAmount, int storageSize, int ordersDelay, JsonBaker[] bakers, JsonDeliverer[] deliverers) {
        this.bakersAmount = bakersAmount;
        this.deliverersAmount = deliverersAmount;
        this.storageSize = storageSize;
        this.ordersDelay = ordersDelay;
        this.bakers = bakers;
        this.deliverers = deliverers;
    }

    /**
     * method to return speed of baker
     *
     * @return array of baker's speeds
     */
    public int[] getBakersSpeeds() {
        int[] bakersSpeeds = new int[bakersAmount];
        for (int i = 0; i < bakersAmount; i++) {
            bakersSpeeds[i] = bakers[i].getCookingTime();
        }
        return bakersSpeeds;
    }

    /**
     * method to return and array of deliverer's speeds
     *
     * @return array of deliverer's speeds
     */
    public int[] getDeliverersSpeeds() {
        int[] deliverersSpeeds = new int[deliverersAmount];
        for (int i = 0; i < deliverersAmount; i++) {
            deliverersSpeeds[i] = deliverers[i].getSpeed();
        }
        return deliverersSpeeds;
    }

    /**
     * method to return trunk size of each deliverer's car
     *
     * @return array of trunk sizes
     */
    public int[] getTrunkSizes() {
        int[] trunkSizes = new int[deliverersAmount];
        for (int i = 0; i < deliverersAmount; i++) {
            trunkSizes[i] = deliverers[i].getTrunkSize();
        }
        return trunkSizes;
    }

    /**
     * method to return amount of bakers
     *
     * @return bakers amount
     */
    public int getBakersAmount() {
        return bakersAmount;
    }

    /**
     * method to return amount of deliverers
     *
     * @return deliverers amount
     */
    public int getDeliverersAmount() {
        return deliverersAmount;
    }

    /**
     * method to return size of storage
     *
     * @return storage size
     */
    public int getStorageSize() {
        return storageSize;
    }

    /**
     * method to return delay between two orders from customers
     *
     * @return a delay
     */
    public int getOrdersDelay() {
        return ordersDelay;
    }
}
