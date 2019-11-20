package com.example.kviz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class kraj extends AppCompatActivity {

    Button izadji;
    TextView rezultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kraj);

        izadji = (Button)findViewById(R.id.izadji);
        rezultat = (TextView)findViewById(R.id.rezultat);

        Intent mIntent = getIntent();
        rezultat.setText("Vas rezultat je "+  mIntent.getIntExtra("poeni",0));



        izadji.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }



}
