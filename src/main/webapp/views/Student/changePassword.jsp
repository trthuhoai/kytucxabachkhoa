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
	<%@include file="headerStudent.jsp"%>
	<div class="row">
		<div id="sidebar" class="span3">
			<%@include file="menu.jsp"%>
		</div>
		<div id="sidebar" class="span12">
			<form id="changePasswordForm" action="changePasswordProcess" method="post">
			<div class="well well-small">
				<h4  align="center" style=" color: green">ĐỔI MẬT KHẨU</h4>
				<hr class="soften" />
				<div class="well well-small" style="min-height: 70px; background: #ffffff; margin-bottom: 8px">
				<table align="center">			
					<tr>
						<td> <p>Sinh viên: </p>  </td>
						<td> 
							<div class="row-fluid">
								<p > ${ student.tenSV } - ${sessionScope.user }</p>
							</div>
						</td>
					</tr>
					<tr>
						<td> Mật khẩu cũ: </td>
						<td>  <input type="password" id="oldpassword" name="oldpassword" ></td>
					</tr>
					<tr>
						<td> Mật khẩu mới: </td>
						<td>  <input type="password" id="newpassword" name= "newpassword" ></td>
					</tr>
					<tr>
						<td> Gõ lại mật khẩu mới: </td>
						<td>  <input type="password" id="renewpassword" name="renewpassword" ></td>
					</tr>
				</table> 		
				</div>
			</div>
				
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table> 
		<div class="row-fluid">
			<div class="span6"></div>
			<div class="span4"><button onclick="return validate(${ student.matKhau });" align="center" id="update" name="update" class="snip1457">Xác nhận</button></div>
		</div>
	</form>
	</div>
</div>
	<%@include file="/footer.jsp"%>


	
 <script>
	function getValue(id){
		return document.getElementById(id).value.trim();
	}
	
	function validate(a){
		var flag=true;
		var oldPassword=getValue("oldpassword");
		var newPassword=getValue("newpassword");
 		var reNewPassword=getValue("renewpassword");
		if(oldPassword==''||newPassword==''||reNewPassword==''){
			window.alert("Vui lòng nhập đầy đủ thông tin");
			flag=false; 
		} 
		else if(oldPassword!=a){
			window.alert("Nhập mật cũ không đúng");
			flag=false; 
		} 
		else if(newPassword!=reNewPassword){
			window.alert("Gõ lại mật khẩu mới không trùng với mật khẩu mới");
			flag=false; 
		}
	
	return flag;
	}
	</script>
</body>
</html>