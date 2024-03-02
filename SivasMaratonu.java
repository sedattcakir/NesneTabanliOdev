import java.util.Arrays;

class Ogrenci {
    String isim;
    int derece;

    public Ogrenci(String isim, int derece) {
        this.isim = isim;
        this.derece = derece;
    }

    public static void main(String[] args) {
        Ogrenci[] ogrenciler = {
                new Ogrenci("Muhammet", 480),
                new Ogrenci("Melda", 195),
                new Ogrenci("Fatoş", 210),
                new Ogrenci("Emre", 215),
                new Ogrenci("Ömer", 220),
                new Ogrenci("Emir", 150),
                new Ogrenci("Berat", 350),
                new Ogrenci("Can", 410),
                new Ogrenci("Mert", 520),

        };


        System.out.println("En iyi 3 derece:");
        enIyiUcDereceyiYazdir(ogrenciler);

        
        int enIyiIndex = enIyiDereceIndeksiniBul(ogrenciler);
        System.out.println("En iyi dereceye sahip ogrenci: " + ogrenciler[enIyiIndex].isim + ", Derece: " + ogrenciler[enIyiIndex].derece);


        int ikinciEnIyiIndex = ikinciEnIyiDereceIndeksiniBul(ogrenciler, enIyiIndex);
        System.out.println("Ikinci en iyi dereceye sahip ogrenci: " + ogrenciler[ikinciEnIyiIndex].isim + ", Derece: " + ogrenciler[ikinciEnIyiIndex].derece);


        sinifiYazdir(ogrenciler);
    }

    public static void enIyiUcDereceyiYazdir(Ogrenci[] ogrenciler) {
        Arrays.sort(ogrenciler, (o1, o2) -> o1.derece - o2.derece);
        for (int i = 0; i < 3; i++) {
            System.out.println(ogrenciler[i].isim + ": " + ogrenciler[i].derece + " dakika");
        }
    }

    public static int enIyiDereceIndeksiniBul(Ogrenci[] ogrenciler) {
        int minIndex = 0;
        for (int i = 1; i < ogrenciler.length; i++) {
            if (ogrenciler[i].derece < ogrenciler[minIndex].derece) {
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static int ikinciEnIyiDereceIndeksiniBul(Ogrenci[] ogrenciler, int enIyiIndex) {
        int ikinciEnIyiIndex = 0;
        int minDerece = Integer.MAX_VALUE;
        for (int i = 0; i < ogrenciler.length; i++) {
            if (i != enIyiIndex && ogrenciler[i].derece < minDerece) {
                minDerece = ogrenciler[i].derece;
                ikinciEnIyiIndex = i;
            }
        }
        return ikinciEnIyiIndex;
    }

    public static void sinifiYazdir(Ogrenci[] ogrenciler) {
        char[] siniflar = new char[ogrenciler.length];
        for (int i = 0; i < ogrenciler.length; i++) {
            int derece = ogrenciler[i].derece;
            if (derece >= 200 && derece <= 299) {
                siniflar[i] = 'A';
            } else if (derece >= 300 && derece <= 399) {
                siniflar[i] = 'B';
            } else {
                siniflar[i] = 'C';
            }
        }
        System.out.println("Sınıflar:");
        System.out.println("A → " + saySinif(siniflar, 'A'));
        System.out.println("B → " + saySinif(siniflar, 'B'));
        System.out.println("C → " + saySinif(siniflar, 'C'));
    }

    public static int saySinif(char[] siniflar, char sinif) {
        int count = 0;
        for (char c : siniflar) {
            if (c == sinif) {
                count++;
            }
        }
        return count;
    }
}
