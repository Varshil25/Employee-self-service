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
	<%-- <%@include file="admindashboard.jsp"%> --%>
	<div class="container-fluid p-0">
		<nav class="navbar navbar-light" style="background: #1d1b31">
			<a class="navbar-brand text-light" href="#"> <i
				class="fas fa-users"></i> Employee Self Service (Admin Panel)
			</a>

			<form action="logout" method="post">
				<div class="form-inline">
					<i class="fas fa-user text-light mr-sm-4"></i>
					<button onclick="logout()"
						class="btn btn-outline-success my-2 my-sm-0" type="submit">
						<i class="fas fa-sign-out-alt"></i> Logout
					</button>
				</div>
			</form>
		</nav>
	</div>

	<div class="container-fluid mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center">-- Employee List --</h1>
				<div class="table-responsive">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Emp_Id</th>
								<th scope="col">Emp_Name</th>
								<th scope="col">Email</th>
								<th scope="col">Password</th>
								<th scope="col">Position</th>
								<th scope="col">Role</th>
								<th scope="col">Emp_Address</th>
								<th scope="col">Gender</th>
								<th scope="col">Blood_Group</th>
								<th scope="col">DOB</th>
								<th scope="col">Mo. Number</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${users}" var="user">
								<tr>
									<td>${user.id}</td>
									<td>${user.name}</td>
									<td>${user.email}</td>
									<td>${user.password}</td>
									<td>${user.position}</td>
									<td>${user.role}</td>
									<td>${user.address}</td>
									<td>${user.gender}</td>
									<td>${user.bloodGroup}</td>
									<td>${user.dob}</td>
									<td>${user.number}</td>
									<td><a href="delete/${user.id}"><i
											class="fas fa-trash text-danger" style="font-size: 20px;"></i></a>
										<a href="update/${user.id}"><i
											class="fas fa-pen-nib text-primary" style="font-size: 20px;"></i></a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="container text-center">
					<a href="javascript:history.back()" class="btn btn-outline-danger">Back</a>
					<a href="add-employee" class="btn btn-outline-success">Add Employee</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>