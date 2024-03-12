<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<title>Sign Up Form</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Lato:300,400,700,900&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="GUI/css/styleLogin.css">
<style>
.red {
	color: red;
}
.form-check-input {
	margin-top: 9px;
	margin-left: 9px;
}
</style>

</head>
<body>
	<section class="ftco-section">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-6 text-center mb-5">
					<h2 class="heading-section">Sign Up Form</h2>
				</div>
			</div>
			<div class="row justify-content-center">
				<div class="col-md-12 col-lg-10">
					<div class="wrap d-md-flex">
						<div
							class="text-wrap p-4 p-lg-5 text-center d-flex align-items-center order-md-last">
							<div class="text w-100">
								<h2>Welcome to Sign Up</h2>
								<p>You have an account?</p>
								<a href="sign-in" class="btn btn-white btn-outline-white">Sign Up</a>
							</div>
						</div>
						<div class="login-wrap p-4 p-lg-5">
							<div class="d-flex">
								<div class="w-100">
									<h3 class="mb-4">Sign Up</h3>
								</div>
								<div class="w-100">
									<p class="social-media d-flex justify-content-end">
										<a href="#"
											class="social-icon d-flex align-items-center justify-content-center"><span
											class="fa fa-facebook"></span></a> <a href="#"
											class="social-icon d-flex align-items-center justify-content-center"><span
											class="fa fa-twitter"></span></a>
									</p>
								</div>
							</div>
							<form action="sign-in" method="post" class="signin-form">
								<div class="form-floating mb-2">
									<input type="text" class="form-control" id="floatingInput"
										name="user_name" placeholder="username" required value="" />
								</div>
								<div class="form-floating mb-2">
									<input type="password" class="form-control mb-0"
										id="floatingPassword" placeholder="password" name="password"
										required value="" onkeyup="kiemTraMatKhau()" />
								</div>
								<div class="form-floating mb-2">
									<input type="password" class="form-control"
										id="floatingPasswordConfirm" placeholder="re-password"
										name="re-password" required value=""
										onkeyup="kiemTraMatKhau()" />
								</div>
								<div class="form-floating mb-2">
									<input type="email" class="form-control" id="floatingInput"
										name="email" placeholder="email" required value="" />
								</div>
								<div class="mb-3">
									<label for="dongYDieuKhoan" class="form-label">Agree to terms and policies</label> <input type="checkbox"
										class="form-check-input" id="dongYDieuKhoan"
										name="dongYDieuKhoan" onchange="xuLyChonDongY()">
								</div>
								<div class="form-group">
									<button type="submit"
										class="form-control btn btn-primary submit px-3">Sign
										Up</button>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="js/jquery.min.js"></script>
	<script src="js/popper.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/main.js"></script>

</body>
</html>