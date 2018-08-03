package com.dmitrijkuzmin.sampleps.ui.splash.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.dmitrijkuzmin.sampleps.R;

public class PreLoginFragment extends Fragment {

    PreLoginListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        listener = (PreLoginListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pre_login, container, false);

        Button btnNext = view.findViewById(R.id.btnNext);
        btnNext.setOnClickListener(view1 -> listener.moveToLoginScreen());

        return view;
    }

    public interface PreLoginListener {
        void moveToLoginScreen();
    }
}
