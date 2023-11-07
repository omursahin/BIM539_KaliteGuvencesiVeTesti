import utils.animal.Cat;
import utils.animal.Fish;

public class Preconditions {
    //Ön koşulların sağlanması kolaylaştırılmalıdır. Aşağıdaki örnekte CatWeight alabilmek için yalnızca Cat örneğini
    // alıp bir başka sınıftaki statik değerle toplamaktadır. Bu yüzden bu sınıf bir başka sınıftaki statik değere bağımlıdır ve precondition'ı
    // bulunmaktadır.
    public float getCatWeight(Cat cat){
        int fishWeight = Fish.weight;

        // Kedi, balığı yedi :)
        return cat.weight + fishWeight;
    }

    // Aslında olması gereken aşağıdaki gibidir. Böylelikle bağımlılık ortadan kaldırılır.
    public float getCatWeight(Cat cat, int fishWeight){
        return cat.weight + fishWeight;
    }

}
