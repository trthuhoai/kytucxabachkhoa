<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page language="java" import="model.bean.Staff"%>
<%@ page language="java" import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<form action="<%=request.getContextPath()%>/CheckQL_TienDienNuoc"
				method="post">
				<div class="row">
					<div class="span3">
						<select name="nha" >
							<%-- <option value="$ {nha}">Nhà ${nha}</option> --%>
							<c:choose>
						    <c:when test="${not empty nha1}">
						       <option value="${nha1}">Nhà ${nha1}</option>
						        <br />
						    </c:when>    
						    <c:otherwise>
						       <option value="">Chọn khu</option>
						        <br />
						    </c:otherwise>
						</c:choose>
							<option value="3">Nhà 3</option>
							<option value="4">Nhà 4</option>
							<option value="5">Nhà 5</option>

						</select>
					</div>
					<div class="span3">
						<input type="month" name="time" value="${tg }">
					</div>
					<div class="span4">
						<input class="btn btn-info" type="submit" name="id"
							value="Dữ liệu">
					</div>
				</div>
				<h3 style="font-size: 26px;">Danh sách thông tin phí điện nước</h3>

				<div class="row">
					<div class="span3">
						<input type="text" name="timkiem" value="" placeholder="Nhập số phòng tìm kiếm">
					</div>
					<div class="span2">
						<input class="btn btn-info" type="submit" name="id"
							value="Tìm kiếm">
					</div>
			<!-- 		<div class="span2">
						<input class="btn btn-success" type="submit" name="id"
							value="Cập nhật">
					</div>
					<div class="span2">
						<input class="btn btn-warning" type="submit" name="id"
							value="Reset">
					</div> -->
				</div>
				</form>
				<table class="table table-striped table-bordered table-hover"
					border="1">
					<thead>
						<tr
							style="background-color: blue; color: #ffffff; font-weight: bold;"
							align="center">
							<th style="background-color: #724585">Khu</th>
							<th style="background-color: #724585">Tên phòng</th>
							<th style="background-color: #724585">Tổng tiền (VNĐ)</th>
							<th style="background-color: #724585">Trạng thái</th>
							<th style="background-color: #724585">Ngày thanh toán</th>
							<th style="background-color: #724585">Người nộp</th>
							<th style="background-color: #724585">Thanh toán</th>

						</tr>
					</thead>
					<tbody>

						<%
						ArrayList<Staff> list = (ArrayList<Staff>) request.getAttribute("listUser");

						for (int i = 0; i < list.size(); i++) {
						%>
						<form action="<%=request.getContextPath()%>/CheckQL_TienDienNuoc?capnhat=<%=list.get(i).getiDPhiDienNuoc() %>" method="post">
						<tr>
							<td>Nhà <%=list.get(i).getNha()%></td>
							<td><%=list.get(i).getTenphong()%></td>
							<td><%=list.get(i).getTiendiennuoc()%></td>

							<td> 
							<% if(list.get(i).getChapnhan().equals("1")){
								
								out.print("Đã thanh toán");
							}
							else{
								out.print("Chưa thanh toán");
							}%></td>
							<%-- <input type="checkbox" name="check"
								value="<%=list.get(i).getIdpdnuoc()%>"> --%>
							<td>
							<% if(list.get(i).getNgayNop()==null){
								%>
								<input type="date" name="ngaynop" id="datepickerNgaySinh" value=""></input>
							<%}
							else{
								%>
								<input type="date" name="ngaynop" id="datepickerNgaySinh" value="<%=list.get(i).getNgayNop()%>"></input>
								<%
							}%>
										
							<%-- <input type="text" name="ngaycha" id="datepickerNgaySinh" value="<%=list.get(i).getNgayNop()%>"></input> --%>
							<%-- <%=list.get(i).getNgayNop()%><input type="Date" name="ngay" value="${list.get(i).getNgayNop()}"> --%></td>
							<td><input type="text" name="nguoinop" id="datepickerNgaySinh" value="<%=list.get(i).getNguoiNop()%>"></input></td>
							<td><input class="btn btn-success" type="submit" name="id"
							value="Xác nhận"></td>


						</tr>
						</form>
						<%
						}
						%>
					</tbody>

				</table>
			
		</div>
	</div>
		<script src="assets/js/dictrict.js"></script>
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
	<script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
	<script src="assets/js/shop.js"></script>
	<script src="assets/js/shop.js"></script>
  	<script src="assets/jquery/jquery-ui.js"></script> 
   	<script src="assets/jquery/jquery-ui.min.js"></script> 
   	 <link href="assets/jquery/jquery-ui.min.css" type="text/css" rel="stylesheet"/> 
<script>
/* 
 $('#datepickerNgaySinh').datepicker(
	      {
	        dateFormat: 'dd/mm/yy'    
	      }
	    );
  $(' #datepickerNgaySinhMe').datepicker(
	      {
	        dateFormat: 'dd/mm/yy'   
	      }
	    ); */

</script> 
</body>
</html>