<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<div class="container-fluid p-0">
		<nav class="navbar navbar-light bg-dark">
			<a class="navbar-brand text-light" href="#"> <i
				class="fas fa-users"></i> Employee Self Service
			</a>
		</nav>

		<div class="container ">
			<div class="card mx-auto mt-4 bg-light " style="max-width: 50%;">

				<div class="card-body ">
					<div class="text-center">
						<i class="fa-solid fa-user-plus p-1" style="font-size: 60px;"></i>
					</div>
					<h3 class="text-center bg-dark text-light">Login here</h3>
					<c:if test="${not empty rolenull }">
						<div class="text-center" style="color: red; font-size: 30px;">${rolenull }</div>
						<script>
        					setTimeout(function() {
            				window.location.href = "<c:url value='/' />";
        					}, ${delay});
   						 </script>
					</c:if>
					<c:if test="${not empty error }">
						<div class="text-center" style="color: red; font-size: 30px;">${error }</div>
						<script>
        					setTimeout(function() {
            				window.location.href = "<c:url value='/' />";
        					}, ${delay});
    					</script>
					</c:if>
					<c:if test="${not empty message }">
						<div class="text-center" style="color: red; font-size: 30px;">${message }</div>
						<script>
      						  setTimeout(function() {
          					  window.location.href = "<c:url value='/' />";
       						  }, ${delay});
   						 </script>
					</c:if>

					<form action="login" method="post" class="mt-4">
						<div class="form-group">
							<i class="fas fa-user"></i> <label for="exampleInputEmail1">Email
								Id</label> <input type="text" class="form-control"
								id="exampleInputEmail1" name="email"
								aria-describedby="emailHelp" placeholder="Enter Email Id here..">
						</div>
						<div class="form-group">
							<i class="fas fa-lock"></i> <label for="exampleInputEmail1">Password</label>
							<input type="password" class="form-control"
								id="exampleInputEmail1" name="password"
								aria-describedby="emailHelp" placeholder="Enter password">
						</div>
						<div class="form-group">
							<label for="role">Role</label> <select name="roleString"
								class="form-control form-control-lg">

								<option>Select Role</option>
								<option>Admin</option>
								<option>Employee</option>
							</select>
						</div>
						<div class="form-check">
							<input type="checkbox" class="form-check-input"
								id="exampleCheck1"> <label class="form-check-label"
								for="exampleCheck1">Remember me</label>
						</div>
						<div class="form-group text-center">
							<button type="submit" class="btn btn-primary">Login</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>