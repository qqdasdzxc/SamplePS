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

public class PreMainFragment extends Fragment {

    PreMainListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (PreMainListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pre_main, container, false);

        Button btnNext = view.findViewById(R.id.next_btn);
        btnNext.setOnClickListener(view1 -> listener.moveToMainScreen());

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface PreMainListener {
        void moveToMainScreen();
    }
}
