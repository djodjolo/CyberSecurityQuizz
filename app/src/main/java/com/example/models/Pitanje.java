package com.example.models;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class  Pitanje {
    String broj, odgovor, pitanje;
    List<String> odgovori;

    public Pitanje(String broj, String odgovor, String pitanje, List<String> odgovori) {
        this.broj = broj;
        this.odgovor = odgovor;
        this.pitanje = pitanje;
        this.odgovori = odgovori;
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

    public void setPitanje(String pitanje) {
        this.pitanje = pitanje;
    }

    public List<String> getOdgovori() {
        return odgovori;
    }

    public void setOdgovori(List<String> odgovori) {
        this.odgovori = odgovori;
    }
}
