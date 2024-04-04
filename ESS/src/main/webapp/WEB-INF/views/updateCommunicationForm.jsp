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
		<nav class="navbar navbar-light" style="background: #1d1b31">
			<a class="navbar-brand text-light" href="#"> <i
				class="fas fa-users"></i> Employee Self Service
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


	<div class="container mt-3">
		<div class="row ">
			<div class="col-md-8 offset-md-2">
				<h2 class="text-center" style="font-weight: bolder;">Update
					Employee Details</h2>
				<form action="${pageContext.request.contextPath }/com-module"
					method="post" class="pt-3">


					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Name</label>
						<div class="col-sm-9">
							<input type="text" name="name" class="form-control"
								placeholder="Enter Employee Name" value="${c.name }">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Position</label>
						<div class="col-sm-9">
							<input type="text" name="position" class="form-control"
								placeholder="Enter Position" value="${c.position }">
						</div>
					</div>

					<div class="form-group row">
						<label for="department" class="col-sm-3 col-form-label ">Department</label>

						<div class="col-sm-9">
							<select id="department" class="form-control" name="department">
								<option value="Select Department" selected="selected"
									disabled="disabled">-- Select Your Department --</option>
								<option
									<c:if test="${c.department == 'Software Development'}">selected="selected"</c:if>>Software
									Development</option>
								<option
									<c:if test="${c.department == 'Software Engineer'}">selected="selected"</c:if>>Software
									Engineer</option>
								<option
									<c:if test="${c.department == 'Web Development'}">selected="selected"</c:if>>Web
									Development</option>
								<option
									<c:if test="${c.department == 'QA'}">selected="selected"</c:if>>QA</option>
								<option
									<c:if test="${c.department == 'UI/UX'}">selected="selected"</c:if>>UI/UX</option>
								<option
									<c:if test="${c.department == 'Design'}">selected="selected"</c:if>>Design</option>
								<option
									<c:if test="${c.department == 'BDA'}">selected="selected"</c:if>>BDA</option>
								<option
									<c:if test="${c.department == 'Mobile Application
									Development'}">selected="selected"</c:if>>Mobile
									Application Development</option>
								<option
									<c:if test="${c.department == 'Sales'}">selected="selected"</c:if>>Sales</option>
								<option
									<c:if test="${c.department == 'Devops'}">selected="selected"</c:if>>Devops</option>
								<option
									<c:if test="${c.department == 'HR'}">selected="selected"</c:if>>HR</option>
								<option
									<c:if test="${c.department == 'Accounts & Finance'}">selected="selected"</c:if>>Accounts
									& Finance</option>
							</select>
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Email</label>
						<div class="col-sm-9">
							<input type="text" name="email" class="form-control"
								placeholder="Enter Email Id" value="${c.email }">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Mo. Number</label>
						<div class="col-sm-9">
							<input type="number" name="number" class="form-control"
								placeholder="Enter Mo. Number" value="${c.number }">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Comment</label>
						<div class="col-sm-9">
							<textarea rows="2" name="comment" class="form-control"
								placeholder="Comment here">${c.comment }</textarea>
						</div>
					</div>

					<div class="form-group text-center">
						<a href="javascript:history.back()" class="btn btn-outline-danger">Back</a>
						<button type="submit" class="btn btn-outline-success">Update</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>