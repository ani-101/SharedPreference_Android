package com.example.sharedpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button b;
    TextView txt;
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = findViewById(R.id.button);
        txt = findViewById(R.id.textView);
        et = findViewById(R.id.plaintext);

        SharedPreferences SP = getSharedPreferences("MyPref",MODE_PRIVATE);
        String editVal = SP.getString("name","No value as of now");
        txt.setText(editVal);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String val = et.getText().toString();
                SharedPreferences SP = getSharedPreferences("MyPref",MODE_PRIVATE);
                SharedPreferences.Editor ed = SP.edit();
                ed.putString("name",val);
                ed.apply();
                txt.setText(val);
            }
        });



    }
}