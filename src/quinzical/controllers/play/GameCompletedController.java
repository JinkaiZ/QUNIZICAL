package quinzical.controllers.play;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import quinzical.model.Database;
import quinzical.model.SceneChanger;

import java.io.IOException;

/**
 * Controls the scene when the entire game has been completed
 *
 * @author Beverley Sun, Jinkai Zhang
 */
public class GameCompletedController {

    @FXML private Label finalWinningsLabel;
    @FXML private TextField textField;

    /**
     *  Initializes the "game completed" scene.
     */
    @FXML
    public void initialize() {
        int winnings = Database.getInstance().getWinnings();
        finalWinningsLabel.setText("You won $" + winnings + "!");
    }

    /**
     * Check if the enter key is pressed. If yes, then proceed to save the user's score.
     * @param e the KeyEvent that occurred
     */
    @FXML
    public void checkKeyPress(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            save(e);
        }
    }

    /**
     * Saves the user's score.
     * It will reset the game and switch to the StartPage scene.
     * @param e the source of the click
     */
    public void save(Event e) {
        try {
            String name = textField.getText().toUpperCase();
            Database.getInstance().addScore(name);
            Database.getInstance().reset();
            Parent scores = FXMLLoader.load(getClass().getResource("/quinzical/scenes/Scores.fxml"));
            SceneChanger.changeScene(e, scores);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
