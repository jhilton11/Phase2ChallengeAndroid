package com.appify.phase2challenge_android;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
    private Button saveButton;
    private EditText nameTv, emailTv, passwordTv;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        getSupportActionBar().setTitle("Sign up");

        nameTv = findViewById(R.id.name_tv);
        emailTv = findViewById(R.id.email_tv);
        passwordTv = findViewById(R.id.password_tv);

        saveButton = findViewById(R.id.save_button);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 saveUser();
            }
        });
    }

    private void saveUser() {
        mAuth.createUserWithEmailAndPassword(nameTv.getText().toString(), passwordTv.getText().toString())
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(SignUpActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
