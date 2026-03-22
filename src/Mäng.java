import java.util.Random;
import java.util.Scanner;

public class Mäng {
    Mängija mängija;
    Koobas koobas;
    boolean mängLäbi;
    Scanner scanner = new Scanner(System.in);
    Random random = new Random();
    int käigud;

    public void alustaMängu() {
        System.out.println("OLETE JÕUDNUD PIMEDASSE KOOPASSE");
        System.out.println("Sisesta oma kangelase nimi:");
        String nimi = scanner.nextLine();
        if (nimi.equals("")) {
            nimi = "Tundmatu kangelane";
        }
        mängija = new Mängija(nimi, 100, 10, 2, 0);
        koobas = new Koobas(1, random.nextInt(7)+5);
        mängLäbi = false;
        System.out.println("Tere tulemast koopasse, "+mängija.getNimi() + "!");
        System.out.println("Proovi koguda võimalikult palju kulda ja pääseda koopast tervena.");
        System.out.println("======================================================");
        System.out.println();
        System.out.println("ALGSEIS: "+mängija);
        System.out.println("======================================================");
        käigud = 0;
        while (!mängLäbi) {
            teeKäik();
            if (!mängija.onElus()) {
                mängLäbi=true;
                System.out.println();
                System.out.println("MÄNG LÄBI. "+mängija.getNimi() +" sai koopas surma.");
            }
            if (!mängLäbi) {
                System.out.println();
                System.out.println("Vajuta Enter, et liikuda edasi...");
                scanner.nextLine();
            }
        }
        System.out.println();
        System.out.println("================ LÕPPSEIS ================");
        System.out.println("Nimi: "+mängija.getNimi());
        System.out.println("Elud: "+mängija.getElud());
        System.out.println("Ravijoogid: "+mängija.getRavijookideArv());
        System.out.println("Kuld: "+mängija.getKuld());
        System.out.println("==========================================");
    }

    public void teeKäik() {
        käigud = käigud + 1;
        System.out.println();
        System.out.println("------------------------------------------------------");
        System.out.println("KÄIK " + käigud + " | KAMBER " + koobas.kambriNumber + "/" + koobas.kambriteKoguarv);
        System.out.println("Mängija seis: " + mängija);
        System.out.println("------------------------------------------------------");
        Sündmus sündmus=koobas.looSündmus();
        töötleSündmus(sündmus);
        if (!mängija.onElus()){
            mängLäbi = true;
            return;
        }
        if (koobas.kambriNumber>=koobas.kambriteKoguarv) {
            mängLäbi = true;
            System.out.println();
            System.out.println("Palju õnne! Jõudsid koopast välja!");
            if (mängija.getKuld()>40){
                System.out.println("Leidsid koopast palju aaret, peaksid olema uhke enda üle!");
            }
            else{
                System.out.println("Proovi uuesti, nii vähese kullaga ei tee sa midagi!");
            }
            return;
        }
        koobas = new Koobas(koobas.kambriNumber+1,koobas.kambriteKoguarv);
    }
    public void töötleSündmus(Sündmus sündmus) {
        switch (sündmus) {
            case Koletis:
                System.out.println("Selles kambris on koletis!");
                võitlus();
                break;
            case Aare:
                int kuld =random.nextInt(15) + 5;
                mängija.setKuld(mängija.getKuld() + kuld);
                System.out.println("Leidsid aarde! +" + kuld + " kulda");
                System.out.println("Praegune kuld: " + mängija.getKuld());
                break;
            case Lõks:
                int kahju =random.nextInt(10) + 5;
                mängija.saaKahju(kahju);
                System.out.println("Sattusid lõksu! Said " + kahju + " kahju");
                System.out.println("Sinu HP pärast lõksu: " + mängija.getElud());
                break;
            case Tühi:
                System.out.println("See kamber on tühi.");
                break;
        }
    }
    public void võitlus() {
        Koletis koletis = koobas.koletis;
        if (koletis instanceof Lohe){
            System.out.println("=======================================");
            System.out.println("Koopa lõpus kohtasite te näljast ja iidset LOHE");
            System.out.println(mängija.getNimi() + ", valmistu raskeks võitluseks");
            System.out.println("=======================================");
        }
        System.out.println("Sinu ette ilmus: "+koletis.getNimi() + "!");
        System.out.println("Koletise HP: "+koletis.getElud());
        while (koletis.onElus()&&mängija.onElus()) {
            System.out.println();
            System.out.println("--- VÕITLUSE SEIS ---");
            System.out.println(mängija.getNimi()+" HP: "+mängija.getElud());
            System.out.println(koletis.getNimi()+" HP: "+koletis.getElud());
            String valik=küsiTegevus();
            switch (valik) {
                case "1":
                    int dmg = mängija.ründa();
                    koletis.saaKahju(dmg);
                    System.out.println("Ründasid "+koletis.getNimi()+" ja tegid "+dmg +" kahju.");
                    System.out.println(koletis.getNimi()+" HP on nüüd: "+koletis.getElud());
                    if (koletis.onElus()) {
                        int vastaseKahju =koletis.ründa();
                        mängija.saaKahju(vastaseKahju);
                        System.out.println(koletis.getNimi() + " lõi vastu ja tegi " + vastaseKahju + " kahju.");
                        System.out.println("Sinu HP on nüüd: " + mängija.getElud());
                    } else {
                        int voit =koletis.saaKulda();
                        mängija.setKuld(mängija.getKuld() +voit);
                        System.out.println("Võitsid koletise vastu!");
                        System.out.println("Said" +voit + "kulda.");
                        System.out.println("Sinu kuld kokku: " + mängija.getKuld());
                    }
                    break;

                case "2":
                    int enneHP= mängija.getElud();
                    int joogidEnne= mängija.getRavijookideArv();
                    mängija.ravi();
                    if (joogidEnne > 0) {
                        System.out.println("Kasutasid ravijooki.");
                        System.out.println("HP: " + enneHP +" -> "+ mängija.getElud());
                        System.out.println("Ravijooke alles: "+mängija.getRavijookideArv());
                    } else {
                        System.out.println("Sul ei ole enam ravijooke!");
                    }
                    break;
                case "3":
                    if (random.nextInt(2) == 0) {
                        System.out.println("Põgenesid edukalt!");
                        return;
                    } else {
                        System.out.println("Ei õnnestunud põgeneda!");
                        int dmg1 = koletis.ründa();
                        mängija.saaKahju(dmg1);
                        System.out.println(koletis.getNimi()+" ründas sind ja tegi " +dmg1+" kahju!");
                    }
                    break;

                default:
                    System.out.println("Vale valik! Proovi uuesti.");
                    break;
            }
        }
    }
    public String küsiTegevus() {
        System.out.println();
        System.out.println("Vali tegevus:");
        System.out.println("1 - Ründa");
        System.out.println("2 - Kasuta ravijooki");
        System.out.println("3 - Põgene");
        System.out.print("Sinu valik: ");
        return scanner.nextLine();
    }
}