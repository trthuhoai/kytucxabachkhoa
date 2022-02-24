<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông tin KTX</title>
</head>
<body>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<title>Thông tin KTX</title>
<link href="assets/css/style2.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">
<link href="assets/css/style3.css" rel="stylesheet" type="text/css">
<link href="assets/css/style4.css" rel="stylesheet" type="text/css"> 
<link href="assets/css/style5.css" rel="stylesheet" type="text/css"> 
<link href="assets/css/style1.css" rel="stylesheet" type="text/css">
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
    		<a href="index.jsp">Trang chủ</a>
    		<a href="view_intro.jsp">Giới thiệu</a>
    		<a class = "active" href="ktx_infor.jsp">Thông tin KTX</a>
    		<a href="<%=request.getContextPath()%>/ShowBangGia">Bảng giá KTX</a>
			<a href="register.jsp">Đăng ký</a>
			<a href="login">Đăng nhập</a>
			
		</div>
		<div class = "content">
			<div class = "left-content" style = "width: 70%; float: left">
				<h3 style = "margin-left: 20px">THỦ TỤC ĐĂNG KÝ LƯU TRÚ BAO GỒM</h3>
				<div style = "margin-left: 40px">
					<p> - 03 ảnh 3x4 (có thể chụp tạo văn phòng KTX)
					<br /> - 01 bản photo CMND/CCCD
					<br /> - 01 bản photo thẻ sinh viên (Trường hợp là tân sinh viên chưa có thẻ sinh viên thì nộp bản photo giấy báo nhập
					 học hoặc phiếu thu học phí)
					 <br /> - Ở ghép: Tối đa 06 sinh viên/1 phòng
					 <br /> - Bao phòng: Tối đa 05 sinh viên/1 phòng
					 <br /> - Đóng phí theo kỳ, tối thiểu 3 tháng/kỳ</p>
					 <div style = "margin-top: 50px"><a href = "view_cost.jsp">Xem thông tin bảng giá lưu trú</a></div>
					 <div style = "margin-top: 20px">Mọi thông tin cần giải đáp bạn có thể gửi về email: <br/> <b style = "margin-left: 40px">kytucxa@ktxdn.vn</b></div>
					<div style = "margin-top: 200px">
					<!-- 	<a href="login.jsp">Đăng nhập</a>
						<a style = "margin-left: 20px" href="signin.jsp">Đăng kí</a> -->
					</div>
				</div>
			</div>
			<div class = "right-content" style = "width: 30%; float: right; margin-top: 20px">
				<div><img alt="lai-xe" src="assets/img/lai-xe.png" style = "width:70%; margin-left: 40px"></div>
				<div><img alt="phong-o" src="assets/img/room.png" style = "width: 70%; margin-top: 20px; margin-left: 40px"></div>
				<div style = "margin-top:20px">
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
					    margin-right: 60px;
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
    <div><%@include file="footer.jsp"%></div>
    </body>
</html>