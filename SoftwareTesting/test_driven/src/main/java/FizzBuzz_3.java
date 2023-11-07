public class FizzBuzz_3 {
    private boolean fizzy(int n) {
        return (n % 3) == 0;
    }

    public String value(int n) {
        if(fizzy(n)){
            return "Fizz";
        }else{
            return String.valueOf(n);
        }
    }

}
