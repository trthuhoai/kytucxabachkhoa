<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
<!DOCTYPE html>
<head>
<meta charset="utf-8">
<title>Các phòng đang trống</title>
<link href="assets/css/style2.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">
<link href="assets/css/style3.css" rel="stylesheet" type="text/css">
<link href="assets/css/style4.css" rel="stylesheet" type="text/css"> 
<link href="assets/css/style5" rel="stylesheet" type="text/css"> 
<link href="assets/css/style1.css" rel="stylesheet" type="text/css">
<link href="assets/css/style1.css" rel="stylesheet" type="text/css">
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome-ie7.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.ie7.min.css" rel="stylesheet">
<link rel="shortcut icon" href="assets/ico/lg.ico">
</head>
    <body>
    <div><%@include file="header.jsp"%></div>
    <div>
    	<div class="topnav">
    		<a href="index.jsp">Trang chủ</a>
    		<a href="view_intro.jsp">Giới thiệu</a>
    		<a href="ktx_infor.jsp">Thông tin KTX</a>
    		<a href="<%=request.getContextPath()%>/ShowBangGia">Bảng giá KTX</a>
			<a class = "active" href="view_emptyroom.jsp">Các phòng đang trống</a>
			<a href="register.jsp">Đăng ký</a>
			<a href="login.jsp">Đăng nhập</a>
		</div>
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
    <div><%@include file="footer.jsp"%></div>
    </body>
</html>