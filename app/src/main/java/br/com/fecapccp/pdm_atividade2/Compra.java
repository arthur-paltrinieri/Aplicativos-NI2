package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Compra extends AppCompatActivity {
    CheckBox op1, op2, op3, op4, op5;
    Button calcular;
    TextView resultado, redirectMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_compra);
        op1 = findViewById(R.id.op1);
        op2 = findViewById(R.id.op2);
        op3 = findViewById(R.id.op3);
        op4 = findViewById(R.id.op4);
        op5 = findViewById(R.id.op5);
        calcular = findViewById(R.id.calcular);
        resultado = findViewById(R.id.resultado);
        redirectMenu = findViewById(R.id.redirectMenu);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float total = 0.0f;

                if (op1.isChecked()) total += 2.69f;
                if (op2.isChecked()) total += 2.70f;
                if (op3.isChecked()) total += 16.70f;
                if (op4.isChecked()) total += 3.38f;
                if (op5.isChecked()) total += 3.0f;

                resultado.setText("Total: R$ " + total);
            }
        });


        redirectMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Compra.this, MainActivity.class);
                startActivity(intent);
            }
        });


        }
    }
