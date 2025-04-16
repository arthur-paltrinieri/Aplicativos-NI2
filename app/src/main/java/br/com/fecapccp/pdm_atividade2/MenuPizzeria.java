package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MenuPizzeria extends AppCompatActivity {

    CheckBox calabresa, margherita, portuguesa, vegana, casa;
    Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pizzeria);

        // Inicialização dos componentes
        calabresa = findViewById(R.id.calabresa);
        margherita = findViewById(R.id.margherita);
        portuguesa = findViewById(R.id.portuguesa);
        vegana = findViewById(R.id.vegana);
        casa = findViewById(R.id.casa);
        btnContinuar = findViewById(R.id.button);

        btnContinuar.setOnClickListener(v -> {
            ArrayList<String> pizzas = new ArrayList<>();

            if (calabresa.isChecked()) pizzas.add("Calabresa");
            if (margherita.isChecked()) pizzas.add("Margherita");
            if (portuguesa.isChecked()) pizzas.add("Portuguesa");
            if (vegana.isChecked()) pizzas.add("Vegana");
            if (casa.isChecked()) pizzas.add("Da Casa");

            if (pizzas.isEmpty()) {
                Toast.makeText(this, "Selecione pelo menos uma pizza", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                Intent intent = new Intent(this, propriedades_pizzeria.class);
                intent.putStringArrayListExtra("pizzasSelecionadas", pizzas);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Erro ao abrir próxima tela", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }
}