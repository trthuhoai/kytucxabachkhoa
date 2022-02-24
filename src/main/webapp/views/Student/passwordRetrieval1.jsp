<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome-ie7.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.ie7.min.css" rel="stylesheet">
<link rel="shortcut icon" href="assets/ico/lg.ico">
</head>
<body>
	<%@include file="/header1.jsp"%>
	<div class="navbar" style="padding-right: 20px; padding-left: 20px;">
			<form id="passwordRetrievalForm" action="resetpassword" method="post">
				<div class="well well-small" >
					<h4  align="center" style=" color: green;">LẤY LẠI MẬT KHẨU</h4>
					<hr class="soften" />
					<div class="well well-small"
						style="min-height: 70px; background: #ffffff; margin-bottom: 8px">
						<c:choose>
							 <c:when test="${detail.mssv == null}">
								<div class="row">
									<div class="span3"></div>
									<div class="span1"><p>Họ và tên: </p></div>
									<div class="span0"><p  style=" color: red;">*</p></div>
									<div class="span4"> <input type="text" id="hovaten" name= "hovaten" > </div>
									<div class="span0-5">MSSV: </div>
									<div class="span0"><p  style=" color: red;">*</p> </div>
									<div class="span2"><input type="text" id="mssv" name="mssv" > </div>
								</div>
								<div class="row">
									<div class="span3"></div>
									<div class="span1"><p>Lớp: </p></div>
									<div class="span0"><p  style=" color: red;">*</p></div>
									<div class="span4">  <input type="text" id="lop" name= "lop" > </div>
									<div class="span0-5">Email: </div>
									<div class="span0"><p  style=" color: red;">*</p> </div>
									<div class="span2"> <input type="text" id="email" name="email" >  </div>
								</div>
								<div class="row">
									<div class="span3"></div>
									<div class="span1"><p>Khu: </p></div>
									<div class="span0"><p  style=" color: red;">*</p></div>
									<div class="span4"><select id="khu" name="khu" >
		  									<option value="">Chọn khu</option>
		  									<option  value="3">Nhà 3</option>
		  									<option  value="4">Nhà 4</option>
		  									<option  value="5">Nhà 5</option>
										</select> 
										 <!-- <input type="text" id="khu" name="khu" >  -->
										 </div>
									<div class="span0-5">Phòng: </div>
									<div class="span0"><p  style=" color: red;">*</p> </div>
									<div class="span2"><input type="text" id="phong" name="phong" >  </div>
								</div>
							</c:when> 
							<c:otherwise>
								<div class="row">
									<div class="span3"></div>
									<div class="span1"><p>Họ và tên: </p></div>
									<div class="span0"><p  style=" color: red;">*</p></div>
									<div class="span4"> <input type="text" id="hovaten" name= "hovaten" value="${ detail.hoVaTen }"> </div>
									<div class="span0-5">MSSV: </div>
									<div class="span0"><p  style=" color: red;">*</p> </div>
									<div class="span2"><input type="text" id="mssv" name="mssv" value="${ detail.mssv }"> </div>
								</div>
								<div class="row">
									<div class="span3"></div>
									<div class="span1"><p>Lớp: </p></div>
									<div class="span0"><p  style=" color: red;">*</p></div>
									<div class="span4">  <input type="text" id="lop" name= "lop" value="${ detail.lop }"> </div>
									<div class="span0-5">Email: </div>
									<div class="span0"><p  style=" color: red;">*</p> </div>
									<div class="span2"> <input type="text" id="email" name="email" value="${ detail.email }">  </div>
								</div>
								<div class="row">
									<div class="span3"></div>
									<div class="span1"><p>Khu: </p></div>
									<div class="span0"><p  style=" color: red;">*</p></div>
									<div class="span4">
										<select id="khu" name="khu" >
		  									<option value="${ detail.khu }">Nhà ${ detail.khu }</option>
		  									<option  value="3">Nhà 3</option>
		  									<option  value="4">Nhà 4</option>
		  									<option  value="5">Nhà 5</option>
										</select> 
									<%-- <input type="text" id="khu" name="khu" value="${ detail.khu }">  --%>
									</div>
									<div class="span0-5">Phòng: </div>
									<div class="span0"><p  style=" color: red;">*</p> </div>
									<div class="span2"><input type="text" id="phong" name="phong" value="${ detail.phong }">  </div>
								</div>
							</c:otherwise>
						</c:choose>
					</div>

				</div>
				
	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table> 
	<div class="row-fluid">
		<div class="span4"></div>
		<div class="span1"><div  onclick="return reset();" id="reset" name="reset" align="center" class="snip1458">Hủy</div></div>
			<div class="span1"></div>
		<div class="span2"><button onclick="return validate();"   align="center" id="update" name="update" class="snip1457">Xác nhận</button></div>
	</div> 
</form>
</div>
	
	<%@include file="/footer.jsp"%>


	
 <script>
	function getValue(id){
		return document.getElementById(id).value.trim();
	}
	
	function validate(){
		var flag=true;
		var hovaten=getValue("hovaten");
		var mssv=getValue("mssv");
		var lop=getValue("lop");
		var khu=getValue("khu");
		var phong=getValue("phong");
		var email=getValue("email");
		if(hovaten==''||mssv==''||lop==''||khu==''||email==''||phong==''){
			window.alert("Vui lòng nhập đầy đủ thông tin");
			flag=false; 
		} 
	return flag;
	}
	function reset(){
		document.getElementById('hovaten').value="";
		document.getElementById('mssv').value="";
		document.getElementById('lop').value="";
		document.getElementById('khu').value="";
		document.getElementById('phong').value="";
		document.getElementById('email').value="";
	
	return false;
	}
</script>
</body>
</html>