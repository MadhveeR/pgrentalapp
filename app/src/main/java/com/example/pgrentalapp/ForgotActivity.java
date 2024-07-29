package com.example.pgrentalapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class ForgotActivity extends AppCompatActivity {

    EditText email,password,confirmpassword;
    Button submit;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot);
        
        email =findViewById(R.id.forgot_email);
        password =findViewById(R.id.forgot_password);
        confirmpassword =findViewById(R.id.forgot_confirmpassword);
        submit =findViewById(R.id.forgot_submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (email.getText().toString().trim().equals("")) {
                    email.setError("Email Id Required");
                }
                else if (!email.getText().toString().trim().matches(emailPattern)) {
                    email.setError("Valid Email Required");
                }
                else if (password.getText().toString().trim().equals("")) {
                    password.setError("Password Required");
                }
                else if (password.getText().toString().trim().length()<6) {
                    password.setError("Min.6 Char Password Required");
                }
                else if (confirmpassword.getText().toString().trim().equals("")) {
                    confirmpassword.setError("ConfinePassword Required");
                }
                else if (confirmpassword.getText().toString().trim().length()<6) {
                    confirmpassword.setError("Min.6 Char Password Required");
                }
                else if (!password.getText().toString().trim().matches(confirmpassword.getText().toString().trim())) {
                    confirmpassword.setError("Password Does Not Match");
                }
                else{
                    Toast.makeText(ForgotActivity.this, "Password Changed Successfully", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }

            }
        });
    }
}