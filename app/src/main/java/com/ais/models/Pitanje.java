package com.ais.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pitanje implements Serializable {


    String broj, odgovor, pitanje, tezina;
    List<String> odgovori;

    public Pitanje(String broj, String odgovor, String pitanje, List<String> aodgovori,String tezina)  {
        this.broj = broj;
        this.odgovor = odgovor;
        this.pitanje = pitanje;
        this.tezina = tezina;
        this.odgovori = new ArrayList<>(aodgovori);
    }


    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getOdgovor() {
        return odgovor;
    }

    public void setOdgovor(String odgovor) {
        this.odgovor = odgovor;
    }

    public String getPitanje() {
        return pitanje;
    }

    public void setTezina(String tezina) {
        this.tezina = tezina;
    }

    public String getTezina() {
        return tezina;
    }

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public List<String> getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(List<String> odgovori) {
        this.odgovori = odgovori;
    }

    @Override
    public String toString() {
        return "Pitanje{" +
                "broj='" + broj + '\'' +
                ", odgovor='" + odgovor + '\'' +
                ", pitanje='" + pitanje + '\'' +
                ", tezina='" + tezina + '\'' +
                ", odgovori=" + odgovori +
                '}';
    }
}
