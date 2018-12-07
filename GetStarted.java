package com.example.shahzad.project1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GetStarted extends AppCompatActivity implements View.OnClickListener {

    private TextView customer;
    private TextView technician;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_started);

        technician=(TextView)findViewById(R.id.start_as_technician);
        customer=(TextView)findViewById(R.id.start_as_customer);

        technician.setOnClickListener(this);
        customer.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {

        Intent intent;
        if (view.getId() == R.id.start_as_technician)
        {
            intent=new Intent(this,Login.class);
            startActivity(intent);

        }
        else if(view.getId() == R.id.start_as_customer)
        {
            intent=new Intent(this,Login.class);
            startActivity(intent);
        }


    }
}
