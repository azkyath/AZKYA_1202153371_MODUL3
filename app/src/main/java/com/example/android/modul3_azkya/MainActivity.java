package com.example.android.modul3_azkya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText uname;
    private String isiusername;
    private EditText pass;
    private String isipassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){
        uname = (EditText)findViewById(R.id.text_username);
        isiusername = uname.getText().toString();
        pass = (EditText)findViewById(R.id.text_password);
        isipassword = pass.getText().toString();
        if(isiusername.equals("EAD") && isipassword.equals("MOBILE")){
            Intent login = new Intent(MainActivity.this, daftar_minuman.class);
            Toast message = Toast.makeText(this,"Login is successful",Toast.LENGTH_LONG);
            startActivity(login);
            message.show();
        }else{
            Toast message = Toast.makeText(this,"Your username/password is wrong",Toast.LENGTH_LONG);
            message.show();
        }
    }
}
