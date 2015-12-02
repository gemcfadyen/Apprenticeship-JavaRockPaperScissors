package rps;

public interface Prompt {
    void promptForGestureFrom(String playerId);

    void display(String status);

    Gesture readInput();
}
