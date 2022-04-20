package atm_Proje;

public class Musteribilgi {
    static int sifre=1234;
    static String kartNo="1234567891011234";
    static int bakiye=1000;

    public static int getSifre() {
        return sifre;
    }

    public static void setSifre(int sifre) {
        Musteribilgi.sifre = sifre;
    }

    public static String getKartNo() {
        return kartNo;
    }

    public static void setKartNo(String kartNo) {
        Musteribilgi.kartNo = kartNo;
    }

    public static int getBakiye() {
        return bakiye;
    }

    public static void setBakiye(int bakiye) {
        Musteribilgi.bakiye = bakiye;
    }
}
