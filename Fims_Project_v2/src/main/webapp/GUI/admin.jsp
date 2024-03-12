<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="database.ProductDAO"%>
<%@ page import="model.Product"%>
<%@ page import="database.ProductImageDAO"%>
<%@ page import="model.ProductImage"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Admin Page</title>
<link rel="stylesheet" href="GUI/css/styleAdmin.css">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto|Varela+Round">
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>
img {
	width: 200px;
	height: 120px;
}

.table-wrapper {
	margin-top: 20px; /* thêm margin ở đây */
}

.table-wrapper {
	min-height: 400px; /* độ cao tối thiểu của table-wrapper */
}

.table-title {
	min-height: 50px; /* độ cao tối thiểu của table-title */
}


.navigation {
	z-index: 100; /* đảm bảo navigation hiển thị trên các phần tử khác */
}
</style>
</head>
<body>
	<div class="navigation">
		<ul>
			<li><a href="#"> <span class="icon"><i
						class="fa-solid fa-house"></i></span> <span class="title">Home</span>
			</a></li>
			<li><a href="#"> <span class="icon"><i
						class="fa-solid fa-user"></i></span> <span class="title">Profile</span>
			</a></li>
			<li><a href="#"> <span class="icon"><i
						class="fa-solid fa-message"></i></span> <span class="title">Message</span>
			</a></li>
			<li><a href="manageProduct"> <span class="icon"><i
						class="fa-solid fa-mobile"></i></span> <span class="title">Product</span>
			</a></li>
			<li><a href="#"> <span class="icon"><i
						class="fa-solid fa-calendar"></i></span> <span class="title">Calendar</span>
			</a></li>
			<li><a href="#"> <span class="icon"><i
						class="fa-solid fa-circle-question"></i></span> <span class="title">Help</span>
			</a></li>
			<li><a href="#"> <span class="icon"><i
						class="fa-solid fa-gear"></i></span> <span class="title">Setting</span>
			</a></li>
			<li><a href="#"> <span class="icon"><i
						class="fa-solid fa-right-from-bracket"></i></span> <span class="title">Sign
						out</span>
			</a></li>
		</ul>
	</div>
	<div class="toggle" onclick="toggleMenu()"></div>
	<script type="text/javascript">
		function toggleMenu() {
			let navigation = document.querySelector('.navigation');
			let toggle = document.querySelector('.toggle');
			navigation.classList.toggle('active');
			toggle.classList.toggle('active');
		}
	</script>
</body>
</html>