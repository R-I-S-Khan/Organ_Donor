package com.risk.dolist;

/**
 * Created by Redwan on 11/4/17.
 */

public class TaskCauseItem {
    int id;
    String name;
    String address;
    String donating_selling;
    String charging_price;
    String email;
    String phone;

    public TaskCauseItem(String name, String address, String donating_selling, String charging_price, String email, String phone) {
        this.name = name;
        this.address = address;
        this.donating_selling = donating_selling;
        this.charging_price = charging_price;
        this.email = email;
        this.phone = phone;
    }

    public TaskCauseItem(int _id,String name, String address, String donating_selling, String charging_price, String email, String phone) {
        this.id = _id;
        this.name = name;
        this.address = address;
        this.donating_selling = donating_selling;
        this.charging_price = charging_price;
        this.email = email;
        this.phone = phone;
    }
    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                ", Donating/Selling='" + donating_selling + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDonating_Selling(){ return donating_selling;}

    public String getCharging_Price(){ return charging_price;}

    public String getEmail(){ return email;}

    public String getPhone(){return phone;}

}
