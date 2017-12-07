package com.flora.flora_quiz_quotes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText Name,Quote;
    Button BtnSave, BtnNext;
    SharedPreferences preferences;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.name);
        Quote = (EditText)findViewById(R.id.quote);
        BtnSave = (Button)findViewById(R.id.btnsave);
        BtnNext = (Button)findViewById(R.id.btnnext);


        preferences = getSharedPreferences("pref", Context.MODE_WORLD_READABLE);
    }

    public void savePreferences(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("name",Name.getText().toString());
        editor.putString("quote", Quote.getText().toString());
        editor.commit();
        Toast.makeText(this, "Saved in Shared Preferences!", Toast.LENGTH_LONG).show();
    }

    public void nextPage(View view){
        Intent intent = new Intent(this, Display.class);
        startActivity(intent);
    }

}