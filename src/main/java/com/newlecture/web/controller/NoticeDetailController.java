package com.newlecture.web.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/notice/detail")
public class NoticeDetailController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));

        String url = "jdbc:oracle:thin:@192.168.219.106:1521/ORCLPDB";
        String sql = "SELECT * FROM NOTICE WHERE ID=?";


        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection(url, "NEWLEC", "newlec");
            PreparedStatement st = con.prepareStatement(sql); // 미리 준비
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();

            rs.next();

            String title = rs.getString("TITLE");
            String writerId = rs.getString("WRITER_ID");
            Date regdate = rs.getDate("REGDATE");
            int hit = rs.getInt("HIT");
            String files = rs.getString("FILES");
            String content = rs.getString("CONTENT");

            request.setAttribute("title", title);
            request.setAttribute("writerId", writerId);
            request.setAttribute("regdate", regdate);
            request.setAttribute("hit", hit);
            request.setAttribute("files", files);
            request.setAttribute("content", content);

            rs.close();
            st.close();
            con.close();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



        request.getRequestDispatcher("/notice/detail.jsp").forward(request, response);

    }
}
