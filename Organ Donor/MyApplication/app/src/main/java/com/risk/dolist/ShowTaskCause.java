package com.risk.dolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Redwan Khan on 11/4/2017.
 */

public class ShowTaskCause extends AppCompatActivity{

    private TextView tvName,tvAddress, tvDonatingSelling, tvChargingPrice,tvEmail, tvPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showtaskcause);


        Intent in= getIntent();

        String name = in.getStringExtra("name");
        String address = in.getStringExtra("address");
        String donating_selling = in.getStringExtra("donating_selling");
        String charging_price = in.getStringExtra("charging_price");
        String email = in.getStringExtra("email");
        String phone = in.getStringExtra("phone");

        tvName = (TextView) findViewById(R.id.tvName);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        tvDonatingSelling = (TextView) findViewById(R.id.tvDonatingSelling);
        tvChargingPrice = (TextView) findViewById(R.id.tvChargingPrice);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvPhone = (TextView) findViewById(R.id.tvPhone);

        tvName.setText(name);
        tvAddress.setText("Address: " + address);
        tvDonatingSelling.setText("Donating/Selling: "+ donating_selling);
        tvChargingPrice.setText("Charging Price: "+ charging_price);
        tvEmail.setText("Email: "+ email);
        tvPhone.setText("Phone: "+ phone);
    }
}
