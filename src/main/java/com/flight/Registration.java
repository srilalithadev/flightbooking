package com.flight;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Registration")
public class Registration extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ServletContext context = getServletContext();
		
		int id = (int) context.getAttribute("flightNumber");
		String name = (String) context.getAttribute("flightName");
		String source = (String) context.getAttribute("source");
		String destination = (String) context.getAttribute("destination");
		double price =  (double) context.getAttribute("price");
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String Name = request.getParameter("name");
		String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        out.println("<h1>Registerd Successfully</h1>");
        out.println("<br>Thanks for registering to Fly Away Airlines");
        out.println("<br>Please keep your email and password safely");
        
        out.println("<h1>Your Flight Details</h1>");
        out.println("<br>FlightNumber is: " + id);
        out.println("<br>FlightName is: " + name);
        out.println("<br>From is: " + source);
        out.println("<br>To is: " + destination);
        out.println("<br>Total Price is: " + price);
        
        out.println("<br><br><a href='Payment'>Click here to proceed for payment</a>");
        
	}

}
