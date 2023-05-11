<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TRAVEL SEARCH</title>
</head>
<body>

<div align= center>
<h1>Welcome To FlyAway Airlines Booking Portal</h1><br><br>
<h1> Airlines Search Form</h1>

  <form action = "flights" method="post">
   Date of Travel <input type="date" id="date" name="date"><br><br>
   Source <input type="text" id="source" name="source"><br><br>
   Destination <input type="text" id="destination" name="destination"><br><br>
   Number of Persons <input type="number" id="persons" name="persons"><br><br>
   
   <input type="submit" value= "Search">
  </form>
</div>

</body>
</html>