package nsu.medvedev.v.snake;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Snake game soon!");
    }
    @FXML
    protected void onByeButtonClick() throws InterruptedException {
        welcomeText.setText("Bye!");

        Platform.exit();
    }
}