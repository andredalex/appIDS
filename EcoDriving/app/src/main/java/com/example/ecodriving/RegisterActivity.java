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

public class RegisterActivity extends AppCompatActivity {

    private EditText etFullName, etEmailRegister, etPasswordRegister, etCarBrand, etCarModel, etFuelType;
    private Button btnRegister;
    private TextView tvLoginLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Inizializza i componenti
        etFullName = findViewById(R.id.etFullName);
        etEmailRegister = findViewById(R.id.etEmailRegister);
        etPasswordRegister = findViewById(R.id.etPasswordRegister);
        etCarBrand = findViewById(R.id.etCarBrand);
        etCarModel = findViewById(R.id.etCarModel);
        etFuelType = findViewById(R.id.etFuelType);
        btnRegister = findViewById(R.id.btnRegister);
        tvLoginLink = findViewById(R.id.tvLoginLink);

        // Aggiungi listener per il pulsante di registrazione
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });

        // Testo da rendere cliccabile
        String text = "Hai già un account? Loggati";

        // Crea uno SpannableString con il testo
        SpannableString spannableString = new SpannableString(text);

        // Definisci il ClickableSpan per "Registrati"
        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Avvia la LoginActivity quando cliccato
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        };

        // Imposta il ClickableSpan sulla parola "Registrati"
        spannableString.setSpan(clickableSpan, 20, 27, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Imposta lo SpannableString sul TextView
        tvLoginLink.setText(spannableString);

        // Rende il link cliccabile
        tvLoginLink.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void registerUser() {
        // Ottieni l'input dell'utente
        String fullName = etFullName.getText().toString().trim();
        String email = etEmailRegister.getText().toString().trim();
        String password = etPasswordRegister.getText().toString().trim();
        String carBrand = etCarBrand.getText().toString().trim();
        String carModel = etCarModel.getText().toString().trim();
        String fuelType = etFuelType.getText().toString().trim();

        // Verifica se i campi sono vuoti
        if (TextUtils.isEmpty(fullName)) {
            etFullName.setError("Inserisci il tuo nome completo");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            etEmailRegister.setError("Inserisci la tua email");
            return;
        }

        if (TextUtils.isEmpty(password)) {
            etPasswordRegister.setError("Inserisci una password");
            return;
        }

        if (TextUtils.isEmpty(carBrand)) {
            etCarBrand.setError("Inserisci la marca della tua auto");
            return;
        }

        if (TextUtils.isEmpty(carModel)) {
            etCarModel.setError("Inserisci il modello della tua auto");
            return;
        }

        if (TextUtils.isEmpty(fuelType)) {
            etFuelType.setError("Inserisci il tipo di combustibile");
            return;
        }

        // Simulazione della registrazione (puoi aggiungere logica per salvare i dati)
        Toast.makeText(RegisterActivity.this, "Registrazione completata con successo", Toast.LENGTH_SHORT).show();
    }
}
