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
        System.out.println("OLETE JÕUDNUD PIMEDASSE KOOPASSE ");
        System.out.println("Sisesta oma kangelase nimi: ");
        String nimi = scanner.nextLine();
        if (nimi == "") {
            nimi = "Tundmatu kangelane";
        }
        mängija = new Mängija(nimi, 100, 10, 2, 0);
        koobas = new Koobas(1, 4);
        mängLäbi = false;
        System.out.println("Tere tulemast koopasse, " + mängija.getNimi());
        System.out.println("Proovi koguda võimalikult palju kulda ja pääseda koopast tervena.");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println(mängija.toString());
        System.out.println("=====================================================================================");
        int käigud = 0;
        while (!mängLäbi) {
            teeKäik();
        }
        if (!mängija.onElus()) {
            mängLäbi = true;
            System.out.println("MÄNG LÄBI." + mängija.getNimi() + " sai koopas surma");
        }
        if (!mängLäbi) {
            System.out.println();
            System.out.println("Vajuta Enter, et liikuda koopas edasi");
            scanner.nextLine();
        }
        System.out.println();
        System.out.println("Lõppseis:");
        System.out.println("Nimi: " + mängija.getNimi());
        System.out.println("Elud: " + mängija.getElud());
        System.out.println("Ravijoogid: " + mängija.getRavijookideArv());
        System.out.println("Kuld: " + mängija.getKuld());


    }

    public void teeKäik() {
        käigud = käigud + 1;
        System.out.println();
        System.out.println(mängija.toString());
        Sündmus sündmus = koobas.looSündmus();
        töötleSündmus(sündmus);

    }

    public void töötleSündmus(Sündmus sündmus) {
        switch (sündmus) {
            case Koletis:
                Koletis koletis = koobas.koletis;
                System.out.println("Pimedas koopas tuli sulle vastu üks " + koletis.getNimi() + "!");
                while (koletis.onElus() && mängija.onElus()) {
                    String otsus = küsiTegevus();
                    if(otsus.equals("1")){
                        int mängijaKahju= mängija.ründa();
                        koletis.saaKahju(mängijaKahju);
                        System.out.println("Ründasid "+koletis.getNimi()+" ja tegid" + mängijaKahju + " haiget");
                        System.out.println(koletis.getNimi()+ " on alles " + koletis.getElud()+ " HP");
                        if (koletis.onElus()) {
                            int koletiseKahju = koletis.ründa();
                            mängija.saaKahju(koletiseKahju);
                            System.out.println(koletis.getNimi() + " ründas sind tehes " + koletiseKahju + " kahju");
                            System.out.println(mängija.getNimi() + "HP: " + mängija.getElud());
                        }else{
                            int saadudKuld=random.nextInt(21)+5;
                            mängija.setKuld(mängija.getKuld()+saadudKuld);
                        }
                    }
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