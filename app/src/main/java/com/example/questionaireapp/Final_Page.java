package com.example.questionaireapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Final_Page extends AppCompatActivity {
    MediaPlayer mediaPlayer1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_final_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


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

        mediaPlayer1 = new MediaPlayer();
        mediaPlayer1 = MediaPlayer.create(this,R.raw.proofofhero);
        mediaPlayer1.start();

        Button finBtn = findViewById(R.id.finBtn);
        finBtn.setOnClickListener(view -> {
            mediaPlayer1.stop();
            finish();

            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://store.steampowered.com/app/2246340/Monster_Hunter_Wilds/")));
        });

    }
}