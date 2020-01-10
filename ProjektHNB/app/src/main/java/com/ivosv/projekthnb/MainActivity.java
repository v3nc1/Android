package com.ivosv.projekthnb;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterListe.ItemClickInterface{

    private AdapterListe adapterListe;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.lista);
        recyclerView.setLayoutManager(
                new LinearLayoutManager(this));
        adapterListe = new AdapterListe(this);
        adapterListe.setClickListener(this);


        recyclerView.setAdapter(adapterListe);

        RESTTask restTask = new RESTTask();
        Log.d("GREŠKA", "TU SAM ");
        restTask.execute("http://api.hnb.hr/tecajn/v2");

    }

    @Override
    public void onItemClick(View view, int position) {
    }

    private class RESTTask extends AsyncTask<String,Void, List<Tecaj>>{


        @Override
        protected List<Tecaj> doInBackground(String... strings) {
            Log.d("GREŠKA", "TU SAM 2");
            String adresa=strings[0];
            try{
                URL url=new URL(adresa);

                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(15000);
                connection.setConnectTimeout(15000);
                connection.connect();

                InputStreamReader streamReader=new InputStreamReader(connection.getInputStream());

                BufferedReader reader=new BufferedReader(streamReader);


                Tecaj[] mcArray = new Gson().fromJson(reader, Tecaj[].class);

                List<Tecaj> mcList = Arrays.asList(mcArray);

                reader.close();
                streamReader.close();

                return mcList;
            } catch (Exception e) {
                Log.d("GREŠKA", e.getMessage());
            }
            return null;
        }

        @Override
        protected void onPostExecute(List<Tecaj> tecajs) {
            adapterListe.setTecaj(tecajs);
            adapterListe.notifyDataSetChanged();
        }

        @Override
        protected void onProgressUpdate(Void... values) {

        }
    }
}
