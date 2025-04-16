package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class propriedades_pizzeria extends AppCompatActivity {

    private RadioGroup tamanhoGroup, pagamentoGroup;
    private Button btnContinuar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_propriedades_pizzeria);

        tamanhoGroup = findViewById(R.id.radioGroupTamanho);
        pagamentoGroup = findViewById(R.id.radioGroupPagamento);
        btnContinuar = findViewById(R.id.btnContinuar);

        String pizza = getIntent().getStringExtra("pizzaSelecionada");

        btnContinuar.setOnClickListener(v -> {
            int tamanhoId = tamanhoGroup.getCheckedRadioButtonId();
            int pagamentoId = pagamentoGroup.getCheckedRadioButtonId();

            if (tamanhoId == -1 || pagamentoId == -1) {
                Toast.makeText(this, "Selecione todas as opções", Toast.LENGTH_SHORT).show();
                return;
            }

            RadioButton tamanhoBtn = findViewById(tamanhoId);
            RadioButton pagamentoBtn = findViewById(pagamentoId);

            String tamanho = tamanhoBtn.getText().toString();
            String pagamento = pagamentoBtn.getText().toString();

            int total = calcularValor(pizza, tamanho);

            Intent intent = new Intent(this, ResumoPedidoPizzeria.class);
            intent.putExtra("pizzaSelecionada", pizza);
            intent.putExtra("tamanhoSelecionado", tamanho);
            intent.putExtra("pagamentoSelecionado", pagamento);
            intent.putExtra("valorTotal", total);
            startActivity(intent);
        });
    }

    private int calcularValor(String pizza, String tamanho) {
        int valorPizza = 0;

        switch(pizza) {
            case "Margherita": valorPizza = 62; break;
            case "Calabresa": valorPizza = 49; break;
            case "Vegana": valorPizza = 53; break;
            case "Portuguesa": valorPizza = 58; break;
            case "Da Casa": valorPizza = 62; break;
        }

        int valorTamanho = 0;
        switch(tamanho) {
            case "Média": valorTamanho = 15; break;
            case "Grande": valorTamanho = 30; break;
        }

        return valorPizza + valorTamanho;
    }
}