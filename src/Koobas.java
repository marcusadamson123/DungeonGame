import java.util.Random;

public class Koobas {
    int kambriNumber;
    int kambriteKoguarv;
    Random random;
    Koletis koletis = looJuhuslikKoletis();

    public Koletis looJuhuslikKoletis() {
        return JuhuslikkuseAbi.juhuslikKoletis();
    }

    public Sündmus looSündmus() {
        int x = new Random().nextInt(4);

        if (x == 0) return Sündmus.Koletis;
        if (x == 1) return Sündmus.Aare;
        if (x == 2) return Sündmus.Lõks;

        return Sündmus.Tühi;
    }
}