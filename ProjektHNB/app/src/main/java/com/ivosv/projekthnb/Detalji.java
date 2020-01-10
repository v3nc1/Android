package com.ivosv.projekthnb;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.InputStream;

public class Detalji extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_);

    }
        private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{

            ImageView bmImage;

            public DownloadImageTask(ImageView bmImage){
                this.bmImage=bmImage;
            }

            protected Bitmap doInBackround(String... urls){
                String urlDisplay=urls[0];
                Bitmap mIconl=null;

                try{
                    InputStream in=new java.net.URL(urlDisplay).openStream();
                    mIconl= BitmapFactory.decodeStream(in);
                }catch (Exception e){
                    Log.e("Error", e.getMessage());
                    e.printStackTrace();
                }
                return mIconl;
            }

            @Override
            protected Bitmap doInBackground(String... strings) {
                return null;
            }

            @Override
            protected void onPostExecute(Bitmap result){

                bmImage.setImageBitmap(result);
            }


        }



}
