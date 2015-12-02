package rps;

public class PromptStub implements Prompt {
    private String idOfGesture;

    public PromptStub(String idOfGesture) {
        this.idOfGesture = idOfGesture;
    }

    @Override
    public void promptPlayerOneForGesture() {

    }

    @Override
    public Gesture readInput() {
        return Gesture.withId(Integer.valueOf(idOfGesture));
    }
}
