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

public class Q2 extends AppCompatActivity {

    EditText answer2;

    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_q2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    public void q2Question(View view){
        final String answer = "Unknown";

        answer2 = findViewById(R.id.edTxAnswer2);
        String kyleAnswer = answer2.getText().toString().trim();

        if(kyleAnswer.equalsIgnoreCase(answer)){
            Intent intent2 = new Intent(Q2.this, Q3.class);
            startActivity(intent2);
        }
        else{
            textView2 = findViewById(R.id.txWrong2);
            String str = "Wrong answer, try again";
            textView2.setText(str);
        }

    }
}