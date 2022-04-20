package yeni_Atm;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import static yeni_Atm.Bilgiler.*;


public class Method {

    static int islem;

    public Method() {

        giris();
    }

    public static void paraYatirma1() {
        System.out.println("+++ Lutfen yatirmak istediginiz miktari giriniz : ");
        islem = scan.nextInt();
        setBakiye(bakiye + islem);
        System.out.println("Guncel bakiyeniz : " + getBakiye());
        System.out.println("*****");

    }

    public static void paraCekme1() {
        System.out.println("--- Lutfen cekmek istediginiz miktari giriniz : ");
        islem = scan.nextInt();
        if (islem > getBakiye()) {
            System.out.println("xxx Yetersiz bakiye xxx");
        } else {
            setBakiye(bakiye - islem);
            System.out.println("Guncel bakiyeniz : " + getBakiye());
        }
    }

    public static void paraGonderme1() {
        System.out.println("==> Lutfen gondermek istediginiz miktari giriniz :");
        islem = scan.nextInt();
        if (islem > getBakiye()) {
            System.out.println("xxx Yetersiz bakiye ! xxx");
        } else {
            String bosKod = scan.nextLine();
            ibanKontrol();
        }
    }

    public static void ibanKontrol() {
        System.out.println("Lutfen iban giriniz : ");
        String gonderilecekIban = scan.nextLine();
        gonderilecekIban = gonderilecekIban.replace(" ", "");
        if (gonderilecekIban.length() == 26 && gonderilecekIban.startsWith("TR")) {
            setBakiye(bakiye - islem);
            System.out.println("==> Guncel bakiyeniz : " + getBakiye());
        } else {
            System.out.println("xxx Yanlis veya hatali iban girdiniz xxx\nTekrar deneyiniz : ");
            ibanKontrol();
        }
    }

    public static void sifre() {
        System.out.println("~~~ Mevcut sifrenizi giriniz ~~~");
        String mevcutSifre = scan.next();


        if (sifrem.equals(mevcutSifre)) {
            System.out.println("~~~Degistirmek istediginiz sifreyi giriniz :\n(Sifrenizin 4 rakam olmasina dikkat ediniz.");
            String yeniSifre = scan.next();

            if (yeniSifre.length() == 4) {
                System.out.println("sifreniz basariyla degistirilmistir");
                setSifrem( yeniSifre);
            } else {
                System.out.println("^^^4 rakamli olmasina dikka ediniz!^^^");
                sifre();
            }

        } else {
            System.out.println("hatali giris tekrar deneyiniz");
            sifre();
        }

    }

    public static void cikisIslemi() {

        System.out.println("Yaptiginiz islemler icin makbuz istiyorsaniz 1'e basiniz istemiyorsanız 0 basiniz");
        int makbuz = 1;
        makbuz = scan.nextInt();
        if (makbuz == 1) {
            LocalTime trh = LocalTime.now();
            DateTimeFormatter formatterSaat = DateTimeFormatter.ofPattern("h:mm:ss  a");
            System.out.println("+-------------------+\r\n"
                    + "|    " + formatterSaat.format(trh) + "   |\r\n"
                    + "|                   |\r\n"
                    + "|     JAVA BANK     |\r\n"
                    + "|  Guncel Bakiyeniz |\r\n"
                    + "|       " + bakiye + "        |\r\n"
                    + "|   ALLAH PARANIZA  |\r\n"
                    + "|      BEREKET      |\r\n"
                    + "|      VERSİN       |\r\n"
                    + "|                   |\r\n"
                    + "|                   |\r\n"
                    + "|     TESEKKURLER   |\r\n"
                    + "+-------------------+");
        } else System.out.println("=== Yine Bekleriz ===");
    }




    

}

















