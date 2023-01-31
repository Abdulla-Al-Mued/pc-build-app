package com.example.easybuild.View.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easybuild.MainActivity;
import com.example.easybuild.R;
import com.example.easybuild.Service.Model.RegisterResponse;
import com.example.easybuild.Service.Model.User;
import com.example.easybuild.ViewModel.AuthViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    private AuthViewModel authViewModel;
    TextInputLayout name, email, password;
    Button login, register;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.uPassword);
        login = findViewById(R.id.login);
        register = findViewById(R.id.signup);
        message = findViewById(R.id.message);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpAction();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            }
        });

    }

    private void signUpAction() {

        String Email = email.getEditText().getText().toString().trim();
        String pass = password.getEditText().getText().toString().trim();
        String uname = name.getEditText().getText().toString().trim();

        if (Email.isEmpty()){
            email.getEditText().setError("field can not be empty");
            return;
        }
        if (uname.isEmpty()){
            name.getEditText().setError("field can not be empty");
            return;
        }
        if (pass.isEmpty()){
            password.getEditText().setError("field can not be empty");
            return;
        }

        User user = new User(Email, uname, pass);

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        authViewModel.userRegistered(user).observe(this, new Observer<RegisterResponse>() {
            @Override
            public void onChanged(RegisterResponse registerResponse) {
                if (registerResponse.getSuccess()){
                    Toast.makeText(getApplicationContext(), "Log IN success", Toast.LENGTH_LONG).show();

                    SharedPreferences sp = getSharedPreferences("datafile",MODE_PRIVATE);
                    SharedPreferences.Editor ed = sp.edit();
                    ed.putString("email",Email);
                    ed.commit();
                }
                message.setText(registerResponse.getMsg());
            }
        });

    }
}