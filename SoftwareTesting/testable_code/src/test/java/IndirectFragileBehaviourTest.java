import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import utils.Number;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;

public class IndirectFragileBehaviourTest {
    @Test
    void testSetSquared(){
        IndirectFragileBehaviour b = new IndirectFragileBehaviour();
        Number n = Mockito.mock(Number.class);
        b.setSquared(n, 3);
        Mockito.verify(n, times(1)).setVal(anyInt());
    }

    @Test
    void testSetSquaredFragileNot(){
        IndirectFragileBehaviour b = new IndirectFragileBehaviour();
        Number n = Mockito.mock(Number.class);
        b.setSquaredFragile(n, 3);
        Mockito.verify(n, times(1)).setVal(anyInt());
    }

    @Test
    void testSetSquaredRefactored(){
        IndirectFragileBehaviour b = new IndirectFragileBehaviour();
        Number n = Mockito.mock(Number.class);
        assertEquals(9, b.setSquaredRefactored(n, 3));
    }
}
