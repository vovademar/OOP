package ru.nsu.medvedev.v;

public class Order {
    private int orderNumber;
    private String orderStatus;

    /**
     * method to get order number
     *
     * @return number of an order
     */
    public int getOrderNumber() {
        return orderNumber;
    }

    /**
     * method to set order number
     *
     * @param orderNumber - new order number
     */
    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * method to get order status
     *
     * @return status of an order
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * method to set order status
     *
     * @param orderStatus - new status to set
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}