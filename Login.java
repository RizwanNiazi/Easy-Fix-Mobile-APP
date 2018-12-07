package com.example.shahzad.project1;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity implements View.OnClickListener {

    String email,password,error;

    private EditText userEmail;
    private EditText userPassword;

    private TextView forgetPassword;
    private Button login;
    private TextView newAccount;
    public boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();

    }

    public void init()
    {
        userEmail = (EditText)findViewById(R.id.login_txt_email);
        userPassword = (EditText)findViewById(R.id.login_txt_password);

        forgetPassword = (TextView)findViewById(R.id.login_txt_forgetpassword);
        login = (Button)findViewById(R.id.login_btnlogin);
        newAccount = (TextView)findViewById(R.id.login_txtsignup);

        forgetPassword.setOnClickListener(this);
        login.setOnClickListener(this);
        newAccount.setOnClickListener(this);

    }
/////////////



    @Override
    public void onClick(View view) {
        Intent intent;

        if(view.getId() == R.id.login_txt_forgetpassword)
        {
            intent=new Intent(this,forgetPassword.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.login_txtsignup)
        {
            intent=new Intent(this,signup.class);
            startActivity(intent);
        }
        else if(view.getId() == R.id.login_btnlogin)
        {
            if (checkValidations() && validate()) {
                Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();

                intent = new Intent(this, gMapsActivity.class);
                startActivity(intent);

            }
            else{
                Toast.makeText(this, "User does not exist in database", Toast.LENGTH_SHORT).show();
            }

        }

    }
    private boolean vall(){
        //for(int i=0;i<100;i++){
        {
            String a=modeldb.getPassword(0);
            String b=modeldb.getUserEmail(0);

            Toast.makeText(this,a , Toast.LENGTH_SHORT).show();
            Toast.makeText(this,b , Toast.LENGTH_SHORT).show();


        }
        return true;
    }

    private boolean validate(){

        //modeldb aa=new modeldb();
        for(int i=0;i<modeldb.counterr;i++){
            if(modeldb.getUserEmail(i).equals(userEmail.getText().toString())){
                if(modeldb.getPassword(i).equals(userPassword.getText().toString()))
                {

                    flag=true;
                    //           break;
                }
            }

        }
        return flag;
    }


    private boolean checkValidations() {

        email=userEmail.getText().toString().trim();
        password=userPassword.getText().toString().trim();

        int color = ContextCompat.getColor(this,R.color.darkgray);


        if (email.length()==0)
        {
            error=getResources().getString(R.string.email_require);
            userEmail.setError(error);
            userEmail.setTextColor(color);
            return false;
        }
        else
        {
            if(!isValidMail(email))
            {
                error=getResources().getString(R.string.invalid_email);
                userEmail.setError(error);

                userEmail.setTextColor(color);
                return false;
            }
        }

        if (password.equals(null))
        {
            error=getResources().getString(R.string.password_missing);
            userPassword.setError(error);
            userEmail.setTextColor(color);
            return false;
        }

        return true;
    }

    private boolean isValidMail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}
