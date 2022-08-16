package com.example.week4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText name;
    RatingBar rtb;
    Switch sw1;
    ///CheckBox cb_male, cb_female;
    Button but_ent;
    RadioButton rad_m,rad_f;
    Spinner spinner;
    SeekBar seekBar;
    TextView txt_seek;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.inp_name);
        rtb = findViewById(R.id.rtb);
        sw1 = findViewById(R.id.sw1);
        rad_m = findViewById(R.id.rad_male);
        rad_f = findViewById(R.id.rad_female);
        but_ent = findViewById(R.id.but_ent);
        spinner = findViewById(R.id.spinner);
        seekBar = findViewById(R.id.seekBar);
        txt_seek = findViewById(R.id.txt_sb);

        ///Seekbar
        int seek_value = seekBar.getProgress();
        txt_seek.setText(Integer.toString(seek_value));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int seek_value = (seekBar.getThumbOffset()*i)/22;
                txt_seek.setText(Integer.toString(seek_value));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        but_ent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goto_page2 = new Intent(MainActivity.this,MainActivity2.class);

                ///txt-name
                goto_page2.putExtra("name",name.getText().toString());

                ///Rating
                String v1 = Float.toString(rtb.getRating());
                goto_page2.putExtra("Rating",v1);

                ///Switch
                if (sw1.isChecked()){
                    goto_page2.putExtra("sw_val","ON");
                }
                else {
                    goto_page2.putExtra("sw_val","OFF");
                }

                ///RadioButton
                if (rad_m.isChecked() && !rad_f.isChecked()){
                    goto_page2.putExtra("rad_sex","Male");
                }
                else if (!rad_m.isChecked() && rad_f.isChecked()){
                    goto_page2.putExtra("rad_sex","Female");
                }

                ///SendSeek
                goto_page2.putExtra("seek",txt_seek.getText());

                ///Spinner
                goto_page2.putExtra("spinner",spinner.getSelectedItem().toString());

                startActivity(goto_page2);

            }
        });


    }
}