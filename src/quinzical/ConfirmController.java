package quinzical;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public abstract class ConfirmController {
    @FXML
    private Label winnings;

    @FXML
    private Slider voiceSlider;

    @FXML
    public void initialize() {
        winnings.setText("$" + Database.getInstance().getWinnings());
        voiceSlider.setValue(TTS.getInstance().getMultiplier());
    }

    public void toQuestionBoard(MouseEvent e){
        try {
            // Load the question board scene
            Parent questionBoard = FXMLLoader.load(getClass().getResource("Play.fxml"));
            SceneChanger.changeScene(e, questionBoard);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void sliderChanged() {
        TTS.getInstance().setMultiplier(voiceSlider.getValue());
    }
}