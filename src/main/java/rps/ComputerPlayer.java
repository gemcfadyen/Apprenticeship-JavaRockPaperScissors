package rps;

public class ComputerPlayer implements Player {
    private GestureIdGenerator gestureIdGenerator;

    public ComputerPlayer(GestureIdGenerator gestureIdGenerator) {
        this.gestureIdGenerator = gestureIdGenerator;
    }

    @Override
    public Gesture getGesture() {
        return Gesture.withId(gestureIdGenerator.id());
    }
}
