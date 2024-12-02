package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class NomeJogadoresActivity extends AppCompatActivity {

    private EditText edt_nomeJogador1, edt_nomeJogador2;
    private Button btn_confirmarNomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nome_jogadores);

        edt_nomeJogador1 = findViewById(R.id.edt_nome_jogador1);
        edt_nomeJogador2 = findViewById(R.id.edt_nome_jogador2);
        btn_confirmarNomes = findViewById(R.id.btn_confirmar_nomes);

        btn_confirmarNomes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nomeJogador1 = edt_nomeJogador1.getText().toString().trim();
                String nomeJogador2 = edt_nomeJogador2.getText().toString().trim();

                if (nomeJogador1.isEmpty() || nomeJogador2.isEmpty()) {
                    // Caso algum nome não tenha sido preenchido
                    Toast.makeText(NomeJogadoresActivity.this, "Por favor, preencha os dois nomes", Toast.LENGTH_SHORT).show();
                } else {
                    // Passa os nomes dos jogadores para a MainActivity
                    Intent intent = new Intent(NomeJogadoresActivity.this, MainActivity.class);
                    intent.putExtra("nomeJogador1", nomeJogador1);
                    intent.putExtra("nomeJogador2", nomeJogador2);
                    startActivity(intent);
                    finish(); // Finaliza a tela de seleção de nomes
                }
            }
        });
    }
}
