<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page language="java" import="java.util.ArrayList" %>
     <%@ page language="java" import="model.bean.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bảng giá KTX</title>
</head>
<body>
<head>
<meta charset="utf-8">
<title>Bảng giá KTX</title>
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
</head>
    <body>
    <div><%@include file="header.jsp"%></div>
    <div>
    	<div class="topnav">
    		<a href="index.jsp">Trang chủ</a>
    		<a href="view_intro.jsp">Giới thiệu</a>
    		<a href="ktx_infor.jsp">Thông tin KTX</a>
    		<a class = "active" href="<%=request.getContextPath()%>/ShowBangGia">Bảng giá KTX</a>
			<a href="register.jsp">Đăng ký</a>
			<a href="login">Đăng nhập</a>
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
    <div>
    	<div class = "left-content" style = "width: 100%; float: left">
    	<h3><b>A. BẢNG GIÁ LƯU TRÚ</b></h3>
    	<h4 style = "margin-left: 20px"><b>1. PHÍ NỘP BAN ĐẦU</b></h4>
    	<table border="1" width = "50%" style = "margin-left : 50px">
    		<%ArrayList<PhiBD> pbd = (ArrayList<PhiBD>)request.getAttribute("pbd");
			if(pbd == null)
				return;
			else 
			{
				for (int i=0;i<pbd.size();i++){
					%>
					<tr>
					<td><%=i+1%></td>
					<td><%=pbd.get(i).getname() %></td>
					<td><%=pbd.get(i).getcost() %></td>
				
					</tr>
			<%} 
			}%>
    	</table>
    	
    	<h4 style = "margin-left: 20px"><b>2. PHÍ LƯU TRÚ</b></h4>
    	<table border="1" width = "50%" style = "margin-left : 50px">
    		<%ArrayList<BGLT> bglt = (ArrayList<BGLT>)request.getAttribute("bglt");
			if(bglt == null)
				return;
			else 
			{
				for (int i=0;i<bglt.size();i++){
					%>
					<tr>
					<td><%=i+1%></td>
					<td><%=bglt.get(i).getname() %></td>
					<td><%=bglt.get(i).getcost() %></td>
				
					</tr>
			<%} 
			}%>
    	</table>
    	
    	<h3><b>A. BẢNG GIÁ ĐỀN BÙ SỬA CHỮA</b></h3>
    	<table border="1" width = "150%" style = "margin-left : 50px">
	    	<tr>
			<td>STT</td>
			<td>Tên vật tư</td>
			<td>Chủng loại</td>
			<td>Đơn vị tính</td>
			<td>Số lượng</td>
			<td>Đơn giá</td>
			<td>Ghi chú</td>
		
		</tr>
		<%ArrayList<BGDB> bgdb=(ArrayList<BGDB>)request.getAttribute("bgdb");
		if(bgdb==null)
			return;
		else 
		{
			for (int i=0;i<bgdb.size();i++){
				%>
				<tr>
				<td><%=i+1 %></td>
				<td><%=bgdb.get(i).getten() %></td>
				<td><%=bgdb.get(i).getchungloai() %></td>
				<td><%=bgdb.get(i).getdvt() %></td>
				<td><%=bgdb.get(i).getsoluong() %></td>
				<td><%=bgdb.get(i).getdongia() %></td>
		        <td><%=bgdb.get(i).getnote() %></td>
			
				</tr>
		<%} 
		}%>
    	</table>
    	</div>
    </div>
    <div><%@include file="footer.jsp"%></div>
    </body>
</html>