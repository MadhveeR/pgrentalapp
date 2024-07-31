package com.example.pgrentalapp;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignupActivity extends AppCompatActivity {

    EditText name,contact,email,password,confirmpassword;
    Button submit;
    TextView already;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        db = openOrCreateDatabase("AndroidPgRentalApp.db", MODE_PRIVATE, null);
        String tableQuery = "CREATE TABLE IF NOT EXISTS USERS(USERID  INTEGER PRIMARY KEY AUTOINCREMENT ,NAME VARCHAR(100),EMAIL VARCHAR(50),CONTACT BIGINT(10),PASSWORD VARCHAR(20))";
        db.execSQL(tableQuery);


        name = findViewById(R.id.signup_names);
        contact = findViewById(R.id.signup_contacts);
        email = findViewById(R.id.signup_emails);
        password = findViewById(R.id.signup_passwords);
        confirmpassword = findViewById(R.id.signup_confirmpasswords);
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
                    String insertQuery = "TNSERT TNTO USERS VALUES(NULL,'" + name.getText().toString() + "','" + email.getText().toString() + "','" + contact.getText().toString() + "','" + password.getText().toString() + "')";
                    db.execSQL(insertQuery);
                    Toast.makeText(SignupActivity.this, "Signup Successfully", Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }

            }
            });

    }
}