package com.ivosv.projekthnb;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;


public class Detalji extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalji);

        Intent intent=getIntent();

        Tecaj tecaj = (Tecaj) intent.getSerializableExtra("tecaj");

        new DownloadImage((ImageView) findViewById(R.id.slika)).execute(tecaj.getFlagUrl());

        TextView drzava=findViewById(R.id.imeDrzave);
        drzava.setText(String.valueOf(tecaj.getDrzava()));

        TextView valuta=findViewById(R.id.valuta);
        valuta.setText(String.valueOf(tecaj.getJedinica()+" "+tecaj.getValuta()));

        TextView kupovni=findViewById(R.id.kupovniVal);
        kupovni.setText(String.valueOf(tecaj.getKupovni()+" kn"));

        TextView srednji=findViewById(R.id.srednjiVal);
        srednji.setText(String.valueOf(tecaj.getSrednji()+" kn"));

        TextView prodajni=findViewById(R.id.prodajniVal);
        prodajni.setText(String.valueOf(tecaj.getProdajni()+" kn"));

        Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}
