package com.padc.travelling.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.padc.travelling.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Nyein Nyein on 9/17/2016.
 */
public class FeedbackFragment extends Fragment {

    @BindView(R.id.btn_send)
    Button btnSend;

    @BindView(R.id.et_sendsuggestion)
    EditText etSendSuggestion;

    public static FeedbackFragment newInstace(){
        FeedbackFragment feedbackFragment = new FeedbackFragment();
        return feedbackFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_feedback, container, false);
        ButterKnife.bind(this, view);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","sometimes2009@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_EMAIL, "thiriyadana90@gmail.com");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "My Suggestion");
                emailIntent.putExtra(Intent.EXTRA_TEXT, etSendSuggestion.getText().toString());
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
            }
        });

        return view;
    }
}
