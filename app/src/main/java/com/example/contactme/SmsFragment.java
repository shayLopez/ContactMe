package com.example.contactme;

import android.Manifest;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;

import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SmsFragment extends Fragment {
    private EditText msgEt;
    private Button sndMsgBt;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sms, container, false);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        msgEt=view.findViewById(R.id.EtSms);
        sndMsgBt=view.findViewById(R.id.BtnSendSms);
        sndMsgBt.setOnClickListener(V ->{if (!(msgEt.getText().toString()).isEmpty())permissionLauncher.launch(Manifest.permission.SEND_SMS);
        else
            msgEt.setError("Empty");
        });

    }
    private void sendSms() {
        String text = msgEt.getText().toString().trim();
        if (!text.isEmpty())
        {
        SmsManager sms = requireContext().getSystemService(SmsManager.class);
        sms.sendTextMessage(MainActivity.SMS_PHONE, null, text, null, null);
    }
    }
    private final ActivityResultLauncher<String> permissionLauncher =
            registerForActivityResult(
                    new ActivityResultContracts.RequestPermission(), granted ->
                    {
                        if (granted)
                            sendSms();
                        else
                            Toast.makeText(requireContext(),"No SMS permission", Toast.LENGTH_SHORT).show();
                    });
}