package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CadastrarTemDeTudo extends AppCompatActivity {
    EditText name, surname, email;
    Button cadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrar_tem_de_tudo);
        name = findViewById(R.id.editTextName);
        surname = findViewById(R.id.editTextSurame);
        email = findViewById(R.id.editEmail);
        cadastrar = findViewById(R.id.cadastrar);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = name.getText().toString();
                String sobrenome = surname.getText().toString();
                String emailText = email.getText().toString(); // Corrigido: antes estava pegando o sobrenome duas vezes

                Intent intent = new Intent(CadastrarTemDeTudo.this, CadastradoTemDeTudo.class);
                intent.putExtra("nome", nome);
                intent.putExtra("sobrenome", sobrenome);
                intent.putExtra("email", emailText);
                startActivity(intent);
            }
        });

    }
}