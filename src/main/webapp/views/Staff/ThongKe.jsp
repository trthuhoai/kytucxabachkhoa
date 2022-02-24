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
<style>
	.container-chat {
	    width: 100%;
	    margin-right: 60px;
	    border-radius: 10px;
	    background-color: #d9d3da;
	    padding: 20px;
	}
		.container-chat1 {
	    width: 98%;
/* 	    margin-right: 60px;
	    margin-lè: 60px; */
	    border-radius: 10px;
	    background-color: #ffffff;
	    padding: 10px;
	}
	p{
	 font-size: 16px;
	  font-weight: bold;
	}
</style>
<!-- <style>
            ul{
                width: 250px;
            }

            ul li{
                height: 30px;           /*Cao 30px*/
                line-height: 30px;      /*Cho chữ canh giữa 30px*/    
                list-style: none;       /*Không hiển thị dấu chấm đầu menu*/
                padding: 0px 10px;      /*đẩy nôi dung menu vào 10cm (trái + phải)*/
                background: #33FF66;       /*màu nèn màu hồng*/
                border: solid 1px black;  /*đường viền màu đỏ*/
                border-bottom: none;    /*vì menu liền kề nhau nên border-bottom không cần*/
                position: relative;     /*chọn làm khung*/
            }

            ul li:last-child{
                border-bottom: solid 1px black;
            }

            ul li ul{
                position: absolute;     
                top: -1px;          /*cho ngang hàng với menu cha, vì menu cha có border - 1 nên ta phải trừ đi 1*/
                right: -250px;      /*vì nàm ngoài khung và dài 250px nên là số âm 250px */
                display: none;      /*Ban đầu sẽ không hiển thị*/
            }

            ul li:hover ul{
                display: block;
            }
        </style> -->
        <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
        
</head>

<body>
 <%@include file="header.jsp"%>

	<div class="row" style="margin-top: 30px;">
		<div class="span3">
			<%@include file="menu.jsp"%>
		</div>
		<div class="span12">
    <form action="<%=request.getContextPath()%>/CheckThongKe" method="post">
 		<table border="1"  align="center">
				<div class="row">
					<div class="span3">
				<select  name="nam">
						<option value="2022" >2022</option>
						<option value="2021">2021</option>						
						<option value="2020">2020</option>
						<option value="2019">2019</option>
				</select> 
					</div>
					<div class="span1">
						<input class="btn btn-info" type="submit" name="id"
							value="Tìm kiếm">
					</div>
					<!-- <div class="span2"></div>
					<div class="span4">
						<input class="btn btn-success" type="submit" name="id"
							value="Cập nhật">
					</div> -->
				</div>
				<h3>Thống kê hằng năm</h3>
				<%ArrayList<Staff> StaffArray=(ArrayList<Staff>)request.getAttribute("StaffArray");
	for (int i=0;i<StaffArray.size();i++){
		%>
				 <div class="container-chat">
				  <div class="container-chat1">
 					<div class="row">
 					<div class="span1"></div>
 					<div class="span2"><p>Số lượng đăng ký:</p></div>
 					<div class="span1"><p><%=StaffArray.get(i).getDkphong()%></p>
 					</div>
 					<div class="span2"><p>Trả phòng</div>
 					<div class="span1"><p> <%=StaffArray.get(i).getTraphong()%></p></div>
 						<div class="span3"><p>Số phòng đang sử dụng:</div>
 					<div class="span1"><p><%=StaffArray.get(i).getPhongsd()%> </p></div>
 					</div>
 					
 						<div class="row">
 					<div class="span1"></div>
 					<div class="span2"><p>Phòng trống:</p></div>
 					<div class="span1"><p><%=StaffArray.get(i).getPhongtrong()%></p>
 					</div>
 					<div class="span2"><p>Số phòng sửa chữa:</p></div>
 					<div class="span1"><p><%=StaffArray.get(i).getSuachua()%></p></div>
 						<div class="span3"><p>Tổng thu:</div>
 					<div class="span1"><p><p><%=StaffArray.get(i).getPhi()%> </p></div>
 					</div>
 					</div>
 				</div>
 					<%} %>

		
           
	</form>
</div>
</div>
</body>

</html>