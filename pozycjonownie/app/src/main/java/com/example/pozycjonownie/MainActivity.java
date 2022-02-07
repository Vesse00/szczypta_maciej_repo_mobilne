package com.example.pozycjonownie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button save_btn = findViewById(R.id.save_btn);
        Button load_btn = findViewById(R.id.load_btn);
        EditText text_window = findViewById(R.id.editTextTextPersonName);

        String filename = "data.txt";
        Context context = this;

        File file = new File(context.getFilesDir(), filename);

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = text_window.getText().toString();

                try {
                    System.out.println(context.getFilesDir());
                    FileWriter fw = new FileWriter(file);
                    fw.write(text);
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        load_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Scanner sc = new Scanner(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}