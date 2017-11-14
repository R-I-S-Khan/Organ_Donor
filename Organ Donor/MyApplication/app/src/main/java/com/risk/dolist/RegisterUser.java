package com.risk.dolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 11/5/2017.
 */

public class RegisterUser extends AppCompatActivity {
    public ImageButton imgbSignUpRegister;// = (ImageButton) findViewById(R.id.imgbSignUpRegister);
    public EditText etNameRegister; //= (EditText) findViewById(R.id.etNameRegister);
    public EditText etPasswordRegister; //= (EditText)findViewById(R.id.etPasswordRegister);

    //MainActivity.NewAdapter adapter;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user);
        Intent in= getIntent();

        ImageButton imgbSignUpRegister = (ImageButton) findViewById(R.id.imgbSignUpRegister);
        etNameRegister = (EditText) findViewById(R.id.etNameRegister);
        etPasswordRegister = (EditText)findViewById(R.id.etPasswordRegister);
        requestQueue = Volley.newRequestQueue(this);

        imgbSignUpRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String s1 = etNameRegister.getText().toString();
                final String s2 = etPasswordRegister.getText().toString();

                StringRequest jor = new StringRequest(Request.Method.POST, "http://10.84.25.26/OrganDonorRegister/insert.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //Refresh(adapter);

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //tvSelection.setText(error.toString());
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> p = new HashMap<>();
                        p.put("name", s1);
                        p.put("password", s2);

                        return p;
                    }
                };
                requestQueue.add(jor);
                //Intent in = new Intent(RegisterUser.this, MainActivity.class);
                //startActivity(in);

                //setContentView(R.layout.activity_main);

            }
        });


    }
}
