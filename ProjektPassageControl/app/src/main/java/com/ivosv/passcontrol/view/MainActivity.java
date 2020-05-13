package com.ivosv.passcontrol.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ivosv.passcontrol.R;
import com.ivosv.passcontrol.viewmodel.PassEntryViewModel;

public class MainActivity extends AppCompatActivity {

    private Button records=null;
    private Button preview=null;
    private Button exit=null;
    private Button newEntry=null;
    private Button closeEntry=null;
    private Button openEntrys=null;
    private Button closedEntrys=null;
    private Button backNewEntryForm=null;
    private PassEntryViewModel entryViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        records=(Button) findViewById(R.id.btnRecords);
        preview=(Button) findViewById(R.id.btnOverview);
        exit=(Button) findViewById(R.id.btnExit);

        records.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.evidencija);
                newEntry=(Button) findViewById(R.id.btnNewRecord);
                closeEntry=(Button) findViewById(R.id.btnCloseRecord);
                backNewEntryForm=(Button) findViewById(R.id.btnBack);

            }
        });

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.pregled);
                entryViewModel= ViewModelProviders.of(this).get(PassEntryViewModel.class);
                read();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });


    }

    public PassEntryViewModel getModel(){ return this.entryViewModel;}
    public void read(){ setFragment();}

    public void cud(){ setFragment();}

    private void setFragment(Fragment fragment){

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace()


    }
}
