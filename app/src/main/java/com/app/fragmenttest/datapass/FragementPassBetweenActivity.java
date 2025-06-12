package com.app.fragmenttest.datapass;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.app.fragmenttest.R;

public class FragementPassBetweenActivity extends AppCompatActivity {
    private FragmentPassA fragmentPassA;
    private FragmentPassB fragmentPassB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fragement_pass_between);
        fragmentPassA = new FragmentPassA();
        fragmentPassB = new FragmentPassB();


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fcv_a, fragmentPassA)
                .commit();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fcv_b, fragmentPassB)
                .commit();
    }

    public FragmentPassA getFragmentPassA() {
        return fragmentPassA;
    }

    public FragmentPassB getFragmentPassB() {
        return fragmentPassB;
    }
}