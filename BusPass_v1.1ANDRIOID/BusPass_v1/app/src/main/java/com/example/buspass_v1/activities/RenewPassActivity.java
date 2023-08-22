package com.example.buspass_v1.activities;

import androidx.appcompat.app.AppCompatActivity;
import com.example.buspass_v1.R;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RenewPassActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renew_pass);
    }

    public void verifyBtn (View view) {
        startActivity(new Intent(this, PaymentActivity.class));
    }
}