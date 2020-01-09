package com.ivosv.projekthnb;

import java.util.Date;
import java.util.List;

public class Odgovor {

    private String kljuc;
    private Date vrijeme;
    private boolean greska;
    private List<Tecaj> tecaj;

    public String getKljuc() {
        return kljuc;
    }

    public void setKljuc(String kljuc) {
        this.kljuc = kljuc;
    }

    public Date getVrijeme() {
        return vrijeme;
    }

    public void setVrijeme(Date vrijeme) {
        this.vrijeme = vrijeme;
    }

    public boolean isGreska() {
        return greska;
    }

    public void setGreska(boolean greska) {
        this.greska = greska;
    }

    public List<Tecaj> getTecaj() {
        return tecaj;
    }

    public void setTecaj(List<Tecaj> tecaj) {
        this.tecaj = tecaj;
    }
}
