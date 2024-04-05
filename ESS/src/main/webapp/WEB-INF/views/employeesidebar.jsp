<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>

<style type="text/css">
/* Created by Tivotal */

/* Google fonts(Poppins) */
@import
	url("https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap")
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Poppins", sans-serif;
}

.sidebar {
	position: fixed;
	top: 56px;
	left: 0;
	width: 400px;
	height: 100vh;
	background-color: #11101d;
	z-index: 100;
	transition: all 0.5s ease;
	background-color: #11101d;
}

.sidebar.close {
	width: 78px;
}

.sidebar .logo {
	height: 60px;
	display: flex;
	width: 100%;
	align-items: center;
}

.sidebar .logo i {
	font-size: 30px;
	color: #fff;
	height: 50px;
	min-width: 78px;
	text-align: center;
	line-height: 50px;
}

.sidebar .logo .logo-name {
	font-size: 22px;
	color: #fff;
	font-weight: 600;
	transition: all 0.3s ease;
	transition-delay: 0.1s;
}

.sidebar.close .logo .logo-name {
	opacity: 0;
	pointer-events: none;
}

.sidebar .nav-list {
	height: 100%;
	padding: 30px 0 150px 0;
	overflow: auto;
}

.sidebar.close .nav-list {
	overflow: visible;
}

.sidebar .nav-list::-webkit-scrollbar {
	display: none;
}

.sidebar .nav-list li {
	position: relative;
	list-style: none;
	transition: all 0.4s ease;
}

.sidebar .nav-list li:hover {
	background-color: #1d1b31;
}

.sidebar .nav-list li .icon-link {
	display: flex;
	align-items: center;
	justify-content: space-between;
}

.sidebar.close .nav-list li .icon-link {
	display: block;
}

.sidebar .nav-list li i {
	height: 50px;
	min-width: 78px;
	text-align: center;
	line-height: 50px;
	color: #fff;
	font-size: 20px;
	cursor: pointer;
	transition: all 0.3s ease;
}

.sidebar.close .nav-list li i.arrow {
	display: none;
}

.sidebar .nav-list li.show i.arrow {
	transform: rotate(-180deg);
}

.sidebar .nav-list li a {
	display: flex;
	align-items: center;
	text-decoration: none;
}

.sidebar .nav-list li a .link-name {
	color: #fff;
	font-size: 18px;
	font-weight: 400;
	transition: all 0.4s ease;
}

.sidebar.close .nav-list li a .link-name {
	opacity: 0;
	pointer-events: none;
}

.sidebar .nav-list li .sub-menu {
	padding: 6px 6px 14px 80px;
	margin-top: -10px;
	background: #1d1b31;
	display: none;
	transition: all 0.3s ease;
}

.sidebar .nav-list li.show .sub-menu {
	display: block;
}

.sidebar.close .nav-list li .sub-menu {
	position: absolute;
	left: 100%;
	top: -10px;
	margin-top: 0;
	padding: 10px 20px;
	border-radius: 0 6px 6px 0;
	opacity: 0;
	display: block;
	pointer-events: none;
	transition: 0s;
}

.sidebar.close .nav-list li:hover .sub-menu {
	top: 0;
	opacity: 1;
	pointer-events: auto;
	transition: all 0.4s ease;
}

.sidebar .nav-list li .sub-menu a {
	color: #fff;
	font-size: 15px;
	padding: 5px 0;
	white-space: nowrap;
	opacity: 0.6;
	transition: all 0.3s ease;
}

.sidebar .nav-list li .sub-menu a:hover {
	opacity: 1;
}

.sidebar .nav-list li .sub-menu .link-name {
	display: none;
}

.sidebar.close .nav-list li .sub-menu .link-name {
	font-size: 18px;
	opacity: 1;
	display: block;
}

.sidebar .nav-list li .sub-menu.blank {
	padding: 3px 20px 6px 16px;
	opacity: 0;
	pointer-events: none;
}

.sidebar .nav-list li:hover .sub-menu.blank {
	top: 50%;
	transform: translateY(-50%);
}

.profile-details {
	position: fixed;
	bottom: 0;
	width: 400px;
	display: flex;
	align-items: center;
	justify-content: space-between;
	background-color: #1d1b31;
	padding: 12px 0;
	transition: all 0.5s ease;
}

.sidebar.close .profile-details {
	background-color: none;
	width: 78px;
	position: fixed;
}

.profile-details .profile-content {
	display: flex;
	align-items: center;
}

.profile-details .profile-content img {
	height: 51px;
	width: 51px;
	border-radius: 50%;
	object-fit: cover;
	margin: 0 14px 0 12px;
	background-color: #1d1b31;
	transition: all 0.5s ease;
}

.sidebar.close .profile-details .profile-content img {
	padding: 10px;
}

.profile-details .name-job .name, .profile-details .name-job .job {
	color: #fff;
	font-size: 18px;
	white-space: nowrap;
}

.sidebar.close .profile-details i, .sidebar.close .profile-details .name-job .name,
	.sidebar.close .profile-details .name-job .job {
	opacity: 0;
	pointer-events: none;
}

.profile-details .name-job .job {
	font-size: 12px;
}

.home-section {
	position: relative;
	/* 	height: 100vh; */
	width: calc(9% - 78px);
	left: 400px;
	background-color: #e4e9f7;
	transition: all 0.5s ease;
}

.sidebar.close ~ .home-section {
	left: 78px;
	width: calc(9% - 78px);
}

.home-section .home-content {
	display: flex;
	height: 60px;
	align-items: center;
}

.home-section .home-content i, .home-section .home-content .text {
	color: #11101d;
	font-size: 35px;
}

.home-section .home-content i {
	margin: 0 15px;
	cursor: pointer;
}

.home-section .home-content .text {
	white-space: nowrap;
	font-size: 20px;
	font-weight: 600;
}

.main {
	position: relative;
}

.main .sidebar {
	position: absolute;
}

@media ( max-width : 400px) {
	.sidebar.close .nav-list li .sub-menu {
		display: none;
	}
	.sidebar {
		width: 78px;
	}
	.sidebar.close {
		width: 0;
	}
	.home-section {
		left: 78px;
		width: calc(9% - 78px);
		z-index: 100;
	}
	.sidebar.close ~ .home-section {
		width: 9%;
		left: 0;
	}
}
</style>
</head>
<body>
	<div class="main">

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

		<div class="sidebar close">
			<div class="logo">
				<i class="fas fa-address-card"></i> <span class="logo-name">ESS</span>
			</div>

			<ul class="nav-list">
				<li><a href="dashboard"> <i class="fab fa-microsoft"></i> <span
						class="link-name">Dashboard</span>
				</a>
					<ul class="sub-menu">
						<li><a href="dashboard" class="link-name">Dashboard</a></li>
					</ul></li>
				<li>
					<div class="icon-link">
						<a href="#"> <i class="fas fa-bell"></i><span
							class="link-name">Notifications</span>
						</a> <i class="fas fa-caret-down arrow"></i>
					</div>

					<ul class="sub-menu">
						<li><a href="#" class="link-name">Notifications</a></li>
						<li><a href="show-Event">Event </a></li>
						<li><a href="show-Holiday">Holiday Schedule</a></li>
						<li><a href="show-Training">Training Details</a></li>
						<li><a href="/ESS/display-report/ESSUserGuide">UserGuide</a></li>
					</ul>
				</li>

				<li>
					<div class="icon-link">
						<a href="#"> <i class="fas fa-user-clock"></i> <span
							class="link-name">Time Attendance </span>
						</a> <i class="fas fa-caret-down arrow"></i>
					</div>

					<ul class="sub-menu">
						<li><a href="#" class="link-name">Time Attendance </a></li>
						<li><a href="#">Web Design</a></li>
						<li><a href="#">Card Design</a></li>
						<li><a href="#">Form Design</a></li>
					</ul>
				</li>

				<li>
					<div class="icon-link">
						<a href="list-leave"> <i class="fas fa-calendar-alt"></i> <span
							class="link-name">Leave Management</span>
						</a> <i class="fas fa-caret-down arrow"></i>
					</div>

					<ul class="sub-menu">
						<li><a href="#" class="link-name">Leave Management</a></li>
						<!-- <li><a href="#">Leave Balance</a></li> -->
						<li><a href="add-leave">Leave Application</a></li>
						<li><a href="list-leave">List Leave</a></li>
					</ul>
				</li>

				<li><a href="show-Communication-module"> <i
						class="fas fa-comments"></i> <span class="link-name">Communication</span>
				</a>

					<ul class="sub-menu blank">
						<li><a href="show-Communication-module" class="link-name">Communication</a></li>
					</ul></li>


				<li>
					<div class="profile-details">
						<div class="profile-content">
							<img src="varshil.jpeg" alt="error" />
						</div>

						<div class="name-job">
							<div class="name">Varshil Patel</div>
							<div class="job">Java Developer</div>
						</div>
						<i class="fas fa-arrow-alt-circle-right"></i>
					</div>
				</li>
			</ul>
		</div>

		<div class="home-section">

			<div class="home-content">
				<i class="fas fa-bars"></i>
			</div>

		</div>
	</div>

	<script type="text/javascript">
	let btn = document.querySelector(".fa-bars");
	let sidebar = document.querySelector(".sidebar");

	btn.addEventListener("click", () => {
	  sidebar.classList.toggle("close");
	});

	let arrows = document.querySelectorAll(".arrow");
	for (var i = 0; i < arrows.length; i++) {
	  arrows[i].addEventListener("click", (e) => {
	    let arrowParent = e.target.parentElement.parentElement;

	    arrowParent.classList.toggle("show");
	  });
	}
	</script>
</body>
</html>
