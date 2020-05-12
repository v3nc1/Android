package com.ivosv.passcontrol.model;

import java.io.Serializable;
import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;
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


}
