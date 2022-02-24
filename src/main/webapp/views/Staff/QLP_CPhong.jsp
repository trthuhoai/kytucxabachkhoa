<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="model.bean.Staff"%>
<%@ page language="java" import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ký túc xá bách khoa</title>
<link href="assets/css/style2.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">
<link href="assets/css/style3.css" rel="stylesheet" type="text/css">
<link href="assets/css/style4.css" rel="stylesheet" type="text/css">
<link href="assets/css/style5.css" rel="stylesheet" type="text/css">
<link href="assets/css/style1.css" rel="stylesheet" type="text/css">
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.min.css"
	rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome-ie7.css"
	rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.ie7.min.css"
	rel="stylesheet">
<link rel="shortcut icon" href="assets/ico/lg.ico">
</head>
<body>

	<%@include file="header.jsp"%>

	<div class="row" style="margin-top: 30px;">
		<div class="span3">
			<%@include file="menu.jsp"%>
		</div>
		<div class="span12">

 <form action="<%=request.getContextPath()%>/CheckQLP_CPhong" method="post">
 <h3 style="font-size: 26px;">Danh sách đăng ký chuyển phòng</h3>
		<div class="row">
					<div class="span3">
						<input type="text" name="timkiem"value=""  placeholder="Nhập Tên / Lớp / Mã số / Ngành">
					</div>
					<div class="span1">
						<input type="submit" class="btn btn-info"  name="id"value="Tìm kiếm">
					</div>
					 <div class="span4"></div>
					<div class="span4"> <input class="btn btn-success"  type="submit" name="id"value="Cập nhật"></div>
					<!-- <div class="span4">
						<input type="submit" class="btn btn-warning"  name="id"value="Reset">
					</div> -->
				</div>
				
	<table class="table table-striped table-bordered table-hover" border="1">
		<thead>
			<tr style="background-color: blue; color: #ffffff; font-weight: bold;" align="center">

				<th style="background-color: #724585">Mã sinh viên</th>
				<th style="background-color: #724585">Tên sinh viên</th>
				<th style="background-color: #724585">Nhà</th>
				<th style="background-color: #724585">Phòng</th>
				<th style="background-color: #724585">ID Phòng</th>
				<th style="background-color: #724585">Ngày chuyển</th>
				<th style="background-color: #724585">Chấp nhận</th>

			</tr>
		</thead>
		<tbody>
		
		<%
		ArrayList<Staff> list = (ArrayList<Staff>) request.getAttribute("listUser");

		for (int i = 0; i < list.size(); i++) {
		%>
		<tr>
			<td><%=list.get(i).getMasv()%></td>
			<td><%=list.get(i).getTensv()%></td>
			<td><%=list.get(i).getNha()%></td>
			<td><%=list.get(i).getTenphong()%></td>
			<td><%=list.get(i).getIdp_new()%></td>
			<td><%=list.get(i).getNgaychuyen()%></td> 
			<td><input type="checkbox" name="check" value="<%=list.get(i).getMasv()%>"></td>
		
		</tr>
		<%
		}
		%>
		</tbody>

	</table>
	</form>
	</div>
	</div>
</body>
</html>