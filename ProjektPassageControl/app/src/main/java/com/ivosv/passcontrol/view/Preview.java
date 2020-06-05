package com.ivosv.passcontrol.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ivosv.passcontrol.R;
import com.ivosv.passcontrol.viewmodel.PassEntryViewModel;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Preview extends Fragment {

    @BindView(R.id.preview_image)
    ImageView image;
    @BindView(R.id.back_button)
    Button back;

    PassEntryViewModel passEntryViewModel;
    String side;

    public Preview(String side) {

        this.side=side;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        super.onCreate(savedInstance);
        View view = inflater.inflate(R.layout.preview,container,false);
        ButterKnife.bind(this, view);

        passEntryViewModel = ((MainActivity) getActivity()).getModel();

        showImage();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ((MainActivity)getActivity()).cud();
            }
        });
        return view;
    }

    private void showImage(){

        if(side.equals("front")) {
            Picasso.get().load(passEntryViewModel.getEntry().getImgFront()).error(R.drawable.ic_launcher_background).into(image);
        }else{

            Picasso.get().load(passEntryViewModel.getEntry().getImgBack()).error(R.drawable.ic_launcher_background).into(image);
        }
    }




}
