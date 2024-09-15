package com.auaboi.signupfun;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button signUpBtn = (Button) findViewById(R.id.signUpBtn);

        signUpBtn.setOnClickListener((View.OnClickListener) this);
    }

    @Override
    public void onClick(View view) {
        startActivity(new Intent(MainActivity.this, SignUpActivity.class));
    }
}