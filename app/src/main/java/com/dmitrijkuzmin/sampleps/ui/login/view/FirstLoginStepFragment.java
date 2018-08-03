package com.dmitrijkuzmin.sampleps.ui.login.view;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dmitrijkuzmin.sampleps.R;

public class FirstLoginStepFragment extends Fragment {

    FirstLoginStepListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (FirstLoginStepListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_login_step, container, false);

        EditText registrationNumberEditText = view.findViewById(R.id.registration_number_et);

        Button btnNext = view.findViewById(R.id.next_btn);
        btnNext.setOnClickListener(view1 -> listener.onNextFirstStep(registrationNumberEditText.getText().toString()));

        Button btnSkip = view.findViewById(R.id.skip_btn);
        btnSkip.setOnClickListener(view1 -> listener.onSkipFirstStep());

        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface FirstLoginStepListener {
        void onNextFirstStep(String registrationNumber);
        void onSkipFirstStep();
    }
}
