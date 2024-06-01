<%@page import="org.jsp.entity.Admin"%>
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
	<%
	Admin adminSession=(Admin)session.getAttribute("adminObj");
	%>
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
    String msg=request.getParameter("msg");
    
    if( msg!=null && msg.equals("adminAdded")){
    %>
    <center> <h2 style="color: white;"> Admin Added Successfully!! </h2> </center>
    <%}else if(msg!=null && msg.equals("admin_update")){%>
    <center> <h2 style="color: white;"> Admin Updated Successfully!! </h2> </center>
    <% }else if(msg!=null && msg.equals("adminDelete")){%>
    <center> <h2 style="color: white;"> Error !! </h2> </center>
    <% }
    AdminDao adminDao=new AdminDaoImpl();
    List<Admin> admins= adminDao.getAllAdminsDetails();
    if(admins!=null){
    %>
    <div class="container">
        <h1>Admin List</h1>
            <table class="table ">
                <thead>
                  <tr>
                    <th scope="col">Id</th> 
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Mobile </th>
                    <th scope="col"> <center>Action</center>  </th>
                  </tr>
                </thead>
                <%for(Admin admin:admins){ %>
                <tbody>
                  <tr>
                    <th scope="row"> <%=admin.getId() %></th>
                    <td><%=admin.getFirstName() %></td>
                    <td><%=admin.getLastName() %></td>
                    <td>********</td>
                    <td><%=admin.getMobile() %></td>
                    <%if(admin.getId()==adminSession.getId()){ %>
                    <td>
                    	<center>
                         <a href="/Hotel-Managment/admin/EditAdmin.jsp?adminId=<%= admin.getId() %>" id="btn" class="button btn btn-outline-dark" >Update</a>
                         &nbsp; 
                         <a href="/Hotel-Managment/DeleteAdmin?adminId=<%= admin.getId() %>" id="btn" class="button btn btn-outline-dark" >Delete</a> 
                         </center>
                    </td>
                    <%}else{ %>
                    <td>
                         
                    </td>
                    <%} %>
                  </tr>
                </tbody>
                <%} %>
              </table>
    </div>
<%} %>
</body>
</html>