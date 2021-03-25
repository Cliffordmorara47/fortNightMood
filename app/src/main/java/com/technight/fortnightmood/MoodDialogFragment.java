package com.technight.fortnightmood;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.fragment.app.DialogFragment;

import java.util.Objects;

import butterknife.ButterKnife;

public class MoodDialogFragment extends DialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_mood_dialog, container, false);
        Objects.requireNonNull(getDialog()).setTitle("Simple Dialog");

        RadioGroup surveyRadioGroup = (RadioGroup) rootView.findViewById(R.id.moodRadioGroup); // Pull Group
        int selectedId = surveyRadioGroup.getCheckedRadioButtonId();  // Get Selected ID
        final RadioButton selectedRadioButton = (RadioButton) rootView.findViewById(selectedId); // get r button val via ID

        Button cancelButton = (Button) rootView.findViewById(R.id.cancelButton);
        Button submitButton = (Button) rootView.findViewById(R.id.submitButton);

        cancelButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("Testing", selectedRadioButton.getText().toString());
                dismiss();
            }
        });
        return rootView;
    }
}
