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
    max-width: 330px;
    padding: 15px;
}
main.form-signin.w-100.m-auto {
}

.m-auto {
    margin: auto!important;
}
.w-100 {
    width: 100%!important;
}
.form-floating {
    position: relative;
    margin-bottom: 5px;
}
</style>
<title>Registration page</title>
</head>
<body class="text-center" data-new-gr-c-s-check-loaded="14.1078.0" data-gr-ext-installed="">
<main class="form-signin w-100 m-auto">
  <form:form action="/registration" modelAttribute="login">
    <img class="mb-4" src="https://img.icons8.com/color/480/000000/spring-logo.png" alt="" width="70" height="70">
    <h1 class="h3 mb-3 fw-normal">Register For User</h1>

    <div class="form-floating">
      <form:input type="text" class="form-control" id="floatingInput" path="username"></form:input>
      <label for="floatingInput">User Name</label>
    </div>
    <div class="form-floating">
      <form:input type="password" class="form-control" id="floatingPassword" path="password" ></form:input>
      <label for="floatingPassword">Password</label>
    </div>

    <div class="checkbox mb-3">
      <form:select  class="btn btn-outline-primary dropdown-toggle" aria-expanded="false" path="role">
    <option value="admin">admin</option>
    <option value="student">student</option>
    
</form:select>
      
    </div>
    <button style="background-color:#8BC34A" class="w-100 btn btn-lg btn-success" type="submit">Register</button>
   
  </form:form>
      <form:form action="/" method="post">

    <div class="checkbox mb-3">
      
    </div>
    <button style="background-color:#8BC34A" class="w-100 btn btn-lg btn-success" type="submit">Login</button>
   
  </form:form>
 </main>
</body>
</html>