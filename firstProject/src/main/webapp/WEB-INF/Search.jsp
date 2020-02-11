<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<form id="MyClass" action="/search" method="get">
		<table class="table-bordered table-dark">
			<thead>
				<tr>
					<th style="width: 30%">Sl.No</th>
					<th style="width: 30%">Name</th>
					<th style="width: 30%">ID</th>
					<th style="width: 30%">Modify</th>
					<th style="width: 30%">Option</th>

				</tr>
			</thead>
			<tbody>
				<%-- <tr>
      <td >1</td>
      <td>${name}</td>
      <td>${id}</td>
      <td><button type="submit"  <a href="<c:url value="/test/${object.argument}" />" >hello</a> class="btn btn-primary btn-sm">Edit</button></td>
     
       <td><a href="/edit/${name}/${id}" >Edit</a></td>
     
    </tr> --%>
				<c:forEach items="${myUserList}" var="user">
					<tr>
						<td >1</td>
						<td> <c:out value="${user.empName}" /></td>
						<td><c:out value="${user.empId}" /></td>
						<!-- <td><button type="submit"  <a href="<c:url value="/test/${object.argument}" />" >hello</a> class="btn btn-primary btn-sm">Edit</button></td> -->
						<td><a href="/edit/${user.empName}/${user.empId}" > Edit</a></td>
						<td><a href="/myDelete/${user.empName}/${user.empId}" > Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</form>

	<form id="MyClass" action="/back" method="get">
		<div class="text-center">
			<button type="submit" class="btn btn-primary btn-sm">Previous</button>
		</div>
	</form>
</body>
</html>