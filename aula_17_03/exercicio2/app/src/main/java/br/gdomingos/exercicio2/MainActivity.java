package br.gdomingos.exercicio2;

import androidx.appcompat.app.AppCompatActivity;

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

        Button btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText edtPrecoAlcool = findViewById(R.id.edtPrecoAlcool);
                EditText edtPrecoGasolina = findViewById(R.id.edtPrecoGasolina);
                EditText edtKmLitroAlcool = findViewById(R.id.edtKmLitroAlcool);
                EditText edtKmLitroGasolina = findViewById(R.id.edtKmLitroGasolina);
                TextView txtMelhorOpcao = findViewById(R.id.txtMelhorOpcao);

                try {
                    Double precoAlcool = Double.parseDouble(edtPrecoAlcool.getText().toString());

                    Double mediaPonderadaGasolina = calculaMediaPonderadaGasolina(Double.parseDouble(edtKmLitroAlcool.getText().toString()),
                                                                                  Double.parseDouble(edtKmLitroGasolina.getText().toString()),
                                                                                  Double.parseDouble(edtPrecoGasolina.getText().toString()));

                    if(mediaPonderadaGasolina > precoAlcool) {
                        txtMelhorOpcao.setText("ALCOOL. Valor: ".concat("R$").concat(precoAlcool.toString()));
                        txtMelhorOpcao.setTextColor(Color.GREEN);
                    }else if(mediaPonderadaGasolina < precoAlcool) {
                        txtMelhorOpcao.setText("GASOLINA. Valor: ".concat("R$").concat(mediaPonderadaGasolina.toString()));
                        txtMelhorOpcao.setTextColor(Color.YELLOW);
                    }else {
                        txtMelhorOpcao.setText("TANTO FAZ!");
                        txtMelhorOpcao.setTextColor(Color.RED);
                    }

                }catch(NumberFormatException e) {
                    txtMelhorOpcao.setText("");
                    Toast.makeText(MainActivity.this, "Erro ao converter numeros, digite novamente.", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        });


    }

    public Double calculaMediaPonderadaGasolina(Double kmLitroAlcool, Double kmPorLitroGasolina, Double precoGasolina) {
        return (kmLitroAlcool / kmPorLitroGasolina) * precoGasolina;
    }


}