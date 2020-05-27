package com.ivosv.passcontrol.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import com.ivosv.passcontrol.R;
import com.ivosv.passcontrol.viewmodel.PassEntryViewModel;


public class MainActivity extends AppCompatActivity {


    private PassEntryViewModel entryViewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        entryViewModel=ViewModelProviders.of(this).get(PassEntryViewModel.class);
        read();

    }


    public void read(){
        setFragment( new ReadFragment());
    }

    public PassEntryViewModel getModel(){ return this.entryViewModel;}

    public void cud(){ setFragment(new CUDFragment());}

    private void setFragment(Fragment fragment){


        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();

    }

}
