<%@page import="model.bean.SinhVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Admin | Xem chi tiết sinh viên</title>
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
	
	input[type=text], input[type=date], input[type=email] {
	    width: 100%;
	    padding: 12px;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;
	    margin-top: 6px;
	    margin-bottom: 16px;
	    resize: vertical;
	}
</style>

<body>
<div><%@include file="header.jsp"%></div>
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
						    <h4>Xem chi tiết sinh viên</h4>
						    <form action="javascript:void(0)">
						    	<%
						        	if (request.getParameter("update") != null) {
						        %>
						        <div align="center">
									<div class="alert alert-success">Cập nhật thông tin sinh viên thành công</div>
								</div>
								<%
						        	}
								%>
								<label>Tên sinh viên</label>
						        <input type="text" id="hoten" name="hoten" value="${sv.hoTen}" placeholder="Nhập tên sinh viên" disabled="disabled">
						        <label>Số điện thoại</label>
						        <input type="text" id="sdt" name="sdt" value="${sv.soDienThoai}" placeholder="Nhập số điện thoại" disabled="disabled">
						        <label>Email</label>
						        <input type="email" id="email" name="email" value="${sv.email}" placeholder="Nhập email" disabled="disabled">
						        <label>Ngày sinh</label>
						        <input type="date" id="ngaysinh" name="ngaysinh" value="${sv.ngaySinh}" placeholder="Nhập ngày sinh" disabled="disabled">
						        <label style="margin-right: 10px">Giới tính</label>
						        <%
						        	String checkedNam = "";
						        	String checkedNu = "";
						        	SinhVien sv = null;
						        	if (request.getAttribute("sv") != null) {
						        		sv = (SinhVien) request.getAttribute("sv");
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
						        <input type="radio" name="gioitinh" value="Nam" <%=checkedNam %> disabled="disabled"> <span style="margin-right: 10px">Nam</span>
						        <input type="radio" name="gioitinh" value="Nữ" <%=checkedNu %> disabled="disabled"> Nữ
						        <br>
						        <label>Địa chỉ</label>
						        <input type="text" id="diachi" name="diachi" value="${sv.diaChi}" disabled="disabled">
						        <label>Khoa</label>
						        <input type="text" id="khoa" name="khoa" value="${sv.nganh}" disabled="disabled">
						        <label>Lớp</label>
						        <input type="text" id="lop" name="lop" value="${sv.lop}" disabled="disabled">
						        <label>Khu</label>
						        <%
						        	if (sv.getPhong().getNha() == null) {
						       	%>
						       	<input type="text" id="khu" name="khu" value="Chưa có" disabled="disabled">
						       	<%
						        	} else {
								%>
								<input type="text" id="khu" name="khu" value="${sv.phong.nha}" disabled="disabled">
								<%						        		
						        	}
						        %>
						        <label>Phòng</label>
						        <%
						        	if (sv.getPhong().getPhong() == null) {
						       	%>
						       	<input type="text" id="phong" name="phong" value="Chưa có" disabled="disabled">
						       	<%
						        	} else {
								%>
								<input type="text" id="phong" name="phong" value="${sv.phong.phong}" disabled="disabled">
								<%						        		
						        	}
						        %>
						        <label>Mã sinh viên</label>
						        <input type="text" id="masv" name="masv" value="${sv.maSV}" placeholder="Nhập mã sinh viên (tài khoản)" disabled="disabled">
						        <button type="button" onclick="history.back()" class="btn btn-primary">Trở về</button>
						        <a href="<%=request.getContextPath() %>/admin/sinh-vien/cap-nhat?masv=${sv.maSV}" class="btn btn-success">Sửa</a>
						        <a href="<%=request.getContextPath() %>/admin/sinh-vien/xoa?masv=${sv.maSV}" onclick="return confirm('Xác nhận xoá sinh viên \'${sv.hoTen}\'?')" class="btn btn-danger">Xoá</a>
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