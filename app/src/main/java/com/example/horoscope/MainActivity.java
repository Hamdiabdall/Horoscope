package com.example.horoscope;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText inputMonth = findViewById(R.id.input_month);
        EditText inputDay = findViewById(R.id.input_day);
        Button btnConsulter = findViewById(R.id.btn_consulter);

        btnConsulter.setOnClickListener(v -> {
            String monthStr = inputMonth.getText().toString();
            String dayStr = inputDay.getText().toString();

            if (monthStr.isEmpty() || dayStr.isEmpty()) {
                Toast.makeText(this, "Veuillez entrer une date valide", Toast.LENGTH_SHORT).show();
                return;
            }

            int month = Integer.parseInt(monthStr);
            int day = Integer.parseInt(dayStr);

            if (month < 1 || month > 12 || day < 1 || day > 31) {
                Toast.makeText(this, "Date invalide", Toast.LENGTH_SHORT).show();
                return;
            }

            // Naviguer vers la deuxième page avec les données
            Intent intent = new Intent(MainActivity.this, HoroscopeResultActivity.class);
            intent.putExtra("month", month);
            intent.putExtra("day", day);
            startActivity(intent);
        });
    }
}
