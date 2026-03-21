public class Lohe extends Koletis {

    public Lohe() {
        super("Lohe", 50, 20, 40);
    }

    @Override
    public int ründa() {
        return juhuslik(8, 12);
    }
}
