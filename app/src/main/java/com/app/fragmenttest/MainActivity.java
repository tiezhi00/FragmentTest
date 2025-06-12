package com.app.fragmenttest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.app.fragmenttest.datapass.FragementPassBetweenActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_jump_to_fragment).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DynamicFragemnetActivity.class);
            startActivity(intent);
        });
        findViewById(R.id.btn_jump_to_fragment_pass_between).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FragementPassBetweenActivity.class);
            startActivity(intent);
        });
    }
}