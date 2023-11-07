import java.util.Random;

public class Repeatable {
    public class Die{
        public int roll(){
            Random rn = new Random();
            return (rn.nextInt() % 6) + 1 ;
        }
    }
    public static enum Result {
        RESULT_OVER,
        RESULT_UNDER,
    }
    // aşağıdaki sınıf Die sınıfına bağımlıdır ve Die sınıfı mock edilemez. Bu yüzden göndereceği değerler de kontrol edilemez durumdadır.
    // Bu yüzden bu bağımlılık kaldırılacak şekilde tekrar tasarlanmalıdır.
    public Result playOverUnder(){
        int dieRoll = (new Die()).roll();

        if(dieRoll > 3){
            return Result.RESULT_OVER;
        }else {
            return Result.RESULT_UNDER;
        }
    }

    //Bu yüzden doğru yazım aşağıdaki gibi olmalıdır
    public Result playOverUnder(Die d){
        int dieRoll = d.roll();
        if(dieRoll > 3){
            return Result.RESULT_OVER;
        }else {
            return Result.RESULT_UNDER;
        }
    }

    //Mock ve stub'sız daha iyi bir çözüm için ise:
    public Result playOverUnder(int dieRoll){
        if(dieRoll > 3){
            return Result.RESULT_OVER;
        }else {
            return Result.RESULT_UNDER;
        }
    }
}
