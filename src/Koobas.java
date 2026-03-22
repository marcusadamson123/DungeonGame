import java.util.Random;

public class Koobas {
    int kambriNumber;
    int kambriteKoguarv;
    Koletis koletis;

    public Koobas(int kambriNumber, int kambriteKoguarv) {
        this.kambriNumber = kambriNumber;
        this.kambriteKoguarv = kambriteKoguarv;
        this.koletis = JuhuslikkuseAbi.juhuslikKoletis(kambriNumber);
        if (kambriNumber == kambriteKoguarv) {
            this.koletis = JuhuslikkuseAbi.juhuslikKoletis(kambriNumber, true);
        } else {
            this.koletis = JuhuslikkuseAbi.juhuslikKoletis(kambriNumber);
        }

    }

    public Sündmus looSündmus() {
        int x = new Random().nextInt(4);

        if (x == 0) return Sündmus.Koletis;
        if (x == 1) return Sündmus.Aare;
        if (x == 2) return Sündmus.Lõks;


        return Sündmus.Tühi;
    }
}