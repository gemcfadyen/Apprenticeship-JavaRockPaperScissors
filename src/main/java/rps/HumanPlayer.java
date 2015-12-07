package rps;

public class HumanPlayer implements Player {
    private Prompt prompt;

    public HumanPlayer(Prompt prompt) {
        this.prompt = prompt;
    }

    @Override
    public Gesture getGesture() {
        return Gesture.ROCK;
    }
}
