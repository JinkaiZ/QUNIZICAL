package quinzical;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TTS {

    private static TTS _tts;

    private double _speedMultiplier;

    private TTS() {}

    // Singleton class
    public static TTS getInstance() {
        if (_tts == null) {
            _tts = new TTS();
        }
        return _tts;
    }

    public void speak (String str) throws IOException {
        strToText(str);
        String command = "festival -b ./.save/voice-speed/test.scm \n wait ";
        ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
        try {
            Process process = pb.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setMultiplier(double multiplier) {
        _speedMultiplier = multiplier;
        Database.getInstance().updateSpeed(multiplier);
    }

    public void initMultiplier(double multiplier){
        _speedMultiplier = multiplier;
    }

    public double getMultiplier() {
        return _speedMultiplier;
    }


    public void strToText(String input) throws IOException {
        new File("./.save/voice-speed/test.scm").createNewFile();
        FileWriter writer = new FileWriter("./.save/voice-speed/test.scm");
        writer.write("(voice_akl_nz_jdt_diphone)" + "\n");
        writer.write("(Parameter.set 'Duration_Stretch " + (1/_speedMultiplier) +")" + "\n");
        writer.write("(SayText \""+ input+"\")");
        writer.close();
    }

}
