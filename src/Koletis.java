import java.util.Random;

public abstract class Koletis {
    private String nimi;
    private int elud;
    private int minKuld;
    private int maxKuld;

    public Koletis(String nimi, int elud, int minKuld, int maxKuld) {
        this.nimi = nimi;
        this.elud = elud;
        this.minKuld = minKuld;
        this.maxKuld = maxKuld;
    }

    public String getNimi() {
        return nimi;
    }

    public int getElud() {
        return elud;
    }

    public void saaKahju(int kahju) {
        elud -= kahju;
        if (elud < 0) {
            elud = 0;
        }
    }

    public boolean onElus() {
        return elud > 0;
    }

    public int saaKulda() {
        return juhuslik(minKuld, maxKuld);
    }

    public void setElud(int elud) {
        this.elud = elud;
    }

    public abstract int ründa();
    protected static Random random = new Random();

    protected int juhuslik(int min, int max) {
        return random.nextInt(max - min + 1) + min;
    }
}
