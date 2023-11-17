package com.example.project_layanalharbi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class SignUpBtn extends AppCompatActivity{
    private EditText Username, Firstname, userEmail, Lastname, Password, ConfPassword;
    private FirebaseAuth mAuth;
    userInfo userInfo;
    private FirebaseDatabase db;
    private DatabaseReference root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_btn);
        mAuth = FirebaseAuth.getInstance();
        Username = (EditText) findViewById(R.id.editTextUserName);
        Firstname = (EditText) findViewById(R.id.editTextFirstName);
        Lastname = (EditText) findViewById(R.id.editTextLastName);
        userEmail = (EditText) findViewById(R.id.editTextEmail);
        Password = (EditText) findViewById(R.id.editTextPassword);
        ConfPassword = (EditText) findViewById(R.id.editTextConPassword);
        db = FirebaseDatabase.getInstance();
    }

    public void SendDataBtn(View v) {
        String child = Username.getText().toString();
        root = db.getReference("Users").child(child);
        root.child("User Name").setValue(Username.getText().toString());
        root.child("First Name").setValue(Firstname.getText().toString());
        root.child("Last Name").setValue(Lastname.getText().toString());
        root.child("Email").setValue(userEmail.getText().toString());
        root.child("Password").setValue(Password.getText().toString());
        root.child("Confirm Password").setValue(ConfPassword.getText().toString());

        String UserEmail = userEmail.getText().toString().trim();
        String PAssword = Password.getText().toString().trim();

        mAuth.createUserWithEmailAndPassword(UserEmail, PAssword)
                .addOnCompleteListener(task -> {
                    if(task.isSuccessful()){
                        userInfo user = new userInfo();
                        FirebaseDatabase.getInstance().getReference("Users")
                                .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                .setValue(user).addOnCompleteListener(task1 -> {
                                    if(task1.isSuccessful()){
                                        startActivity(new Intent(SignUpBtn.this, HomePage.class));
                                        Toast.makeText(SignUpBtn.this, "User is added successfully", Toast.LENGTH_SHORT).show();

                                    }else{
                                        Toast.makeText(this, "Failed to add the user", Toast.LENGTH_SHORT).show();

                                    }

                                });
                    }else{
                        Toast.makeText(this,"Failed to add please try again", Toast.LENGTH_SHORT).show();
                    }

                });
    }

    private void sendDatatoFirebase(String Username, String userEmail, String Firstname,
                                    String Lastname, String Password, String ConfPassword) {

        userInfo.setUserName(Username);
        userInfo.setUserEmail(userEmail);
        userInfo.setUserFName(Firstname);
        userInfo.setUserLName(Lastname);
        userInfo.setUserPassword(Password);
        userInfo.setUserConfPassword(ConfPassword);

        root.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                root.setValue(userInfo);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(SignUpBtn.this,"Failed to add please try again", Toast.LENGTH_SHORT).show();
            }
        });
    }

}













