package com.example.kviz1;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.example.models.Pitanje;

public class Kviz extends AppCompatActivity {

    Button a1, a2, a3;
    TextView q;

    List<Pitanje> pitanja;

    //initialize Firebase reference
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference("pitanja");



    //define JSON
    List<JSONObject> obj=new ArrayList<JSONObject>();

    List lista = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kviz);




        q = (TextView) findViewById(R.id.q);
        a1 = (Button) findViewById(R.id.a1);
        a2 = (Button) findViewById(R.id.a2);
        a3 = (Button) findViewById(R.id.a3);



        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Kviz.this, kraj.class));
            }
        });

        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myRef.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
//                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
//                Log.e("Mapped", map.toString());

                pitanja = new ArrayList<Pitanje>();
                for (DataSnapshot chidSnap : dataSnapshot.getChildren()) {
//                    Log.e("tmz",""+ chidSnap.getKey()); //displays the key for the node
//                    Log.e("tmz",""+ chidSnap.child("pitanje").getValue());   //gives the value for given keyname
//                    pitanja.add(new Pitanje(chidSnap.child("pitanje").getValue().toString()));

                    List<String> localPitanja = new ArrayList<>();

                    for(DataSnapshot odgovor : chidSnap.child("odgovori").getChildren()){
                        Log.e("iz nove liste",odgovor.getValue().toString());
                        localPitanja.add(odgovor.getValue().toString());
                    }
                        Log.e("----","-----");
//
                    pitanja.add(new Pitanje(
                              chidSnap.child("broj").getValue().toString(),
                              chidSnap.child("odgovor").getValue().toString(),
                              chidSnap.child("pitanje").getValue().toString(),
                              localPitanja
                      ));
                    localPitanja.clear();

                }

                for(Pitanje pitanje : pitanja){
                    q.append(pitanje.getOdgovor());
                }
//                Log.e("ntwz",dataSnapshot.getChildren().toString());
                    }
                    @Override
                    public void onCancelled(DatabaseError error) {
                        Log.e("error",error.toString());
                    }
                });
            }
        });

    }

}
