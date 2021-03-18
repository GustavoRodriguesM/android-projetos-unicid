package br.gdomingos.exercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnCalcular = (Button) findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText edtNotaUm = findViewById(R.id.edtNotaUm);
                EditText edtNotaDois = findViewById(R.id.edtNotaDois);
                TextView txtMedia = findViewById(R.id.txtMedia);
                TextView txtAprovacao = findViewById(R.id.txtAprovacao);

                if(edtNotaUm.getText().toString().isEmpty() || edtNotaDois.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Digite as duas notas", Toast.LENGTH_LONG).show();
                    return;
                }

                try {
                    Double media = calcularMedia(Double.parseDouble(edtNotaUm.getText().toString()), Double.parseDouble(edtNotaDois.getText().toString()));

                    txtMedia.setText("Média: ".concat(media.toString()));
                    if (verificaAprovacao(media)) {
                        txtAprovacao.setTextColor(Color.GREEN);
                        txtAprovacao.setText("Aprovado!");
                    } else {
                        txtAprovacao.setTextColor(Color.RED);
                        txtAprovacao.setText("Reprovado!");
                    }
                }catch(NumberFormatException e ) {
                    txtAprovacao.setText("Erro ao converter notas");
                    txtAprovacao.setTextColor(Color.MAGENTA);
                }catch(Exception e ) {
                    txtAprovacao.setText("Erro geral no aplicativo");
                    txtAprovacao.setTextColor(Color.MAGENTA);
                }
            }
        });
    }

    private boolean verificaAprovacao(Double media) {
        return media >= 6;
    }

    private Double calcularMedia(Double nota1, Double nota2) {
        return (nota1 + nota2) / 2;
    }
}