package yeni_Atm;

import java.util.Scanner;


import static yeni_Atm.Method.*;


public class Bilgiler {

    static String iban = "TR123456789123456789123456";
    static String kartNo = "1234 5678 1234 5678";
    static String sifrem = "1234";
    static int bakiye = 3000;
    static int select = 4;
    static int count = 0;
    static Scanner scan = new Scanner(System.in);

    public static String getKartNo() {
        return kartNo;
    }

    public static void setKartNo(String kartNo) {
        Bilgiler.kartNo = kartNo;
    }

    public static String getSifrem() {
        return sifrem;
    }

    public static void setSifrem(String sifrem) {

        Bilgiler.sifrem = sifrem;
    }

    public static int getBakiye() {
        return bakiye;
    }

    public static void setBakiye(int bakiye) {
        Bilgiler.bakiye = bakiye;
    }

    public static void giris() {
        System.out.println("~~~ Lutfen kart numaranızı giriniz ~~~");
        String kartNumarası = scan.nextLine();
        if (kartNo.equals(kartNumarası)) {
            System.out.println("Isleminize devam ediliyor...");
            select = 4;
            sifreGir();
        } else {
            select--;
            System.out.println("Hatali kart numarasi girdiniz. " + select + " hakkiniz kalmistir.");
            if (select == 0) {
                System.out.println("Birden fazla hatali giris oldugu icin kartiniz bloke olmustur.");
            } else {
                giris();
            }
        }
    }

    private static void sifreGir() {
        System.out.println("~~~ Lutfen sifrenizi giriniz ~~~");
        String sifre = scan.next();
        if (sifre.equals(sifrem)) {
            ekran();
        } else {
            if (select == 1) {
                System.out.println("Birden fazla hatali giris oldugu icin kartiniz bloke olmustur.");
            } else {
                hataliSifre();
                sifreGir();
            }
        }
    }

    private static void hataliSifre() {
        System.out.println("Şifreniz Hatalıdır. Tekrar Giriş Yapın.");
        select--;
        System.out.println("Kalan Hakkınız : " + select);
    }


    public static void ekran() {
        System.out.println("~~~ Lutfen yapmak istediginiz islemi seciniz ~~~");
        System.out.println("Bakiye sorgulamak icin : 1\nPara yatirmak icin     : 2\nPara çekmek icin       : 3\nPara göndermek icin    : 4\nSifre değiştirmek icin : 5\nCikis icin             : 6 ");
        System.out.print("Seciminizi Belirtiniz  : ");
        int secim = scan.nextInt();
        islemYapma(secim);
    }

    public static void islemYapma(int secim) {
        switch (secim) {
            case 1:
                System.out.println("Bakiyeniz : " + getBakiye());
                ekran();
                break;
            case 2:
                paraYatirma1();
                ekran();
                break;
            case 3:
                paraCekme1();
                ekran();
                break;
            case 4:
                paraGonderme1();
                ekran();
                break;
            case 5:
                sifre();
                ekran();
                break;
            case 6:
                cikisIslemi();
                break;
            default:
                System.out.println("hatali tuslama yaptiniz");
                ekran();

        }

    }
}
