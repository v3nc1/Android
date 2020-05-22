package com.ivosv.passcontrol.model;

import java.io.Serializable;
import androidx.annotation.NonNull;
import androidx.lifecycle.Observer;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.ivosv.passcontrol.view.ReadFragment;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(tableName = "entrydata")

public class PassEntry implements Serializable {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int id;
    private String entryDate;
    private String exitDate;
    private String name;
    private String lastName;
    private int idNumber;
    private String reason;
    private String imgFront;
    private String imgBack;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getExitDate() {
        return exitDate;
    }

    public void setExitDate(String exitDate) {
        this.exitDate = exitDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getImgFront() {
        return imgFront;
    }

    public void setImgFront(String imgFront) {
        this.imgFront = imgFront;
    }

    public String getImgBack() {
        return imgBack;
    }

    public void setImgBack(String imgBack) {
        this.imgBack = imgBack;
    }

    public void observe(ReadFragment readFragment, Observer<List<PassEntry>> listObserver) {
    }
}
