package com.example.easytl;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;
    private EditText u_email;
    private EditText u_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    //User is signed in
                    Intent intent = new Intent(LoginActivity.this, LogedIn.class);
                    startActivity(intent);
                } else {
                    //User is signed out

                }
            }
        };
        u_email = (EditText) findViewById(R.id.email_input_reg);
        u_pass = (EditText) findViewById(R.id.pass_input_reg);
        findViewById(R.id.enter_but).setOnClickListener(this);
        /*FirebaseUser user = mAuth.getCurrentUser();
        if(user != null) {
            Intent intent = new Intent(LoginActivity.this, LogedIn.class);
            startActivity(intent);
        }*/
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.enter_but) {
            signIn(u_email.getText().toString(), u_pass.getText().toString());
        }
    }

    public void signIn(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginActivity.this, "Ты авторизовался, дружище!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Упс, что-то не так :(", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void backBut(View view) {
        Intent intent = new Intent(LoginActivity.this, EasyTL.class);
        startActivity(intent);
    }
}
