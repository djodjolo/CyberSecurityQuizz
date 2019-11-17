package com.example.kviz1;

import android.content.Intent;
import android.os.Bundle;

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

import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Kviz extends AppCompatActivity {

    Button a1, a2, a3;
    TextView q;

    //initialize Firebase reference
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();



    //define JSON
    List<JSONObject> obj=new ArrayList<JSONObject>();

    List lista = new ArrayList();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kviz);


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, Object> map = (Map<String, Object>) dataSnapshot.getValue();
                Log.e("Mapped", map.toString());




            }
            @Override
            public void onCancelled(DatabaseError error) {
                Log.e("cancled",error.toString());
            }
        });

        q = (TextView) findViewById(R.id.q);
        a1 = (Button) findViewById(R.id.a1);
        a2 = (Button) findViewById(R.id.a2);
        a3 = (Button) findViewById(R.id.a3);


        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q.setText("workss");

            }
        });

        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Kviz.this, kraj.class));
            }
        });

    }

}
