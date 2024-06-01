<%@page import="org.jsp.entity.Admin"%>
<%@page import="org.jsp.entity.Hotel"%>
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
      label{
        color: white;
      } 
      h2{
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
                      <li><a class="dropdown-item" href="http://localhost:8080/Hotel-Managment/admin/UsersLists.jsp">User List</a></li>
                    </ul>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                      Booking
                    </a>
                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                      <li><a class="dropdown-item" href="/http://localhost:8080/Hotel-Managment/admin/BookingList.jsp">Booking List</a></li>
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
    	//get hotel Id from url
    	int adminId=Integer.parseInt(request.getParameter("adminId"));
    	//call gethotelById
    	AdminDao adminDao=new AdminDaoImpl();
    	Admin admin=adminDao.getAdminById(adminId);
    	if(admin != null){
    %>
    <div class="container  w-50 p-3 m-5">
        <div class="row justify-content-left">
          <div class="col-md-8">
              <h2 class="mb-4 " >Update Admin Profile</h2>
              <form action="../UpdateAdmin"  method="post">
                  <div class="row mb-3">
                      <div class="col">
                          <label for="hotelname" class="form-label">First Name</label>
                          <input type="text" class="form-control"  placeholder="First Name" name="fName" required
                          value="<%= admin.getFirstName() %>" >
                      </div>
                      <div class="col">
                          <label for="hotelname" class="form-label">Last Name</label>
                          <input type="text" class="form-control"  placeholder="Last Name" name="lName" required
                          value="<%= admin.getLastName() %>" >
                      </div>
                      
                  </div>
                  <div class="row mb-3">
                      <div class="col">
                          <label for="contact" class="form-label">Contact Number :</label>
                          <input type="number" class="form-control" placeholder="Contact Number "  name="contact"  required 
                          value="<%= admin.getMobile() %>">
                      </div>
                       <div class="col">
                          <label for="address" class="form-label">Email :</label>
                          <input type="email" class="form-control"  placeholder="Email" name="email"  required 
                          value="<%= admin.getEmail()%>">
                      </div>
                  </div>
                  <div class="row mb-3">
                     
                      <div class="col">
                          <label for="address" class="form-label">Password :</label>
                          <input type="text" class="form-control"  placeholder="Enter Address" name="password"  required 
                          value="<%= admin.getPassword()%>">
                      </div>
                       <div class="col">
                     </div>
                  </div>
                   
                  <input hidden value="<%= admin.getId()%>" name="adminId">
                   <button type="submit" class="btn btn-outline-dark" style="background:gray  ; color: black;">Update Admin</button> 
                  <!-- <a href="#" id="btn" class="button btn btn-outline-dark"> ADD HOTEL</a> -->
              </form>
          </div>        
        </div>
      </div>
      <% }
    	else{
      %>
      <center> <h2 style="color: white;"> Error While Fetching Hotel Details. Verify Hotel Id</h2> </center>
      <%} %>

</body>
</html>