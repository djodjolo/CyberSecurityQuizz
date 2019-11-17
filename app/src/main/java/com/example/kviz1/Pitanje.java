package com.example.kviz1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

class Pitanje {
    String pitanje;
    int tacanOdogovor;
    List<String> odgovori;

    public Pitanje(String pitanje, int tacanOdogovor, List odgovori){
        this.pitanje = pitanje;
        this.tacanOdogovor = tacanOdogovor;
        this.odgovori = odgovori;

    }

    public String getPitanje() {
        return pitanje;
    }
}
