package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ResumoPedidoPizzeria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pedido_pizzeria);

        TextView tipoPizza = findViewById(R.id.tipoPizzaResumo);
        TextView tamanho = findViewById(R.id.tamanhoResumo);
        TextView pagamento = findViewById(R.id.metodoPagamentoResumo);
        TextView valorTotal = findViewById(R.id.valorTotalResumo);
        Button btnContinuar = findViewById(R.id.btnContinuar);

        Intent intent = getIntent();
        String pizza = intent.getStringExtra("pizzaSelecionada");
        String tamanhoSelecionado = intent.getStringExtra("tamanhoSelecionado");
        String pagamentoSelecionado = intent.getStringExtra("pagamentoSelecionado");
        int total = intent.getIntExtra("valorTotal", 0);

        tipoPizza.setText("Tipo de Pizza: " + pizza);
        tamanho.setText("Tamanho: " + tamanhoSelecionado);
        pagamento.setText("Pagamento: " + pagamentoSelecionado);
        valorTotal.setText("Valor Total: R$ " + total + ",00");

        btnContinuar.setOnClickListener(v -> {
            Toast.makeText(this, "Pedido confirmado!", Toast.LENGTH_SHORT).show();
            finish();
        });
    }
}