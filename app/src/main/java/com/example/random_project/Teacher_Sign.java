package com.example.random_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.random_project.databinding.ActivityTeacherSignBinding;

public class Teacher_Sign extends AppCompatActivity {

    ActivityTeacherSignBinding binding;
    DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeacherSignBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);
        binding.signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = binding.signupEmail.getText().toString();
                String password = binding.signupPassword.getText().toString();
                String confirmPassword  = binding.signupConfirm.getText().toString();

                if(email.equals("")|| password.equals("")||confirmPassword.equals(""))
                    Toast.makeText(Teacher_Sign.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();

                else
                {
                    if(password.equals(confirmPassword)){
                        Boolean checkUserEmail = databaseHelper.emailcheck(email);

                        if(checkUserEmail == false){
                            Boolean insert = databaseHelper.insertData(email, password);

                            if(insert == true) {
                                Toast.makeText(Teacher_Sign.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), Teacher_Login.class);
                                startActivity(intent);
                            } else{
                                Toast.makeText(Teacher_Sign.this, "Signup failed", Toast.LENGTH_SHORT).show();
                            }

                        } else{
                            Toast.makeText(Teacher_Sign.this, "User already exists, please login", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(Teacher_Sign.this, "Invalid Password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        binding.loginRedirectText.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),Teacher_Login.class);
                startActivity(intent);
            }
        });
    }

}