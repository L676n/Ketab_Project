package com.example.project_layanalharbi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class orangetreeReader extends AppCompatActivity {

    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orangetree_reader);

        pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset("orangetree.pdf").load();
    }
}