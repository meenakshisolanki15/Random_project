package com.example.random_project;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;
import java.util.UUID;

public class teacher_attendence extends AppCompatActivity {

    private AttendanceManager attendanceManager;
    private TextView keyDisplay;
    private TextView attendanceDisplay;

    private Button logoutButton;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_teacher_attendence);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        attendanceManager = AttendanceManager.getInstance();
        keyDisplay = findViewById(R.id.keyDisplay);

        logoutButton = findViewById(R.id.logoutButton);

        // Generate the key when activity starts
        attendanceManager.generateAndSetKey();

        // Display the generated key
        keyDisplay.setText(attendanceManager.getCurrentKey());


        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(teacher_attendence.this, User_Choice.class));
                finish();
            }
        });

        attendanceDisplay = findViewById(R.id.attendanceDisplay);

        displayAttendance();
    }

    private void displayAttendance() {
        StringBuilder attendanceResult = new StringBuilder();
        for (String student : attendanceManager.getStudents()) {
            attendanceResult.append(student)
                    .append(": ")
                    .append(attendanceManager.isPresent(student) ? "Present" : "Absent")
                    .append("\n");
        }
        attendanceDisplay.setText(attendanceResult.toString());
    }

}