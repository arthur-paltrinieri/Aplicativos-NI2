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

public class ResumoPedidoLancheRapido extends AppCompatActivity {

    TextView textoResumo, redirectMenu;
    Button retornarMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pedido_lanche_rapido);

        textoResumo = findViewById(R.id.textoResumo);

        String nome = getIntent().getStringExtra("nomeUsuario");
        String pedidos = getIntent().getStringExtra("pedidosSelecionados");

        textoResumo.setText(nome + "Pedidos: " + pedidos);


        redirectMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPedidoLancheRapido.this, MainActivity.class);
                startActivity(intent);
            }
        });
        retornarMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResumoPedidoLancheRapido.this, MenuLancheRapido.class);
                startActivity(intent);
            }
        });
    }
}