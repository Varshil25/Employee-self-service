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
				<h2 class="text-center" style="font-weight: bolder;">Employee
					Details</h2>
				<form action="com-module" method="post" class="pt-3">


					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Name</label>
						<div class="col-sm-9">
							<input type="text" name="name" class="form-control"
								placeholder="Enter Employee Name">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Position</label>
						<div class="col-sm-9">
							<input type="text" name="position" class="form-control"
								placeholder="Enter Position">
						</div>
					</div>

					<div class="form-group row">
						<label for="department" class="col-sm-3 col-form-label ">Department</label>

						<div class="col-sm-9">
							<select id="department" class="form-control" name="department">
								<option value="Select Department" selected="selected"
									disabled="disabled">-- Select Your Department --</option>
								<option value="Software Development">Software
									Development</option>
								<option value="Software Engineer">Software Engineer</option>
								<option value="Web Development">Web Development</option>
								<option value="QA">QA</option>
								<option value="UI/UX">UI/UX</option>
								<option value="Design">Design</option>
								<option value="BDA">BDA</option>
								<option value="Mobile Application Development">Mobile
									Application Development</option>
								<option value="Sales">Sales</option>
								<option value="Devops">Devops</option>
								<option value="HR">HR</option>
								<option value="Accounts & Finance">Accounts & Finance</option>
							</select>
						</div>
					</div>
					`

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Email</label>
						<div class="col-sm-9">
							<input type="text" name="email" class="form-control"
								placeholder="Enter Email Id">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Mo. Number</label>
						<div class="col-sm-9">
							<input type="number" name="number" class="form-control"
								placeholder="Enter Mo. Number">
						</div>
					</div>

					<div class="form-group row">
						<label class="col-sm-3 col-form-label">Comment</label>
						<div class="col-sm-9">
							<textarea rows="2" name="comment" class="form-control"
								placeholder="Comment here"></textarea>
						</div>
					</div>



					<div class="form-group text-center">
						<button type="submit" class="btn btn-outline-success">Save</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<div class="container mt-2">
		<div class="row">
			<div class="col-md-12">
				<h2 class="text-center">--Communication List --</h2>
				<div class="table-responsive">
					<table class="table">
						<thead class="thead-dark">
							<tr>
								<th scope="col">Id</th>
								<th scope="col">Name</th>
								<th scope="col">Position</th>
								<th scope="col">Department</th>
								<th scope="col">Email</th>
								<th scope="col">Mo.Number</th>
								<th scope="col">Comment</th>
								<th scope="col">Action</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${communications}" var="c">
								<tr>
									<td>${c.id}</td>
									<td>${c.name}</td>
									<td>${c.position}</td>
									<td>${c.department}</td>
									<td>${c.email}</td>
									<td>${c.number}</td>
									<td>${c.comment}</td>
									<td><a href="deleteCom/${c.id}"><i
											class="fas fa-trash text-danger" style="font-size: 20px;"></i></a>
										<a href="updateCom/${c.id}"><i
											class="fas fa-pen-nib text-primary" style="font-size: 20px;"></i></a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="container text-center">
					<a href="javascript:history.back()" class="btn btn-outline-danger">Back</a>
					<a href="Communication-module" class="btn btn-outline-success">Add
						Employee Details</a>
				</div>
			</div>
		</div>
	</div>

</body>
</html>