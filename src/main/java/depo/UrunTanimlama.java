package depo;

public class UrunTanimlama {
    private String urunismi;
    private String uretici;
    private int miktar;
    private String birim;

    private String raf;

    public UrunTanimlama() {
    }



    public UrunTanimlama(String urunismi, String uretici, String birim, int miktar, String raf) {
        this.urunismi = urunismi;
        this.uretici = uretici;
        this.miktar = miktar;
        this.birim = birim;
        this.raf = raf;
    }

    public String getUrunismi() {
        return urunismi;
    }

    public void setUrunismi(String urunismi) {
        this.urunismi = urunismi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public String getBirim() {
        return birim;
    }

    public void setBirim(String birim) {
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

    @Override
    public String toString() {
        return "UrunTanimlama{" +
                "urunismi='" + urunismi + '\'' +
                ", uretici='" + uretici + '\'' +
                ", miktar=" + miktar +
                ", birim='" + birim + '\'' +
                ", raf='" + raf + '\'' +
                '}';
    }
}

