package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CadastradoTemDeTudo extends AppCompatActivity {
    TextView welcome, redirectMenu;
    Button cadastrarOutraPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cadastrado_tem_de_tudo);
        welcome = findViewById(R.id.boasvindas);
        redirectMenu = findViewById(R.id.redirectMenu);
        cadastrarOutraPessoa = findViewById(R.id.cadastrarOutraPessoa);
        String nome = getIntent().getStringExtra("nome");

        welcome.setText("Bem vindo ao Tem de tudo, " + nome + "!");

        cadastrarOutraPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (CadastradoTemDeTudo.this, MenuTemDeTudo.class);
                startActivity(intent);
            }
        });

        redirectMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (CadastradoTemDeTudo.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}