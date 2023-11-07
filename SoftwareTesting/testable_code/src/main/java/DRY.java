import utils.animal.Animal;
import utils.animal.Giraffe;
import utils.animal.Monkey;
import utils.animal.Rabbit;

import java.util.ArrayList;
import java.util.List;

//Don't repeat yourself, kendini tekrar etme!
public class DRY {
    // Copy/Paste kullanmamalısınız
    // Benzer fonksiyona sahip birden fazla metot yazma
    // generic sınıf ve metotları kullan

    //Farklı veri tipleri için kod çoğullaması kötü bir örnektir:

    private ArrayList<Animal> animalList = new ArrayList<>();
    public int addMonkey(Monkey m){
        animalList.add(m);
        return animalList.size();
    }

    public int addGiraffe(Giraffe g){
        animalList.add(g);
        return animalList.size();
    }

    public int addRabbit(Rabbit r){
        animalList.add(r);
        return animalList.size();
    }

    // Buradaki kod şu şekilde yazılabilirdi:

    public int addAnimal(Animal a){
        animalList.add(a);
        return animalList.size();
    }


    //Peki bir superclass yoksa (üstteki örnekte Animal):
    public void addOne(List<Monkey> l, Monkey m){
        l.add(m);
    }

    public void addOne(List<Giraffe> l, Giraffe g){
        l.add(g);
    }

    public void addOne(List<Rabbit> l, Rabbit r){
        l.add(r);
    }

    // Bu durumda da generic tip kullanılabilir:
    public <T> void addOne(List<T> l, T e){
        l.add(e);
    }
}
