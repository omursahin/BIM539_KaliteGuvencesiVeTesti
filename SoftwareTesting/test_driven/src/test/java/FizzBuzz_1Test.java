import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzz_1Test {
    @Test
    public void testNumber(){
        FizzBuzz_1 _fb = new FizzBuzz_1();
        assertEquals(_fb.value(1), "1");
    }
}
