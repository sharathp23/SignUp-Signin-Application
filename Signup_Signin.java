main.java

package com.example.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText editTextUserName;
    EditText editTextPassWord;
    Button btn_signup;
    String regularExpression = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUserName = (EditText) findViewById(R.id.editTextUserName);
        editTextPassWord = (EditText) findViewById(R.id. editTextPassWord);
        btn_signup = (Button) findViewById(R.id.btn_signup);
        btn_signup.setOnClickListener(this);
    }
    public void onClick(View v) {
        String username = editTextUserName.getText().toString();
        String password = editTextPassWord.getText().toString();
        if (validatePassword(password)) {
            Bundle bundle = new Bundle();
            bundle.putString("username", username);
            bundle.putString("password", password);
            Intent it = new Intent(this, Login.class);
            it.putExtra("data", bundle);
            startActivity(it);
        } else {
            Toast.makeText(getBaseContext(), "Invalid Password", Toast.LENGTH_LONG).show();
        }
    }

    public boolean validatePassword(String password) {
        Pattern pattern = Pattern.compile(regularExpression);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }

    private class Login {
    }
}

loginjava

package com.example.signup;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.signup.R;

public class login extends AppCompatActivity implements View.OnClickListener {
    EditText txtLoginUsername;
    EditText txtLoginPassword;
    Button btnLogin;
    String user, pass;
    int count = 0;
    @SuppressLint("MissingSuperCall")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        txtLoginUsername = (EditText) findViewById(R.id.editTextUserName);
        txtLoginPassword = (EditText) findViewById(R.id. editTextPassWord);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
        Bundle bundle = getIntent().getBundleExtra("data");
        user = bundle.getString("user");
        pass = bundle.getString("Lab@2018");
    }
    public void onClick(View v) {
        String user1 = txtLoginUsername.getText().toString();
        String pass1 = txtLoginPassword.getText().toString();
        if (user.equals(user1) && pass.equals(pass1)) {
            Toast.makeText(this, "Login Successful", Toast.LENGTH_LONG).show();
        } else {
            count++;
            if (count == 3) {
                btnLogin.setEnabled(false);
                Toast.makeText(this, "Failed Login Attempts", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Login Failed " + count, Toast.LENGTH_LONG).show();
            }
        }
    }
