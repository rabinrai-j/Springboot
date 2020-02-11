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
<form id="MyClass" action="/submit" method="Post">
<div class="container">
    	
        <div class="container center_div">
            <div class="form-group col-lg-3">
                <label for="code">Username</label>
                <input type="text" class="form-control" name = "name" />
            </div>
        </div>

        <div class="container center_div">
            <div class="form-group col-lg-3 ">
                <label for="code">Id</label>
                <input type="text" class="form-control input-normal" name = "id" />
            </div>
        </div>
        
         <div class="form-group form-check">
    		<label class="form-check-label">
      			<input class="form-check-input" type="checkbox"> Remember me
    		</label>
  		</div>
  
        <div class="container center_div">
            <button type="submit" class="btn btn-default">Submit</button>
        </div>
  
</div>
</div>
</form>
</body>

</html>