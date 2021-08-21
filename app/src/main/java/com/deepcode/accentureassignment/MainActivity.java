package com.deepcode.accentureassignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.crypto.SealedObject;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intializeLayout();

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etUsername.getText().toString().trim().equals("Ronelle") && etPassword.getText().toString().equals("Ronelle1234")) {
                    startActivity(new Intent(MainActivity.this, SecondActivity.class));
                    finish();
                } else {
                    displayLoginFailedDialog();
                }
            }
        });


    }

    private void intializeLayout() {
        //EditText
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);

        //Button
        btnLogin = findViewById(R.id.btn_login);
    }

    private void displayLoginFailedDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle(getString(R.string.main_error_title));
        builder.setMessage(getString(R.string.main_error_message));
        builder.setPositiveButton(getString(R.string.main_okay), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                etUsername.setText("");
                etPassword.setText("");
                dialogInterface.cancel();

            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}