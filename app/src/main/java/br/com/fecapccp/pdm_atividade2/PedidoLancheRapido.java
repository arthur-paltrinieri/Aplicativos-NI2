package br.com.fecapccp.pdm_atividade2;

import android.os.Bundle;

import android.content.Intent;
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

        confirmarPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString();
                StringBuilder pedidos = new StringBuilder();

                if (meat.isChecked()) pedidos.append("X-Burger, ");
                if (chicken.isChecked()) pedidos.append("X-Chicken, ");
                if (bacon.isChecked()) pedidos.append("X-Bacon, ");
                if (veggie.isChecked()) pedidos.append("X-Veggie, ");
                if (fries.isChecked()) pedidos.append("Fritas, ");
                if (nuggets.isChecked()) pedidos.append("Nuggets, ");
                if (salad.isChecked()) pedidos.append("Salada, ");
                if (water.isChecked()) pedidos.append("Água, ");
                if (cola.isChecked()) pedidos.append("Coca Cola, ");

                // Remover vírgula final
                if (pedidos.length() > 2)
                    pedidos.setLength(pedidos.length() - 2);
            confirmarPedido.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PedidoLancheRapido.this, ResumoPedidoLancheRapido.class);
                    intent.putExtra("nomeUsuario", nome);
                    intent.putExtra("pedidosSelecionados", pedidos.toString());
                    startActivity(intent);
                }
            });
            }
        });
    }
}