package com.app.fragmenttest.datapass;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.app.fragmenttest.R;


public class FragmentPassB extends Fragment {

    private TextView tv_content;
    private Button btn_pass;
    private String content;
    public void setContent(String content) {
        this.content = content;
        tv_content.setText(content);
    }

    public FragmentPassB() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_pass_b, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_content = view.findViewById(R.id.tv_content_b);
        btn_pass = view.findViewById(R.id.btn_pass_b);
        btn_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //向 FragmentPassA 传递数据
                FragmentPassA fragmentPassA = ((FragementPassBetweenActivity)getActivity()).getFragmentPassA();
                if(fragmentPassA != null) {
                    fragmentPassA.setContent("Data from Fragment B");
                }
            }
        });
    }
}