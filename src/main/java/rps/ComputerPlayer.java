package rps;

public class ComputerPlayer implements Player {
    private static final int UPPER_BOUNDARY = Gesture.values().length;
    private Prompt prompt;
    private String name;
    private GestureIdGenerator gestureIdGenerator;

    public ComputerPlayer(Prompt prompt, String name, GestureIdGenerator gestureIdGenerator) {
        this.prompt = prompt;
        this.name = name;
        this.gestureIdGenerator = gestureIdGenerator;
    }

    @Override
    public Gesture getGesture() {
        Gesture gesture = Gesture.withId(gestureIdGenerator.nextInt(UPPER_BOUNDARY));
        prompt.display(name + "chose " + gesture.getId() + " - " + gesture.name());
        return gesture;
    }

    @Override
    public String getName() {
        return name;
    }
}
