package rps;

import java.util.ArrayList;
import java.util.List;

public class PromptSpy implements Prompt {
    private String[] playersChoiceOfGestures;
    private int currentInputIndex = 0;
    private List<Gesture> gesturesChosenByPlayers = new ArrayList<>();
    private int numberOfTimesPlayerHasBeenPrompted = 0;

    public PromptSpy(String... playersChoiceOfGestures) {
        this.playersChoiceOfGestures = playersChoiceOfGestures;
    }

    @Override
    public void promptForGestureFrom(String playerId) {
        numberOfTimesPlayerHasBeenPrompted++;
    }

    @Override
    public Gesture readInput() {
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
