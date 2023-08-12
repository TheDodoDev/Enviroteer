package com.enviroteer.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.enviroteer.R;

public class LoginActivity extends AppCompatActivity {

    private LinearLayout loginLayout, registerLayout;
    private Button LoginOption, RegisterOption;

    private EditText loginEmail, loginPassword, registerUsername, registerEmail, registerPassword, registerConfirmPassword;
    private Button buttonLogin, buttonRegister;

    private String email;
    private String password;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginLayout = findViewById(R.id.login_layout);
        registerLayout = findViewById(R.id.register_layout);
        LoginOption = findViewById(R.id.btn_login_option);
        RegisterOption = findViewById(R.id.btn_register_option);


        loginEmail = findViewById(R.id.login_email);
        loginPassword = findViewById(R.id.login_password);
        registerUsername = findViewById(R.id.register_username);
        registerEmail = findViewById(R.id.register_email);
        registerPassword = findViewById(R.id.register_password);
        registerConfirmPassword = findViewById(R.id.register_confirm_password);
        buttonLogin = findViewById(R.id.btn_login);
        buttonRegister = findViewById(R.id.btn_register);

        LoginOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginLayout.getVisibility() != View.VISIBLE) {
                    registerLayout.setVisibility(View.GONE);
                    loginLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        RegisterOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginLayout.getVisibility() != View.VISIBLE) {
                    loginLayout.setVisibility(View.GONE);
                    registerLayout.setVisibility(View.VISIBLE);
                }
            }
        });



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = loginEmail.getText().toString().trim();
                password = loginPassword.getText().toString().trim();

            }
        });
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = registerEmail.getText().toString().trim();
                password = registerPassword.getText().toString().trim();
                username = registerUsername.getText().toString().trim();
                String confirmPassword = registerConfirmPassword.getText().toString().trim();

                if (password.equals(confirmPassword)) {

                } else {
                    Toast.makeText(LoginActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}