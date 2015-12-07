package rps;

public interface Prompt {
    void promptForGestureFrom(String playerId);

    void display(String status);

    Gesture readValidGestureFrom(String playerId);

    void promptForReplay();

    ReplayOption readValidReplayOption();
}
