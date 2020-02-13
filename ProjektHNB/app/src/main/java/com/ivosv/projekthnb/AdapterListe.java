package com.ivosv.projekthnb;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.InputStream;
import java.util.List;

public class AdapterListe extends RecyclerView.Adapter<AdapterListe.Red>{

    private List<Tecaj> tecaji;
    private LayoutInflater layoutInflater;
    private ItemClickInterface itemClickInterface;

    public AdapterListe(Context context){
        layoutInflater=LayoutInflater.from(context);
    }

    public void setTecaj(List<Tecaj> tecaji){
        this.tecaji=tecaji;
    }


    @Override
    public Red onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.red_liste,parent,false);

        return new Red(view);
    }

    @Override
    public void onBindViewHolder(Red holder, int position) {

        Tecaj tecaj=tecaji.get(position);
        holder.drzava.setText(tecaj.getDrzava());
        new DownloadImageTask((ImageView) holder.slika).execute(tecaj.getFlagUrl());
       // holder.slika.setImageBitmap();
        //holder.valuta.setText(tecaj.getValuta());

        Log.d("Drugi kurac od ovce","Kurac od ovce");

    }

    @Override
    public int getItemCount() {
        return tecaji==null ? 0:tecaji.size();
    }

    public Tecaj getTecaj(int position){

        return tecaji.get(position);
    }

    public class Red extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView drzava;
        private ImageView slika;
        private TextView valuta;
        private TextView kupovni;
        private TextView srednji;
        private TextView prodajni;


        public Red(View view){
            super(view);
            drzava=view.findViewById(R.id.drzava);
            slika=view.findViewById(R.id.slika);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int br;
            if(itemClickInterface != null){
                br=getAdapterPosition();
                itemClickInterface.onItemClick(v,getAdapterPosition());

                Log.d("KLIK","onClick: "+ br);
            }
        }
    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }


    public void setClickListener(ItemClickInterface clickListener) {
        this.itemClickInterface=clickListener;
    }

    public interface ItemClickInterface{
        void onItemClick(View view, int position);
    }
}
