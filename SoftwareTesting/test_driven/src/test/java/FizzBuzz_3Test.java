import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzz_3Test {
    @Test
    public void testNumber(){
        FizzBuzz_3 _fb = new FizzBuzz_3();
        assertEquals(_fb.value(1), "1");
    }
    @Test
    public void testNumber2(){
        FizzBuzz_3 _fb = new FizzBuzz_3();
        assertEquals(_fb.value(2), "2");
    }
    @Test
    public void testNumber3(){
        FizzBuzz_3 _fb = new FizzBuzz_3();
        assertEquals(_fb.value(3), "Fizz");
    }
}
