public class FizzBuzz_5 {
    private boolean fizzy(int n) {
        return (n % 3) == 0;
    }

    private boolean buzzy(int n) {
        return (n % 5) == 0;
    }

    public String value(int n) {
        if(fizzy(n) && buzzy(n)){
            return "FizzBuzz";
        }
        else if (fizzy(n)) {
            return "Fizz";
        } else if (buzzy(n)) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }
}
