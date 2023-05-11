package com.flight;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/flights")
public class Flights extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		String date = request.getParameter("date");
		String source = request.getParameter("source");
		String destination = request.getParameter("destination");
		int persons = Integer.parseInt(request.getParameter("persons"));
		
		
		
		 String url ="jdbc:mysql://localhost:3306/flightbooking";
			String uname= "root";
			String pass = "root";
			Connection con= null;
			PreparedStatement st = null;
			ResultSet rs= null;
		
         String query ="SELECT f.flightid, a.airlinename, p1.placename AS sourceplacename, p2.placename AS destination, f.ticketprice FROM flights f JOIN airlines a ON f.airlineid = a.airlineid JOIN places p1 ON f.sourceplaceid = p1.placeid JOIN places p2 ON f.destinationplaceid = p2.placeid WHERE f.travelDate =? AND p1.placename =? AND p2.placename =? ";
			
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pass);
			st = con.prepareStatement(query);
			st.setString(1, date);
            st.setString(2, source);
            st.setString(3, destination);
            
			rs = st.executeQuery();
			
			out.println("<h1> Available Airlines Details</h1>");
			out.println("<p> Airlines available for " + persons + " persons on " + date + " from " + source + " to " + destination + ":</p>");
            out.println("<table><tr><th>Flight Number</th><th>FlightName</th><th>Source</th><th>Destination</th><th>Price per Person</th><th>Total Price</th></tr>");
            
            while (rs.next()) {
                int flightNumber = rs.getInt(1);
                String flightName = rs.getString(2);
                String Source = rs.getString(3);
                String Destination = rs.getString(4);
                double price = rs.getDouble(5);
             double totalPrice = price * persons;
                
              out.println("<tr><td>" + flightNumber + "</td><td>" + flightName + "</td><td>" + Source + "</td><td>" + Destination
                        + "</td><td>" + price + "</td><td>"+ totalPrice+"</td><td>"+"<br><br>");
             
             out.println("<a href='register.jsp'>Book Tickect</a>");
             
             context.setAttribute("flightNumber", flightNumber);
             context.setAttribute("flightName", flightName);
             context.setAttribute("source", Source);
             context.setAttribute("destination", Destination);
             context.setAttribute("price", totalPrice);
             
  }
            out.println("</table></body></html>");
            
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