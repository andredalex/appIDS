package com.example.ecodriving;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;
    private TextView tvRegisterLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inizializza i componenti
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvRegisterLink = findViewById(R.id.tvRegisterLink);

        // Aggiungi listener per il pulsante di login
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });

        // Testo da rendere cliccabile
        String text = "Non hai un account? Registrati";

        // Crea uno SpannableString con il testo
        SpannableString spannableString = new SpannableString(text);

        // Definisci il ClickableSpan per "Registrati"
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Avvia la RegistrationActivity quando cliccato
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        };

        // Imposta il ClickableSpan sulla parola "Registrati"
        spannableString.setSpan(clickableSpan, 20, 30, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Imposta lo SpannableString sul TextView
        tvRegisterLink.setText(spannableString);

        // Rende il link cliccabile
        tvRegisterLink.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void loginUser() {
        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            etEmail.setError("Inserisci la tua email");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPassword.setError("Inserisci la tua password");
            return;
        }

        // Logica di autenticazione (per ora simulata con un Toast)
        Toast.makeText(LoginActivity.this, "Login avvenuto con successo", Toast.LENGTH_SHORT).show();
    }
}
