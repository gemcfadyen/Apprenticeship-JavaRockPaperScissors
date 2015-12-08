package rps;

public class ComputerPlayer implements Player {
    private static final int UPPER_BOUNDARY = Gesture.values().length;
    private String name;
    private GestureIdGenerator gestureIdGenerator;

    public ComputerPlayer(String name, GestureIdGenerator gestureIdGenerator) {
        this.name = name;
        this.gestureIdGenerator = gestureIdGenerator;
    }

    @Override
    public Gesture getGesture() {
        return Gesture.withId(gestureIdGenerator.nextInt(UPPER_BOUNDARY));
    }

    @Override
    public String getName() {
        return name;
    }
}
