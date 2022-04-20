package atm_Proje;

import java.util.Scanner;

import static atm_Proje.Musteribilgi.*;

public class Islem_Ekrani {
    static Scanner scan = new Scanner(System.in);


    public static void kontrol() {
        System.out.println("Hosgeldiniz");

        System.out.println("*****");

        System.out.println("Lutfen kart numarasini giriniz");
        String kart = scan.nextLine();
        if (kart.equals(getKartNo())) {
            System.out.println("sifrenizi giriniz");
            int parola = scan.nextInt();

            if (parola == getSifre()) {
                islemEkrani();

            } else {
                System.out.println("sifrenizi yanlis girdiniz ");
                kontrol();
            }

        } else {
            System.out.println("kart numaraniz yanlis tekrar giriniz");
            kontrol();
        }


    }


    public static void islemEkrani() {

        System.out.println("Bakiye sorgula : 1 giriniz\npara yatirma : 2 giriniz\npara çekme : 3 giriniz\npara gönderme : 4 giriniz\nsifre değiştirme : 5 giriniz\n" +
                "cikis : 6 giriniz");
        int secim = scan.nextInt();

        switch (secim) {
            case 1:
                bakiyeSorgula();
                break;
            case 2:
                paraYatirma();
                break;
            case 3:
                paraCekme();
                break;
            case 4:
                paraGonderme();
                break;

            case 5:
                sifreDegistirme();
                break;


            case 6:
                cıkıs();


        }


    }

    private static void cıkıs() {
        System.out.println("iyi günler");
        System.out.println("*****");
    }

    private static void sifreDegistirme() {

        System.out.println("mevcut sifrenizi giriniz");
        System.out.println("*****");
        int mevcutSifre = scan.nextInt();
        if (mevcutSifre == getSifre()) {
            System.out.println("yeni sifrenizi giriniz");
            System.out.println("*****");
            int yeniSifre = scan.nextInt();
            setSifre(yeniSifre);
        } else {
            System.out.println("yanlis sifre girdiniz tekrar giriniz");
            System.out.println("*****");
            islemEkrani();
        }

    }

    public static void paraGonderme() {
        System.out.println("bakiyeniz : " + getBakiye());
        System.out.println("Gondermek istediginiz miktari giriniz");
        System.out.println("*****");
        int pGonderme = scan.nextInt();
        String bosKod = scan.nextLine();

        if (getBakiye() > pGonderme) {
            System.out.println("Basında TR ile iban giriniz");
            String iban = scan.nextLine();
            System.out.println("*****");
            if (iban.length() == 26) {
                if (iban.startsWith("TR")) {
                    setBakiye(bakiye - pGonderme);
                    System.out.println("Yeni bakiyeniz : " + getBakiye());
                    System.out.println("*****");
                    islemEkrani();
                } else {
                    System.out.println("yanlis iban girdiniz");
                    System.out.println("*****");
                    islemEkrani();
                }

            } else {
                System.out.println("yanlis iban girdiniz");
                System.out.println("*****");
                islemEkrani();
            }


        } else {
            System.out.println("Bakiyenizde yeterli, miktarda para yok gondermezsin");
            System.out.println("*****");
            paraGonderme();


        }
    }

    public static void paraCekme() {
        System.out.println("bakiyeniz : " + getBakiye());
        System.out.println("Cekmek istediginiz miktari giriniz");
        System.out.println("*****");

        int pCekme = scan.nextInt();
        if (getBakiye() < pCekme) {
            System.out.println("Bakiyenizde yeterli, miktarda para yok cekemezsin");
            System.out.println("*****");
            paraCekme();
        } else {
            setBakiye(bakiye - pCekme);
            System.out.println("Yeni bakiyeniz : " + getBakiye());
            islemEkrani();
        }

    }

    public static void paraYatirma() {
        System.out.println("Yatirmak istediginiz miktari giriniz");
        System.out.println("*****");
        int pYatirma = scan.nextInt();

        setBakiye(bakiye + pYatirma);

        System.out.println("Yeni bakiyeniz : " + getBakiye());
        System.out.println("*****");
        islemEkrani();

    }

    private static void bakiyeSorgula() {

        System.out.println("bakiyeniz : " + getBakiye());
        System.out.println("*****");
        islemEkrani();

    }
}



