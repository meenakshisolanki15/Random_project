package com.example.random_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private AttendanceManager attendanceManager;
    private EditText keyInput;
    private Button submitButton;
    private Handler handler;
    private Runnable runnable;
    private Button logoutButton;
    private boolean isInForeground;
    private long startTime;
    private static final long RESTRICT_TIME = 2 * 60 * 1000; // 3 minutes in milliseconds
    @SuppressLint({"MissingSuperCall", "MissingInflatedId"})
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

        attendanceManager = AttendanceManager.getInstance(); // This should be the same instance or data
        keyInput = findViewById(R.id.keyInput);
        submitButton = findViewById(R.id.submitButton);

        logoutButton = findViewById(R.id.logoutButton);

        Intent intent = getIntent();
        String studentName = intent.getStringExtra("STUDENT_NAME");

        handler = new Handler();
        isInForeground = true;

        runnable = new Runnable() {
            @Override
            public void run() {
                if (!isInForeground && (System.currentTimeMillis() - startTime) < RESTRICT_TIME) {
                    // Notify user that they can't switch tabs or close the app
                    Toast.makeText(MainActivity.this, "Please do not switch tabs or close the app", Toast.LENGTH_LONG).show();
                }
            }
        };

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputKey = keyInput.getText().toString().trim();
                if (attendanceManager.checkKeyAndMarkAttendance(studentName, inputKey)) {
                    Toast.makeText(MainActivity.this, studentName + " Attendance marked successfully!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Incorrect key. Attendance not marked.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, User_Choice.class));
                finish();
            }
        });
    }

    protected void onPause() {
        super.onPause();
        isInForeground = false;
        startTime = System.currentTimeMillis();
        handler.postDelayed(runnable, 1000); // Check every second
    }

    @Override
    protected void onResume() {
        super.onResume();
        isInForeground = true;
        handler.removeCallbacks(runnable);
    }
}