module nsu.medvedev.v.snake {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.datatransfer;
    requires java.desktop;


    opens nsu.medvedev.v.snake to javafx.fxml;
    exports nsu.medvedev.v.snake;
    exports nsu.medvedev.v.snake.model;
    opens nsu.medvedev.v.snake.model to javafx.fxml;
    exports nsu.medvedev.v.snake.graphics;
    opens nsu.medvedev.v.snake.graphics to javafx.fxml;
}