public class Skelett extends Koletis {

    public Skelett() {
        super("Skelett", 18, 3, 8);
    }

    @Override
    public int ründa() {
        return juhuslik(3, 10);
    }
}
