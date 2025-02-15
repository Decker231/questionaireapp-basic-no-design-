package com.example.questionaireapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Q5 extends AppCompatActivity {

    EditText answer5;
    MediaPlayer mediaPlayer;
    TextView textView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_q5);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mediaPlayer = MediaPlayer.create(this, R.raw.fatal);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);

        AnotherAdapter adapter;
        ArrayList<Image> imageList;
        RecyclerView recyclerView = findViewById(R.id.rView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        imageList = new ArrayList<>();

        for (int i = 0; i < 7; i++) {
            imageList.add(new Image(R.drawable.mewheeze));
        }


        adapter = new AnotherAdapter(imageList);
        recyclerView.setAdapter(adapter);

    }

    public void q5Question(View view){
        final String answer = "Sheepy";

        answer5 = findViewById(R.id.edTxAnswer3);
        String kyleAnswer = answer5.getText().toString().trim();

        if(kyleAnswer.equalsIgnoreCase(answer)){
            finish();
            mediaPlayer.stop();
            Intent intent5 = new Intent(Q5.this, Final_Page.class);
            startActivity(intent5);
        }
        else{
            textView5 = findViewById(R.id.txWrong5);
            String str = "Wrong answer, try again";
            textView5.setText(str);
        }

    }
}