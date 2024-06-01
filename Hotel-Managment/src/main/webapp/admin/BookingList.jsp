<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDateTime"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.mysql.cj.protocol.x.ErrorToFutureCompletionHandler"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="org.jsp.dao.CustomerDaoImpl"%>
<%@page import="org.jsp.dao.CustomerDao"%>
<%@page import="org.jsp.entity.Customer"%>
<%@page import="org.jsp.entity.BookingDetails"%>
<%@page import="java.util.List"%>
<%@page import="org.jsp.dao.AdminDaoImpl"%>
<%@page import="org.jsp.dao.AdminDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel</title>
    <style>
        body {
        margin: 0;
        padding: 0;
        background-image: url("http://localhost:8080/Hotel-Managment/image/Owall-Hotel-Seoul-Exterior.jpeg");
        background-repeat:no-repeat;
        background-position: inherit;
        /* background-size: cover; */
        background-attachment: fixed;
        background-size: 100% 100%;
        /* height: 300px; */
        /* position: absolute; */
       }
       a{
        color: white;
       }
      .navbar {
        background-color: rgba(0, 0, 0, 0.5); /* Use RGBA with alpha value less than 1 for transparency */
        }
        .navbar-nav .nav-item a.nav-link {
        color: white; /* Set the text color to white */
        }
        #btn{
        color: white;
      }
      label,h1,th,td{
        color: white;
      }
    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light navbar-expand-md">
        <a href="" class="navbar-brand" style="color: white;"> <img src="https://w7.pngwing.com/pngs/927/770/png-transparent-hotel-logo-resort-suite-investment-banking-letter-b-angle-company-text.png" width="50px" style="border-radius: 10px;" alt="No img"> Hotel Booking System</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
              <ul class="navbar-nav">
                <li class="nav-item active">
                  <a class="nav-link " href="http://localhost:8080/Hotel-Managment/admin/Home1.jsp">Home</a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Hotels
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="http://localhost:8080/Hotel-Managment/admin/AddHotel.jsp">Add Hotel</a></li>
                      <li><a class="dropdown-item" href="http://localhost:8080/Hotel-Managment/admin/HotelList.jsp">Hotel List</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Users
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="http://localhost:8080/Hotel-Managment/admin/AddUsers.jsp">Add Users</a></li>
                      <li><a class="dropdown-item" href="http://localhost:8080/Hotel-Managment/admin/UserLists.jsp">User List</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Booking
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="http://localhost:8080/Hotel-Managment/admin/BookingList.jsp">Booking List</a></li>
                    </ul>
                </li>
               
              </ul>
        </div>
        <ul class="navbar-nav ml-auto"> <!-- Add ml-auto class to push "Contact" to the right -->
          <li class="nav-item">
            <a class="nav-link" href="../adminLogout">LogOut</a>
          </li>
        </ul>
    </nav>
    <%
	    AdminDao adminDao=new AdminDaoImpl();
	    List<BookingDetails> details=adminDao.getAllBookingDetails();
	   if(details!=null){
    %>
    
    <div class="container">
        <h1>All Booking Histrory</h1>
            <table class="table ">
                <thead>
                  <tr>
                   	<th scope="col">Id</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Mobile</th>
                    <th scope="col">Booking Date & Time</th>
                    <th scope="col">Hotel Name</th>
                    <th scope="col">CheckIn</th>
                    <th scope="col">CheckOut</th>
                    <th scope="col">No of Days</th>
                    <th scope="col">No of Persons</th>
                    <th scope="col">No of Rooms</th>
                    <th scope="col">Price</th>
                    <th scope="col">status</th>
                  </tr>
                </thead>
                <tbody>
                <%for(BookingDetails detail:details){ 
                	
                	if(detail.getCustomer().getFirstName()!= null){
                %>
                
                  <tr>
                    <th scope="row"><%=detail.getId() %></th>
                    <td><%=detail.getCustomer().getFirstName() %></td>
                    <td><%=detail.getCustomer().getLastName()%></td>
                    <td><%=detail.getCustomer().getEmail() %></td>
                    <td><%=detail.getCustomer().getMobile()%></td>
                    <td><%=detail.getBookingDateTime().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) %></td>
                    <td><%=detail.getHotel().getHotelName() %></td>
                    <td><%=detail.getStartDate() %></td>
                    <td><%=detail.getEndDate() %></td>
                    <td><%=detail.getNoOfDays() %></td>
                    <td><%=detail.getNoOfPerson() %></td>
                    <td><%=detail.getNoOfRoom()%></td>
                    <td><%=detail.getTotalPrice()%></td>
                    <td><%=detail.getStatus() %></td>
                  </tr>
                  <%}
                	}
                }%>
                </tbody>
              </table>
    </div>

</body>
</html>