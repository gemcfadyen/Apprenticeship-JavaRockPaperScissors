package rps;

public interface Prompt {
    void promptForGestureFrom(String playerId);

    void display(String message);

    Gesture readValidGestureFrom(String playerId);

    void promptForReplay();

    ReplayOption readValidReplayOption();
}
