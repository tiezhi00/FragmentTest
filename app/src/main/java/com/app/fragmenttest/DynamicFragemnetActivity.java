package com.app.fragmenttest;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.app.fragmenttest.fragment.ExampleFragment;

public class DynamicFragemnetActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
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
        findViewById(R.id.btn_pass_data_by_interface).setOnClickListener(v -> {
            //通过接口方式向Fragement传递数据
            if (onDataChangeListener != null) {
                onDataChangeListener.onDataChange("通过接口传递数据");
            }
        });
    }
    private OnDataChangeListener onDataChangeListener;
    public void setOnDataChangeListener(OnDataChangeListener listener) {
        this.onDataChangeListener = listener;
    }
    public interface OnDataChangeListener {
        void onDataChange(String data);
    }
}