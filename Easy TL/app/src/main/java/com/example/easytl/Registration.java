package com.example.easytl;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Registration extends AppCompatActivity implements View.OnClickListener {
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText u_email;
    private EditText u_pass;
    private EditText u_name;
    private DatabaseReference myRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is signed in

                } else {
                    //User is signed out

                }
            }
        };
        u_email = (EditText) findViewById(R.id.email_input_reg);
        u_pass = (EditText) findViewById(R.id.pass_input_reg);
        u_name = (EditText) findViewById(R.id.username_input_reg);
        findViewById(R.id.reg_but_reg).setOnClickListener(this);
        myRef = FirebaseDatabase.getInstance().getReference();
       // myRef.child("Name").setValue(u_name.getText());*/

    }

    public void onClick(View view) {

        if (view.getId() == R.id.reg_but_reg) {
            registration(u_email.getText().toString(), u_pass.getText().toString());
        }
    }

    public void registration(String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(Registration.this, "Ты теперь часть команды, дружище!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Registration.this, "Упс, что-то не так :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void backBut(View view) {
        Intent intent = new Intent(Registration.this, EasyTL.class);
        startActivity(intent);
    }
}
