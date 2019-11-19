package com.example.kviz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.models.Pitanje;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;


import android.util.Log;


public class MainActivity extends AppCompatActivity {

    Button uvod;
    List<Pitanje> pitanja;

    //initialize Firebase reference
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("pitanja");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //create instance
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //init button
        uvod = (Button) findViewById(R.id.uvod);

        //init data
        pitanja = new ArrayList<Pitanje>();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {



                for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {

                    List<String> localPitanja = new ArrayList<>();

                    for (DataSnapshot odgovor : chidSnap.child("odgovori").getChildren()) {
                        //    Log.e("iz nove liste", odgovor.getValue().toString());
                        localPitanja.add(odgovor.getValue().toString());
                    }
                    //  Log.e("----", "-----");

                    pitanja.add(new Pitanje(
                            chidSnap.child("broj").getValue().toString(),
                            chidSnap.child("odgovor").getValue().toString(),
                            chidSnap.child("pitanje").getValue().toString(),
                            localPitanja
                    ));
                    localPitanja.clear();
                }


            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.e("error", error.toString());
            }
        });

        uvod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Gson gson = new Gson();
                String pitanja_json = gson.toJson(pitanja);

//                startActivity(new Intent(MainActivity.this, Kviz.class));
                startActivity(new Intent(MainActivity.this, Kviz.class).putExtra("pitanja_json",pitanja_json));

            }
        });
    }
}






