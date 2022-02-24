<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<div class="row">
		<div class="span3">
			<%@include file="menu.jsp"%>
		</div>
		<div  class="span12">
			<form action="<%=request.getContextPath()%>/CheckDoiMatKhau" method="post">
			
			<div class="well well-small" style="margin-top: 80px;">
				<h4  align="center" style=" color: green; ">ĐỔI MẬT KHẨU</h4>
				<hr class="soften" />
				<%-- <div align="center"style="color: red">
				<c:if = test="${not empty message }">
					<div class="alert alert-${alert}">${message}</div>
				</c:if>
			</div> --%>
				<div class="well well-small" style=" min-height: 70px; background: #ffffff; margin-bottom: 8px">
				<table align="center">			
			<%-- 		<tr>
						<td> <p>Sinh viên: </p>  </td>
						<td> 
							<div class="row-fluid">
								<p > ${ student.tenSV } - ${sessionScope.user }</p>
							</div>
						</td>
					</tr> --%>
					<tr>
						<td> Mật khẩu cũ: </td>
						<td>  <input type="password" id="old" name="old" ></td>
					</tr>
					<tr>
						<td> Mật khẩu mới: </td>
						<td>  <input type="password" id="new" name= "new" ></td>
					</tr>
					<tr>
						<td> Gõ lại mật khẩu mới: </td>
						<td>  <input type="password" id="renew" name="renew" ></td>
					</tr>
				</table> 		
				</div>
			</div>
				
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table> 
		<div class="row-fluid" style="margin-bottom: 80px;">
			<div class="span6"></div>
			<div class="span4"><button  align="center" id="update" name="update" class="snip1457">Xác nhận</button></div>
		</div>
	</form>
	</div>
</div>
<%@include file="footer.jsp"%>
<%-- <div class="row-fluid">
	<%@include file="footer.jsp"%>
</div> --%>

	
 
</body>
</html>