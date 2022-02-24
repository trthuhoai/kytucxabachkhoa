<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="model.bean.Staff" %>
<%@ page language="java" import="java.util.ArrayList" %>
    
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
<body>
<%@include file="header.jsp"%>

	<div class="row" style="margin-top: 30px;">
		<div class="span3">
			<%@include file="menu.jsp"%>
		</div>
		<div class="span12">
    <form action="<%=request.getContextPath()%>/CheckPhiThuePhong" method="post">	
    <div class="row">
					<div class="span3">
						<select  name="hocky">
				<option value="1" >Kỳ 1</option>
				<option value="2">Kỳ 2</option>						
		</select>
					</div>
					<div class="span3">
						<select  name="namhoc">
<option value="2021-2022">2021-2022</option>
<option value="2020-2021">2020-2021</option>
						<option value="2019-2020" >2019-2020</option>
												
						
					
				</select>
					</div>
					<div class="span1"><input  class="btn btn-info" type="submit" name="id" value="Dữ liệu"></div>
				<!-- 	<div class="span4">
						<input class="btn btn-success" type="submit" name="id" value="Cập nhật">
					</div> -->
				</div>
<!-- 		<select  name="hocky">
				<option value="1" >Kỳ 1</option>
				<option value="2">Kỳ 2</option>						
		</select>
<select  name="namhoc">
<option value="2021-2022">2021-2022</option>
<option value="2020-2021">2020-2021</option>
						<option value="2019-2020" >2019-2020</option>
												
						
					
				</select>
					<div></div><input type="submit" name="id"value="Dữ liệu"></div> -->
		<h3 style="font-size: 26px;">Quản lý phí thuê phòng</h3>
		<div class="row">
					<div class="span3">
						<input type="text"  name="timkiem"  placeholder="Nhập mã số sinh viên">
					</div>
					<div class="span1">
						<input class="btn btn-info" type="submit" name="id"
							value="Tìm kiếm">
					</div>
					<div class="span2"></div>
			<!-- 		<div class="span3">
						<input class="btn btn-success" type="submit" name="id"
							value="Cập nhật">
					</div>
					<div class="span3">
						<input type="reset" name="id"value="Reset">
					</div> -->
				</div>
			</form>
			<table border="1"  align="center"class="table table-striped table-bordered table-hover" border="1">
<!-- 	<tr> 	
	    <td><input type="text" name="timkiem"value=""></td>
		<td><input type="submit" name="id"value="timkiem"></td>
		<td><input type="submit" name="id"value="capnhat"></td>
		<td><input type="reset" name="id"value="Reset"></td>
		
	</tr>	 -->
	
	

	<div align="center" style="color: red">
		<c:if = test="${not empty message }">
			<div >${message}</div>
		</c:if>
	</div>
	<tr style="background-color: blue; color: #ffffff; font-weight: bold;" align="center"> 
	<th style="background-color: #724585;">Mã sinh viên</th>
	<th style="background-color: #724585;">Học kỳ</th>
	<th style="background-color: #724585;">Năm học</th>
	<th style="background-color: #724585;">Tổng phí</th>
	<th style="background-color: #724585;">Trạng thái</th>
	<th style="background-color: #724585;">Hình thức thanh toán</th>
	<th style="background-color: #724585;">Ngày thanh toán</th>
	<th style="background-color: #724585;">Xác nhận thanh toán</th>
	</tr>
	  
	
	<%ArrayList<Staff> StaffArray=(ArrayList<Staff>)request.getAttribute("StaffArray");
	if(StaffArray!=null){
	for (int i=0;i<StaffArray.size();i++){
		%>
		<tr>
		
		<td><%=StaffArray.get(i).getMasv() %></td>
		<td><%=StaffArray.get(i).getHocky()%></td>
		<td><%=StaffArray.get(i).getNamhoc()%></td>
		<td><%=StaffArray.get(i).getTongphi()%></td> 
	   	<td> 
				<% if(StaffArray.get(i).getTrangThai()==1){
					
					out.print("Đã thanh toán");
				}
				else{
					out.print("Chưa thanh toán");
				}%></td>
			<td> 
					<%
					 if(StaffArray.get(i).getTrangThai()==1){
						if(StaffArray.get(i).getHinhThuc()==1){
				
						
						out.print("Chuyển khoản");
					}
					else{
						out.print("Tại văn phòng");
			}}
					else{ out.print("Chưa thanh toán");
					%>
					
					
					<%} %></td>
					<form action="<%=request.getContextPath()%>/CheckPhiThuePhong?capnhat=<%=StaffArray.get(i).getIdPhiPhong() %>" method="post">
	   <td><input type="date" name="ngaythanhtoan" value="<%=StaffArray.get(i).getNgayTT()%>"></td>
	   <%-- <td><input type="checkbox" name="check" value="<%=StaffArray.get(i).getMasv()%>"></td> --%>
	   <td><input class="btn btn-success" type="submit" name="id"
							value="Xác nhận"></td>
							</form>
	<%}} %>
          
			</tr>     
		</table>
           
	
</div>
</div>
</body>
</html>