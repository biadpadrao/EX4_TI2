import com.microsoft.cognitiveservices.speech.*;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Program {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //Find your key and resource region under the 'Keys and Endpoint' tab in your Speech resource in Azure Portal
        //Remember to delete the brackets <> when pasting your key and region!
        SpeechConfig speechConfig = SpeechConfig.fromSubscription("<paste-your-resource-key>" "<paste-your-region>");
        recognizeFromMic(speechConfig);
    }

    public static void recognizeFromMic(SpeechConfig speechConfig) throws InterruptedException, ExecutionException {
        AudioConfig audioConfig = AudioConfig.fromDefaultMicrophoneInput();
        SpeechRecognizer recognizer = new SpeechRecognizer(speechConfig, audioConfig);

        //Asks user for mic input and prints transcription result on screen
        System.out.println("Speak into your microphone.");
        Future<SpeechRecognitionResult> task = recognizer.recognizeOnceAsync();
        SpeechRecognitionResult result = task.get();
        System.out.println("RECOGNIZED: Text=" + result.getText());
    }
}
