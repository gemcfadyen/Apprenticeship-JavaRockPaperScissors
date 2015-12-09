package rps;

public interface Prompt {
    void promptForGestureFrom(String playerId);
    void display(String message);
    void promptForReplay();
    void displayChosenMove(Gesture gesture, String name);

    Gesture readValidGestureFrom(String playerId);
    ReplayOption readValidReplayOption();
}
