package com.functionhall.model;
public class FunctionHall {
 private int id,capacity; private String name,location; private double price;
 public FunctionHall(int id,String name,String location,int capacity,double price){this.id=id;this.name=name;this.location=location;this.capacity=capacity;this.price=price;}
 public int getId(){return id;} public String getName(){return name;} public String getLocation(){return location;} public int getCapacity(){return capacity;} public double getPrice(){return price;}
}