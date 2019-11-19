package com.example.kviz1;

import android.content.Intent;
import android.os.Bundle;

import com.example.models.Podaci;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import com.example.models.Pitanje;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Kviz extends AppCompatActivity {

    Button a1, a2, a3;
    TextView q;

    List<Pitanje> pitanja;
    Podaci podaci;

    int brojPitanja = 2;
    //initialize Firebase reference
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
//
        Log.e("nemixano",pitanja.toString());
        Collections.shuffle(pitanja);
        Log.e("mixano-raw",pitanja.toString());
        List<Pitanje> mixanaPitanja = new ArrayList<>();
            int index = 0;
            for(Pitanje p : pitanja){
                if(index++<brojPitanja){
                    mixanaPitanja.add(p);
                }else{
                    break;
                }
            }

            Log.e("spremno",mixanaPitanja.toString());



        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Kviz.this, kraj.class));
            }
        });

//        a2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                myRef.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(DataSnapshot dataSnapshot) {
//
//
//                pitanja = new ArrayList<Pitanje>();
//                for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {
////                    Log.e("tmz",""+ chidSnap.getKey()); //displays the key for the node
////                    Log.e("tmz",""+ chidSnap.child("pitanje").getValue());   //gives the value for given keyname
////                    pitanja.add(new Pitanje(chidSnap.child("pitanje").getValue().toString()));
//
//                    List<String> localPitanja = new ArrayList<>();
//
//                    for(DataSnapshot odgovor : chidSnap.child("odgovori").getChildren()){
//                        Log.e("iz nove liste",odgovor.getValue().toString());
//                        localPitanja.add(odgovor.getValue().toString());
//                    }
//                        Log.e("----","-----");
////
//                    pitanja.add(new Pitanje(
//                              chidSnap.child("broj").getValue().toString(),
//                              chidSnap.child("odgovor").getValue().toString(),
//                              chidSnap.child("pitanje").getValue().toString(),
//                              localPitanja
//                      ));
//                    localPitanja.clear();
//
//                }
//
//                for(Pitanje pitanje : pitanja){
//                    q.append(pitanje.getOdgovor());
//                }
////                Log.e("ntwz",dataSnapshot.getChildren().toString());
//                    }
//                    @Override
//                    public void onCancelled(DatabaseError error) {
//                        Log.e("error",error.toString());
//                    }
//                });
//            }
//        });

    }

}
