package com.example.t1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.t1.apresentador.MainActivityApresentador;
import com.example.t1.viewInterface.VisaoCadastro;
import com.example.t1.viewInterface.VisaoMain;

public class MainActivity extends AppCompatActivity  implements VisaoMain {

    private MainActivityApresentador apresentador = new MainActivityApresentador(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText email = findViewById(R.id.etLogin);
        EditText senha = findViewById(R.id.etSenha);
        Button botaoEntrar = findViewById(R.id.btnEntrar);
        TextView txtCadastro = findViewById(R.id.txtCadastro);
        botaoEntrar.setOnClickListener(view -> apresentador.onVerifyUser(email.getText().toString(), senha.getText().toString()));
        txtCadastro.setOnClickListener(view -> apresentador.onNavToSingUp());
    }

    public void onNavToActivity(Class classe){
        Intent intent = new Intent(this, classe);
        this.startActivity(intent);
    }

    @Override
    public void onShowToast(String mesage) {
        Toast.makeText(this, mesage, Toast.LENGTH_SHORT).show();
    }
}