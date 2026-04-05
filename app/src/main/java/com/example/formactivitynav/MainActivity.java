package com.example.formactivitynav; // ← remplace par ton package

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Déclaration des champs de saisie
    private EditText etNom, etEmail, etPhone, etAdresse, etVille;
    private Button btnValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // lie le XML

        // Liaison avec les vues XML via leurs IDs
        etNom     = findViewById(R.id.etNom);
        etEmail   = findViewById(R.id.etEmail);
        etPhone   = findViewById(R.id.etPhone);
        etAdresse = findViewById(R.id.etAdresse);
        etVille   = findViewById(R.id.etVille);
        btnValider = findViewById(R.id.btnValider);

        // Clic sur le bouton Valider
        btnValider.setOnClickListener(v -> {

            // Lecture + suppression des espaces (trim)
            String sNom     = etNom.getText().toString().trim();
            String sEmail   = etEmail.getText().toString().trim();
            String sPhone   = etPhone.getText().toString().trim();
            String sAdresse = etAdresse.getText().toString().trim();
            String sVille   = etVille.getText().toString().trim();

            // --- VALIDATIONS ---

            // 1) Champ Nom obligatoire
            if (sNom.isEmpty()) {
                etNom.setError("Le nom est obligatoire");
                etNom.requestFocus();
                return;
            }

            // 2) Champ Email obligatoire + format valide (BONUS)
            if (sEmail.isEmpty()) {
                etEmail.setError("L'email est obligatoire");
                etEmail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(sEmail).matches()) {
                etEmail.setError("Format d'email invalide");
                etEmail.requestFocus();
                return;
            }

            // --- INTENT EXPLICITE vers SummaryActivity ---
            Intent intent = new Intent(MainActivity.this, SummaryActivity.class);

            // Envoi des données par putExtra (clé → valeur)
            intent.putExtra("CLE_NOM",     sNom);
            intent.putExtra("CLE_EMAIL",   sEmail);
            intent.putExtra("CLE_PHONE",   sPhone);
            intent.putExtra("CLE_ADRESSE", sAdresse);
            intent.putExtra("CLE_VILLE",   sVille);

            startActivity(intent);
        });
    }

    // BONUS : vider les champs quand on revient sur cet écran
    @Override
    protected void onResume() {
        super.onResume();
        etNom.setText("");
        etEmail.setText("");
        etPhone.setText("");
        etAdresse.setText("");
        etVille.setText("");
    }
}