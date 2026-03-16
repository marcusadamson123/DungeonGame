import java.util.Random;

public class JuhuslikkuseAbi {

    private Random random = new Random();

    Koletis juhuslikKoletis() {
        int x = random.nextInt(2);

        if (x == 0) {
            return new Zombi();
        } else {
            return new Lohe();
        }
    }

    int juhuslikKahju() {
        return random.nextInt(16) + 5;
    }
}
