package com.example.questionaireapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Q1 extends AppCompatActivity {

    EditText answer1;

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


    }

    public void q1Question(View view){
        final String answer = "Unknown";

        answer1 = findViewById(R.id.edTxAnswer2);
        String kyleAnswer = answer1.getText().toString().trim();

        if(kyleAnswer.equalsIgnoreCase(answer)){
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