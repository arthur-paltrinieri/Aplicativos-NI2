package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ResumoPedidoPizzeria extends AppCompatActivity {

    TextView tipoPizzaResumo, tamanhoResumo, metodoPagamentoResumo, valorTotalResumo;
    Button confirmarPagamento, redirectMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pedido_pizzeria);

        // Inicializa todos os componentes
        tipoPizzaResumo = findViewById(R.id.tipoPizzaResumo);
        tamanhoResumo = findViewById(R.id.tamanhoResumo);
        metodoPagamentoResumo = findViewById(R.id.metodoPagamentoResumo);
        valorTotalResumo = findViewById(R.id.valorTotalResumo);
        redirectMenu = findViewById(R.id.redirectMenu); // Adicionado esta linha

        Intent intent = getIntent();
        ArrayList<String> pizzasSelecionadas = intent.getStringArrayListExtra("pizzasSelecionadas");
        String tamanho = intent.getStringExtra("tamanhoSelecionado");
        String pagamento = intent.getStringExtra("pagamentoSelecionado");
        int valorTotal = intent.getIntExtra("valorTotal", 0);

        // Monta a string de pizzas com verificação de null
        StringBuilder pizzasStr = new StringBuilder("Tipo de Pizza: ");
        if (pizzasSelecionadas != null) {
            for (int i = 0; i < pizzasSelecionadas.size(); i++) {
                pizzasStr.append(pizzasSelecionadas.get(i));
                if (i < pizzasSelecionadas.size() - 1) {
                    pizzasStr.append(", ");
                }
            }
        }

        // Exibe as informações
        tipoPizzaResumo.setText(pizzasStr.toString());
        tamanhoResumo.setText("Tamanho: " + tamanho);
        metodoPagamentoResumo.setText("Pagamento: " + pagamento);
        valorTotalResumo.setText("Valor Total: R$ " + valorTotal + ",00");

        // Listener do botão de confirmação
        confirmarPagamento.setOnClickListener(v -> {
            Toast.makeText(this, "Pedido confirmado! Seu pedido chegará em breve.", Toast.LENGTH_LONG).show();
            Intent intent1 = new Intent(this, MenuPizzeria.class);
            startActivity(intent1);
            finish();
        });

        // Listener do botão de redirecionamento
        redirectMenu.setOnClickListener(v -> {
            Intent intent2 = new Intent(ResumoPedidoPizzeria.this, MainActivity.class);
            startActivity(intent2);
            finish(); // Adicionado para limpar a pilha de atividades
        });
    }
}