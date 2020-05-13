package com.ivosv.passcontrol.db;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import com.ivosv.passcontrol.model.PassEntry;
import java.util.List;

public interface PassDAO {

    @Query("SELECT * FROM entrydata ORDER BY id DESC")
    LiveData<List<PassEntry>> getPassEntry();

    @Insert
    void addEntry(PassEntry record);

    @Update
    void closeEntry(PassEntry record);

    @Delete
    void deleteEntry(PassEntry record);

}
