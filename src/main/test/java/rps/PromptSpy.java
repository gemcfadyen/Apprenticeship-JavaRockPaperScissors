package rps;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PromptSpy implements Prompt {
    private Writer writer;
    private String[] playersChoiceOfGestures;
    private String[] playersChoiceOfReplayOptions;
    private int currentInputIndex = 0;
    private List<Gesture> gesturesChosenByPlayers = new ArrayList<>();
    private int numberOfTimesPlayerHasBeenPrompted = 0;
    private int currentReplayInputIndex = 0;
    private int numberOfTimesPlayerPromptedForReplay = 0;

    public PromptSpy(Writer writer, String[] playersChoiceOfGestures, String[] replayOption) {
        this.writer = writer;
        this.playersChoiceOfGestures = playersChoiceOfGestures;
        this.playersChoiceOfReplayOptions = replayOption;
    }

    public PromptSpy(Writer writer, String[] playersChoiceOfGestures) {
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

    @Override
    public void promptForReplay() {
        numberOfTimesPlayerPromptedForReplay++;
    }

    @Override
    public ReplayOption readValidReplayOption() {
        return ReplayOption.of(playersChoiceOfReplayOptions[currentReplayInputIndex++]);
    }

    public int numberOfTimesPlayersHaveBeenPrompted() {
        return numberOfTimesPlayerHasBeenPrompted++;
    }

    public int numberOfTimesPlayerPromptedForReplay() {
        return numberOfTimesPlayerPromptedForReplay;
    }

    public List<Gesture> getGesturesEntered() {
        return gesturesChosenByPlayers;
    }
}
