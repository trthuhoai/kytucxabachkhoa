<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<form action="<%=request.getContextPath()%>/CheckQLP_TTPhongChiTiet"
				method="post">
				<h3 align="center" style="font-size: 26px;">Danh sách sinh viên</h3>
				<div class="row">
					<div class="span3">
						<input type="text" name="timkiem" value="" placeholder="Nhập Tên / Lớp / Mã số / Ngành">
					</div>
					<div class="span0">
						<input class="btn btn-info" type="submit" name="id"
							value="Tìm kiếm">
					</div>
				</div>
				
				<table class="table table-striped table-bordered table-hover"
					align="center" border="1">
					<thead>

						<tr
							style="background-color: blue; color: #ffffff; font-weight: bold;"
							align="center">

							<th style="background-color: #724585">Mã sinh viên</th>
							<th style="background-color: #724585">Tên sinh viên</th>
							<th style="background-color: #724585">Lớp</th>
							<th style="background-color: #724585">Ngành</th>
							<th style="background-color: #724585">Số điện thoại</th>
							<th style="background-color: #724585">Số CMT/CCCD</th>
							<th style="background-color: #724585">Số tài khoản</th>
							<th style="background-color: #724585">Tên ngân hàng</th>
							<th style="background-color: #724585" align="center">Địa chỉ</th>


						</tr>
					</thead>
					<tbody>

						<!-- 	<caption style="font-size: 30px;">Danh sách </caption> -->
						<%
						ArrayList<Staff> list = (ArrayList<Staff>) request.getAttribute("listUser");

						for (int i = 0; i < list.size(); i++) {
						%>
						<tr>
							<td><%=list.get(i).getMasv()%></td>
							<td><%=list.get(i).getTensv()%></td>
							<td><%=list.get(i).getLop()%></td>
							<td><%=list.get(i).getNganh()%></td>
							<td><%=list.get(i).getSdt()%></td>
							<td><%=list.get(i).getSocccd()%></td>
							<td><%=list.get(i).getStk()%></td>
							<td><%=list.get(i).getTennh()%></td>
							<td><%=list.get(i).getDiachi()%></td>
						</tr>
						<%
						}
						%>
					</tbody>

				</table>
			</form>
		</div>
	</div>
<%-- 	<%@include file="footer.jsp"%> --%>
</body>
</html>