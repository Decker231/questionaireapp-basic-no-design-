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

public class Q3 extends AppCompatActivity {

    EditText answer3;

    TextView textView3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_q3);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void q3Question(View view){
        final String answer = "Unknown";

        answer3 = findViewById(R.id.edTxAnswer2);
        String kyleAnswer = answer3.getText().toString().trim();

        if(kyleAnswer.equalsIgnoreCase(answer)){
            Intent intent3 = new Intent(Q3.this, Q4.class);
            startActivity(intent3);
        }
        else{
            textView3 = findViewById(R.id.txWrong3);
            String str = "Wrong answer, try again";
            textView3.setText(str);
        }

    }
}