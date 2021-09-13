package com.example.loginform.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginform.R;
import com.example.loginform.controller.ILoginController;
import com.example.loginform.controller.LoginController;
import com.example.loginform.view.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView{
    EditText emailAddress, password;
    Button login;
    ILoginController iLoginController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iLoginController = new LoginController(this);

        emailAddress = findViewById(R.id.editTextEmailAddress);
        password  = findViewById(R.id.editTextPassword);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iLoginController.onLogin(emailAddress.getText().toString().trim(),
                        password.getText().toString().trim());
            }
        });
    }

    @Override
    public void onLoginSuccess(String message) {
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginError(String message) {
        Toast.makeText(this, message,Toast.LENGTH_LONG).show();
    }
}