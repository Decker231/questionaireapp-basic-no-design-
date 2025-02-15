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

public class Q1 extends AppCompatActivity {

    EditText answer1;
    MediaPlayer mediaPlayer;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_q1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        mediaPlayer = MediaPlayer.create(this, R.raw.jeopardy);
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









    public void q1Question(View view){
        final String answer = "Pickle";
        final String answer2 = "Deviljho";

        answer1 = findViewById(R.id.edTxAnswer3);
        String kyleAnswer = answer1.getText().toString().trim();

        if(kyleAnswer.equalsIgnoreCase(answer) || kyleAnswer.equalsIgnoreCase(answer2)){
            finish();
            mediaPlayer.stop();
            Intent intent = new Intent(Q1.this, Q2.class);
            startActivity(intent);
        }
        else{
            textView = findViewById(R.id.txWrongAnswer);
            String str = "Wrong answer, try again";
            textView.setText(str);
        }

    }
}