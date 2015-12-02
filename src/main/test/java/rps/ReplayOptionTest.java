package rps;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static rps.ReplayOption.*;

public class ReplayOptionTest {
    @Test
    public void lowerCaseYTranslatesToReplayOption() {
        ReplayOption replayOption = of("Y");
        assertThat(replayOption, is(Y));
    }

    @Test
    public void upperCaseYTranslatesToReplayOption() {
        ReplayOption replayOption = of("y");
        assertThat(replayOption, is(Y));
    }

    @Test
    public void entriesOtherThanYTranslateToNoReplay() {
        ReplayOption replayOption = of("p");
        assertThat(replayOption, is(N));
    }
}