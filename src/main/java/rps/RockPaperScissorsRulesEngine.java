package rps;

public class RockPaperScissorsRulesEngine {

    public static Gesture play(Gesture gesture1, Gesture gesture2) {
        if (gesture1.equals(Gesture.ROCK) && !gesture2.equals(Gesture.PAPER)) {
            return gesture1;
        } else if (gesture2.equals(Gesture.ROCK) && !gesture1.equals(Gesture.PAPER)) {
            return gesture2;
        } else if (gesture1.equals(Gesture.PAPER) && gesture2.equals(Gesture.ROCK)) {
            return gesture1;
        } else if(gesture1.equals(Gesture.SCISSORS) && gesture2.equals(Gesture.PAPER)) {
            return gesture1;
        }
        return gesture2;
    }
}
