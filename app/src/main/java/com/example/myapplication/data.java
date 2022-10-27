package com.example.myapplication;

public class data {
private String name,height,mass;

public data(String name,String mass, String height){
    this.name = name;
    this.height = height;
    this.mass = mass;
}
public String getName(){
    return name;
}
public String getHeight(){
    return height;
}
public String getMass(){
    return mass;
}
}
