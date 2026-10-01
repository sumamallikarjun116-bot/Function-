package com.functionhall.dao;

import com.functionhall.model.Booking;
import com.functionhall.util.DBConnection;
import java.sql.*;

public class BookingDAO {
    public boolean create(Booking b){
        String sql="INSERT INTO bookings(user_id,hall_id,booking_date,event_name,payment_method,status) VALUES(?,?,?,?,?,?)";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setInt(1,b.getUserId());p.setInt(2,b.getHallId());p.setDate(3,Date.valueOf(b.getDate()));
            p.setString(4,b.getEventName());p.setString(5,b.getPaymentMethod());p.setString(6,b.getStatus());
            return p.executeUpdate()==1;
        }catch(SQLException e){e.printStackTrace();return false;}
    }
}