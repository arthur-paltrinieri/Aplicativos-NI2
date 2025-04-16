package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class propriedades_pizzeria extends AppCompatActivity {

    private RadioGroup tamanhoGroup, pagamentoGroup;
    private Button btnContinuar;
    private ArrayList<String> pizzasSelecionadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propriedades_pizzeria);

        // Verificação inicial dos dados recebidos
        if (getIntent() == null || getIntent().getStringArrayListExtra("pizzasSelecionadas") == null) {
            Toast.makeText(this, "Erro: Dados inválidos recebidos", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        // Inicialização dos componentes
        try {
            tamanhoGroup = findViewById(R.id.radioGroupTamanho);
            pagamentoGroup = findViewById(R.id.radioGroupPagamento);
            btnContinuar = findViewById(R.id.btnContinuar);

            pizzasSelecionadas = getIntent().getStringArrayListExtra("pizzasSelecionadas");

            if (pizzasSelecionadas == null || pizzasSelecionadas.isEmpty()) {
                throw new Exception("Lista de pizzas vazia");
            }
        } catch (Exception e) {
            Toast.makeText(this, "Erro ao inicializar componentes", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
            finish();
            return;
        }

        btnContinuar.setOnClickListener(v -> {
            try {
                // Verificação de seleção do tamanho
                int selectedTamanhoId = tamanhoGroup.getCheckedRadioButtonId();
                if (selectedTamanhoId == -1) {
                    Toast.makeText(this, "Selecione um tamanho", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Verificação de seleção do pagamento
                int selectedPagamentoId = pagamentoGroup.getCheckedRadioButtonId();
                if (selectedPagamentoId == -1) {
                    Toast.makeText(this, "Selecione uma forma de pagamento", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Obtenção dos valores selecionados
                RadioButton selectedTamanho = findViewById(selectedTamanhoId);
                RadioButton selectedPagamento = findViewById(selectedPagamentoId);

                if (selectedTamanho == null || selectedPagamento == null) {
                    throw new Exception("RadioButtons não encontrados");
                }

                String tamanho = selectedTamanho.getText().toString();
                String pagamento = selectedPagamento.getText().toString();

                // Cálculo do valor total
                int valorTotal = calcularValorTotal(pizzasSelecionadas, tamanho);

                // Início da próxima activity
                Intent intent = new Intent(this, ResumoPedidoPizzeria.class);
                intent.putStringArrayListExtra("pizzasSelecionadas", pizzasSelecionadas);
                intent.putExtra("tamanhoSelecionado", tamanho);
                intent.putExtra("pagamentoSelecionado", pagamento);
                intent.putExtra("valorTotal", valorTotal);
                startActivity(intent);

            } catch (Exception e) {
                Toast.makeText(this, "Erro ao processar pedido", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        });
    }

    private int calcularValorTotal(ArrayList<String> pizzas, String tamanho) {
        int valorBase = 0;

        try {
            for (String pizza : pizzas) {
                switch (pizza) {
                    case "Margherita": valorBase += 62; break;
                    case "Calabresa": valorBase += 49; break;
                    case "Vegana": valorBase += 53; break;
                    case "Portuguesa": valorBase += 58; break;
                    case "Da Casa": valorBase += 62; break;
                }
            }

            switch (tamanho) {
                case "Média": return valorBase + 15;
                case "Grande": return valorBase + 30;
                default: return valorBase; // Pequena
            }
        } catch (Exception e) {
            e.printStackTrace();
            return valorBase; // Retorna pelo menos o valor base em caso de erro
        }
    }
}