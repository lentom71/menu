package com.example.diak.menu;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity
{

    private Button btn_next, btn_namechange, btn_inform, btn_exit;
    public  static TextView txtview_activity2;                                   //ITT public  statikussá tettem a változót hogy más activityben is tudjam használni!!!
    private AlertDialog.Builder alert;

    public static String informacio;                                            //ITT is public statikussá teszem a változót!!

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        init();
        onclicklisteners();
    }


    public void init()
    {
        btn_next = (Button) findViewById(R.id.button_next);
        btn_namechange = (Button) findViewById(R.id.button_namechange);
        btn_inform = (Button) findViewById(R.id.button_inform);
        btn_exit = (Button) findViewById(R.id.button_exit);
        txtview_activity2 = (TextView) findViewById(R.id.textview_activity2);

        SharedPreferences sharedinfo = getSharedPreferences("MyData", Context.MODE_PRIVATE);
        informacio = sharedinfo.getString("nev","");
        txtview_activity2.setText( informacio);

        alert = new AlertDialog.Builder(Main2Activity.this);                             // 2  Alert.Dialog  egymásbaágyazása  történik  a  lentiekben!!
        alert.setMessage("Biztos kilépsz?")
                .setPositiveButton("NEM", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        alert = new AlertDialog.Builder(Main2Activity.this);
                        alert.setMessage("Üdvözöllek újra  " + Main2Activity.informacio +  "    Új játékot szeretnél vagy ezen a néven folytatod?")
                                .setPositiveButton("ÚJ JÁTÉK", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                        Intent gofolytatom = new Intent(Main2Activity.this,MainActivity.class);
                                        startActivity(gofolytatom);
                                        finish();
                                        MainActivity.edittxt_nev1.setText("");
                                    }
                                })
                                .setNegativeButton("FOLYTATOM", new DialogInterface.OnClickListener()
                                {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which)
                                    {
                                                                                              //Ide nem irtam semmit hiszen itt semmi nem változik!
                                    }
                                })
                                .setCancelable(false)
                                .create();

                        final AlertDialog show = alert.show();
                    }
                })
                .setNegativeButton("IGEN", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        finish();
                    }
                })
                .setCancelable(false)
                .create();
    }


    public void onclicklisteners()
    {
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent kovetkezo = new Intent(Main2Activity.this,Main3Activity.class);
                startActivity(kovetkezo);
                finish();
            }
        });

        btn_inform.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                Toast.makeText(Main2Activity.this,"A NEVED :" + informacio ,Toast.LENGTH_SHORT).show();
            }
        });

        btn_namechange.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent nevvaltozik = new Intent(Main2Activity.this,Main4Activity.class);
                startActivity(nevvaltozik);
                finish();
            }
        });

        btn_exit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final AlertDialog show = alert.show();
            }
        });
    }
}
