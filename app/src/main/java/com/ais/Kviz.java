package com.ais;

import android.content.Intent;
import android.os.Bundle;

import com.ais.models.Pitanje;
import com.example.kviz1.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Kviz extends AppCompatActivity {

    Button a1, a2, a3;
    TextView q;

    List<Pitanje> pitanja;
    int poeni = 0;
    int indexpitanje = 0;
    int brojPitanja = 5;

    //init firebase referencu
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("pitanja");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kviz);

        q = (TextView) findViewById(R.id.q);
        a1 = (Button) findViewById(R.id.a1);
        a2 = (Button) findViewById(R.id.a2);
        a3 = (Button) findViewById(R.id.a3);

        Gson gson = new Gson();
        Intent intent = getIntent();
        Type listType = new TypeToken<ArrayList<Pitanje>>(){}.getType();
        List<Pitanje> pitanja = new Gson().fromJson(intent.getStringExtra("pitanja_json"), listType);

        if(pitanja.isEmpty()){
            startActivity(new Intent(Kviz.this, MainActivity.class));
        }

        //Log.e("nemixano",pitanja.toString());
        Collections.shuffle(pitanja);
        //Log.e("mixano-raw",pitanja.toString());
        final List<Pitanje> mixanaPitanja = new ArrayList<>();
            int index = 0;
            for(Pitanje p : pitanja){
                if(index++<brojPitanja){
                    mixanaPitanja.add(p);
                }else{
                    break;
                }
            }

        q.setText(mixanaPitanja.get(indexpitanje).getPitanje());
        a1.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(0));
        a2.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(1));
        a3.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(2));

        a1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(Integer.parseInt(mixanaPitanja.get(indexpitanje).getOdgovor()) == 1){
                        poeni++;
                    }

                   if(++indexpitanje==brojPitanja){
                       startActivity(new Intent(Kviz.this,  MainActivity.class).putExtra("poeni",poeni));
                   }else{
                       q.setText(mixanaPitanja.get(indexpitanje).getPitanje());
                       a1.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(0));
                       a2.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(1));
                       a3.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(2));
                   }
                }
            });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.parseInt(mixanaPitanja.get(indexpitanje).getOdgovor()) == 2){
                    poeni++;
                }

                if(++indexpitanje==brojPitanja){
                    startActivity(new Intent(Kviz.this,  MainActivity.class).putExtra("poeni",poeni));

                }else{
                    q.setText(mixanaPitanja.get(indexpitanje).getPitanje());
                    a1.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(0));
                    a2.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(1));
                    a3.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(2));
                }

            }
        });
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if(Integer.parseInt(mixanaPitanja.get(indexpitanje).getOdgovor()) == 3){
                        poeni++;
                }
                if(++indexpitanje==brojPitanja){
                    startActivity(new Intent(Kviz.this, MainActivity.class).putExtra("poeni",poeni));
                }else{
                    q.setText(mixanaPitanja.get(indexpitanje).getPitanje());
                    a1.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(0));
                    a2.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(1));
                    a3.setText(mixanaPitanja.get(indexpitanje).getOdgovori().get(2));
                }
            }
        });
    }
}
