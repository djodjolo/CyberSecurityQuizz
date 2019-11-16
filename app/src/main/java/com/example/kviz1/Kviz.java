package com.example.kviz1;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Kviz extends AppCompatActivity {

    Button a1, a2, a3, a4;
    TextView q;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kviz);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference();


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
//                   q.append(postSnapshot.toString());
                    q.append(postSnapshot.child("questions").toString());
                }
//
            }

            @Override
            public void onCancelled(DatabaseError error) {
            }
        });


        q = (TextView) findViewById(R.id.q);
        a1 = (Button) findViewById(R.id.a1);
        a2 = (Button) findViewById(R.id.a2);
        a3 = (Button) findViewById(R.id.a3);
        a4 = (Button) findViewById(R.id.a4);

        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                q.setText("workss");

            }
        });


    }

}
