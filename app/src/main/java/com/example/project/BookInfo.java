package com.example.project_layanalharbi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BookInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_info);
    }

    public void onClickShowMoonInfo(View view){
        Intent intent = new Intent(this, show_moonknight_info.class);
        startActivity(intent);
    }

    public void onClickShowDuneInfo(View view){
        Intent intent = new Intent(this, show_dune_info.class);
        startActivity(intent);
    }

    public void onClickShowNarutoInfo(View view){
        Intent intent = new Intent(this, show_naruto_info.class);
        startActivity(intent);
    }

    public void onClickShowOrangeInfo(View view){
        Intent intent = new Intent(this, show_orange_info.class);
        startActivity(intent);
    }

    public void onClickGoBackHome(View view){
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

}