<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Bootstrap Header</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/5.1.3/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<style>
/* Custom styles for this template */
.navbar-custom {
	background-color: #F4F5F6; /* Màu nền xám */
}

.navbar-custom .navbar-brand, .navbar-custom .navbar-text {
	color: rgba(255, 255, 255, .8); /* Màu chữ trắng */
}

.navbar-custom .navbar-nav .nav-link {
	color: #333; /* Màu chữ trắng xám nhạt */
}

.navbar-custom .navbar-nav .nav-link:hover, .navbar-custom .navbar-nav .nav-link:focus
	{
	color: #9AC9FF; /* Màu chữ trắng khi hover */
}

.navbar-custom .navbar-nav .active>.nav-link {
	color: #fff; /* Màu chữ trắng cho mục active */
}

.navbar-nav .nav-item {
	margin-right: 20px; /* Khoảng cách giữa các mục */
}

.pe-3 a {
	color: black; /* Màu của các biểu tượng */
	margin: 0 10px;
}

.pe-3 a:hover {
	color: #FFD43B;
}

#searchButton {
	color: #000;
	background-color: transparent;
	border: none;
	cursor: pointer;
	margin-left: 5px;
}
.search-box {
    display: flex;
}

#searchInput {
    flex: 1; /* Ô input sẽ mở rộng để lấp đầy không gian còn lại */
}


</style>
</head>
<body>
	<nav id="header-nav"
		class="navbar navbar-expand-lg px-3 mb-3 navbar-custom">
		<div class="container-fluid">
			<a class="navbar-brand" href="index.html"> <img
				src="GUI/images/logo_FIMS.png" class="logo"
				style="width: 200px; height: 60px">
			</a>
			<div class="offcanvas offcanvas-end" tabindex="-1" id="bdNavbar"
				aria-labelledby="bdNavbarOffcanvasLabel">
				<div class="offcanvas-body">
					<ul id="navbar"
						class="navbar-nav text-uppercase justify-content-end align-items-center flex-grow-1 pe-3">
						<li class="nav-item"><a class="nav-link me-4 active"
							href="GUI/index.jsp">Home</a></li>
						<li class="nav-item"><a class="nav-link me-4"
							style="color: red" href="#mobile-products">HOT</a></li>
						<li class="nav-item"><a class="nav-link me-4" href="#">Products</a></li>
						<li class="nav-item"><a class="nav-link me-4"
							href="#smart-watches">News</a></li>
						<li class="nav-item"><a class="nav-link me-4"
							href="#yearly-sale">Services</a></li>
						<li class="nav-item dropdown"><a
							class="nav-link me-4 dropdown-toggle link-dark"
							data-bs-toggle="dropdown" href="#" role="button"
							aria-expanded="false">Pages</a>
							<ul class="dropdown-menu">
								<li><a href="about.html" class="dropdown-item">About</a></li>
								<li><a href="blog.html" class="dropdown-item">Blog</a></li>
								<li><a href="cart.html" class="dropdown-item">Cart</a></li>
								<li><a href="checkout.html" class="dropdown-item">Checkout</a></li>
								<li><a href="contact.html" class="dropdown-item">Contact</a></li>
							</ul></li>
						<li class="nav-item">
						<li>
							<form action="search" method="get" class="form-inline my-2 my-lg-0">
								<div class="search-box">
								<input name="txt" type="text" id="searchInput" class="form-control"
									placeholder="Search..." value=${txtV}>
								<button id="searchButton" type="submit" class="btn btn-primary">
									<i class="fa-solid fa-search"></i>
								</button>
							</div>
							</form>
						</li>
						<li class="pe-3"><a href="cart.html"> <i
								class="fa-solid fa-shopping-cart"></i>
						</a></li>
						<li class="pe-3 dropdown">
							<button class="btn btn-warning dropdown-toggle" type="button"
								data-bs-toggle="dropdown" aria-expanded="false">
								<i class="fa-solid fa-user"></i>
							</button>
							<div class="dropdown-menu" id="user-menu">
								<ul class="list-unstyled">
									<li><a href="sign-in">Login</a></li>
									<li><a href="register-signup">Sign Up</a></li>
								</ul>
							</div>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</nav>


	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.1.3/js/bootstrap.bundle.min.js"></script>
</body>
</html>
