package com.app.fragmenttest.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.app.fragmenttest.R;


public class ExampleFragment extends Fragment {
    private TextView tv_title,tv_content;
    private RadioButton rb_like;
    private RadioButton rb_dislike;
    private RatingBar ratingBar;
    public static final String CONTENT = "content";
    private String content;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            content = getArguments().getString(CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_example, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_title = view.findViewById(R.id.tv_title);
        tv_content = view.findViewById(R.id.tv_content);
        rb_like = view.findViewById(R.id.rb_like);
        rb_dislike = view.findViewById(R.id.rb_dislike);
        rb_like.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if (isChecked) {
                        tv_title.setText("喜欢");
                    }
                }
        );
        rb_dislike.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if (isChecked) {
                        tv_title.setText("不喜欢");
                    }
                }
        );
        ratingBar = view.findViewById(R.id.ratingBar);
        ratingBar.setOnRatingBarChangeListener(
                (ratingBar, rating, fromUser) -> {
                    if (fromUser) {
                        Toast.makeText(getActivity(), "评分：" + rating, Toast.LENGTH_SHORT).show();
                    }
                }
        );
        tv_content.setText(content);

    }
}