package com.example.diak.menu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private Button btn_submit1;
    public static EditText edittxt_nev1;                                                  //IT is staticot használok!
    private TextView txtview_activity1;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_submit1 = (Button) findViewById(R.id.button_submit1);
        edittxt_nev1 = (EditText) findViewById(R.id.edittext_name1);
        txtview_activity1 = (TextView) findViewById(R.id.textview_activity1);

        btn_submit1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

               // Main2Activity.txtview_activity2.setText( edittxt_nev1.getText().toString());        Ez   miért nem müködik itt?

                SharedPreferences sharedinfo = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor szerkeszt = sharedinfo.edit();
                szerkeszt.putString("nev",edittxt_nev1.getText().toString());
                szerkeszt.commit();

                Intent iranya_menube = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(iranya_menube);
                finish();
            }
        });
    }

}
