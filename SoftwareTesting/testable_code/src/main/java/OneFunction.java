import utils.Database;

import java.util.ArrayList;
import java.util.List;

import static utils.Database.DEFAULT_DATABASE;

// Yalnızca tek bir fonksiyon barındırıyor olmalıdır. Aşağıdaki örnekte hem database ile ilgili hem de liste boyutunu alma ile ilgili
// birbirinden bağımsız iki farklı işlem gerçekleşmektedir.
public class OneFunction {
    public List<Integer> monkeyList = new ArrayList<>();

    public int getNumMonkeysandSetDatabase(String d){
        String database = (d != null) ? d : DEFAULT_DATABASE;
        Database.setDefaultDatabase(database);
        int numMonkeys = monkeyList.size();
        return numMonkeys;

    }
// Çözüm: daha modüler hale getirip parçalara ayırmaktır.

    public void setDatabase(String d){
        String database = (d != null) ? d : DEFAULT_DATABASE;
        Database.setDefaultDatabase(database);
    }

    public int getNumMonkeys(){
        int numMonkeys = monkeyList.size();
        return numMonkeys;
    }

}

