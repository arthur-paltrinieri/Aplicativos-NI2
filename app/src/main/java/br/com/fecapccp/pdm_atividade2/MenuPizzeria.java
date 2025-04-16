package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MenuPizzeria extends AppCompatActivity {

    private RadioGroup pizzaGroup;
    private Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_pizzeria);

        pizzaGroup = findViewById(R.id.radioGroupPizzas);
        btnContinuar = findViewById(R.id.button);

        btnContinuar.setOnClickListener(v -> {
            int selectedId = pizzaGroup.getCheckedRadioButtonId();

            if(selectedId == -1) {
                Toast.makeText(this, "Selecione um sabor de pizza", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton selected = findViewById(selectedId);
            String pizzaSelecionada = selected.getText().toString();

            Intent intent = new Intent(this, propriedades_pizzeria.class);
            intent.putExtra("pizzaSelecionada", pizzaSelecionada);
            startActivity(intent);
        });
    }
}