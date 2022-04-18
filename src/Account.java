import java.util.ArrayList;
import java.util.List;

public class Account {

    int accountNumber=1000;
    String sifre ="";
    int bakiye =0;
    String adSoyad ="";
    int gunlukCekilen=0;
    static List<Account> musteriList = new ArrayList<>();

    public Account() {
    }

    public Account(int accountNumber,String adSoyad,String sifre, int bakiye) {
        this.accountNumber = accountNumber;
        this.adSoyad = adSoyad;
        this.bakiye = bakiye;
        this.sifre = sifre;
    }

//    public static void main(String[] args) {
//        paraEkle();
//    }

      void paraEkle(int objeIndex,int eklenen) {
          if(musteriList.get(objeIndex).gunlukCekilen<=5000) {


              int a = musteriList.get(objeIndex).bakiye;
              a += eklenen;
              musteriList.get(objeIndex).bakiye = a;
              System.out.println("Güncel bakiye = " + musteriList.get(objeIndex).bakiye);
              musteriList.get(objeIndex).gunlukCekilen+=eklenen;
          }

    }

    void paraCekme21(int objeIndex,int cekilen) {
        int a= musteriList.get(objeIndex).bakiye;
        a-=cekilen;
        musteriList.get(objeIndex).bakiye=a;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", sifre='" + sifre + '\'' +
                ", bakiye=" + bakiye +
                ", adSoyad='" + adSoyad + '\'' +
                '}';
    }
}