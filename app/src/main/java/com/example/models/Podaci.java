package com.example.models;

import com.example.models.Pitanje;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Podaci {

    int brojPitanja;
    List<Pitanje> pitanja;

    public Podaci(int aBrojPitanja, List<Pitanje> listaPitanja){
        this.brojPitanja = aBrojPitanja;
        this.pitanja = listaPitanja;
//        Collections.shuffle(pitanja);
    }


    public List<Pitanje> getPitanja() {
        List<Pitanje> localpitanja = new ArrayList<>();
        for(int i=0;i<brojPitanja;i++)
            localpitanja.add(this.pitanja.get(i));
        return localpitanja;
    }

    @Override
    public String toString() {
        return getPitanja().toString();
    }
}
