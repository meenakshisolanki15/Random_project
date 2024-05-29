package com.example.random_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Enter_name extends AppCompatActivity {
    private EditText nameInput;
    private Button submitNameButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_enter_name);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nameInput = findViewById(R.id.nameInput);
        submitNameButton = findViewById(R.id.submitNameButton);

        submitNameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String studentName = nameInput.getText().toString();

                if (studentName.isEmpty()) {
                    Toast.makeText(Enter_name.this, "Please enter your name", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(Enter_name.this, "Button clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Enter_name.this, MainActivity.class);
                intent.putExtra("STUDENT_NAME", studentName);
                startActivity(intent);
            }
        });

    }
}