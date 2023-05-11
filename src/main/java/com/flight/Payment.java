package com.flight;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Payment")
public class Payment extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		ServletContext context = getServletContext();
		
		int id = (int) context.getAttribute("flightNumber");
		String name = (String) context.getAttribute("flightName");
		String source = (String) context.getAttribute("source");
		String destination = (String) context.getAttribute("destination");
		double price =  (double) context.getAttribute("price");
		
		 response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
	        // Generate a random booking number
	        //String bookingNumber = generateBookingNumber();
	        
	        out.println("<html><body>");
	        out.println("<h1> Your flight journey was confirmed with following details: </h1>");
	        out.println("Your Payment of "+ price + " successfully completed!");
	        //out.println("<br>Booking Number: " + bookingNumber);
	        out.println("<br>FlightNumber is: " + id);
	        out.println("<br>FlightName is: " + name);
	        out.println("<br>From : " + source);
	        out.println("<br>To : " + destination);
	        
	        
	        out.println("<br><a href='logout'>Logout</a>");
	        
	        out.println("</body></html>");
	    }
	
	 /*private String generateBookingNumber() {
	        // Define the length of the booking number
	        int length = 8;
	        
	        // Define the characters allowed in the booking number
	        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
	        
	        // Create a random object
	        Random random = new Random();
	        
	        // Generate the booking number
	        StringBuilder bookingNumber = new StringBuilder();
	        for (int i = 0; i < length; i++) {
	            int index = random.nextInt(characters.length());
	            bookingNumber.append(characters.charAt(index));
	        }
	        
	        return bookingNumber.toString();*/
	    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
