<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	    width: 100%;
	    margin-right: 60px;
	    border-radius: 10px;
	    background-color: #d9d3da;
	    padding: 20px;
	}
	
	input[type=text], textarea {
	    width: 100%;
	    padding: 12px;
	    border: 1px solid #ccc;
	    border-radius: 4px;
	    box-sizing: border-box;
	    margin-top: 6px;
	    margin-bottom: 16px;
	    resize: vertical;
	}
</style>

</head>
<body>
<%@include file="header.jsp"%>

	<div class="row" style="margin-top: 30px;">
		<div class="span3">
			<%@include file="menu.jsp"%>
		</div>
		<div class="span12">
			<form action="<%=request.getContextPath()%>/CheckThongBao" method="post">
				<div class="content">
			<div>
				<%-- <h3 style = "margin-left: 20px">
					<img src="<%=request.getContextPath() %>/assets/img/ktx.png" style="width: 300px; float: right; margin-right: 40px">
					Thông báo
				</h3> --%>
				<div style = "margin-left: 40px">
					<div>
						<div class="container-chat">
						    <h3>Đăng thông báo</h3>
						    <form action="<%=request.getContextPath() %>/admin/dang-thong-bao" method="post">
						  <%--   	<%
						        	if (request.getAttribute("thongbao") != null) {
						        %> --%>
						        <div align="center" style="color: red">
									<i>${message}</i>
								</div>
							<%-- 	<%
						        	}
								%>
						     --%>
						    	<span style="font-style: italic; color: red; font-size: 13px">${tieuDeError}</span>
						        <input type="text" id="tieude" name="tieude" value="${tb.tieuDe}" placeholder="Nhập tiêu đề">

						    	<span style="font-style: italic; color: red; font-size: 13px">${noiDungError}</span>
						        <textarea rows="10" cols="" id="noidung" name="noidung" placeholder="Nhập nội dung thông báo">${tb.noiDung}</textarea>
						        
						        <input class="btn btn-success" type="submit" value="Đăng">
								<input class="btn btn-warning" type="reset" value="Hủy">
						    </form>
						</div>
					</div>
				</div>
			</div>
		</div>
		
		</form>
		</div>
		</div>
</body>
</html>