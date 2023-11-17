package com.example.project_layanalharbi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseBook extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_book);
    }

    public void onClickGoToMoon(View view){
        Intent intent = new Intent(this, moonKnightReader.class);
        startActivity(intent);
    }

    public void onClickGoToDune(View view){
        Intent intent = new Intent(this, DuneReader.class);
        startActivity(intent);
    }

    public void onClickGoToNaruto(View view){
        Intent intent = new Intent(this, narutoReader.class);
        startActivity(intent);
    }

    public void onClickGoToOrange(View view){
        Intent intent = new Intent(this, orangetreeReader.class);
        startActivity(intent);
    }

    public void onClickGoBackHome(View view){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }


}