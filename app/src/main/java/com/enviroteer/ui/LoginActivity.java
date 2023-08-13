package com.enviroteer.ui;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.enviroteer.MainActivity;
import com.enviroteer.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class LoginActivity extends AppCompatActivity {

    private LinearLayout loginLayout, registerLayout;
    private Button LoginOption, RegisterOption;

    private EditText loginEmail, loginPassword, registerUsername, registerEmail, registerPassword, registerConfirmPassword;
    private Button buttonLogin, buttonRegister;
    private View loginLine,registerLine;

    private String email;
    private String password;
    private String username;
    private FirebaseAuth mAuth;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null) {
            updateUI(currentUser);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginLayout = findViewById(R.id.login_layout);
        registerLayout = findViewById(R.id.register_layout);
        loginLine = findViewById(R.id.loginLine);
        registerLine = findViewById(R.id.registerLine);
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

        mAuth = FirebaseAuth.getInstance();

        LoginOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (loginLayout.getVisibility() != View.VISIBLE) {
                    registerLine.setVisibility(View.INVISIBLE);
                    registerLayout.setVisibility(View.GONE);
                    loginLine.setVisibility(View.VISIBLE);
                    loginLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        RegisterOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (registerLayout.getVisibility() != View.VISIBLE) {
                    loginLine.setVisibility(View.INVISIBLE);
                    loginLayout.setVisibility(View.GONE);
                    registerLine.setVisibility(View.VISIBLE);
                    registerLayout.setVisibility(View.VISIBLE);
                }
            }
        });



        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                email = loginEmail.getText().toString().trim();
                password = loginPassword.getText().toString().trim();
                mAuth.signInWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
                                    Log.d(TAG, "signInWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    updateUI(user);
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(LoginActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    //updateUI(null);
                                }
                            }
                        });
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
                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information
                                        Log.d(TAG, "createUserWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                                                .setDisplayName(username).build();

                                        user.updateProfile(profileUpdates);
                                        updateUI(user);
                                    } else {
                                        // If sign in fails, display a message to the user.
                                        Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                        Toast.makeText(LoginActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();
                                        //updateUI(null);
                                    }
                                }
                            });

                } else {
                    Toast.makeText(LoginActivity.this, "Passwords do not match.", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void updateUI(FirebaseUser user) {
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}