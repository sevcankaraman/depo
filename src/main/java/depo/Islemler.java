package depo;

import java.util.*;

public class Islemler {
    static Scanner scan = new Scanner(System.in);
    public static Map<Integer, UrunTanimlama> urunListesiMap = new HashMap<>();
    public static int urunId = 1000;

    public static void girisPaneli() {
        System.out.println("====================================\nDEPO YONETIM PANELI\n\" +\n" +
                "                \"====================================\\n\"\n" +
                "                + \"1- BULUNDURULACAK URUN TANIMLAMA\\n\" +\n" +
                "                  \"2- URUN LİSTELE\" +\n" +
                "                  \"3- DEPOYA URUN GİRİŞİ\\n\" +\n" +
                "                  \"4- URUNU RAFA KOY\\n\" +\n" +
                "                  \"5- DEPODAN URUN ÇIKIŞI\\n\" +\n" +
                "                  \"6- DEPO SİSTEMİNDEN ÇIKIŞ\");");

        System.out.println("lütfen seçiminizi yapın");
        String secim = scan.next().toUpperCase(Locale.ROOT);
        switch (secim) {
            case "1":
                urunTanimlama();
                girisPaneli();
                break;
            case "2":
                urunListele();
                girisPaneli();
                break;
            case "3":
                urunGirisi();
                girisPaneli();
                break;
            case "4":
                urunuRafaKoy();
                girisPaneli();
                break;
            case "5":
                urunCikisi();
                girisPaneli();
                break;
            case "6":
                cikis();
                break;
            default:
                System.out.println("hatalı giriş yaptınız, tekar deneyiniz...");
                girisPaneli();
                break;
        }
    }

    public static void urunTanimlama() {
        System.out.println("..........urun tanımlama............");
        System.out.println("urun ismi: ");
        scan.nextLine();//dummy
        String urunismi = scan.nextLine();

        System.out.println("ureticisi: ");
        String uretici = scan.nextLine();

        System.out.println("birim: ");
        String birim = scan.next();

        String raf = "-";
        int miktar = 0;

        UrunTanimlama urun = new UrunTanimlama(urunismi, uretici, birim, miktar, raf);
        urunListesiMap.put(urunId,urun);

        urunId++;

    }

    public static void urunListele(){

        Set<Map.Entry<Integer,UrunTanimlama>> urunEntrySeti =urunListesiMap.entrySet();
        System.out.println("-------------urun listesi--------------");
        System.out.println("id       ismi         ureticisi       birim       miktar         raf" +
                "\n----------------------------------------------------------------------");
        for (Map.Entry<Integer, UrunTanimlama> e : urunEntrySeti) {
            Integer entryKey= e.getKey();
            System.out.printf("%-8d %-12s %-15s %-12s %-12d %-9s\n",entryKey,
                    urunListesiMap.get(entryKey).getUrunismi(),
                    urunListesiMap.get(entryKey).getUretici(),
                    urunListesiMap.get(entryKey).getBirim(),
                    urunListesiMap.get(entryKey).getMiktar(),
                    urunListesiMap.get(entryKey).getRaf()
                    );
        }

    }

    public static void urunGirisi(){
        System.out.println("************** urun giris sayfası **************");
        System.out.println("gunellemek istediğiniz urun ıd sını gırınız: ");
        int arananId=scan.nextInt();

        if (urunListesiMap.keySet().contains(arananId)){
            System.out.println(" mıktarı giriniz ");
            int guncelMiktar=0;
            boolean flag=true;

            do{
                try {


                    if (flag == true) {
                        scan.nextLine();
                    }
                    guncelMiktar = scan.nextInt();
                    scan.nextLine();
                    flag = false;
                }catch (Exception e){
                    System.out.println("lütfen gecerlı gırıs yapınız");
                }

            }while (flag);

            urunListesiMap.get(arananId).setMiktar(guncelMiktar+urunListesiMap.get(arananId).getMiktar());
            System.out.println("urun mıktarınız guncel hale getırıldı\n" + "guncel mıktar: " + urunListesiMap.get(arananId).getMiktar());
        }else {
            System.out.println("aradıgınız urun yoktur");
            urunGirisi();
        }
    }

    public static  void urunuRafaKoy(){
        System.out.println("--------------urunu rafa koy sayfası----------------");
        System.out.println("Rafa yerlesştırmek ıstedıgınız urunun ID sını giriniz: ");
        int arananId= scan.nextInt();
        if (urunListesiMap.keySet().contains(arananId)){
            System.out.println("hangi rafa kaldıracagınızı yazınız");
            String guncelRaf=scan.next();
            urunListesiMap.get(arananId).setRaf(guncelRaf);
        }else{
            System.out.println("bu urun depoda mevcut degıldır");
            urunuRafaKoy();
        }
    }

    public static void urunCikisi(){
        System.out.println("------------------urun cıkıs sayfası---------------------");
        System.out.println("cıkısını yapmak ıstedıgınız urunun ID sını giriniz");
        int arananId=scan.nextInt();
        if (urunListesiMap.keySet().contains(arananId)){
            System.out.println("miktar giriniz");
            int guncelMiktar=0;
            boolean flag=true;
            do {
               try{
                   if (flag==true){
                       scan.nextLine();//dummy
                   }
                   guncelMiktar= scan.nextInt();
                   scan.nextLine();//dummy
                   flag=false;

               }catch (Exception e){
                   System.out.println("lütfen gecerli bir tamsayı giriniz: ");
               }
            }while (flag);

            if (urunListesiMap.get(arananId).getMiktar()-guncelMiktar<0){
                System.out.println("deponuzda bu mıktarda urun yoktur \n bulunan mıktar : " +urunListesiMap.get(arananId).getMiktar());
            }else {
                urunListesiMap.get(arananId).setMiktar(urunListesiMap.get(arananId).getMiktar()-guncelMiktar);
                System.out.println("urun mıkarınız guncel hale getırıldı\n guncel mıktar: " + urunListesiMap.get(arananId).getMiktar());
            }


        }else{
            System.out.println("aradıgınız urun yoktur...");
        }



        }
         public static void cikis (){
             System.out.println("depodan cıkıs yaptınız tekrar bekleriz...");
         }

    }
