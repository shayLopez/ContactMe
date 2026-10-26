package com.example.contactme;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {
    public static final String SMS_PHONE = "0584751725";
    public static final String WA_PHONE = "972584751725";
    public static final String EMAIL = "shay0584751725@gmail.com";
    private Button BtSms,BtEmail,BtWhatsApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        insit();
        BtSms.setOnClickListener(V ->show(new SmsFragment()));
        BtEmail.setOnClickListener(V ->show(new EmailFragment()));
        BtWhatsApp.setOnClickListener(V ->show(new WhatsAppFragment()));
        if (savedInstanceState == null)
            show(new SmsFragment());
    }
    private void show(Fragment next) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragLayout, next).commit();
    }
    private void insit()
    {
        BtSms=findViewById(R.id.BtnSms);
        BtEmail=findViewById(R.id.BtnEmail);
        BtWhatsApp=findViewById(R.id.BtnWhatsApp);
    }
}