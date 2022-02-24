<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ký túc xá bách khoa</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="Existing Login Form Widget Responsive, Login Form Web Template, Flat Pricing Tables, Flat Drop-Downs, Sign-Up Web Templates, Flat Web Templates, Login Sign-up Responsive Web Template, Smartphone Compatible Web Template, Free Web Designs for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="assets/css/popuo-box.css" rel="stylesheet" type="text/css" media="all" />
 <link rel="stylesheet" href="assets/css/style6.css" type="text/css" media="all">
<link href="//fonts.googleapis.com/css?family=Quicksand:300,400,500,700" rel="stylesheet">
<style type="text/css">
.select-css {
	display: block;
	font-size: 16px;
	font-family: sans-serif;
	font-weight: 700;
	color: #ffffff;
	line-height: 1.3;
	padding: .6em 1.4em .5em .8em;
	width: 89.5%;
	max-width: 100%; 
	box-sizing: border-box;
	margin: 25px;
	margin-right: 23px;
	margin-top: 10px;
/* 	margin-bottom: 10px; */
	border: 2px solid #ffffff;
	box-shadow: 0 1px 0 1px rgba(0,0,0,.04);
	border-radius: .0em;
	-moz-appearance: none;
	-webkit-appearance: none;
	appearance: none;
	background-color: transparent;
		background: transparent;
	/* background-image: url('data:image/svg+xml;charset=US-ASCII,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%22292.4%22%20height%3D%22292.4%22%3E%3Cpath%20fill%3D%22%23007CB2%22%20d%3D%22M287%2069.4a17.6%2017.6%200%200%200-13-5.4H18.4c-5%200-9.3%201.8-12.9%205.4A17.6%2017.6%200%200%200%200%2082.2c0%205%201.8%209.3%205.4%2012.9l128%20127.9c3.6%203.6%207.8%205.4%2012.8%205.4s9.2-1.8%2012.8-5.4L287%2095c3.5-3.5%205.4-7.8%205.4-12.8%200-5-1.9-9.2-5.5-12.8z%22%2F%3E%3C%2Fsvg%3E'),
	  linear-gradient(to bottom, #ffffff 0%,#e5e5e5 100%); */
	background-repeat: no-repeat, repeat;
	background-position: right .7em top 50%, 0 0;
	background-size: .65em auto, 100%;
}
.select-css::-ms-expand {
	display: none;
}
.select-css:hover {
	border-color: #888;
}
.select-css:focus {
	border-color: #aaa;
	box-shadow: 0 0 1px 3px rgba(59, 153, 252, .7);
	box-shadow: 0 0 0 3px -moz-mac-focusring;
	color: #222; 
	outline: none;
}
.select-css option {
	font-weight:normal;
}
.fancy-btn{
  display:inline-block;
  position:relative;
  padding:10px 20px;
  border:2px solid #98358c;
  color:#98358c;
  font-family:'Dancing Script',serif;
  font-style:italic;
  font-size:30px;
  text-decoration:none;
  margin:20px auto;
  transition: color 0.4s
}
.fancy-btn:after{
  content:" ";
  border:2px solid rgba(0,0,0,0);
  display:inline-block;
  width:100%;
  height:100%;
  position:absolute;
  top:0;
  left:0;
  right:0;
  bottom:0;
  margin:auto;
  transition:all 0.4s;
}
.fancy-btn:hover{
  color:green
}
.fancy-btn:hover:after{  
  border:2px solid #98358c;
  width: calc(100% - 10px);
  height: calc(100% + 10px); 
}



/* follow me @nodws */
#btn-twtr{
  clear:both;
  color:#98358c;
  border:2px solid;
  border-radius:3px;
  text-align:center;
  text-decoration:none;
  display:block;
  font-family:sans-serif;
  font-size:14px;
  width:13em;
  padding:5px 10px;
  font-weight:600;
  margin:90px auto;
  background:rgba(0,0,0,0.2);
  box-shadow:0 0 0px 3px rgba(0,0,0,0.2);
  opacity:0.6
}#btn-twtr:hover{color:#98358c;opacity:1}
			
			
</style>
</head>
<!-- //Head -->

<!-- Body -->
<body>

 		
					<c:choose>
							 <c:when test="${detail.mssv == null}">
				<div id="small-dialog1" >
		<div class="contact-form1">
			<div class="contact-w3-agileits">
				<h3>Lấy lại mật khẩu</h3>
				<form id="passwordRetrievalForm" action="resetpassword" method="post">
						<div class="form-sub-w3ls">
							<input placeholder="Họ và tên" id="hovaten" name= "hovaten"   type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Mã số sinh viên" id="mssv" name="mssv"  type="text"  required="">
							<div class="icon-agile">
								<i class="fa fa-envelope-o" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Lớp" id="lop" name= "lop" type="text"  required="">
							<div class="icon-agile">
								<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							</div>
						</div>
								<div class="form-sub-w3ls">
							<input placeholder="Email" id="email" name="email" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<select id="khu" name="khu" class="select-css">
		  									<option value="">Chọn khu</option>
		  									<option  value="3">Nhà 3</option>
		  									<option  value="4">Nhà 4</option>
		  									<option  value="5">Nhà 5</option>
										</select> 
										<i class="fa fa-user" aria-hidden="true"></i>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Phòng" id="phong" name="phong" type="text" required="">
							<div class="icon-agile">
								<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							</div>
						</div>
						
					<div align="center"><p style="font-size: 18px; font-weight: bold; font-style: italic; color: #d3aeae;">${message}</p></div>
                   
					<div class="submit-w3l">
						<input type="submit" value="Xác nhận">
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
				<h3>Lấy lại mật khẩu</h3>
				<form id="passwordRetrievalForm" action="resetpassword" method="post">
						<div class="form-sub-w3ls">
							<input placeholder="Họ và tên" id="hovaten" name= "hovaten"   type="text" required="" value="${ detail.hoVaTen }">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Mã số sinh viên" id="mssv" name="mssv"  type="text" value="${ detail.mssv }" required="">
							<div class="icon-agile">
								<i class="fa fa-envelope-o" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Lớp" id="lop" name= "lop" type="text" value="${ detail.lop }" required="">
							<div class="icon-agile">
								<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							</div>
						</div>
								<div class="form-sub-w3ls">
							<input placeholder="Email" id="email" name="email" type="text" value="${ detail.email }" required="">
							<div class="icon-agile">
								<i class="fa fa-user" aria-hidden="true"></i>
							</div>
						</div>
						<div class="form-sub-w3ls">
							<select id="khu" name="khu" class="select-css">
		  									<option value="${ detail.khu }">Nhà ${ detail.khu }</option>
		  									<option  value="3">Nhà 3</option>
		  									<option  value="4">Nhà 4</option>
		  									<option  value="5">Nhà 5</option>
										</select> 
						</div>
						<div class="form-sub-w3ls">
							<input placeholder="Phòng" id="phong" name="phong" type="text" value="${ detail.phong }" required="">
							<div class="icon-agile">
								<i class="fa fa-unlock-alt" aria-hidden="true"></i>
							</div>
						</div>
						
					<div align="center"><p style="font-size: 18px; font-weight: bold; font-style: italic; color: #d3aeae;">${message}</p></div>
                   
					<div class="submit-w3l">
					<!-- <a class="btn" style="background-color: #ca7b7b; color: #28052c">Thoát</a> -->
						<input type="submit" value="Xác nhận">
					</div>
				</form>
			</div>
		</div>	
	</div>
					
								
							</c:otherwise>
							</c:choose>
	
	<!-- //for register popup -->
	
	<div class="w3footeragile">
	</div>
	<script type="text/javascript" src="assets/js/jquery-2.1.4.min.js"></script>
	<script src="assets/js/jquery.magnific-popup.js" type="text/javascript"></script>
	<script>
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

</html>