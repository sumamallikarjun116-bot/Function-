package com.functionhall.controller;

import com.functionhall.dao.HallDAO;
import com.functionhall.model.FunctionHall;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/halls")
public class HallServlet extends HttpServlet {
    private final HallDAO dao = new HallDAO();
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json");
        List<FunctionHall> halls = dao.getAll();
        StringBuilder json = new StringBuilder("[");
        for (int i=0;i<halls.size();i++) {
            FunctionHall h=halls.get(i);
            if(i>0) json.append(",");
            json.append("{\"id\":").append(h.getId())
                .append(",\"name\":\"").append(esc(h.getName()))
                .append("\",\"location\":\"").append(esc(h.getLocation()))
                .append("\",\"capacity\":").append(h.getCapacity())
                .append(",\"price\":").append(h.getPrice()).append("}");
        }
        json.append("]");
        resp.getWriter().print(json);
    }
    private String esc(String s){ return s==null?"":s.replace("\\","\\\\").replace("\"","\\\""); }
}