<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<form id="MyClass" action="/jsp" method="get">
<button type="submit"  class="btn btn-primary btn-sm">Home</button>
</form>

<form id="MyClass" action="/add" method="get">
<div class = "text-right">
<button type="submit"  class="btn btn-primary btn-sm">Add</button>
</div>
</form>



<table>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <form id ="MyClass"  class="navbar-form navbar-left" action="/search" method = "get">
      <div class="form-group">
       <input type="text" class="form-control" name = "name" placeholder="Search" required = "text">
      </div>
      <button type="submit" class="btn btn-default">Submit</button>
    </form>
  </div>
</nav>
</table>
</body>

<body>

Hi Everyone!!

Thank you for showing interest...


<p>Spring Boot makes it easy to create stand-alone, production-grade Spring based Applications that you can "just run".We take an opinionated view of the Spring </p>
platform and third-party libraries so you can get started with minimum fuss. Most Spring Boot applications need very little Spring configuration.



<form id="MyClass" action="/logout" method="get">

<div class = "text-center">
<button type="submit"  class="btn btn-primary btn-sm">Logout</button>
</div>
</form>


</body>
</html>