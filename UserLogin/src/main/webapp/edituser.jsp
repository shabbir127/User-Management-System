<%@page import="com.entity.User"%>
<%@page import="com.dao.UserDao"%>
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


<div class="container p-4">
<div class="row">
<div class="col-md-6 offset-md-3">
<div class="card">
<div class="card-body">
<p class="fs-3 text-center">Edit User</p>
      
      
      <%
      int id=Integer.parseInt(request.getParameter("id"));
      UserDao dao=new UserDao(DBConnect.getConn());
      User s=dao.getUserById(id);
      
      %>
      
      <form action="update" method="post">
  <div class="mb-3">
    <label class="form-label">Full Name</label>
    <input type="text" class="form-control" name="name" value="<%=s.getUname() %>">
    </div>
    
  <div class="mb-3">
    <label class="form-label">Email</label>
    <input type="email" class="form-control" name="email" value="<%=s.getUemail()%>">
   </div>
   
  <div class="mb-3">
    <label  class="form-label">Contact</label>
    <input type="text" class="form-control" name="mobile" value="<%=s.getUmobile() %>">
   </div>
   
  
   
   <input type="hidden" name="id" value="<%=s.getId()%>">
   
  <button type="submit" class="btn btn-primary">Submit</button>
</form>


     
</div>
</div>
</div>
</div>
</div>




</body>
</html>