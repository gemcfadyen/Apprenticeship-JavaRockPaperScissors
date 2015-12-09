package rps;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class PromptSpy implements Prompt {
    private Writer writer;
    private String[] playersChoiceOfGestures;
    private String[] playersChoiceOfReplayOptions;
    private List<Gesture> gesturesChosenByPlayers = new ArrayList<>();
    private int currentInputIndex = 0;
    private int currentReplayInputIndex = 0;
    private int numberOfTimesPlayerPromptedForReplay = 0;
    private int hasPromptedUser = 0;
    private int numberOfTimesMovePrinted = 0;
    private int numberOfTimesDrawPrinted = 0;
    private int numberOfTimesWinPrinted = 0;
    private String winnerName;

    public PromptSpy(Writer writer, String[] playersChoiceOfGestures, String[] replayOption) {
        this.writer = writer;
        this.playersChoiceOfGestures = playersChoiceOfGestures;
        this.playersChoiceOfReplayOptions = replayOption;
    }

    @Override
    public void promptForGestureFrom(String playerId) {
        hasPromptedUser++;
    }

    @Override
    public void display(String message) {
        try {
            writer.write(message);
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

    @Override
    public void displayChosenMove(Gesture gesture, String name) {
        numberOfTimesMovePrinted++;
    }

    @Override
    public void displayWinner(String winnerName) {
        this.winnerName = winnerName;
        numberOfTimesWinPrinted++;
    }

    @Override
    public void displayDraw() {
        numberOfTimesDrawPrinted++;
    }

    public int numberOfTimesPlayerPromptedForReplay() {
        return numberOfTimesPlayerPromptedForReplay;
    }

    public List<Gesture> getGesturesEntered() {
        return gesturesChosenByPlayers;
    }

    public int numberOfTimesUsersHaveBeenPrompted() {
        return hasPromptedUser;
    }

    public int numberOftimesMovePrinted() {
        return numberOfTimesMovePrinted;
    }

    public int numberOfTimesDrawPrinted() {
        return numberOfTimesDrawPrinted;
    }

    public int numberOfTimesWinPrinted() {
        return numberOfTimesWinPrinted;
    }

    public String getWinnersName() {
        return this.winnerName;
    }
}
