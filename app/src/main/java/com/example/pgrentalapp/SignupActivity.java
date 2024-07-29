package com.example.pgrentalapp;

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

public class SignupActivity extends AppCompatActivity {

    EditText name,contact,email,password,confirmpassword;
    Button submit;
    TextView already;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        name =findViewById(R.id.signup_name);
        contact =findViewById(R.id.signup_contact);
        email =findViewById(R.id.signup_email);
        password =findViewById(R.id.signup_password);
        confirmpassword =findViewById(R.id.signup_confirmpassword);
        submit =findViewById(R.id.signup_signup);
        already =findViewById(R.id.signup_already);

        already.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().trim().equals("")){
                    name.setError("Name Required");
                }
                else if(contact.getText().toString().trim().equals("")){
                    contact.setError("Contact Required");
                }
                else if (contact.getText().toString().trim().length()<10){
                   contact.setError("Valid Contact Reqired");
                }
                else if (email.getText().toString().trim().equals("")) {
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
                    Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }

            }
            });

    }
}