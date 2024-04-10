<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Poppins", sans-serif;
}
</style>
</head>
<body>

	<%-- <%@include file="admindashboard.jsp"%> --%>
	<div class="container-fluid p-0">
		<nav class="navbar navbar-light" style="background: #1d1b31">
			<a class="navbar-brand text-light" href="#"> <i
				class="fas fa-users"></i> Employee Self Service (Admin Panel)
			</a>

			<form action="logout" method="post">
				<div class="form-inline my-2 my-lg-0">
					<i class="fas fa-user text-light mr-sm-4"></i>

					<button onclick="logout()"
						class="btn btn-outline-success my-2 my-sm-0" type="submit">
						<i class="fas fa-sign-out-alt"></i> Logout
					</button>
				</div>
			</form>
		</nav>
	</div>

	<c:if test="${not empty addemployeeMessage }">
		<div class="text-center" style="color: red; font-size: 30px;">${addemployeeMessage }</div>
		<script>
        		setTimeout(function() {
        			window.location.href = "";
        		}, ${delay});
   			</script>
	</c:if>


	<div class="container mt-4">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<h2 class="text-center">Add Employee</h2>

				<form action="handle-employee" method="post">




					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Email Id :</label>
						<div class="col-sm-9">
							<input type="text" name="email" class="form-control"
								placeholder="Enter Email Id">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Password :</label>
						<div class="col-sm-9">
							<input type="password" name="password" class="form-control"
								placeholder="Enter Password">
						</div>
					</div>

					<div class="form-group row">
						<label for="role" class="col-sm-3 col-form-label">Role :</label>
						<div class="col-sm-9">
							<select name="role" class="form-control">
								<option disabled="disabled" selected="selected">--Select
									Role--</option>
								<option>Admin</option>
								<option>Employee</option>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Name :</label>
						<div class="col-sm-9">
							<input type="text" name="name" class="form-control"
								placeholder="Enter Name here">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Address :</label>
						<div class="col-sm-9">
							<textarea rows="2" name="address" class="form-control"
								placeholder="Enter Your Address"></textarea>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Position :</label>
						<div class="col-sm-9">
							<input type="text" name="position" class="form-control"
								placeholder="Position of Employee">
						</div>
					</div>

					<div class="form-group row">
						<label for="gender" class="col-sm-3 col-form-label">Gender:</label>
						<div class="col-sm-9">
							<div class="form-check">
								<input class="form-check-input" type="radio" name="gender"
									value="male"> <label class="form-check-label"
									for="male">Male</label>
							</div>

							<div class="form-check">
								<input class="form-check-input" type="radio" name="gender"
									value="female"> <label class="form-check-label"
									for="female">Female</label>
							</div>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Blood Group :</label>
						<div class="col-sm-9">
							<input type="text" name="bloodGroup" class="form-control"
								placeholder="Enter Blood Group">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Date of Birth :</label>
						<div class="col-sm-9">
							<input type="date" name="dob" class="form-control"
								placeholder="yyyy/mm/dd">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Phone Number:</label>
						<div class="col-sm-9">
							<input type="number" name="number" class="form-control"
								placeholder="Enter Your Phone Number">
						</div>
					</div>


					<div class="form-group text-center">
						<a href="javascript:history.back()" class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-outline-success">Add
							Employee</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>