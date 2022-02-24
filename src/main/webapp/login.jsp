<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ký túc xá bách khoa</title>
<title>Existing Login Form a Flat Responsive Widget Template :: W3layouts</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="Existing Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Meta-Tags -->

<link href="assets/css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />

 <link rel="stylesheet" href="assets/css/style6.css" type="text/css" media="all">
<link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
</head>

<body>

	<h1>Ký túc xá bách khoa</h1>

	<div class="w3layoutscontaineragileits">
	<h2>Đăng nhập</h2>
		<form  id="loginForm" modelAttribute="login" action="loginProcess" method="post">
			<input type="text" name="maso" placeholder="Nhập mã số" required="">
			<input type="password" name="matkhau" placeholder="Nhập mật khẩu" required="">
			<ul class="agileinfotickwthree">
			
				<li>
					<!-- <input type="checkbox" id="brand1" value=""> -->
					
					 <label style="font-style: italic; color: red;"><span></span>${message}</label> 
					<a href="laylaimatkhau">Quên mật khẩu?</a>
				</li>
			</ul>
			<div class="aitssendbuttonw3ls">
				<input type="submit" value="ĐĂNG NHẬP">
				<p> Đăng ký lưu trú ký túc xá tại <a class="w3_play_icon1" href="register.jsp"> Đăng ký</a></p>
				<div class="clear"></div>
			</div>
		</form>
	</div>
	
	<!-- for register popup -->
	<div id="small-dialog1" class="mfp-hide">
		<div class="contact-form1">
			<div class="contact-w3-agileits">
				<h3>Đăng ký lưu trú</h3>
				<form id="registerForm"  action="registerProcess" method="post">
						<div class="form-sub-w3ls">
							<input placeholder="Họ và tên" name="hoten"  type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Số điện thoại"  name="phone" type="text"  required="">
							<div class="icon-agile">
								<i class="fa fa-envelope-o" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Số CMND/CCCD" name="identify" type="text"  required="">
							<div class="icon-agile">
								<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							</div>
						</div>
								<div class="form-sub-w3ls">
							<input placeholder="Ngày sinh" name="dob" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Mã số sinh viên" type="text" name="mssv" class="mail" required="">
							<div class="icon-agile">
								<i class="fa fa-envelope-o" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Ngành" name="major" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Lớp" name="class" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Giới tính" name="gtinh" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Địa chỉ" name="diachi" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Email" name="email" type="email" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Mật khẩu" type="password" name="password" required="">
							<div class="icon-agile">
								<i class="fa fa-envelope-o" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Nhập lại mật khẩu" type="password" name="reenterpass" required="">
							<div class="icon-agile">
								<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							</div>
						</div>
					<div class="login-check">
						 <label class="checkbox"><input type="checkbox" name="checkbox" checked="">Tôi đồng ý các quy định của ký túc xá</label>
					</div>
					<div class="submit-w3l">
						<input type="submit" value="Đăng ký">
					</div>
				</form>
			</div>
		</div>	
	</div>
	<div class="w3footeragile">
	</div>
	<script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
	<script src="assets/js/jquery.magnific-popup.js" type="text/javascript"></script>
	<script>
	</script>

</body>

</html>