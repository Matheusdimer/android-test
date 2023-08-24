package com.example.myapplication;

import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText userEditText;
    private EditText senhaEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.loginButton);
        button.setOnClickListener(this::login);
        userEditText = findViewById(R.id.usuario);
        senhaEditText = findViewById(R.id.senha);

    }
    public void login(View view) {
        String usuario = userEditText.getText().toString();
        String senha = senhaEditText.getText().toString();

        if (true) {
            startActivity(new Intent(MainActivity.this, PrincipalActivity.class));
        } else {
            Toast.makeText(this, "Usuário ou senha inválidos!", Toast.LENGTH_SHORT).show();
        }
    }
}