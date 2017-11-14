package com.risk.dolist;

/**
 * Created by Redwan Khan on 11/4/2017.
 **/

import android.app.DownloadManager;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {


    ArrayList<TaskCauseItem> items;
    ListView lvItems;
    ImageButton imgbAdd, imgbRefresh;
    EditText etName,etAddress,etDonateSell, etChargingPrice, etEmail,etPhone;
    TextView tvSelection;

    NewAdapter adapter;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Intent in = new Intent(MainActivity.this, LoginUser.class);
        //startActivity(in);
        //setContentView(R.layout.login_user);
        Intent inlogtomain= getIntent();
        lvItems = (ListView)findViewById(R.id.lvItems);
        imgbAdd = (ImageButton) findViewById(R.id.imgbAdd);
        imgbRefresh = (ImageButton)findViewById(R.id.imgbRefresh);
        etName = (EditText) findViewById(R.id.etName);
        etAddress = (EditText)findViewById(R.id.etAddress);
        etDonateSell = (EditText)findViewById(R.id.etDonateSell);
        etChargingPrice = (EditText)findViewById(R.id.etChargingPrice);
        etEmail = (EditText)findViewById(R.id.etEmail);
        etPhone = (EditText)findViewById(R.id.etPhone);
        tvSelection = (TextView)findViewById(R.id.tvSelection);


        items = new ArrayList<TaskCauseItem>();


        adapter = new NewAdapter();
        lvItems.setAdapter(adapter);

        requestQueue = Volley.newRequestQueue(this);




        imgbRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Refresh(adapter);
            }
        });

        imgbAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String s1 = etName.getText().toString();
                final String s2 = etAddress.getText().toString();
                final String s3 = etDonateSell.getText().toString();
                final String s4 = etChargingPrice.getText().toString();
                final String s5 = etEmail.getText().toString();
                final String s6 = etPhone.getText().toString();

                StringRequest jor = new StringRequest(Request.Method.POST, "http://10.84.25.26/OrganDonor/insert.php",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                Refresh(adapter);

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                            tvSelection.setText(error.toString());
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> p = new HashMap<>();
                        p.put("name", s1);
                        p.put("address", s2);
                        p.put("donating_selling",s3);
                        p.put("charging_price",s4);
                        p.put("email",s5);
                        p.put("phone",s6);
                        return p;
                    }
                };
                requestQueue.add(jor);
                //Intent in = new Intent(MainActivity.this, LoginUser.class);
                //startActivity(in);


            }
        });

        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent in = new Intent(MainActivity.this, ShowTaskCause.class);
                in.putExtra("name",items.get(position).getName());
                in.putExtra("address",items.get(position).getAddress());
                in.putExtra("donating_selling",items.get(position).getDonating_Selling());
                in.putExtra("charging_price",items.get(position).getCharging_Price());
                in.putExtra("email",items.get(position).getEmail());
                in.putExtra("phone",items.get(position).getPhone());
                startActivity(in);
            }
        });

    }

    public class NewAdapter extends ArrayAdapter<TaskCauseItem>{
        int gid;
        public NewAdapter(){

            super(getApplicationContext(),R.layout.task_cause_item,items);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            //gid = items.get(position).id;
            View v = convertView;
            if(v == null) {
                v = getLayoutInflater().inflate(R.layout.task_cause_item, parent, false);
            }
            TextView tvName = (TextView)v.findViewById(R.id.tvName);
            TextView tvDonatingSelling = (TextView)v.findViewById(R.id.tvDonatingSelling);
            ImageButton imgbDelete = (ImageButton)v.findViewById(R.id.imgbDelete);

            tvName.setText(items.get(position).name);
            tvDonatingSelling.setText(items.get(position).donating_selling);

            imgbDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int id = items.get(position).id;
                    delete(id);
                    items.remove(position);
                    notifyDataSetChanged();
                }
            });
            imgbDelete.setFocusable(false);


            return v;
        }
    }

    void Refresh(final NewAdapter adapter){

        items.clear();

        JsonArrayRequest jor  = new JsonArrayRequest(Request.Method.GET, "http://10.84.25.26/OrganDonor/view.php", null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                            items.clear();
                            int len =  response.length();
                            for( int i =0; i<len; i++){
                                try {
                                    JSONObject j = response.getJSONObject(i);

                                    int id = j.getInt("id");
                                    String name = j.getString("name");
                                    String address = j.getString("address");
                                    String donating_selling = j.getString("donating_selling");
                                    String charging_price = j.getString("charging_price");
                                    String email = j.getString("email");
                                    String phone = j.getString("phone");
                                    items.add(new TaskCauseItem(id,name,address,donating_selling,charging_price,email,phone));
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        adapter.notifyDataSetChanged();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvSelection.setText(error.toString());
            }
        });
        requestQueue.add(jor);

    }

    void delete(int id){
        final int _id= id;

        StringRequest jor = new StringRequest(Request.Method.POST, "http://10.84.25.26/OrganDonor/delete.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                tvSelection.setText(error.toString());
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> p = new HashMap<>();
                p.put("id", String.valueOf(_id));
                return p;
            }
        };
        requestQueue.add(jor);
    }
}
