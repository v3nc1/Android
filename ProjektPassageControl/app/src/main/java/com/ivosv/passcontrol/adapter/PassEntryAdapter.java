package com.ivosv.passcontrol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ivosv.passcontrol.model.PassEntry;

import java.util.List;

public class PassEntryAdapter extends ArrayAdapter<PassEntry> {

    private List<PassEntry> records;
    private EntryClickListener entryClickListener;
    private int resource;
    private Context context;


    public PassEntryAdapter(@NonNull Context context, int resource, EntryClickListener entryClickListener) {

        super(context, resource);
        this.entryClickListener=entryClickListener;
        this.resource=resource;
        this.context=context;

    }

    private static class ViewHolder{

        private TextView entryDate;
        private TextView exitDate;


    }

    @androidx.annotation.NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @androidx.annotation.NonNull ViewGroup parent){

        View view=convertView;
        PassEntry passEntry;
        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (inflater != null) {
                view = inflater.inflate(this.resource, null);

                viewHolder.entryDate = view.findViewById(R.id.);

            } else {
                viewHolder = (ViewHolder) view.getTag();

            }

    }







}
