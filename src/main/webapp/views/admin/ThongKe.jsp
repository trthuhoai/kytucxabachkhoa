<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page language="java" import="model.bean.Staff" %>
<%@ page language="java" import="java.util.ArrayList" %>
<%@ page language="java" import="java.text.NumberFormat"%>
<%@ page language="java"  import="java.util.ArrayList"%>
<%@ page  language="java"  import=" java.util.Locale"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Admin | Thống kê</title>
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
	    background-color: #e6f7ff;
	    padding: 20px;
	}
	
	input[type=text], input[type=password] {
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

<body>
 <%@include file="header.jsp"%>
 <div class="topnav">
    		<%-- <a href="<%=request.getContextPath() %>/admin">Trang chủ</a> --%>
    		<a href="<%=request.getContextPath() %>/admin/nhan-vien">Quản lý nhân viên</a>
    		<a href="<%=request.getContextPath() %>/admin/sinh-vien">Quản lý sinh viên</a>
    		<a  class="active" href="<%=request.getContextPath() %>/admin/CheckThongKe">Thống kê</a>
			<a href="<%=request.getContextPath() %>/admin/doi-mat-khau">Đổi mật khẩu</a>
			<a href="<%=request.getContextPath() %>/admin/logout">Đăng xuất</a>
		</div>
	<div class="row" style="margin-top: 30px;">
		<div class="span2">
			<%-- <%@include file="menu.jsp"%> --%>
		</div>
		<div class="span12">
		<h3 style="color: green;">Thống kê hằng năm</h3>
    <form action="<%=request.getContextPath()%>/admin/CheckThongKe" method="post">
				<div class="row">
					<div class="span3">
				<select  name="nam">
				<c:choose>
						    <c:when test="${not empty nam}">
						       	<option value="${nam }" >${nam }</option>
						    </c:when>    
						    <c:otherwise>
						       	<option value="2022" >2022</option>
						    </c:otherwise>
						</c:choose>
					<option value="2019">2019</option>
					<option value="2020">2020</option>
					<option value="2021">2021</option>						
					<option value="2022" >2022</option>
				</select> 
					</div>
					<div class="span1">
						<input class="btn btn-info" type="submit" name="id"
							value="Tìm kiếm">
					</div>
				</div>	
				<%ArrayList<Staff> StaffArray=(ArrayList<Staff>)request.getAttribute("StaffArray");
	for (int i=0;i<StaffArray.size();i++){
		%>	
	</form>
	<div class="row-fluid">
				<ul class="thumbnails">
					<li class="span4">
						<div class="thumbnail">

							<a class="zoomTool" href="product_details.html"
								title="xem chi tiết"><span class="icon-search"></span> QUICK
								VIEW</a> 
							<div class="caption cntr">
								<p><strong>Số lượng đăng ký</strong></p>
								<br/>
									<p style="font-size: 22px; font-weight: bold"><%=StaffArray.get(i).getDkphong()%></p>
								<br class="clr">
							</div>
						</div>
					</li>
					<li class="span4">
						<div class="thumbnail">
							<a class="zoomTool" href="product_details.html"
								title="xem chi tiết"><span class="icon-search"></span> QUICK
								VIEW</a> 
							<div class="caption cntr">
								<p><strong>Số lượng trả phòng</strong></p>
								<br/>
								<p style="font-size: 22px; font-weight: bold"> <%=StaffArray.get(i).getTraphong()%></p>
								<br class="clr">
							</div>
						</div>
					</li>
					<li class="span4">
						<div class="thumbnail">
							<a class="zoomTool" href="product_details.html"
								title="xem chi tiết"><span class="icon-search"></span> QUICK
								VIEW</a> 
							<div class="caption cntr">
								<p ><strong>Số phòng đang sử dụng</strong></p>
									<br/>
									<p style="font-size: 22px; font-weight: bold"><%=StaffArray.get(i).getPhongsd()%> </p>
								<br class="clr">
							</div>
						</div>
					</li>
				</ul>
			</div>
			
			
			<div class="row-fluid">
				<ul class="thumbnails">
					<li class="span4">
						<div class="thumbnail">

							<a class="zoomTool" href="product_details.html"
								title="xem chi tiết"><span class="icon-search"></span> QUICK
								VIEW</a> 
								<%-- <a href="product_details.html"><img
								src="<c:url value="/assets/user/img/vn1.png"/>" alt=""></a> --%>
							<div class="caption cntr">
								<p><strong>Phòng trống</strong></p>
								<!-- <p>
									<strong> $22.00</strong>
								</p> -->
								<br/>
									<p style="font-size: 22px; font-weight: bold"><%=StaffArray.get(i).getPhongtrong()%></p>
								<br class="clr">
							</div>
						</div>
					</li>
					<li class="span4">
						<div class="thumbnail">
							<a class="zoomTool" href="product_details.html"
								title="xem chi tiết"><span class="icon-search"></span> QUICK
								VIEW</a> 
							<div class="caption cntr">
								<p><strong>Số phòng sửa chữa</strong></p>
								<!-- <p>
									<strong> $22.00</strong>
								</p>
								<h4> -->
								<br/>
								<p style="font-size: 22px; font-weight: bold"> <%=StaffArray.get(i).getSuachua()%></p>
								<br class="clr">
							</div>
						</div>
					</li>
					<li class="span4">
						<div class="thumbnail">
							<a class="zoomTool" href="product_details.html"
								title="xem chi tiết"><span class="icon-search"></span> QUICK
								VIEW</a> 
							<div class="caption cntr">
								<p ><strong>Tổng thu</strong></p>
						<% long vnd=(long)StaffArray.get(i).getPhi();
											Locale localeVN = new Locale("vi", "VN");
		 NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
		 String tien=currencyVN.format(vnd);
		 %>
									<br/>
									<p style="font-size: 22px; font-weight: bold"><%=tien%> </p>
								<br class="clr">
							</div>
						</div>
					</li>
				</ul>
			</div>
	<%} %>	
</div>
</div>
<div><%@include file="/footer.jsp"%></div>
</body>

</html>