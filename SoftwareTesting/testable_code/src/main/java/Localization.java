public class Localization {
    public class Room{
        String roomName;
        Room(String n){
            roomName = n;
        }
    }

    private Room bedRoom;
    private Room bathRoom;

    public Localization(){
        bedRoom = new Room("bedRoom");
        bathRoom = new Room("bathRoom");
    }

    public String toString(){
        return bedRoom.toString() + " " + bathRoom.toString();
    }

    // peki bu örnek neden kötüdür? Çünkü bedRoom ve bathRoom'u mock ve toString metodunu stub yapma şansımız bulunmamaktadır.

    // Bu yüzden aşağıdaki gibi tekrar düzenlenmelidir. Böylelikle kolaylıkla mock ve stub işlemleri yapılabilir.
    public Localization(Room r1, Room r2){
        bedRoom = r1;
        bathRoom = r2;
    }
}
