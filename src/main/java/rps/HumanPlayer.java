package rps;

public class HumanPlayer implements Player {
    private String name;
    private Prompt prompt;

    public HumanPlayer(String name, Prompt prompt) {
        this.name = name;
        this.prompt = prompt;
    }

    @Override
    public Gesture getGesture() {
        return prompt.readValidGestureFrom(getName());
    }

    @Override
    public String getName() {
        return name;
    }
}
