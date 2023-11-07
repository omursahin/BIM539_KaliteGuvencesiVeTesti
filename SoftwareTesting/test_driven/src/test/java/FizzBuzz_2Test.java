import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzz_2Test {
    @Test
    public void testNumber(){
        FizzBuzz_2 _fb = new FizzBuzz_2();
        assertEquals(_fb.value(1), "1");
    }
    @Test
    public void testNumber2(){
        FizzBuzz_2 _fb = new FizzBuzz_2();
        assertEquals(_fb.value(2), "2");
    }
}
