import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class LocalizationTest {
    @Test
    public void localizationTest(){
        Localization.Room bedRoom = Mockito.mock(Localization.Room.class);
        Localization.Room bathRoom = Mockito.mock(Localization.Room.class);
        // Böylelikle dependecy injection gerçekleştirmiş olduk. Bu da nesneyi kopyalayarak rahatlıkla test etmemizi sağladı.
        // Yazılım mühendisliği açısından de decoupled sınıflar elde etmiş olduk. Böylelikle bir sınıf bir başka sınıfla rahatlıkla
        // değiştirilebilir.
        Localization l = new Localization(bedRoom, bathRoom);
    }
}
