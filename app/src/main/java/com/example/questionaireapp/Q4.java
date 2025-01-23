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

public class Q4 extends AppCompatActivity {

    EditText answer4;

    TextView textView4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_q4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    public void q2Question(View view){
        final String answer = "Unknown";

        answer4 = findViewById(R.id.edTxAnswer2);
        String kyleAnswer = answer4.getText().toString().trim();

        if(kyleAnswer.equalsIgnoreCase(answer)){
            Intent intent4 = new Intent(Q4.this, Q5.class);
            startActivity(intent4);
        }
        else{
            textView4 = findViewById(R.id.txWrong4);
            String str = "Wrong answer, try again";
            textView4.setText(str);
        }

    }
}