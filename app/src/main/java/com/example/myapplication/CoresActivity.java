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
    private final List<Drawable> originalsBackgrounds = new ArrayList<>();

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
        resetButton.setOnClickListener(this::resetColors);
        backupOriginalColors();
        checkSavedColor();
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
        ((ColorDrawable) linearLayout.getBackground()).setColor(color);
    }

    private void onClick(View view) {
        Drawable background = view.getBackground();
        linearLayout1.setBackground(background);
        linearLayout2.setBackground(background);
        linearLayout3.setBackground(background);
        linearLayout4.setBackground(background);
        linearLayout5.setBackground(background);

        preferences.edit()
                .putInt(KEY_COLOR, ((ColorDrawable) background).getColor())
                .apply();
    }

    private void backupOriginalColors() {
        originalsBackgrounds.add(linearLayout1.getBackground());
        originalsBackgrounds.add(linearLayout2.getBackground());
        originalsBackgrounds.add(linearLayout3.getBackground());
        originalsBackgrounds.add(linearLayout4.getBackground());
        originalsBackgrounds.add(linearLayout5.getBackground());
    }

    private void resetColors(View view) {
        linearLayout1.setBackground(originalsBackgrounds.get(0));
        linearLayout2.setBackground(originalsBackgrounds.get(1));
        linearLayout3.setBackground(originalsBackgrounds.get(2));
        linearLayout4.setBackground(originalsBackgrounds.get(3));
        linearLayout5.setBackground(originalsBackgrounds.get(4));

        preferences.edit().remove(KEY_COLOR).apply();
    }
}