package com.example.horoscope;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HoroscopeResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope_result);

        TextView horoscopeName = findViewById(R.id.horoscope_name);
        TextView horoscopeDescription = findViewById(R.id.horoscope_description);
        Button btnRetour = findViewById(R.id.btn_retour);

        // Récupérer les données passées depuis la première page
        Intent intent = getIntent();
        int month = intent.getIntExtra("month", 0);
        int day = intent.getIntExtra("day", 0);

        // Déterminer l'horoscope selon le mois et le jour
        String name = getHoroscopeName(month, day);
        String description = getHoroscopeDescription(name);

        horoscopeName.setText(name);
        horoscopeDescription.setText(description);

        // Retourner à la première page
        btnRetour.setOnClickListener(v -> finish());
    }

    private String getHoroscopeName(int month, int day) {
        if ((month == 1 && day >= 20) || (month == 2 && day <= 18)) return "Verseau";
        if ((month == 2 && day >= 19) || (month == 3 && day <= 20)) return "Poissons";
        if ((month == 3 && day >= 21) || (month == 4 && day <= 19)) return "Bélier";
        if ((month == 4 && day >= 20) || (month == 5 && day <= 20)) return "Taureau";
        if ((month == 5 && day >= 21) || (month == 6 && day <= 20)) return "Gémeaux";
        if ((month == 6 && day >= 21) || (month == 7 && day <= 22)) return "Cancer";
        if ((month == 7 && day >= 23) || (month == 8 && day <= 22)) return "Lion";
        if ((month == 8 && day >= 23) || (month == 9 && day <= 22)) return "Vierge";
        if ((month == 9 && day >= 23) || (month == 10 && day <= 22)) return "Balance";
        if ((month == 10 && day >= 23) || (month == 11 && day <= 21)) return "Scorpion";
        if ((month == 11 && day >= 22) || (month == 12 && day <= 21)) return "Sagittaire";
        if ((month == 12 && day >= 22) || (month == 1 && day <= 19)) return "Capricorne";

        return "Inconnu"; // Cas par défaut si la date ne correspond à aucun signe
    }

    private String getHoroscopeDescription(String name) {
        switch (name) {
            case "Verseau":
                return "Vous êtes indépendant, inventif et toujours prêt à aider les autres.";
            case "Poissons":
                return "Vous êtes empathique, intuitif et très imaginatif.";
            case "Bélier":
                return "Vous êtes dynamique, courageux et toujours prêt à relever des défis.";
            case "Taureau":
                return "Vous êtes patient, fiable et aimez la stabilité.";
            case "Gémeaux":
                return "Vous êtes curieux, adaptable et excellent communicant.";
            case "Cancer":
                return "Vous êtes sensible, protecteur et très attaché à votre famille.";
            case "Lion":
                return "Vous êtes confiant, généreux et toujours prêt à briller.";
            case "Vierge":
                return "Vous êtes organisé, méthodique et toujours prêt à aider.";
            case "Balance":
                return "Vous êtes charmant, équilibré et appréciez l'harmonie.";
            case "Scorpion":
                return "Vous êtes passionné, déterminé et très mystérieux.";
            case "Sagittaire":
                return "Vous êtes optimiste, aventurier et toujours en quête de nouvelles expériences.";
            case "Capricorne":
                return "Vous êtes discipliné, ambitieux et travailleur.";

            default:
                return "Pas de description disponible.";
        }
    }
}
