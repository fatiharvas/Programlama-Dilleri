package com.h5200045.fatih_arvas_final.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//ProgramlamaDilleri, uygulumada kullanılacak olan veriler için oluşturulmuş bir sınıftır.
//Bu sınıfı oluşturmamızın sebebi her bir satırımızda farklı tiplerden oluşan verilere tek seferde ulaşmaktır.
public class ProgramlamaDilleri {

    @SerializedName("ProgramlamaDili")
    @Expose
    private String programlamaDili;
    @SerializedName("Tasarimci")
    @Expose
    private String tasarimci;
    @SerializedName("CikisTarihi")
    @Expose
    private String cikisTarihi;
    @SerializedName("Detay")
    @Expose
    private String detay;
    @SerializedName("KucukLogoUrl")
    @Expose
    private String kucukLogoUrl;
    @SerializedName("BuyukResimUrl")
    @Expose
    private String buyukResimUrl;

    //Private bilgilere erişmek için her değişkenin getter ve setter metotları oluşturulmuştur.
    public String getProgramlamaDili() {
        return programlamaDili;
    }

    public void setProgramlamaDili(String programlamaDili) {
        this.programlamaDili = programlamaDili;
    }

    public String getTasarimci() {
        return tasarimci;
    }

    public void setTasarimci(String tasarimci) {
        this.tasarimci = tasarimci;
    }

    public String getCikisTarihi() {
        return cikisTarihi;
    }

    public void setCikisTarihi(String cikisTarihi) {
        this.cikisTarihi = cikisTarihi;
    }

    public String getDetay() {
        return detay;
    }

    public void setDetay(String detay) {
        this.detay = detay;
    }

    public String getKucukLogoUrl() {
        return kucukLogoUrl;
    }

    public void setKucukLogoUrl(String kucukLogoUrl) {
        this.kucukLogoUrl = kucukLogoUrl;
    }

    public String getBuyukResimUrl() {
        return buyukResimUrl;
    }

    public void setBuyukResimUrl(String buyukResimUrl) {
        this.buyukResimUrl = buyukResimUrl;
    }

}