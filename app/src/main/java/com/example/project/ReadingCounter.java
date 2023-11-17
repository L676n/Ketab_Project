package com.example.project_layanalharbi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ReadingCounter extends AppCompatActivity {

    private Spinner spinner;
    private EditText editText;
    private TextView textView;

    int MoonKnight = 140;
    int Dune = 579;
    int Naruto = 154;
    int OrangeTree = 258;
    int pos = 0;
    long id1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reading_counter);
        spinner = findViewById(R.id.booksSpinner);
        textView = findViewById(R.id.BooksCounted);
        List<String> books = new ArrayList<>();
        books.add(0,"Choose from the list");
        books.add(1,"MoonKnight");
        books.add(2,"Dune");
        books.add(3,"Naruto");
        books.add(4,"My Orange Tree");

        ArrayAdapter arrayAdapter = new ArrayAdapter(ReadingCounter.this,
                android.R.layout.simple_dropdown_item_1line, books);

        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos = position;
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public  void onBtnBreClick(View view){

        editText = findViewById(R.id.NumOfPages);
        int amount = Integer.parseInt(editText.getText().toString());

        switch (pos){
            case 0:
                break;
            case 1:
                textView.setText(String.valueOf(MoonKnight/amount));
                break;
            case 2:
                textView.setText(String.valueOf(Dune/amount));
                break;
            case 3:
                textView.setText(String.valueOf(Naruto/amount));
                break;
            case 4:
                textView.setText(String.valueOf(OrangeTree/amount));
                break;
        }
    }

    public void onClickGoBackHome(View view) {
        Intent intent = new Intent(this, HomePage.class);
        startActivity(intent);
    }

}