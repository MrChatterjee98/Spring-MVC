<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script async src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.min.js" integrity="sha384-ODmDIVzN+pFdexxHEHFBQH3/9/vQ9uori45z4JjnFsRydbmQbmL5t1tQ0culUzyK" crossorigin="anonymous"></script>
<script async src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<style type="text/css">
.form-signin {
  max-width:60%;
  padding: 15px;
}
.m-auto {
  margin: auto !important;
}
.w-100 {
  width: 100% !important;
}
*, ::after, ::before {
  box-sizing: border-box;
}
body {
  display: flex;
  align-items: center;
  padding-top: 40px;
  padding-bottom: 40px;
  background-color: #f5f5f5;
}</style>


<title>Basic CRUD</title>
</head>
<body  >
<main class="form-signin w-100 m-auto">
<div >
<ul class="nav nav-pills nav-justified" id="pills-tab" role="tablist">
  <li class="nav-item" role="presentation">
    <button class="nav-link active" id="pills-insert-tab" data-bs-toggle="pill" data-bs-target="#pills-insert" type="button" role="tab" aria-controls="pills-insert" aria-selected="true">Insert</button>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link" id="pills-getlist-tab" data-bs-toggle="pill" data-bs-target="#pills-getlist" type="button" role="tab" aria-controls="pills-getlist" aria-selected="false">View Student</button>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link" id="pills-update-tab" data-bs-toggle="pill" data-bs-target="#pills-update" type="button" role="tab" aria-controls="pills-update" aria-selected="false">Update</button>
  </li>
  <li class="nav-item" role="presentation">
    <button class="nav-link" id="pills-delete-tab" data-bs-toggle="pill" data-bs-target="#pills-delete" type="button" role="tab" aria-controls="pills-delete" aria-selected="false">Delete</button>
  </li>
</ul>
</div>


<div class="tab-content" id="pills-tabContent">
  <div style="margin: 10px" class="tab-pane fade show active" id="pills-insert" role="tabpanel" aria-labelledby="pills-insert-tab" tabindex="0">
  <form:form action="add" method="post" modelAttribute="student">
  <div class="mb-4">
    <label for="studentId" class="form-label">Enter Student Id</label>
    <form:input type="text" class="form-control" id="studentId" path="studentId"/>
    
  </div>
  <div class="mb-4">
    <label for="firstName" class="form-label">Enter First Name</label>
    <form:input type="text" class="form-control" path="firstName"/>
  </div>
  <div class="mb-4">
    <label for="lastName" class="form-label">Enter Last Name</label>
    <form:input type="text" class="form-control" path="lastName"/>
  </div>
    <div class="mb-4">
    <label for="age" class="form-label">Enter Age</label>
    <form:input  type="text" class="form-control" path="age"/>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form:form>
  </div>
  <div class="tab-pane fade" id="pills-getlist" role="tabpanel" aria-labelledby="pills-getlist-tab" tabindex="0">
  	<form:form action="/find" method="post">
  		<div class="mb-3">
  			<label class="form-label">Enter valid student Id</label>
  			<input class="form-control" type="text" name="studentId" />
  			
  		</div>
  		<button type="submit" class="btn btn-primary">Submit</button>
  		
  	</form:form >
  	<form:form style="margin-top:10px" action="/findall" method="get">
  	<button type="submit" class="btn btn-success">Find All</button></form:form>
  </div>
  <div class="tab-pane fade" id="pills-update" role="tabpanel" aria-labelledby="pills-update-tab" tabindex="0">

  
  	<form:form action="/update" method="post">
  	<div class="mb-3">
    <label for="adminPass" class="form-label">Student Id</label>
    <input type="text" class="form-control" name="id"/>
  </div>
   <div class="dropdown mb-3">
 
  <select  class="btn btn-outline-primary dropdown-toggle" aria-expanded="false" name="option" id="lang" class="dropdown-menu">
    <option value="firstName">First Name</option>
    <option value="lastName">Last Name</option>
    <option value="age">Age</option>
</select>

</div>
  <div class="mb-3">
    <input type="text" class="form-control" name="value"/>
  </div>
  
 
  <button type="submit" class="btn btn-primary">Submit</button>
  
  	</form:form>
</div>
  <div class="tab-pane fade" id="pills-delete" role="tabpanel" aria-labelledby="pills-delete-tab" tabindex="0">
  <form:form action="/delete" method="post">
  		<div class="mb-3">
  			<label class="form-label">Enter valid student Id</label>
  			<input class="form-control" type="text" name="studentId" />
  			
  		</div>
  		<button type="submit" class="btn btn-primary">Submit</button>
  	</form:form>
  
  </div>
</div>
<div>

</div>

</main>
</body>
</html>
