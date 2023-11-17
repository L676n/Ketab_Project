package com.example.project_layanalharbi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class HomePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }

    public void onClickChooseBok(View view){
        Intent intent = new Intent(this, ChooseBook.class);
        startActivity(intent);
    }

    public void onClickReminder(View view){
        Intent intent = new Intent(this, Reminder.class);
        startActivity(intent);
    }

    public void onClickReadingCounter(View view){
        Intent intent = new Intent(this, ReadingCounter.class);
        startActivity(intent);
    }

    public void onClickBookInfo(View view){
        Intent intent = new Intent(this, BookInfo.class);
        startActivity(intent);
    }

    public void onClickGoodBye(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}