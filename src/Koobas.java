import java.util.Random;

public class Koobas {
    int kambriNumber;
    int kambriteKoguarv;
    Random random;
    Koletis koletis = looJuhuslikKoletis();

    public Koletis looJuhuslikKoletis() {
        Random r = new Random();
        int x = r.nextInt(2);

        // vaja lisada ja vajadusel muuta Koletised
        if (x == 0) return new Zombi();
        else return new Lohe();
    }
}
