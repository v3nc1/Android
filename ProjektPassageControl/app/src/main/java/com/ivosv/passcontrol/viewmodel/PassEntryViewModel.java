package com.ivosv.passcontrol.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ivosv.passcontrol.db.PassDAO;
import com.ivosv.passcontrol.db.PassDB;
import com.ivosv.passcontrol.model.PassEntry;

import java.util.List;

public class PassEntryViewModel extends AndroidViewModel {

    private PassDAO passDAO;
    private PassEntry passEntry;
    private LiveData<List<PassEntry>> entryRecords;



    public PassEntryViewModel(@NonNull Application application) {
        super(application);
        passDAO= PassDB.getDB(application.getApplicationContext()).passDAO();

    }

    public PassEntry getEntry(){ return passEntry;}

    public void setEntry(PassEntry record){ this.passEntry=record;}

    public LiveData<List<PassEntry>> getEntryRecords(){ return passDAO.getPassEntry();}

    public void addEntry(){ passDAO.addEntry(passEntry);}

    public void closeEntry(){ passDAO.closeEntry(passEntry);}

    public void deleteEntry(){ passDAO.deleteEntry(passEntry);}



}
