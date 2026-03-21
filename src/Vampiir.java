public class Vampiir extends Koletis {

    public Vampiir() {
        super("Vampiir", 22, 5, 12);
    }

    @Override
    public int ründa() {
        int kahju = juhuslik(4, 6);
        // saab 2 elu tagasi;
        setElud(getElud() + 2);
        return kahju;
    }
}
