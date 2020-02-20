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
        new DownloadImage((ImageView) holder.slika).execute(tecaj.getFlagUrl());

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


        public Red(View view){
            super(view);
            drzava=view.findViewById(R.id.drzava);
            slika=view.findViewById(R.id.slika);

            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            if(itemClickInterface != null){
                itemClickInterface.onItemClick(v,getAdapterPosition());

            }
        }
    }

    public void setClickListener(ItemClickInterface clickListener) {
        this.itemClickInterface=clickListener;
    }

    public interface ItemClickInterface{
        void onItemClick(View view, int position);
    }
}
