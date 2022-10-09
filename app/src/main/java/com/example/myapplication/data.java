package com.example.myapplication;

public class data {

    private String name;
    private Boolean urgent;


    public data(String name, Boolean urgent) {
        this.name = name;
        this.urgent = urgent;
    }

    public String getName() {
        return name;
    }
    public Boolean getUrgent(){
        return urgent;
    }
}
