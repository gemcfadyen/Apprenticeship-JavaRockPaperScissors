package rps;

public class ComputerPlayer implements Player {
    private String name;
    private GestureIdGenerator gestureIdGenerator;

    public ComputerPlayer(String name, GestureIdGenerator gestureIdGenerator) {
        this.name = name;
        this.gestureIdGenerator = gestureIdGenerator;
    }

    @Override
    public Gesture getGesture() {
        return Gesture.withId(gestureIdGenerator.id());
    }

    @Override
    public String getName() {
        return name;
    }
}
