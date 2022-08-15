package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txt_name,txt_rtb,txt_sw,txt_rad,txt_animal,txt_seek;
    Button but_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt_name = findViewById(R.id.txt_name);
        txt_rtb = findViewById(R.id.txt_rtb);
        txt_sw = findViewById(R.id.txt_sw);
        txt_rad = findViewById(R.id.txt_rad);
        but_back = findViewById(R.id.but_back);
        txt_animal = findViewById(R.id.txt_animal);
        txt_seek = findViewById(R.id.txt_seek);



        Intent get_val = getIntent();
        String get_rtb = get_val.getStringExtra("Rating");
        txt_rtb.setText(get_rtb);
        String get_name = get_val.getStringExtra("name");
        txt_name.setText(get_name);
        txt_sw.setText(get_val.getStringExtra("sw_val"));
        txt_rad.setText(get_val.getStringExtra("rad_sex"));
        txt_seek.setText(get_val.getStringExtra("seek"));
        txt_animal.setText(get_val.getStringExtra("spinner"));




        but_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_page1 = new Intent(MainActivity2.this,MainActivity.class);
                startActivity(goto_page1);
            }
        });



    }
}