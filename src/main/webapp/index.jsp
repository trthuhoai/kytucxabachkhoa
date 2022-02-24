<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<title>Trang chủ</title>
<link href="assets/css/style2.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">
<link href="assets/css/style3.css" rel="stylesheet" type="text/css">
<link href="assets/css/style1.css" rel="stylesheet" type="text/css"> 
<link href="assets/css/style4css" rel="stylesheet" type="text/css"> 
<link href="assets/css/style5.css" rel="stylesheet" type="text/css">
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome-ie7.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.ie7.min.css" rel="stylesheet">
<link rel="shortcut icon" href="assets/ico/lg.ico">
<link href="assets/css/view.css" rel="stylesheet" type="text/css">
<style>
			.topnav {
			    overflow: hidden;
			    background-color: #333;
			}
 
			.topnav a {
			    float: left;
			    color: #f2f2f2;
			    text-align: center;
			    padding: 14px 16px;
			    text-decoration: none;
			    font-size: 17px;
			}
			 
			.topnav a:hover {
			    background-color: #ddd;
			    color: black;
			}
			 
			.topnav a.active {
			    background-color: #4CAF50;
			    color: white;
			}
			</style>
</head>
    <body>
    <div><%@include file="header.jsp"%></div>
    <div>
    		<div class="topnav">
    		<a class = "active" href="index.jsp">Trang chủ</a>
    		<a href="view_intro.jsp">Giới thiệu</a>
    		<a  href="ktx_infor.jsp">Thông tin KTX</a>
    		<a href="<%=request.getContextPath()%>/ShowBangGia">Bảng giá KTX</a>
			<a href="register.jsp">Đăng ký</a>
			<a href="login">Đăng nhập</a>
			<style>
			.topnav {
			    overflow: hidden;
			    background-color: #333;
			}
 
			.topnav a {
			    float: left;
			    color: #f2f2f2;
			    text-align: center;
			    padding: 14px 16px;
			    text-decoration: none;
			    font-size: 17px;
			}
			 
			.topnav a:hover {
			    background-color: #ddd;
			    color: black;
			}
			 
			.topnav a.active {
			    background-color: #4CAF50;
			    color: white;
			}
			</style>
		</div>
		<div class = "content">
		<div>
		<h3 style = "margin-left: 20px"><img alt="ktx" src="assets/img/ktx.png" style = "width: 300px; float: right; margin-right: 40px">
		Đôi nét về KTX Trường Đại học Bách khoa Đà Nẵng</h3>
		<div style = "margin-left: 40px">
		<p>
		
		<B>Là dự án được xây dựng có quy mô nhất miền Trung</b><br /> do UBND TP.Đà Nẵng
		làm chủ đầu tư từ nguồn vốn trái phiếu của Chính phủ, góp phần thực hiện 
		chính sách an sinh xã hội, <br /> toạ nơi lưu trú văn minh, hiện đại dành cho sinh 
		viên đang học tập tại trường Đại học Bách khoa Đà Nẵng.</p>
		<p><b>Ký túc xá thoáng mát, sạch sẽ, môi trường "xanh, sạch, đẹp" với tiêu chí:</b>
		<br /> "CHUẨN MỰC - VĂN MINH - HIỆN ĐẠI"</p>
		<p><b>Quản lý sinh viên bằng phần mềm tiên tiến</b><br />
		Kiểm soát ra, vào có hệ thống camera hỗ trợ giám sát chặt chẽ, có đầy đủ
		các dịch vụ tiện ích</p>
		<div style = "column-count: 3; margin-top: 50px">
		<div class = "caption">Ký túc xá nhìn từ trên cao:</div>
		<div class = "image-items" style = "width: 230px; margin-right: 10px;">
			<img alt="ktx-tren-cao" src="assets/img/KhuTayVeDem.png">
			
		</div>
		<div class = "caption">Phòng ở sinh viên:</div>
		<div class = "image-items" style = "width: 300px; margin-right: 10px;">
			<img alt="phong-sinh-vien" src="assets/img/HanhLang.png">
			
		</div>
		<div class = "caption">Các hoạt động ngoại khoá:</div>
		<div class = "image-items" style = "width: 250px; margin-right: 10px;">
			<img alt="cuoc-thi" src="assets/img/beauty.png">
			
		</div>
		</div>
		<div style = "margin-top: 10px">
			<div style = "width: 70%; float: left">
			<b>Dịch vụ tiện ích đa dạng</b>
			<ul>
				<li>Nhà ăn, điểm tâm</li>
				<li>Dạy tiếng anh</li>
				<li>Dịch vụ giặt ủi</li>
				<li>Siêu thị mini tiện lợi</li>
				<li>Dịch vụ cắt tóc</li>
				<li>Dịch vụ photocopy</li>
				<li>Câu lạc bộ thể hình</li>
				<li>Hệ thống Wifi phủ sóng khắp KTX</li>
				<li>Đào tạo lái xe oto, moto</li>
			</ul>

			</div>
			<div style = "width: 30%; float: right">
			<div class="container-chat">
			    <h4>Liên hệ với chúng tôi</h4>
			    <form action="SaveContact" method="post">
			        <input type="text" id="name" name="name" placeholder="Nhập họ và tên...">
			 
			        <input type="text" id="mssv" name="mssv" placeholder="Nhập Mã số sinh viên...">
			 
			        <input type="text" id="phone" name="phone" placeholder="Nhập số điện thoại...">
			 
			        <input type="text" id="content" name="content" placeholder="Nhập thông tin thêm...">
			        <div  align="center"style="color: red">
			       
				<c:if = test="${not empty thongbao }">
					<div class="alert alert-${alert}">${thongbao}</div>
				</c:if>
				</div>
			 
			        <input type="submit" value="Gửi thông tin">
			    </form>
			</div>
			<style>
			.container-chat {
			    width: 70%;
			    margin-right: 10px;
			    border-radius: 5px;
			    background-color: #e6f7ff;
			    padding: 20px;
			}
			    input[type=text] {
			    width: 100%;
			    padding: 12px;
			    border: 1px solid #ccc;
			    border-radius: 4px;
			    box-sizing: border-box;
			    margin-top: 6px;
			    margin-bottom: 16px;
			    resize: vertical;
			}
			 
			input[type=submit] {
			    background-color: #4CAF50;
			    color: white;
			    padding: 12px 20px;
			    border: none;
			    border-radius: 4px;
			    cursor: pointer;
			}
			 
			input[type=submit]:hover {
			    background-color: #45a049;
			}
			</style>
			</div>
			
		</div>
		 
		
		</div>
		</div>
		</div>
    </div>
    <div><%@include file="footer.jsp"%></div>
    </body>
</html>