package br.com.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        Button btnSair = (Button) findViewById(R.id.btnSair);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText edtUsuario = (EditText) findViewById(R.id.edtUsuario);
                System.out.println(edtUsuario.getText());
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
    }

}