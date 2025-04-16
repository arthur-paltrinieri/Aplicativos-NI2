package br.com.fecapccp.pdm_atividade2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PedidoLancheRapido extends AppCompatActivity {

    EditText editTextNome;
    CheckBox meat, chicken, bacon, veggie, fries, nuggets, salad, water, cola;
    Button confirmarPedido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedido_lanche_rapido);

        // Inicializa os componentes
        editTextNome = findViewById(R.id.editTextNome);
        confirmarPedido = findViewById(R.id.confirmarPedido);

        meat = findViewById(R.id.meat);
        chicken = findViewById(R.id.chicken);
        bacon = findViewById(R.id.bacon);
        veggie = findViewById(R.id.veggie);
        fries = findViewById(R.id.fries);
        nuggets = findViewById(R.id.nuggets);
        salad = findViewById(R.id.salad);
        water = findViewById(R.id.water);
        cola = findViewById(R.id.cola);

        // Configura o listener do botão
        confirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                StringBuilder pedidos = new StringBuilder();

                // Verifica quais checkboxes estão marcados
                if (meat.isChecked()) pedidos.append("X-Burger, ");
                if (chicken.isChecked()) pedidos.append("X-Chicken, ");
                if (bacon.isChecked()) pedidos.append("X-Bacon, ");
                if (veggie.isChecked()) pedidos.append("X-Veggie, ");
                if (fries.isChecked()) pedidos.append("Fritas, ");
                if (nuggets.isChecked()) pedidos.append("Nuggets, ");
                if (salad.isChecked()) pedidos.append("Salada, ");
                if (water.isChecked()) pedidos.append("Água, ");
                if (cola.isChecked()) pedidos.append("Coca Cola, ");

                // Remove a vírgula final se houver pedidos
                if (pedidos.length() > 0) {
                    pedidos.setLength(pedidos.length() - 2);
                }

                // Cria e inicia a próxima activity
                Intent intent = new Intent(PedidoLancheRapido.this, ResumoPedidoLancheRapido.class);
                intent.putExtra("nomeUsuario", nome);
                intent.putExtra("pedidosSelecionados", pedidos.toString());
                startActivity(intent);
            }
        });
    }
}