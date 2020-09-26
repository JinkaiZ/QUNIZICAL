package quinzical.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import quinzical.Database;
import quinzical.SceneChanger;

import java.io.IOException;

public class StartPageController {

    public void quit(MouseEvent e) {
        // Go to quit prompt
        try {
            Parent quit = FXMLLoader.load(getClass().getResource("../scenes/QuitPrompt.fxml"));
            SceneChanger.changeScene(e, quit);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void play(MouseEvent e) {
        // Go to game module
        try {
            if (Database.getInstance().gameCompleted()) {
                    Parent gameCompleted = FXMLLoader.load(getClass().getResource("../scenes/play/GameCompleted.fxml"));
                    SceneChanger.changeScene(e, gameCompleted);
            } else {
                Parent play = FXMLLoader.load(getClass().getResource("../scenes/play/Play.fxml"));
                SceneChanger.changeScene(e, play);
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void practice(MouseEvent e) {
        // Go to practice module
        try {
            Parent play = FXMLLoader.load(getClass().getResource("../scenes/practice/Practice.fxml"));
            SceneChanger.changeScene(e, play);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
