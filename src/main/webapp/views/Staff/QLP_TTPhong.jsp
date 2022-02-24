<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="model.bean.Staff"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ký túc xá</title>
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
		<div  class="span12">
		<form action="<%=request.getContextPath()%>/CheckQLP_TTPhong" method="post">
		<h3 style="font-size: 26px;">Danh sách phòng</h3>
					<div class="row">
					<div class="span3">
					<select name = "nha" style="font-size: 18px; border-radius: 5px;">
					<c:choose>
						    <c:when test="${not empty nha}">
						       <option value="${nha}">Nhà ${nha}</option>
						        <br />
						    </c:when>    
						    <c:otherwise>
						       <option value="">Chọn khu</option>
						        <br />
						    </c:otherwise>
						</c:choose>
						<option name="nha" value="3">Nhà 3</option>
						<option name="nha" value="4">Nhà 4</option>
						<option name="nha" value="5">Nhà 5</option>
					</select>
					</div>
					<div class="span1"><input class="btn btn-info" name="searchTTPhong" type="submit" value="Dữ liệu" /></td>
					</div>
				</div>
					
   				
		</form>
<table  class="table table-striped table-bordered table-hover" border="1">
	<!-- 	<thead> -->
			<tr  style="background-color:blue; color: #ffffff; font-weight:bold; ">
				<th style="background-color:#724585">Khu</th>
				<th style="background-color:#724585">Tên phòng</th>
				<th style="background-color:#724585">Số người</th>
				<th style="background-color:#724585">Giới tính</th>
				<th width="160px" style="background-color:#724585">Xem danh sách</th>
				

			</tr>
		
			
			
   
			<%
				ArrayList<Staff> list = (ArrayList<Staff>) request.getAttribute("listUser");
            for (int i = 0; i < list.size(); i++) {
%>
			
			<tr>
			<%--<td><%=list.get(i).getNha()%></td>--%>
			<td>Nhà <%=list.get(i).getNha()%></td>
				<td><%=list.get(i).getTenphong()%></td>
				<td><%=list.get(i).getSLSVDangLuuTru() %></td>
				<td><%=list.get(i).getGioitinh() %></td>
				<td><a class="btn btn-success" href="<%=request.getContextPath()%>/CheckQLP_TTPhongChiTiet?idphong=<%=list.get(i).getIdp_old()%>" >Xem chi tiết</a></td>
			</tr>
			<%
				}
			%>

	</table>

		
		</div>
	</div>
</body>
</html>