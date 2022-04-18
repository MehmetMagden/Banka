import java.util.Scanner;

public class Banka {
    static Scanner scan = new Scanner(System.in);

    static int musteriNumarası = 1000;

    public static void main(String[] args) {
        anaEkran();


    }

    private static void anaEkran() {        //Müsteri mi bankacı mı giris yapıyor

        System.out.println("1- Müsteri kayıt (banka tarafından)\n2- Musteri Islemleri");
        int scm = scan.nextInt();
        scan.nextLine();

        switch (scm){

            case 1 :
                musteriKayit();     //bankacı girisi
                anaEkran();
            case 2 :
                musteriKontrol();       //müşteri girisi
                anaEkran();
    }
    }

    private static void musteriKontrol() {  // müşteri şifresi ve id si kayıtlı müşteri ile uyumlu ise müşteriye ait obje üzerinde işlem yapma yetkisi veriliyor

        System.out.println("lütfen müşteri numaranızı giriniz");
        int musteriID=0;
        int flag =0;
        String psw ="";
        try {                                           // harf girerse sorunu handle ediyor
             musteriID =scan.nextInt();
            scan.nextLine();
        } catch (Exception e) {
            System.out.println("lütfen geçerli bir numara giriniz");
            flag++;


            if (flag ==2) {
                cikis21();
            }else {
                System.out.println(flag);           //deneme
                musteriKontrol();
            }
        }
        System.out.println("Lütfen geçerli şifrenizi giriniz");
        psw = scan.nextLine();

        for (int i = 0; i <Account.musteriList.size() ; i++) {


            if(Account.musteriList.get(i).accountNumber==musteriID && Account.musteriList.get(i).sifre.equalsIgnoreCase(psw)){
                Account musterGeciciObj =Account.musteriList.get(i);
                System.out.println("müsteri girişiniz yapıldı");
                musteriIslemleri( musterGeciciObj,i);
            }

        }


    }

    private static void musteriIslemleri(Account musterGeciciObj,int objeIndex) {

        System.out.println("1- gecerli bilgiler \n2- Müseri para çekme\n3- Müşteri para yatırma \n4- Cıkıs \nlütfen seçim yapınız 5 gizli tercih" );

        int scm = 0;

        try {
            scm = scan.nextInt();
            scan.nextLine();        //dummy
        } catch (Exception e) {
            System.out.println("lütfen geçerli bir seçim yapınız");
            musteriIslemleri(musterGeciciObj,objeIndex);
        }

        switch (scm){

            case 1 :
                System.out.println(Account.musteriList.get(objeIndex));
                musteriIslemleri(musterGeciciObj,objeIndex);

            case 2 :
                ParaCekme(objeIndex,  musterGeciciObj);
                musteriIslemleri(musterGeciciObj,objeIndex);

            case 3 :
                paraEkle(musterGeciciObj,objeIndex);
                musteriIslemleri(musterGeciciObj,objeIndex);

            case 4 :

                cikis21();

            case 5 :

                System.out.println(Account.musteriList);
                anaEkran();

            default :
                System.out.println("lütfen geçerli bir seçim yapınız");
                musteriIslemleri(musterGeciciObj,objeIndex);

        }


    }

    private static void paraEkle(Account obje,int objeIndex) {
        System.out.println("lütfen yatırmak istediğiniz meblayı giriniz");

        int yatanMebla=scan.nextInt();
        scan.nextLine();


        obje.paraEkle(objeIndex,yatanMebla);



    }


    private static void ParaCekme(int objeIndex,Account obje) {
        System.out.println("Lütfen çekmek istediğiniz milktarı giriniz");
        int cekilmekIstenenMebla = scan.nextInt();
        scan.nextLine();
        if (cekilmekIstenenMebla>obje.bakiye){
            System.out.println("Bakiye yetersiz");
            musteriIslemleri(obje,objeIndex);
        }else {
            obje.paraCekme21(objeIndex,cekilmekIstenenMebla);
        }






    }

    private static void cikis21() {
    }

    private static void musteriKayit() {

        do {


            System.out.println("Lütfen isim ve soyisim beraber giriniz");
            String name = scan.nextLine();

            System.out.println("Lütfen sifre  giriniz");
            String password = scan.nextLine();


            System.out.println("Bakiye giriniz");
            int bakiye = 0; //try catch       bakiye girişi
            try {
                bakiye = scan.nextInt();
                scan.nextLine();
            } catch (Exception e) {
                System.out.println("lütfen geçerli birbakiye giriniz");
                musteriKayit();
            }

            musteriNumarası++;      //müsteri numarası otomatik artıyor

            Account object = new Account(musteriNumarası,name,password, bakiye); //obje oluşturup Account class içindeki static listeye kaydediyor
            Account.musteriList.add(object);
            System.out.println(Account.musteriList);
            break;


        } while (true);
    }
}
