package com.ivosv.passcontrol.view;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.FileProvider;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import com.ivosv.passcontrol.R;
import com.ivosv.passcontrol.model.PassEntry;
import com.ivosv.passcontrol.viewmodel.PassEntryViewModel;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CUDFragment extends Fragment {

    static final int SLIKA_1=1;
    static final int SLIKA_2=2;

    private String pictureRoute;

    @BindView(R.id.txtEntryTime)
    TextView entryTime;
    @BindView(R.id.txtExitTime)
    TextView exitTime;
    @BindView(R.id.txtName)
    EditText name;
    @BindView(R.id.txtLastName)
    EditText lastName;
    @BindView(R.id.btnTakePicture)
    Button picture;
    @BindView(R.id.txtIDnumber)
    EditText idNumber;
    @BindView(R.id.txtEntryReason)
    EditText entryReason;
    @BindView(R.id.img_front)
    ImageView imgFront;
    @BindView(R.id.img_back)
    ImageView imgBack;
    @BindView(R.id.btnSave)
    Button save;
    @BindView(R.id.btnCancle)
    Button cancle;

    PassEntryViewModel passEntryViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.new_entry_form, container, false);
        ButterKnife.bind(this, view);

        passEntryViewModel = ((MainActivity) getActivity()).getModel();

        if (passEntryViewModel.getEntry().getId() == 0) {
            defineNewPassEntry();
            return view;
        }

        definirajMijenjanjeBrisanjePassEntry();

        return view;

    }

    private void definirajMijenjanjeBrisanjePassEntry() {


        entryTime.setText(passEntryViewModel.getEntry().getEntryDate());
        exitTime.setText(passEntryViewModel.getEntry().getExitDate());
        name.setText(passEntryViewModel.getEntry().getName());
        lastName.setText(passEntryViewModel.getEntry().getLastName());
        idNumber.setText(passEntryViewModel.getEntry().getIdNumber());
        entryReason.setText(passEntryViewModel.getEntry().getReason());

        Picasso.get().load(passEntryViewModel.getEntry().getImgFront()).error(R.drawable.ic_launcher_background).into(imgFront);


        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0; i<2;i++){

                    if(i==0){
                        takePicture("Front",SLIKA_1);
                    }else{
                        takePicture("Back",SLIKA_2);
                    }


                }
            }
        });


    }
    private void defineNewPassEntry() {

        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i=0; i<2;i++){

                    if(i==0){
                        takePicture("Front",SLIKA_1);
                    }else{
                        takePicture("Back",SLIKA_2);
                    }


                }

            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newPassEntry();
            }
        });
    }

    private void newPassEntry() {
        passEntryViewModel.getEntry().setEntryDate(entryTime.getText().toString());
        passEntryViewModel.getEntry().setName(name.getText().toString());
        passEntryViewModel.getEntry().setLastName(lastName.getText().toString());
        passEntryViewModel.getEntry().setIdNumber(Integer.parseInt(idNumber.getText().toString()));
        passEntryViewModel.getEntry().setReason(entryReason.getText().toString());
        passEntryViewModel.addEntry();

        back();
    }

    @OnClick(R.id.btnCancle)
    public void back(){ ((MainActivity) getActivity()).read();}

    private void takePicture(String orientation, int slikaBr){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        // Ensure that there's a camera activity to handle the intent
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) == null) {
            Toast.makeText(getActivity(), "Problem kod kreiranja slike", Toast.LENGTH_LONG).show();
            return;

        }

        File slika = null;
        try {
            slika = kreirajDatotekuSlike(orientation);
        } catch (IOException ex) {
            Toast.makeText(getActivity(), "Problem kod kreiranja slike", Toast.LENGTH_LONG).show();
            return;
        }

        if (slika == null) {
            Toast.makeText(getActivity(), "Problem kod kreiranja slike", Toast.LENGTH_LONG).show();
            return;
        }

        Uri slikaURI = FileProvider.getUriForFile(getActivity(),"com.ivosv.passcontrol.provider", slika);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, slikaURI);
        startActivityForResult(takePictureIntent, slikaBr);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == SLIKA_1 && resultCode == Activity.RESULT_OK) {

            passEntryViewModel.getEntry().setImgFront("file://" + pictureRoute);
            passEntryViewModel.closeEntry();
            Picasso.get().load(passEntryViewModel.getEntry().getImgFront()).into(imgFront);

        }else {
            passEntryViewModel.getEntry().setImgBack("file://" + pictureRoute);
            passEntryViewModel.closeEntry();
            Picasso.get().load(passEntryViewModel.getEntry().getImgBack()).into(imgBack);

        }
    }

    private File kreirajDatotekuSlike(String orientation) throws IOException {
        String timeStamp = new SimpleDateFormat("HH.mm.ss_dd.MM.yyyy").format(new Date());
        String imeSlike = "PassEntry" + timeStamp + "." + orientation + "_";
        File storageDir = getActivity().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(
                imeSlike,  /* prefix */
                ".jpg",         /* suffix */
                storageDir      /* directory */
        );

        pictureRoute = image.getAbsolutePath();
        return image;
    }




}
