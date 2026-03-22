public class Ork extends Koletis {

    public Ork() {
        super("Ork", 28, 8, 15);
    }

    @Override
    public int ründa() {
        int kahju = juhuslik(7, 15);
        // saab 3 elu tagasi;
        setElud(getElud() + 3);
        return kahju;
    }
}
