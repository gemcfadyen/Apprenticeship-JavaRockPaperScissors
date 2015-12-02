package rps;

public interface Prompt {
    void promptForGestureFrom(String playerId);

    Gesture readInput();
}
