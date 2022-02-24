<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ký túc xá bách khoa</title>

<title>Existing Login Form a Flat Responsive Widget Template :: W3layouts</title>

<!-- Meta-Tags -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="Existing Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //Meta-Tags -->

<link href="assets/css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />

<!-- Style --> <link rel="stylesheet" href="assets/css/style6.css" type="text/css" media="all">

<!-- Fonts -->
<link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
<!-- //Fonts -->

</head>
<!-- //Head -->

<!-- Body -->
<body>

 		
					<c:choose>
							 <c:when test="${empty student}">
				<div id="small-dialog1" >
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
							<input placeholder="Ngày sinh" name="dob" type="text" id="datepickerNgaySinh" required="">
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
					<br/>
					<div align="center"><p style="font-size: 18px; font-weight: bold; font-style: italic; color: #d3aeae;">${error}</p></div>
                   
					<div class="submit-w3l">
						<input type="submit" value="Đăng ký">
					</div>
				</form>
			</div>
		</div>	
	</div>
								
							</c:when> 
							<c:otherwise>
									<div id="small-dialog1" >
		<div class="contact-form1">
			<div class="contact-w3-agileits">
				<h3>Đăng ký lưu trú</h3>
				<form id="registerForm"  action="registerProcess" method="post">
						<div class="form-sub-w3ls">
							<input placeholder="Họ và tên" name="hoten" value="${ student.tenSV }"  type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Số điện thoại" value="${ student.SDT }"   name="phone" type="text"  required="">
							<div class="icon-agile">
								<i class="fa fa-envelope-o" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Số CMND/CCCD" value="${ student.soCCCD }"  name="identify" type="text"  required="">
							<div class="icon-agile">
								<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							</div>
						</div>
								<div class="form-sub-w3ls">
							<input placeholder="Ngày sinh" value="${ student.ngaySinh }" id="datepickerNgaySinh"  name="dob" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Mã số sinh viên" value="${ student.maSV }"  type="text" name="mssv" class="mail" required="">
							<div class="icon-agile">
								<i class="fa fa-envelope-o" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Ngành" value="${ student.nganh }"  name="major" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Lớp" value="${ student.lop }"  name="class" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Giới tính" value="${ student.gioiTinh }"  name="gtinh" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Địa chỉ" value="${ student.diaChi }"  name="diachi" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Email" value="${ student.email }"  name="email" type="email" required="">
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
					<br/>
					<div align="center"><p style="font-size: 18px; font-weight: bold; font-style: italic; color: #d3aeae;">${error}</p></div>
                   
					<div class="submit-w3l">
						<input type="submit" value="Register">
					</div>
				</form>
			</div>
		</div>	
	</div>
								
							</c:otherwise>
							</c:choose>
	
	<!-- //for register popup -->
	
	<div class="w3footeragile">
	<!-- 	<p> &copy; 2017 Existing Login Form. All Rights Reserved | Design by <a href="http://w3layouts.com" target="_blank">W3layouts</a></p> -->
	</div>


	<script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
<script src="assets/js/dictrict.js"></script>
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
	<script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
	<script src="assets/js/shop.js"></script>
	<script src="assets/js/shop.js"></script>
  	<script src="assets/jquery/jquery-ui.js"></script> 
   	<script src="assets/jquery/jquery-ui.min.js"></script> 
   	 <link href="assets/jquery/jquery-ui.min.css" type="text/css" rel="stylesheet"/> 

 
		<script src="assets/js/jquery.magnific-popup.js" type="text/javascript"></script>
	<!--//pop-up-box-js-file -->
	<script>
	 $('#datepickerNgaySinh').datepicker(
		      {
		        dateFormat: 'dd/mm/yy'    
		      }
		    );
	  $(' #datepickerNgaySinhMe').datepicker(
		      {
		        dateFormat: 'dd/mm/yy'   
		      }
		    );
		$(document).ready(function() {
	/* 	$('.w3_play_icon,.w3_play_icon1,.w3_play_icon2').magnificPopup({ */
		window.onload = function()
{
			/* type: 'inline',
			fixedContentPos: false,
			fixedBgPos: true,
			overflowY: 'auto',
			closeBtnInside: true,
			preloader: false,
			midClick: true,
			removalDelay: 300,
			mainClass: 'my-mfp-zoom-in' */
		}); 
																		
		});
	</script>

</body>
<!-- //Body -->

</html>