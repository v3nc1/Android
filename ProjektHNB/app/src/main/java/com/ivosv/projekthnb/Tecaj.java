package com.ivosv.projekthnb;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Tecaj implements Serializable {


    private String drzava;
    private String drzava_iso;
    private String valuta;
    private String kupovni_tecaj;
    private String srednji_tecaj;
    private String prodajni_tecaj;
    private String datum_primjene;
    private String flagUrl;
    private static Map<String,String> linkZastava =new HashMap<>();


    public Tecaj() {
    }

    public Tecaj(String drzava, String iso, String valuta, String kupovni, String srednji, String prodajni, String date, String urlSlika) {

        this.drzava = drzava;
        this.drzava_iso = iso;
        this.valuta = valuta;
        this.kupovni_tecaj = kupovni;
        this.srednji_tecaj = srednji;
        this.prodajni_tecaj = prodajni;
        this.datum_primjene = date;

    }

    public static String getZastave(String key){

        return linkZastava.get(key);

    }

    public static void setZastava(String key,String value){

        linkZastava.put(key,value);

    }


    public String getDrzava() {
        return drzava;
    }

    public String getDrzava_iso() {
        return drzava_iso;
    }

    public String getValuta() {
        return valuta;
    }

    public String getKupovni() {
        return kupovni_tecaj;
    }

    public String getSrednji() {
        return srednji_tecaj;
    }

    public String getProdajni() {
        return prodajni_tecaj;
    }

    public String getDate() {
        return datum_primjene;
    }

    public String getFlagUrl(){return flagUrl;}




    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    public void setDrzava_iso(String drzava_iso) {
        this.drzava_iso = drzava_iso;
    }

    public void setValuta(String valuta) {
        this.valuta = valuta;
    }

    public void setKupovni(String kupovni) {
        this.kupovni_tecaj = kupovni;
    }

    public void setSrednji(String srednji) {
        this.srednji_tecaj = srednji;
    }

    public void setProdajni(String prodajni) {
        this.prodajni_tecaj = prodajni;
    }

    public void setDate(String date) {
        this.datum_primjene = date;
    }

    public void setFlagUrl(String flagUrl){this.flagUrl=flagUrl;}


}
