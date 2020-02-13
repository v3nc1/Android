package com.ivosv.projekthnb;

import android.content.Intent;
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

        restTask.execute("http://api.hnb.hr/tecajn/v2");

    }

    @Override
    public void onItemClick(View view, int position) {
        Tecaj tecaj=adapterListe.getTecaj(position);
        Log.d("Odabrana valuta", tecaj.getDrzava_iso());

        Intent intent=new Intent(this,Detalji.class);
        intent.putExtra("tecaj",tecaj);
        startActivity(intent);

    }

    private class RESTTask extends AsyncTask<String,Void, List<Tecaj>>{


        @Override
        protected List<Tecaj> doInBackground(String... strings) {

            String adresa=strings[0];
            String urlPart1="https://www.countryflags.io/";
            String urlPart2="/shiny/64.png";
            try{
                URL url=new URL(adresa);

                HttpURLConnection connection=(HttpURLConnection)url.openConnection();
                connection.setRequestMethod("GET");
                connection.setReadTimeout(15000);
                connection.setConnectTimeout(15000);
                connection.connect();

                InputStreamReader streamReader=new InputStreamReader(connection.getInputStream());

                BufferedReader reader=new BufferedReader(streamReader);


                Tecaj[] tecajArray = new Gson().fromJson(reader, Tecaj[].class);

                List<Tecaj> tecajList = Arrays.asList(tecajArray);

                reader.close();
                streamReader.close();
                for (Tecaj l:tecajList){


                    switch (l.getDrzava_iso()){

                        case "AUS":
                            l.setFlagUrl(urlPart1+"AU"+urlPart2);
                            Tecaj.setZastava("AUS","AU");
                            break;
                        case "CAN":
                            l.setFlagUrl(urlPart1+"CA"+urlPart2);
                            Tecaj.setZastava("CAN","CA");
                            break;
                        case "CZE":
                            l.setFlagUrl(urlPart1+"CZ"+urlPart2);
                            Tecaj.setZastava("CZE","CZ");
                            break;
                        case "DNK":
                            l.setFlagUrl(urlPart1+"DK"+urlPart2);
                            Tecaj.setZastava("DNK","DK");
                            break;
                        case "HUN":
                            l.setFlagUrl(urlPart1+"HU"+urlPart2);
                            Tecaj.setZastava("HUN","HU");
                            break;
                        case "JPN":
                            l.setFlagUrl(urlPart1+"JP"+urlPart2);
                            Tecaj.setZastava("JPN","JP");
                            break;
                        case "NOR":
                            l.setFlagUrl(urlPart1+"NO"+urlPart2);
                            Tecaj.setZastava("NOR","NO");
                            break;
                        case "SWE":
                            l.setFlagUrl(urlPart1+"SE"+urlPart2);
                            Tecaj.setZastava("SWE","SE");
                            break;
                        case "CHE":
                            l.setFlagUrl(urlPart1+"CH"+urlPart2);
                            Tecaj.setZastava("CHE","CH");
                            break;
                        case "GBR":
                            l.setFlagUrl(urlPart1+"GB"+urlPart2);
                            Tecaj.setZastava("GBR","GB");
                            break;
                        case "USA":
                            l.setFlagUrl(urlPart1+"US"+urlPart2);
                            Tecaj.setZastava("USA","US");
                            break;
                        case "BIH":
                            l.setFlagUrl(urlPart1+"BA"+urlPart2);
                            Tecaj.setZastava("BIH","BA");
                            break;
                        case "EMU":
                            l.setFlagUrl(urlPart1+"EU"+urlPart2);
                            Tecaj.setZastava("EMU","EU");
                            break;
                        case "POL":
                            l.setFlagUrl(urlPart1+"PL"+urlPart2);
                            Tecaj.setZastava("POL","PL");
                            break;
                         default:
                             Log.d("ERROR", "NO DATA ");

                    }
                    Log.d("Red",l.getDrzava_iso()+" - "+Tecaj.getZastave(l.getDrzava_iso())+" "+l.getFlagUrl());
                }

                return tecajList;
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
