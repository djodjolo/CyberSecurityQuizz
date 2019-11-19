package com.example.kviz1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.models.Pitanje;
import com.example.models.Podaci;

import java.util.List;

public class kraj extends AppCompatActivity {

    Button izadji;
    TextView rezultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kraj);

        izadji = (Button)findViewById(R.id.izadji);
        rezultat = (TextView)findViewById(R.id.rezultat);

//        Podaci p = new Podaci(2);
//
//        List<Pitanje>  pitanja = p.getPitanja();
//
//        for(Pitanje item: pitanja)
//            rezultat.append(item.getOdgovor());

        izadji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }



}
