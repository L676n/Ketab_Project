package com.example.project_layanalharbi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class LogInBtn extends AppCompatActivity {

    private EditText Username, userEmail, Password;
    private FirebaseAuth mAuth;
    private FirebaseDatabase db;
    private DatabaseReference root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_btn);

        mAuth = FirebaseAuth.getInstance();
        userEmail = findViewById(R.id.editTextEmail);
        Password = findViewById(R.id.editTextPassword);
        db = FirebaseDatabase.getInstance();
    }

    public void onClickSign(View v) {

        String child = Username.getText().toString();
        root = db.getReference("Users").child(child);
        root.child("Email").setValue(userEmail.getText().toString());
        root.child("Password").setValue(Password.getText().toString());

        String UserEmail = userEmail.getText().toString().trim();
        String PAssword = Password.getText().toString().trim();

        mAuth.signInWithEmailAndPassword(UserEmail, PAssword)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this,"sign In With Email: success",Toast.LENGTH_SHORT).show();
                        FirebaseUser user = mAuth.getCurrentUser();
                        Intent intent = new Intent(this, HomePage.class);
                        startActivity(intent);
                    } else {
                        // If sign in fails, display a message to the user.
                        Toast.makeText(this, "Authentication failed.", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}