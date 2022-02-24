<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
 <%@ page language="java" import="model.bean.Staff" %>    
 <%@ page language="java" import="java.util.ArrayList" %>
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
        </style>
        --> <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js" ></script>
        
</head>

<body>
 <%@include file="header.jsp"%>

	<div class="row" style="margin-top: 30px;">
		<div class="span3">
			<%@include file="menu.jsp"%>
		</div>
		<div class="span12">
    <form action="<%=request.getContextPath()%>/Check_DSDK" method="post">
    		<h3 style="font-size: 26px;">Danh sách đăng ký lưu trú</h3>
   	<div class="row">
					<div class="span3">
						<input type="text"  name="timkiem" value="">
					</div>
					<div class="span1">
						<input class="btn btn-info" type="submit" name="id"
							value="Tìm kiếm">
					</div>
					<div class="span2"></div>
					<div class="span4">
						<input class="btn btn-success" type="submit" name="id"
							value="Cập nhật">
					</div>
				</div>
		
		<table  class="table table-striped table-bordered table-hover" border="1">
<!-- 	<tr> 	
	    <td><input type="text" name="timkiem"value=""></td>
		<td><input type="submit" name="id"value="timkiem"></td>
		<td><input type="submit" name="id"value="capnhat"></td>
		<td><input type="submit" name="id"value="reset"></td>
		
	</tr>	 -->
	<tr style="background-color: blue; color: #ffffff; font-weight: bold;" align="center"> 
	
	<th style="background-color: #724585">Mã sinh viên</th>
	<th style="background-color: #724585">Tên sinh viên</th>
	<th style="background-color: #724585">Phòng</th>
	<th style="background-color: #724585">Khu</th>
	<th style="background-color: #724585">Chấp nhận</th>
	</tr>
	  
	
	<%ArrayList<Staff> StaffArray=(ArrayList<Staff>) request.getAttribute("StaffArray");
	for (int i=0;i<StaffArray.size();i++){
		%>
		<tr>
		
		
		<td><%=StaffArray.get(i).getMasv()%></td>
		<td><%=StaffArray.get(i).getTensv()%></td>
		<td><%=StaffArray.get(i).getTenphong()%></td>
		<td>Nhà <%=StaffArray.get(i).getNha() %></td> 
	   <td><input type="checkbox" name="check" value="<%=StaffArray.get(i).getMasv()%>"></td>
	<%} %>
          
			</tr>     
		</table>
           
	</form>
</div>
</div>
</body>

</html>