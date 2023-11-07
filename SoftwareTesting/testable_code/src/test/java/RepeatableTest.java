import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RepeatableTest {
    @Test
    public void playOverUnderTest() {
        Repeatable r = new Repeatable();

        Repeatable.Die d = Mockito.mock(Repeatable.Die.class);
        Mockito.when(d.roll()).thenReturn(6);
        assertEquals(Repeatable.Result.RESULT_OVER, r.playOverUnder(d));
    }

    @Test
    public void playOverUnderBetterTest() {
        Repeatable r = new Repeatable();
        assertEquals(Repeatable.Result.RESULT_OVER, r.playOverUnder(5));
    }

}
