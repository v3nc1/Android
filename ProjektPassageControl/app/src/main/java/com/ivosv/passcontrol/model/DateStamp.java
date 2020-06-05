package com.ivosv.passcontrol.model;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateStamp {


    public static String getDate(){

        String timeStamp = new SimpleDateFormat("dd/MM/yyyy-HH:mm:ss").format(new Date());
        //String imeSlike = "PassEntry" + timeStamp + "." + orientation + "_";

        Log.w("DATE FORMAT: ",timeStamp);

        return timeStamp;

    }
    public static String getFileDate(){

        String timeStamp = new SimpleDateFormat("HH.mm.ss_dd.MM.yyyy").format(new Date());
        //String imeSlike = "PassEntry" + timeStamp + "." + orientation + "_";

        Log.w("DATE FORMAT: ",timeStamp);

        return timeStamp;

    }
}
