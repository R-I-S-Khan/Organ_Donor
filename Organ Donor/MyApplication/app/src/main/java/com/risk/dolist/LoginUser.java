package com.risk.dolist;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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

import java.util.HashMap;
import java.util.Map;
/**
 * Created by ASUS on 11/5/2017.
 */

public class LoginUser extends AppCompatActivity {


    public EditText etNameLogin;// = (EditText) findViewById(R.id.etNameLogin);
    public EditText etPasswordLogin;// = (EditText)findViewById(R.id.etPasswordLogin);
    public ImageButton imgbSignInLogin;// = (ImageButton) findViewById(R.id.imgbSignInLogin);
    public ImageButton imgbSignUpLogin;// = (ImageButton) findViewById(R.id.imgbSignUpLogin);
    //MainActivity.NewAdapter adapter;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_user);
        //Intent in= getIntent();
        etPasswordLogin = (EditText)findViewById(R.id.etPasswordLogin);
        etNameLogin = (EditText) findViewById(R.id.etNameLogin);
        imgbSignInLogin = (ImageButton) findViewById(R.id.imgbSignInLogin);
        imgbSignUpLogin = (ImageButton) findViewById(R.id.imgbSignUpLogin);
        imgbSignInLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                final String s1 = etNameLogin.getText().toString();
                final String s2 = etPasswordLogin.getText().toString();
                //int id = adapter.gid;
                Intent inlogtomain = new Intent(LoginUser.this, MainActivity.class);
                startActivity(inlogtomain);
                //if(id!=0){

                    //setContentView(R.layout.activity_main);
                //}

                /*StringRequest jor = new StringRequest(Request.Method.POST, "http://10.84.25.26/OrganDonor/insert.php",
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

                setContentView(R.layout.activity_main);*/
            }
        });

        imgbSignUpLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inlogtoregister = new Intent(LoginUser.this, RegisterUser.class);
                startActivity(inlogtoregister);
                //setContentView(R.layout.register_user);
            }
        });
        //Intent inlogtomain = new Intent(LoginUser.this, MainActivity.class);
        //startActivity(inlogtomain);
        //setContentView(R.layout.activity_main);
    }
}
