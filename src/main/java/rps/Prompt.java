package rps;

public interface Prompt {
    void promptPlayerOneForGesture();

    Gesture readInput();
}
