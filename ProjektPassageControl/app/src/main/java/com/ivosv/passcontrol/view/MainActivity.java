package com.ivosv.passcontrol.view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ivosv.passcontrol.R;

public class MainActivity extends Activity {

    private Button records=null;
    private Button preview=null;
    private Button exit=null;
    private Button newRecord=null;
    private Button endRecord=null;
    private Button back=null;


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
                newRecord=(Button) findViewById(R.id.btnNewRecord);
                endRecord=(Button) findViewById(R.id.btnCloseRecord);
                back=(Button) findViewById(R.id.btnBack);

                newRecord.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.new_entry_form);
                    }
                });

                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        setContentView(R.layout.activity_main);
                    }
                });

            }
        });

        preview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.pregled);
            }
        });
/*


*/


    }





}
