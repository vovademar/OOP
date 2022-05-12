package nsu.medvedev.v.snake;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import nsu.medvedev.v.snake.SnakeFx;
import nsu.medvedev.v.snake.model.ParametersForGame;

public class SettingsController {
    private int mapSize = -1;
    private int foodAmount = -1;
    private int barriers = -1;
    private int goal = -1;

    private ParametersForGame parametersForGame = new ParametersForGame();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField amountOfBarriers;

    @FXML
    private Button backToMainMenu;

    @FXML
    private TextField foodGoal;


    @FXML
    private Button defaultButton;

    @FXML
    private TextField foodOnField;

    @FXML
    private TextField mapSizzeRows;

    @FXML
    private Button applyButton;

    @FXML
    void initialize() {

        applyButton.setOnAction(event -> {
            if (!Objects.equals(mapSizzeRows.getText(), "") || !Objects.equals(foodOnField.getText(), "") || !Objects.equals(amountOfBarriers.getText(), "") || !Objects.equals(foodGoal.getText(), "")) {
                mapSize = Integer.parseInt(mapSizzeRows.getText());
                foodAmount = Integer.parseInt(foodOnField.getText());
                barriers = Integer.parseInt(amountOfBarriers.getText());
                goal = Integer.parseInt(foodGoal.getText());
                if (mapSize > 5 && foodAmount > 0 && barriers > -1 && goal > 1) {
                    parametersForGame = new ParametersForGame(mapSize, foodAmount, barriers, goal);
                    applyButton.getScene().getWindow().hide();
                    SnakeFx application = new SnakeFx(parametersForGame);
                    Stage stage = new Stage();
                    try {
                        application.start(stage);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println("wrong input");
                }
            } else {
                System.out.println("empty fields");
            }

        });

        defaultButton.setOnAction(event -> {
            defaultButton.getScene().getWindow().hide();
            SnakeFx application = new SnakeFx();
            Stage stage = new Stage();
            try {
                application.start(stage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        backToMainMenu.setOnAction(event -> {
            backToMainMenu.getScene().getWindow().hide();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("hello-view.fxml"));
            try {
                loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Parent root = loader.getRoot();
            Stage stage = new Stage();
            stage.close();
            stage.setScene(new Scene(root));
            stage.show();
        });

    }

    public ParametersForGame tellParameters() {
        return parametersForGame;
    }

}

