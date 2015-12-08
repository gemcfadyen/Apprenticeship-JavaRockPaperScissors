package rps;

public class PromptStub implements Prompt {
    private int idOfGesture;

    public PromptStub(int idOfGesture) {
        this.idOfGesture = idOfGesture;
    }

    @Override
    public void promptForGestureFrom(String playerId) {

    }

    @Override
    public void display(String status) {

    }

    @Override
    public Gesture readValidGestureFrom(String playerId) {
        return Gesture.withId(idOfGesture);
    }

    @Override
    public void promptForReplay() {

    }

    @Override
    public ReplayOption readValidReplayOption() {
        return null;
    }
}
