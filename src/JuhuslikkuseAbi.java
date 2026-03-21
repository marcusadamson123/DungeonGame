import java.util.Random;

public class JuhuslikkuseAbi {

    private static final Random random = new Random();

    public static Koletis juhuslikKoletis(int kamber) {
        return juhuslikKoletis(kamber, false);
    }

    public static Koletis juhuslikKoletis(int kamber, boolean boss) {
        // viimase kambri lõpus
        if (boss) {
            return new Lohe();
        }

        if (kamber == 1) {
            return new Zombi();
        }

        if (kamber == 2) {
            int x = random.nextInt(2);
            return switch (x) {
                case 0 -> new Zombi();
                case 1 -> new Skelett();
                default -> new Zombi();
            };
        }

        if (kamber == 3) {
            int x = random.nextInt(3);
            return switch (x) {
                case 0 -> new Zombi();
                case 1 -> new Skelett();
                case 2 -> new Vampiir();
                default -> new Zombi();
            };
        }

        int x = random.nextInt(4);
        return switch (x) {
            case 0 -> new Zombi();
            case 1 -> new Skelett();
            case 2 -> new Vampiir();
            case 3 -> new Ork();
            default -> new Zombi();
        };
    }
}
