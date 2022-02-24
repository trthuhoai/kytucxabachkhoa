<%@page import="model.bean.NhanVien"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Admin | Cập nhật thông tin nhân viên</title>
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
	 
	input[type=submit]:hover {
	    background-color: #45a049;
	}
</style>

<body>
<div><%@include file="header.jsp"%></div>
    <div>
    	<div class="topnav">
    		<%-- <a href="<%=request.getContextPath() %>/admin">Trang chủ</a> --%>
    		<a class="active" href="<%=request.getContextPath() %>/admin/nhan-vien">Quản lý nhân viên</a>
    		<a href="<%=request.getContextPath() %>/admin/sinh-vien">Quản lý sinh viên</a>
    		<a href="<%=request.getContextPath() %>/admin/CheckThongKe">Thống kê</a>
			<a href="<%=request.getContextPath() %>/admin/doi-mat-khau">Đổi mật khẩu</a>
			<a href="<%=request.getContextPath() %>/admin/logout">Đăng xuất</a>
		</div>
		<div class="content">
			<div>
				<h3 style = "margin-left: 20px">
					<img src="<%=request.getContextPath() %>/assets/img/ktx.png" style="width: 300px; float: right; margin-right: 40px">
					Quản lý nhân viên ký túc xá
				</h3>
				<div style = "margin-left: 40px">
					<div>
						<div class="container-chat">
						    <h4>Cập nhật thông tin nhân viên</h4>
						    <form action="" method="post">
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
						        <input type="text" id="hoten" name="hoten" value="${nv.hoTen}" placeholder="Nhập tên nhân viên">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${sdtError}</span>
						        <input type="text" id="sdt" name="sdt" value="${nv.soDienThoai}" placeholder="Nhập số điện thoại">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${emailError}</span>
						        <input type="email" id="email" name="email" value="${nv.email}" placeholder="Nhập email">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${ngaySinhError}</span>
						        <input type="date" id="ngaysinh" name="ngaysinh" value="${nv.ngaySinh}" placeholder="Nhập ngày sinh">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${gioiTinhError}</span><br>
						        <label style="margin-right: 10px">Giới tính</label>
						        <%
						        	String checkedNam = "";
						        	String checkedNu = "";
						        	if (request.getAttribute("nv") != null) {
						        		NhanVien nv = (NhanVien) request.getAttribute("nv");
						        		if (nv.getGioiTinh() != null) {
							        		if (nv.getGioiTinh().equals("Nam")) {
							        			checkedNam = "checked";
							        		}
							        		if (nv.getGioiTinh().equals("Nữ")) {
							        			checkedNu = "checked";
							        		}
						        		}
						        	}
						        %>
						        <input type="radio" name="gioitinh" value="Nam" <%=checkedNam %>> <span style="margin-right: 10px">Nam</span>
						        <input type="radio" name="gioitinh" value="Nữ" <%=checkedNu %>> Nữ
						        <br>
						        <span style="font-style: italic; color: red; font-size: 13px">${chucVuError}</span>
						        <input type="text" id="chucvu" name="chucvu" value="${nv.chucVu}" placeholder="Nhập chức vụ">
						        
						        <span style="font-style: italic; color: red; font-size: 13px">${diaChiError}</span>
						        <input type="text" id="diachi" name="diachi" value="${nv.diaChi}" placeholder="Nhập địa chỉ">
								
						        <span style="font-style: italic; color: red; font-size: 13px">${matKhauError}</span>
						        <input type="password" id="matkhau" name="matkhau" placeholder="Nhập mật khẩu (không bắt buộc)">
						        
						        <button type="button" onclick="history.back()" class="btn btn-primary">Trở về</button>
						        <button type="submit" class="btn btn-success">Lưu</button>
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