<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Phong"%>
<%@page import="java.util.List"%>
<%@page import="model.bean.SinhVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Admin | Thêm mới sinh viên</title>
	<link href="<%=request.getContextPath() %>/assets/css/style2.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath() %>/assets/css/style.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath() %>/assets/css/style3.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath() %>/assets/css/style4.css" rel="stylesheet" type="text/css"> 
	<link href="<%=request.getContextPath() %>/assets/css/style5.min.css" rel="stylesheet" type="text/css"> 
	<link href="<%=request.getContextPath() %>/assets/css/style1.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome-ie7.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome.ie7.min.css" rel="stylesheet">
	<link rel="shortcut icon" href="<%=request.getContextPath() %>/assets/ico/lg.ico">
	<link href="<%=request.getContextPath() %>/assets/css/view.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath() %>/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
</head>

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
	
	.container-chat {
	    width: 70%;
	    margin-right: 60px;
	    border-radius: 5px;
	    background-color: #f4edf4;
	    padding: 20px;
	}
	
	input[type=text], input[type=password], input[type=date], input[type=email] {
	    width: 100%;
	    padding: 12px;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;
	    margin-top: 6px;
	    margin-bottom: 16px;
	    resize: vertical;
	}
	
	select {
		width: 100%;
		border: 1px solid #ccc;
	    border-radius: 4px;
		margin-top: 6px;
	    margin-bottom: 16px;
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

<body>
<%@include file="header.jsp"%>
    <div>
    	<div class="topnav">
    		<%-- <a href="<%=request.getContextPath() %>/admin">Trang chủ</a> --%>
    		<a href="<%=request.getContextPath() %>/admin/nhan-vien">Quản lý nhân viên</a>
    		<a class="active" href="<%=request.getContextPath() %>/admin/sinh-vien">Quản lý sinh viên</a>
    		<a href="<%=request.getContextPath() %>/admin/CheckThongKe">Thống kê</a>
			<a href="<%=request.getContextPath() %>/admin/doi-mat-khau">Đổi mật khẩu</a>
			<a href="<%=request.getContextPath() %>/admin/logout">Đăng xuất</a>
		</div>
		<div class="content">
			<div>
				<h3 style = "margin-left: 20px">
					<img src="<%=request.getContextPath() %>/assets/img/ktx.png" style="width: 300px; float: right; margin-right: 40px">
					Quản lý sinh viên ký túc xá
				</h3>
				<div style = "margin-left: 40px">
					<div>
						<div class="container-chat">
						    <h4>Thêm mới sinh viên</h4>
						    <form action="<%=request.getContextPath() %>/admin/sinh-vien/them-moi" method="post">
						    	<%
						        	if (request.getAttribute("thongbao") != null) {
						        %>
						        <div align="center">
									<div class="alert alert-${alert}">${thongbao}</div>
								</div>
								<%
						        	}
								%>
								
								<span style="font-style: italic; color: red; font-size: 13px">${hoTenError}</span>
						        <input type="text" id="hoten" name="hoten" value="${sv.hoTen}" placeholder="Nhập tên sinh viên">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${sdtError}</span>
						        <input type="text" id="sdt" name="sdt" value="${sv.soDienThoai}" placeholder="Nhập số điện thoại">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${emailError}</span>
						        <input type="email" id="email" name="email" value="${sv.email}" placeholder="Nhập email">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${ngaySinhError}</span>
						        <input type="date" id="ngaysinh" name="ngaysinh" value="${sv.ngaySinh}" placeholder="Nhập ngày sinh">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${gioiTinhError}</span><br>
						        <label style="margin-right: 10px">Giới tính</label>
						        <%
							        String checkedNam = "";
						        	String checkedNu = "";
						        	if (request.getAttribute("sv") != null) {
						        		SinhVien sv = (SinhVien) request.getAttribute("sv");
						        		if (sv.getGioiTinh() != null) {
							        		if (sv.getGioiTinh().equals("Nam")) {
							        			checkedNam = "checked";
							        		}
							        		if (sv.getGioiTinh().equals("Nữ")) {
							        			checkedNu = "checked";
							        		}
						        		}
						        	}
						        %>
						        <input type="radio" name="gioitinh" value="Nam" <%=checkedNam %>> <span style="margin-right: 10px">Nam</span>
						        <input type="radio" name="gioitinh" value="Nữ" <%=checkedNu %>> Nữ
						        <br>
						        <span style="font-style: italic; color: red; font-size: 13px">${diaChiError}</span>
						        <input type="text" id="diachi" name="diachi" value="${sv.diaChi}" placeholder="Nhập địa chỉ">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${khoaError}</span>
						        <input type="text" id="khoa" name="khoa" value="${sv.nganh}" placeholder="Nhập khoa">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${lopError}</span>
						        <input type="text" id="lop" name="lop" value="${sv.lop}" placeholder="Nhập lớp">
						        
						    	<span style="font-style: italic; color: red; font-size: 13px">${maSVError}</span>
						        <input type="text" id="masv" name="masv" value="${sv.maSV}" placeholder="Nhập mã sinh viên (tài khoản)">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${matKhauError}</span>
						        <input type="password" id="matkhau" name="matkhau" placeholder="Nhập mật khẩu">
						        
						        <input type="submit" value="Lưu">
						    </form>
						</div>
					</div>
				</div>
			</div>
		</div>
    </div>
<div><%@include file="/footer.jsp"%></div>
</body>
</html>