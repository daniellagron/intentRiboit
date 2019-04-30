package com.example.intnet;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Double a, b, c;
    String aa, bb, cc;
    Random rnd = new Random();
    EditText A,B,C;
    TextView ans1,ans2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        A = (EditText) findViewById(R.id.A);
        B = (EditText) findViewById(R.id.B);
        C = (EditText) findViewById(R.id.C);
        ans1 = (TextView) findViewById(R.id.ans1);
        ans2 = (TextView) findViewById(R.id.ans2);
    }

    public void Random (View view){
        a = rnd.nextInt(200) + 1 + rnd.nextDouble()-100;
        b = rnd.nextInt(200) + 1 + rnd.nextDouble()-100;
        c = rnd.nextInt(200) + 1 + rnd.nextDouble()-100;
        A.setText("" + a);
        B.setText("" + b);
        C.setText("" + c);
    }

    public void Solution (View view){
        Intent si = new Intent(this, Main2Activity.class);
        aa = A.getText().toString();
        bb = B.getText().toString();
        cc = C.getText().toString();
        if((aa.equals(""))||(bb.equals(""))||(cc.equals(""))||(aa.equals("-"))||(bb.equals("-"))||(cc.equals("-"))){}

        else {
            a = Double.parseDouble(aa);
            b = Double.parseDouble(bb);
            c = Double.parseDouble(cc);
            si.putExtra("n", a);
            si.putExtra("nn", b);
            si.putExtra("nnn", c);
            startActivityForResult(si, 1);

        }
    }
    @Override
    protected void onActivityResult(int source , int good, @Nullable Intent data){
        if(source==1){
            if (good==RESULT_OK){
                if (data!=null) {
                    ans1.setText("x1=" + " " + data.getStringExtra("n"));
                    ans2.setText("x2=" +" "+ data.getStringExtra("nn"));
                }
            }
        }
    }


    }



