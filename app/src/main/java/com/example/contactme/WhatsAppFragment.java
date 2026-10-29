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


public class WhatsAppFragment extends Fragment {

private Button openWa;
private EditText msgEt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_whats_app, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        openWa=view.findViewById(R.id.BtnGoToWhatsApp);
        msgEt=view.findViewById(R.id.EtWhatsApp);
        openWa.setOnClickListener(V ->openOnWhatsApp());
    }
    private void openOnWhatsApp()
    {
        String msg=msgEt.getText().toString();
        if (!msg.isEmpty())
        {
            String link = "https://wa.me/" + MainActivity.WA_PHONE
                    + "?text=" + Uri.encode(msg);
            Intent wa = new Intent(Intent.ACTION_VIEW, Uri.parse(link));
            startActivity(wa);
        }

    }

}