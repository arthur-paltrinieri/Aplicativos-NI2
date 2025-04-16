package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Salario extends AppCompatActivity {

    EditText wage ;
    Button calcular;
    TextView resultado, redirectMenu;
    RadioButton fourty, fourtyfive, fifty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_salario);

        wage = findViewById(R.id.editTextWage);
        calcular = findViewById(R.id.calcular);
        resultado = findViewById(R.id.resultado);
        redirectMenu = findViewById(R.id.redirectMenu);
        fourty = findViewById(R.id.fourty);
        fourtyfive = findViewById(R.id.fourtyfive);
        fifty = findViewById(R.id.fifty);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String wageText = wage.getText().toString();
                float currentWage = Float.parseFloat(wageText);
                float percent = 0f;

                if(!wageText.isEmpty()) {

                    if (fourty.isChecked()) {
                        percent = 0.4f;
                    } else if (fourtyfive.isChecked()) {
                        percent = 0.45f;
                    } else if (fifty.isChecked()) {
                        percent = 0.50f;
                    }
                    float newWage = currentWage + currentWage*percent;
                    resultado.setText("O seu novo salário será de: " + newWage + " R$");
                }
            }
        });
        redirectMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Salario.this, MainActivity.class);
                startActivity(intent);
            }
        });
        }
    }
