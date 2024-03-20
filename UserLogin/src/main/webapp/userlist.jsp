<%@page import="com.entity.User"%>
<%@page import="com.dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.conn.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.conn.DBConnect" %>   
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Font Icon -->
<link rel="stylesheet"
	href="fonts/material-icon/css/material-design-iconic-font.min.css">

<!-- Main css -->
<link rel="stylesheet" href="css/style.css">



</head>
<body>


<div class="container p-5">
<div class="card">
<div class="card-body">
<p class="text-center fs-3">All User Data</p>
<c:if test="${not empty succMsg}">
<p class="text-center text-success">${succMsg}</p>
<c:remove var="succMsg"/>
</c:if>
<c:if test="${not empty errorMsg}">
<p class="text-center text-success">${errorMsg}</p>
<c:remove var="errorMsg"/>
</c:if>

<table class="table">
  <thead>
    <tr>
      <th scope="col">User Id</th>
      <th scope="col">Name</th>
      <th scope="col">Email</th>
      <th scope="col">Contact</th>
      
    </tr>
  </thead>
  <tbody>
  
  
  <%
 
  UserDao dao =new UserDao(DBConnect.getConn());
  List<User>list=dao.AllUser();
  for(User s:list)
  {
  %>
	
   <tr>
      <th scope="row"><%=s.getId() %></th>
      <td><%=s.getUname()%></td>
      <td><%=s.getUemail() %></td>
      <td><%=s.getUmobile() %></td>
      
      <td> <a href="edituser.jsp?id=<%=s.getId() %>" class="btn btn-sm btn-primary">Edit</a></td>
       <td> <a href="delete?id=<%=s.getId() %>" class="btn btn-sm btn-danger ms-1">Delete</a></td>
    
    </tr>
   
      <% 
  }
  
  %>
  </tbody>
</table>
</div>


</div></div>
<!-- JS -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
</body>
</html>