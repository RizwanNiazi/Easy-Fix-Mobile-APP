package com.example.shahzad.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class signup extends AppCompatActivity implements View.OnClickListener {
    public modeldb d=new modeldb();
    private EditText userName;
    private EditText userEmail;
    private EditText userPassword;

    private EditText userConformPassword;
    private Spinner spinner;

    private Button signUp;
    private TextView login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        init();

    }

    public void init()
    {
        userName = (EditText)findViewById(R.id.signup_txt_name);
        userEmail = (EditText)findViewById(R.id.signup_txt_email);
        userPassword = (EditText)findViewById(R.id.signup_txt_password);
        userConformPassword = (EditText)findViewById(R.id.signup_txt_cpassword);

        spinner = (Spinner)findViewById(R.id.signup_spin_cities);

        signUp = (Button)findViewById(R.id.btnsignup);
        login = (TextView)findViewById(R.id.signup_txtsignin);


        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(signup.this,R.array.cities,R.layout.spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);


        signUp.setOnClickListener(this);
        login.setOnClickListener(this);

    }
    public void regd(View view){
        Toast.makeText(this, userName.getText().toString()+"User added in database", Toast.LENGTH_SHORT).show();

        modeldb d=new modeldb();
        d.setPassword(userPassword.getText().toString(), d.counterr);
        d.setUserEmail(userEmail.getText().toString(), d.counterr);
        d.setName(userName.getText().toString(), d.counterr);
        String location = spinner.getSelectedItem().toString();
        d.setLocation(location, d.counterr);
        d.counterr=d.counterr+1;

        //Toast.makeText(this,d.getPassword(d.counterr-1), Toast.LENGTH_SHORT).show();


    }
    @Override
    public void onClick(View view) {
        Intent intent;


        if (view.getId() == R.id.btnsignup) {

            Toast.makeText(this, "Successfully SignUp", Toast.LENGTH_SHORT).show();
            intent = new Intent(this, Login.class);
            startActivity(intent);
            d.setPassword(userPassword.getText().toString(), d.counterr);
            d.setUserEmail(userEmail.getText().toString(), d.counterr);
            d.setName(userName.getText().toString(), d.counterr);
            String location = spinner.getSelectedItem().toString();
            d.setLocation(location, d.counterr);
            d.counterr = d.counterr + 1;

        }


        else if (view.getId() == R.id.signup_txtsignin)
        {
            intent = new Intent(this,Login.class);
            startActivity(intent);
        }

    }
}
