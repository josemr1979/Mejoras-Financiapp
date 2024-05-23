package com.example.financiapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Inicio extends AppCompatActivity {
    private FirebaseAuth auth;
    private EditText loginEmail,loginPassword;
    private TextView signupRedirectText;
    private Button loginButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();


        //FirebaseApp.initializeApp(this);

        setContentView(R.layout.activity_inicio);
        auth = FirebaseAuth.getInstance();
        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        loginButton = findViewById(R.id.login_button);
        signupRedirectText = findViewById(R.id.signUpRedirectText);
        loginButton.setOnClickListener(view -> {
            String email = loginEmail.getText().toString();
            String pass = loginPassword.getText().toString();
            if(!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                if (!pass.isEmpty()) {

                    auth.signInWithEmailAndPassword(email, pass).addOnSuccessListener(authResult -> {
                        Toast.makeText(Inicio.this, "Acceso Correcto", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Inicio.this, MainActivity.class ));
                        finish();

                    }).addOnFailureListener(e -> Toast.makeText(Inicio.this, "Acceso Erróneo", Toast.LENGTH_SHORT).show());
                } else { loginPassword.setError("La contraseña no puede estar vacía");
                }
            } else if (email.isEmpty()) {
                loginEmail.setError("El email no puede estar vacío");
            } else {
                loginEmail.setError("Por favor introduce un email válido");
            }
        });
        signupRedirectText.setOnClickListener(view -> startActivity(new Intent(Inicio.this, SignUpActivity.class)));
    }
}