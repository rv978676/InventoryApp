package com.swaraj.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText etUserName, etPassword;
    LinearLayout btnLogin;
    TextView tvError;
    DialogBoxPopup dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        dialog = new DialogBoxPopup();
        etUserName = findViewById(R.id.etUserName);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.llLogin);
        tvError = findViewById(R.id.tvError);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.titlebar);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etUserName.getText().toString().trim().equalsIgnoreCase("")){
                    tvError.setVisibility(View.GONE);
                    dialog.showToast("Enter user name", LoginActivity.this);
                    //Toast.makeText(LoginActivity.this, "Enter user name", Toast.LENGTH_SHORT).show();
                }else if(etPassword.getText().toString().trim().equalsIgnoreCase("")){
                    dialog.showToast("Enter password",LoginActivity.this);
                    //Toast.makeText(LoginActivity.this, "Enter password", Toast.LENGTH_SHORT).show();
                }else if(etUserName.getText().toString().trim().equalsIgnoreCase("admin") && etPassword.getText().toString().trim().equalsIgnoreCase("p455w0rd")){
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                }else if(etUserName.getText().toString().trim().equalsIgnoreCase("employee1") && etPassword.getText().toString().trim().equalsIgnoreCase("p455w0rd")){
                    Intent intent = new Intent(LoginActivity.this,EmployeeActivity.class);
                    intent.putExtra("name","employee1");
                    startActivity(intent);
                }else if(etUserName.getText().toString().trim().equalsIgnoreCase("employee2") && etPassword.getText().toString().trim().equalsIgnoreCase("p455w0rd")){
                    Intent intent = new Intent(LoginActivity.this,EmployeeActivity.class);
                    intent.putExtra("name","employee2");
                    startActivity(intent);
                }else{
                    tvError.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}