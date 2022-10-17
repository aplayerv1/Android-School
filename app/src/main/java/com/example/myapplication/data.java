package com.example.myapplication;

public class data {
    private int id;
    private String name;
    private Boolean urgent;


    public data(String name, Boolean urgent, int id) {
        this.name = name;
        this.urgent = urgent;
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public Boolean getUrgent(){
        return urgent;
    }
}
