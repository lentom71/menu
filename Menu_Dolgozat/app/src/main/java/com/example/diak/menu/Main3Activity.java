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
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private Button   btn_vissza;
    private TextView txtview_activity3;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);



        btn_vissza = (Button) findViewById(R.id.button_vissza);
        txtview_activity3 = (TextView) findViewById(R.id.textview_activity3);

        btn_vissza.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent govissza = new Intent(Main3Activity.this,Main2Activity.class);
                startActivity(govissza);
                Toast.makeText(Main3Activity.this,"VISSZA  a  MENŰBE",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
