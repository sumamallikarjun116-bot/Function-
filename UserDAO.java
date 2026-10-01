package com.functionhall.dao;

import com.functionhall.model.User;
import com.functionhall.util.DBConnection;
import java.sql.*;

public class UserDAO {
    public boolean register(User u) {
        String sql="INSERT INTO users(name,email,password,role) VALUES(?,?,?,?)";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setString(1,u.getName()); p.setString(2,u.getEmail()); p.setString(3,u.getPassword()); p.setString(4,u.getRole());
            return p.executeUpdate()==1;
        }catch(SQLException e){e.printStackTrace(); return false;}
    }
    public User login(String email,String password){
        String sql="SELECT * FROM users WHERE email=? AND password=?";
        try(Connection c=DBConnection.getConnection(); PreparedStatement p=c.prepareStatement(sql)){
            p.setString(1,email);p.setString(2,password);
            ResultSet r=p.executeQuery();
            if(r.next()) return new User(r.getInt("id"),r.getString("name"),r.getString("email"),r.getString("password"),r.getString("role"));
        }catch(SQLException e){e.printStackTrace();}
        return null;
    }
}