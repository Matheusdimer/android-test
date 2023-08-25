package com.example.myapplication;

import android.content.SharedPreferences;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CoresActivity extends AppCompatActivity {

    private static final String KEY_COLOR = "COLOR";
    private LinearLayout linearLayout1;
    private LinearLayout linearLayout2;
    private LinearLayout linearLayout3;
    private LinearLayout linearLayout4;
    private LinearLayout linearLayout5;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cores);

        preferences = getPreferences(MODE_PRIVATE);

        linearLayout1 = findViewById(R.id.linearLayout1);
        linearLayout2 = findViewById(R.id.linearLayout2);
        linearLayout3 = findViewById(R.id.linearLayout3);
        linearLayout4 = findViewById(R.id.linearLayout4);
        linearLayout5 = findViewById(R.id.linearLayout5);

        linearLayout1.setOnClickListener(this::onClick);
        linearLayout2.setOnClickListener(this::onClick);
        linearLayout3.setOnClickListener(this::onClick);
        linearLayout4.setOnClickListener(this::onClick);
        linearLayout5.setOnClickListener(this::onClick);

        Button resetButton = findViewById(R.id.resetColorsButton);
        checkSavedColor();

        resetButton.setOnClickListener(this::resetColors);
    }

    private void checkSavedColor() {
        if (!preferences.contains(KEY_COLOR)) {
            return;
        }

        int color = preferences.getInt(KEY_COLOR, 0);
        setColor(linearLayout1, color);
        setColor(linearLayout2, color);
        setColor(linearLayout3, color);
        setColor(linearLayout4, color);
        setColor(linearLayout5, color);
    }

    private void setColor(LinearLayout linearLayout, int color) {
        linearLayout.setBackgroundColor(color);
    }

    private void onClick(View view) {
        int color = ((ColorDrawable) view.getBackground()).getColor();
        linearLayout1.setBackgroundColor(color);
        linearLayout2.setBackgroundColor(color);
        linearLayout3.setBackgroundColor(color);
        linearLayout4.setBackgroundColor(color);
        linearLayout5.setBackgroundColor(color);

        preferences.edit()
                .putInt(KEY_COLOR, color)
                .apply();
    }

    private void resetColors(View view) {
        linearLayout1.setBackgroundResource(R.color.black);
        linearLayout2.setBackgroundResource(R.color.red);
        linearLayout3.setBackgroundResource(R.color.yellow);
        linearLayout4.setBackgroundResource(R.color.blue);
        linearLayout5.setBackgroundResource(R.color.black);

        preferences.edit().remove(KEY_COLOR).apply();
    }
}