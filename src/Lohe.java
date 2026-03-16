public class Lohe implements Koletis {
    private int elud = 40;

    @Override
    public String getNimi() {
        return "Lohe";
    }

    @Override
    public int ründa() {
        return 10;
    }

    @Override
    public void saaKahju(int kahju) {
        elud -= kahju;
    }

    @Override
    public boolean onElus() {
        return elud > 0;
    }
}
