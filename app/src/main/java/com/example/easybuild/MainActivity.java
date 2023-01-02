package com.example.easybuild;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.easybuild.Service.Model.RegisterResponse;
import com.example.easybuild.Service.Model.User;
import com.example.easybuild.View.Ui.SignUp;
import com.example.easybuild.ViewModel.AuthViewModel;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    Button signup, logIn;
    TextInputLayout email, password;
    TextView message;
    private AuthViewModel authViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        signup = findViewById(R.id.signup);
        logIn = findViewById(R.id.login);
        email = findViewById(R.id.uName);
        password = findViewById(R.id.uPassword);
        message = findViewById(R.id.message);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SignUp.class));
            }
        });

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logInAction();
            }
        });


    }

    private void logInAction() {
        String Email = email.getEditText().getText().toString().trim();
        String Password = password.getEditText().getText().toString().trim();

        if (Email.isEmpty()){
            email.getEditText().setError("field can not be empty");
            return;
        }
        if (Password.isEmpty()){
            password.getEditText().setError("field can not be empty");
            return;
        }

        User user = new User(Email, Password);

        authViewModel = new ViewModelProvider(this).get(AuthViewModel.class);
        authViewModel.userLogIn(user).observe(this, new Observer<RegisterResponse>() {
            @Override
            public void onChanged(RegisterResponse registerResponse) {
                if (registerResponse.getSuccess()){
                    Toast.makeText(getApplicationContext(), "Log IN success", Toast.LENGTH_LONG).show();
                }
                message.setText(registerResponse.getMsg());
            }
        });


    }
}