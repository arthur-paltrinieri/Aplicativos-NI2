package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Button Q1, Q2, Q3, Q4, Q5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Q1 = findViewById(R.id.Q1);
        Q2 = findViewById(R.id.Q2);
        Q3 = findViewById(R.id.Q3);
        Q4 = findViewById(R.id.Q4);
        Q5 = findViewById(R.id.Q5);

        Q1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Compra.class);
                startActivity(intent);
            }
        });

        Q2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Salario.class);
                startActivity(intent);
            }
        });

        Q3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuTemDeTudo.class);
                startActivity(intent);
            }
        });

        Q4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuLancheRapido.class);
                startActivity(intent);
            }
        });

        Q5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MenuPizzeria.class);
                startActivity(intent);
            }
        });
    }
}