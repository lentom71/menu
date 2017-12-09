package com.example.diak.menu;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.view.View;
import android.content.Intent;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    private Button btn_submit2;
    private EditText edittxt_nev2;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        btn_submit2 = (Button) findViewById(R.id.button_submit2);
        edittxt_nev2 = (EditText) findViewById(R.id.edittext_name2);

        Main2Activity.txtview_activity2.setText( edittxt_nev2.getText().toString());

        btn_submit2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                SharedPreferences sharedinfo = getSharedPreferences("MyData", Context.MODE_PRIVATE);
                SharedPreferences.Editor szerkeszt = sharedinfo.edit();
                szerkeszt.putString("nev",edittxt_nev2.getText().toString());
                szerkeszt.commit();

                Intent vissza2_menube = new Intent(Main4Activity.this,Main2Activity.class);
                startActivity(vissza2_menube);

                Toast.makeText(Main4Activity.this,"Név  elmentve",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
