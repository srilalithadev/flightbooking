package com.flight;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class Login extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("username");
        String password = request.getParameter("password");

        
        String url ="jdbc:mysql://localhost:3306/abc";
		String uname= "root";
		String pass = "root";
		Connection con= null;
		PreparedStatement st = null;
		ResultSet rs= null;
		String query ="SELECT * FROM login WHERE username=? AND password=?";
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(url,uname,pass);
	    st = con.prepareStatement(query);
		st.setString(1, username);
		st.setString(2, password);
		rs = st.executeQuery();
		
		if(rs.next()) {
			response.sendRedirect("options");
		}
		else {
			out.println("<div align= center><font color =red size= 10>Invalid username or password</font></div>");
			RequestDispatcher rd= request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
	}
		catch(Exception e) {
            e.printStackTrace();
			
		}
		finally {
			try {
                
                if (st != null) 
                	st.close();
                if (con != null)
                	con.close();
            } 
			catch (Exception e) {
                e.printStackTrace();
            }
		}

}
}
