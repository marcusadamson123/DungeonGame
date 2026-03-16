public class Zombi implements Koletis {
    private int elud = 20;

    @Override
    public String getNimi() {
        return "Zombi";
    }

    @Override
    public int ründa() {
        return 4;
    }

    @Override
    public void saaKahju(int kahju) {
        elud -= kahju;
    }

    @Override
    public boolean onElus() {
        return elud > 0;
    }

    @Override
    public int getElud(){
        return elud;
    }
}
