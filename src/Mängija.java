public class Mängija{
    private String nimi;
    private int elud;
    private int rünnak;
    private int ravijookideArv;
    private int kuld;

    public Mängija(String nimi, int elud, int rünnak, int ravijookideArv, int kuld) {
        this.nimi = nimi;
        this.elud = elud;
        this.rünnak = rünnak;
        this.ravijookideArv = ravijookideArv;
        this.kuld = kuld;
    }

    public void saaKahju(int kahju) {
        elud=elud-kahju;
        if(elud<0){
            elud=0;
        }
    }

    public int ründa() {
        return rünnak;
    }

    public void ravi() {
        if(ravijookideArv>0){
            elud=elud+15;
            ravijookideArv--;
            if (elud>100){
                elud=100;
            }
        }

    }
    boolean onElus(){
        return elud>0;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public int getElud() {
        return elud;
    }

    public void setElud(int elud) {
        this.elud = elud;
    }

    public int getRavijookideArv() {
        return ravijookideArv;
    }

    public void setRavijookideArv(int ravijookideArv) {
        this.ravijookideArv = ravijookideArv;
    }

    public int getKuld() {
        return kuld;
    }

    public void setKuld(int kuld) {
        this.kuld = kuld;
    }
    public String toString(){
        return getNimi() +": HP: "+getElud()+"; Ravijoogid: "+getRavijookideArv() + "; Kuld: "+getKuld();
    }
}
