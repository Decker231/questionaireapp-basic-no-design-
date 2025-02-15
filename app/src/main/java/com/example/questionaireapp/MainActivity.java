package com.example.questionaireapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btnNext = findViewById(R.id.btnMainNextpg);
        mediaPlayer = MediaPlayer.create(this, R.raw.jeopardy);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        AnotherAdapter adapter;
        ArrayList<Image> imageList;
        RecyclerView recyclerView = findViewById(R.id.rView);
        RecyclerView recyclerView1 = findViewById(R.id.rView1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView1.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        imageList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            imageList.add(new Image(R.drawable.mewheeze));
        }


        adapter = new AnotherAdapter(imageList);
        recyclerView1.setAdapter(adapter);
        recyclerView1.setAdapter(adapter);
        recyclerView.setAdapter(adapter);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.stop();
                startActivity(new Intent(MainActivity.this, Q1.class));

            }
        });

    }
}