package com.example.contactme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class EmailFragment extends Fragment {

    private EditText EtSubject,EtMessage;
    private Button GoTo;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_email, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         EtSubject=view.findViewById(R.id.EtSubjectEmail);
         EtMessage=view.findViewById(R.id.EtMsgEmail);
         GoTo=view.findViewById(R.id.BtnGoToEmail);
         GoTo.setOnClickListener(V ->openEmail());



    }
    private void openEmail()
    {
        String subject=EtSubject.getText().toString();
        String message=EtMessage.getText().toString();
        if (message.isEmpty())
        {
            EtMessage.setError("empty");
        }
        else
        {
            Intent email = new Intent(Intent.ACTION_SENDTO);
            email.setData(Uri.parse("mailto:"));
            email.putExtra(Intent.EXTRA_EMAIL, new String[]{MainActivity.EMAIL});
            email.putExtra(Intent.EXTRA_SUBJECT, subject);
            email.putExtra(Intent.EXTRA_TEXT, message);
            startActivity(email);
        }
    }

}