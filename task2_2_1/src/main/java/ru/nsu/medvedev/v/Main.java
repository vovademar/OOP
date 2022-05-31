package ru.nsu.medvedev.v;

import ru.nsu.medvedev.v.json.JsonProcessing;
import ru.nsu.medvedev.v.json.JsonPizzeria;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        JsonProcessing handler = new JsonProcessing();
        JsonPizzeria params = handler.jsonHandle();
        Pizzeria pizzeria = new Pizzeria(params.getBakersAmount(), params.getBakersSpeeds(), params.getDeliverersAmount(),
                params.getDeliverersSpeeds(), params.getStorageSize(), params.getTrunkSizes(), params.getOrdersDelay());
        pizzeria.pizzeriaStart();
        Thread.sleep(1000 * 60);
        pizzeria.pizzeriaStop();
    }
}
