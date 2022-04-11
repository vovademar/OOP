module nsu.medvedev.v.snake {
    requires javafx.controls;
    requires javafx.fxml;


    opens nsu.medvedev.v.snake to javafx.fxml;
    exports nsu.medvedev.v.snake;
}