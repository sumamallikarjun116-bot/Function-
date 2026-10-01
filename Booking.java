package com.functionhall.model;
import java.time.LocalDate;
public class Booking {
 private int id,userId,hallId; private LocalDate date; private String eventName,paymentMethod,status;
 public Booking(int id,int userId,int hallId,LocalDate date,String eventName,String paymentMethod,String status){this.id=id;this.userId=userId;this.hallId=hallId;this.date=date;this.eventName=eventName;this.paymentMethod=paymentMethod;this.status=status;}
 public int getId(){return id;} public int getUserId(){return userId;} public int getHallId(){return hallId;} public LocalDate getDate(){return date;} public String getEventName(){return eventName;} public String getPaymentMethod(){return paymentMethod;} public String getStatus(){return status;}
}