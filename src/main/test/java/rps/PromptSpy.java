package rps;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PromptSpy implements Prompt {
    private Writer writer;
    private String[] playersChoiceOfGestures;
    private int currentInputIndex = 0;
    private List<Gesture> gesturesChosenByPlayers = new ArrayList<>();
    private int numberOfTimesPlayerHasBeenPrompted = 0;

    public PromptSpy(Writer writer, String... playersChoiceOfGestures) {
        this.writer = writer;
        this.playersChoiceOfGestures = playersChoiceOfGestures;
    }

    @Override
    public void promptForGestureFrom(String playerId) {
        numberOfTimesPlayerHasBeenPrompted++;
    }

    @Override
    public void display(String status) {
        try {
            writer.write(status);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Gesture readValidGestureFrom(String playerId) {
        Gesture gesture = Gesture.withId(Integer.valueOf(playersChoiceOfGestures[currentInputIndex++]));
        gesturesChosenByPlayers.add(gesture);
        return gesture;
    }

    public int numberOfTimesPlayersHaveBeenPrompted() {
        return numberOfTimesPlayerHasBeenPrompted;
    }

    public List<Gesture> getGesturesEntered() {
        return gesturesChosenByPlayers;
    }
}
