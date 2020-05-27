package com.ivosv.passcontrol.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.ivosv.passcontrol.R;
import com.ivosv.passcontrol.model.PassEntry;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PassEntryAdapter extends ArrayAdapter<PassEntry> {

    private List<PassEntry> records;
    private EntryClickListener entryClickListener;
    private int resource;
    private Context context;


    public PassEntryAdapter(@NonNull Context context, int resource, EntryClickListener entryClickListener) {

        super(context, resource);
        this.resource = resource;
        this.context = context;
        this.entryClickListener = entryClickListener;

    }

    private static class ViewHolder {

        private TextView entryDate;
        private TextView exitDate;
        private ImageView slika;


    }

    @androidx.annotation.NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @androidx.annotation.NonNull ViewGroup parent) {

        View view = convertView;
        final PassEntry passEntry;
        ViewHolder viewHolder;

        if (view == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (inflater != null) {
                view = inflater.inflate(this.resource, null);

                viewHolder.entryDate = view.findViewById(R.id.podatak_ulaz);
                viewHolder.exitDate = view.findViewById(R.id.podatak_izlaz);
                viewHolder.slika = view.findViewById(R.id.slika);


            } else {
                viewHolder = (ViewHolder) view.getTag();

            }

            passEntry = getItem(position);

            if (passEntry != null) {
                viewHolder.entryDate.setText(passEntry.getEntryDate() + " - " + passEntry.getName());
                if (passEntry.getImgFront() == null) {
                    Picasso.get().load(R.drawable.ic_launcher_background).fit().centerCrop().into(viewHolder.slika);
                } else {
                    Picasso.get().load(passEntry.getImgFront()).fit().centerCrop().into(viewHolder.slika);
                }

                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        entryClickListener.onItemClick(passEntry);
                    }
                });

            }
        }
            return view;

    }

    @Override
    public int getCount() {
        return records == null ? 0 : records.size();
    }

    @Nullable
    @Override
    public PassEntry getItem(int position) {
        return records.get(position);
    }

    public void setEntrys(List<PassEntry> entries) {
        this.records = entries;
    }

    public void osvjeziEntrys() {
        notifyDataSetChanged();
    }

}