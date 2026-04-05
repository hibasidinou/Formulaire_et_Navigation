package com.example.formactivitynav; // ← remplace par ton package

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    private TextView tvResume;
    private Button btnBack, btnPartager;
    private String contenuResume; // pour réutiliser dans le partage

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        tvResume    = findViewById(R.id.tvResume);
        btnBack     = findViewById(R.id.btnBack);
        btnPartager = findViewById(R.id.btnPartager);

        // Récupération des données envoyées par MainActivity
        Intent intent = getIntent();
        String nom     = intent.getStringExtra("CLE_NOM");
        String email   = intent.getStringExtra("CLE_EMAIL");
        String phone   = intent.getStringExtra("CLE_PHONE");
        String adresse = intent.getStringExtra("CLE_ADRESSE");
        String ville   = intent.getStringExtra("CLE_VILLE");

        // Construction du texte récapitulatif
        contenuResume =
                "👤 Nom     : " + valeur(nom)     + "\n" +
                        "📧 Email   : " + valeur(email)   + "\n" +
                        "📞 Tél     : " + valeur(phone)   + "\n" +
                        "🏠 Adresse : " + valeur(adresse) + "\n" +
                        "🏙️ Ville   : " + valeur(ville);

        tvResume.setText(contenuResume);

        // Bouton Retour → ferme cet écran, revient au formulaire
        btnBack.setOnClickListener(v -> finish());

        // BONUS : Bouton Partager → Intent ACTION_SEND
        btnPartager.setOnClickListener(v -> {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Fiche Contact");
            shareIntent.putExtra(Intent.EXTRA_TEXT, contenuResume);
            // Ouvre le sélecteur (SMS, email, WhatsApp, etc.)
            startActivity(Intent.createChooser(shareIntent, "Partager via..."));
        });
    }

    // Si la valeur est vide ou null, afficher "—"
    private String valeur(String s) {
        return (s == null || s.trim().isEmpty()) ? "—" : s.trim();
    }
}