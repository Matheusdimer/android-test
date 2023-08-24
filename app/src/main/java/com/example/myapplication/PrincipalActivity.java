package com.example.myapplication;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class PrincipalActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        Button buttonCores = findViewById(R.id.buttonCores);
        buttonCores.setOnClickListener(this::irParaCores);
    }

    private void irParaCores(View view) {
        startActivity(new Intent(this, CoresActivity.class));
    }
}