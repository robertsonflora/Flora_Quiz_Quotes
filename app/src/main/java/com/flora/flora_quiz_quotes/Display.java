package com.flora.flora_quiz_quotes;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Display extends AppCompatActivity {

    Button BtnBack;
    TextView Display;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        BtnBack = (Button) findViewById(R.id.btnback);
        Display = (TextView) findViewById(R.id.display);

        preferences = getSharedPreferences("pref", Context.MODE_WORLD_READABLE);
        loadQuote();

    }

    public void loadQuote(){
        String name = preferences.getString("name","");
        String quote = preferences.getString("quote","");

        Display.setText(name + " said " + quote);
    }

    public void back(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
