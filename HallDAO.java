package com.functionhall.dao;

import com.functionhall.model.FunctionHall;
import com.functionhall.util.DBConnection;
import java.sql.*;
import java.util.*;

public class HallDAO {
    public List<FunctionHall> getAll(){
        List<FunctionHall> list=new ArrayList<>();
        try(Connection c=DBConnection.getConnection(); Statement s=c.createStatement(); ResultSet r=s.executeQuery("SELECT * FROM halls ORDER BY id")){
            while(r.next()) list.add(new FunctionHall(r.getInt("id"),r.getString("name"),r.getString("location"),r.getInt("capacity"),r.getDouble("price")));
        }catch(SQLException e){e.printStackTrace();}
        return list;
    }
}