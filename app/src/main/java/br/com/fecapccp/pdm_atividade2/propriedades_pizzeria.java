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

    RadioGroup tamanhoGroup, pagamentoGroup;
    RadioButton pequena, media, grande, dinheiro, cartao;
    Button continuar;
    ArrayList<String> pizzasSelecionadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propriedades_pizzeria);

        // Recebe as pizzas da tela anterior
        pizzasSelecionadas = getIntent().getStringArrayListExtra("pizzasSelecionadas");

        // Inicializa os componentes
        tamanhoGroup = findViewById(R.id.radioGroupTamanho);
        pagamentoGroup = findViewById(R.id.radioGroupPagamento);
        pequena = findViewById(R.id.radioPequena);
        media = findViewById(R.id.radioMedia);
        grande = findViewById(R.id.radioGrande);
        dinheiro = findViewById(R.id.radioDinheiro);
        cartao = findViewById(R.id.radioCartao);
        continuar = findViewById(R.id.button);

        continuar.setOnClickListener(v -> {
            // Verifica o tamanho selecionado
            String tamanho = "";
            if (pequena.isChecked()) tamanho = "Pequena";
            else if (media.isChecked()) tamanho = "Média";
            else if (grande.isChecked()) tamanho = "Grande";

            // Verifica o pagamento selecionado
            String pagamento = "";
            if (dinheiro.isChecked()) pagamento = "Dinheiro";
            else if (cartao.isChecked()) pagamento = "Cartão";

            // Verifica se tudo foi selecionado
            if (tamanho.isEmpty() || pagamento.isEmpty()) {
                Toast.makeText(this, "Selecione tamanho e forma de pagamento", Toast.LENGTH_SHORT).show();
                return;
            }

            // Calcula o valor total
            int valorTotal = calcularValorTotal(pizzasSelecionadas, tamanho);

            // Passa para a tela de resumo
            Intent intent = new Intent(propriedades_pizzeria.this, ResumoPedidoPizzeria.class);
            intent.putStringArrayListExtra("pizzasSelecionadas", pizzasSelecionadas);
            intent.putExtra("tamanhoSelecionado", tamanho);
            intent.putExtra("pagamentoSelecionado", pagamento);
            intent.putExtra("valorTotal", valorTotal);
            startActivity(intent);
        });
    }

    private int calcularValorTotal(ArrayList<String> pizzas, String tamanho) {
        int valorBase = 0;

        for (String pizza : pizzas) {
            switch (pizza) {
                case "Margherita": valorBase += 62; break;
                case "Calabresa": valorBase += 49; break;
                case "Vegana": valorBase += 53; break;
                case "Portuguesa": valorBase += 58; break;
                case "Da Casa": valorBase += 62; break;
            }
        }

        if (tamanho.equals("Pequena")) return valorBase + 0; // pequena - sem adicional
        else if (tamanho.equals("Média")) return valorBase + 15; // média + R$15
        else return valorBase + 30; // grande + R$30
    }
}