import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzz_4Test {
    @Test
    public void testNumber(){
        FizzBuzz_4 _fb = new FizzBuzz_4();
        assertEquals(_fb.value(1), "1");
    }
    @Test
    public void testNumber2(){
        FizzBuzz_4 _fb = new FizzBuzz_4();
        assertEquals(_fb.value(2), "2");
    }
    @Test
    public void testNumber3(){
        FizzBuzz_4 _fb = new FizzBuzz_4();
        assertEquals(_fb.value(3), "Fizz");
    }
    @Test
    public void testNumber4(){
        FizzBuzz_4 _fb = new FizzBuzz_4();
        assertEquals(_fb.value(5), "Buzz");
    }
}
