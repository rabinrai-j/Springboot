<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="ISO-8859-1">
   <title>Login Page</title>
   <!--Made with love by Mutiullah Samim -->
   
	<!--Bootsrap 4 CDN-->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    
    <!--Fontawesome CDN-->
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

	<!--Custom styles-->
	<link rel="stylesheet" type="text/css" href="styles.css">
</head>
  <body>
<form id="MyClass" action="/saveData" method="Post">
<div class="container">
	<div class="d-flex justify-content-center h-100">
		<div class="card">
			<div class="card-header">
				
			</div>
			<div class="card-body">
				<form>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"></span>
						</div>
						<input type="text" class="form-control" name = "name" placeholder="name" reqquired>
						
					</div>
					<div class="input-group form-group">
						<div class="input-group-prepend">
							<span class="input-group-text"></span>
						</div>
						<input type="text" class="form-control"  name = "id" placeholder="id" required>
					</div>
					
					<div class="form-group">
						<input type="submit" value="Add" class="btn btn-primary btn-sm btn float-right login_btn">
					</div>
				</form>
			</div>
			
			<div class="card-footer">
			<form id="MyClass" action="/signup" method="Get">
			
				
			</form>
				<div class="d-flex justify-content-center">
					<a href="Welcome.jsp">Please add</a>
				</div>
		<form id="MyClass" action="/back" method="get">
		<div class="text-center">
			<button type="submit" class="btn btn-primary btn-sm">Back</button>
		</div>
		</form>
			</div>
		</div>
	</div>
</div> 
</form>
</body>
</html>