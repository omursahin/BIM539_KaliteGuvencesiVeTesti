import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzz_5Test {
    @Test
    public void testNumber(){
        FizzBuzz_5 _fb = new FizzBuzz_5();
        assertEquals(_fb.value(1), "1");
    }
    @Test
    public void testNumber2(){
        FizzBuzz_5 _fb = new FizzBuzz_5();
        assertEquals(_fb.value(2), "2");
    }
    @Test
    public void testNumber3(){
        FizzBuzz_5 _fb = new FizzBuzz_5();
        assertEquals(_fb.value(3), "Fizz");
    }
    @Test
    public void testNumber4(){
        FizzBuzz_5 _fb = new FizzBuzz_5();
        assertEquals(_fb.value(5), "Buzz");
    }
    @Test
    public void testNumber5(){
        FizzBuzz_5 _fb = new FizzBuzz_5();
        assertEquals(_fb.value(15), "FizzBuzz");
    }
}
