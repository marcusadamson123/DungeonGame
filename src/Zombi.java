public class Zombi extends Koletis {

    public Zombi() {
        super("Zombi", 30, 1, 5);
    }

    @Override
    public int ründa() {
        return juhuslik(3, 5);
    }
}
