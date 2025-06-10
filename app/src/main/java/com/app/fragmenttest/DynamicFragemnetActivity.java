package com.app.fragmenttest;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.app.fragmenttest.fragment.ExampleFragment;

public class DynamicFragemnetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_dynamic_fragemnet);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            Bundle bundle = new Bundle();
            bundle.putString(ExampleFragment.CONTENT, "动态Fragment");
            fragmentTransaction.add(R.id.fcv, ExampleFragment.class, bundle)
                    .setReorderingAllowed(true)
//                .addToBackStack(null)
                    .commit();
        }



    }
}