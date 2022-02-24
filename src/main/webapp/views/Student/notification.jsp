<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.ArrayList" %> 
<%@ page language="java" import="model.bean.Notification" %> 
<%@ page language="java" import="java.util.Collections" %> 
 <%@ page language="java" import="model.bean.Staff" %>    
 <%@ page language="java" import="java.util.ArrayList" %>
    
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
<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome-ie7.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.ie7.min.css" rel="stylesheet">
<link rel="shortcut icon" href="assets/ico/lg.ico">
<link rel="stylesheet prefetch" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
 .pagination {
  list-style: none;
  display: inline-block;
  padding: 0;
  margin-top: 10px;
}
.pagination a.active {
background-color: #187e23;
color: white;
/*Circle Design with CSS*/
border-radius: 50%;
/*  text-align: center;
 display: inline-block;
 position: absolute; */
}
/* add background color when user hovers on inactive class */
.pagination a:hover:not(.active) {
background-color: #ddd;
border-radius: 50%;
/*  text-align: center;
 display: inline-block;
 position: absolute; */
}
.pagination li {
  display: inline;
  text-align: center;
}
.pagination a {
  float: left;
  display: block;
  font-size: 18px;
  text-decoration: none;
  padding: 5px 12px;
  color: #662c6d;
  margin-left: -1px;
  border: 1px solid transparent;
  line-height: 1.5;
}
.pagination a.active {
  cursor: default;
}
.pagination a:active {
  outline: none;
}
.modal-3 a {
  margin-left: 3px;
  padding: 0;
  awidth: 30px;
  height: 30px;
  line-height: 30px;
  -moz-border-radius: 100%;
  -webkit-border-radius: 100%;
  border-radius: 100%;
}
.modal-3 a:hover {
  background-color: #4DAD16;
}
.modal-3 a.active, .modal-3 a:active {
  background-color: #37B247;
}
/* Set the style for the a tag */

</style>
</head>
<body>

<%@include file="headerStudent.jsp"%>
<div class="row" style="margin-left:-30px ;">
	<div id="sidebar" class="span3">
		<%@include file="menu.jsp"%>
	</div>
	<div class="span12">
	<h3 align="center">Thông báo</h3>
	<%ArrayList<Notification> NotificationArray=(ArrayList<Notification>) request.getAttribute("notiArray");
	int m=1;
	if( request.getAttribute("page")!=null){
		m=Integer.parseInt((String)request.getAttribute("page"));
	}
	for (int i=(m-1)*10;i<NotificationArray.size()&&i<m*10;i++){
		%>
			<div class="row">
				<div class="span1"></div>
				<div class="span1-5" style="color: red; font-family: Cambria; font-size:18px; font-weight:bold;"><%=NotificationArray.get(i).getNgay()%></div>
				<div class="span8"  style="color: blue; font-family: Cambria; font-size:18px; font-weight:bold;"><%=NotificationArray.get(i).getTieuDe()%></div>
			</div>
			<div class="row">
				<div class="span1"></div>
				<div class="span10"  style=" font-family: Cambria; font-size:18px;"><%=NotificationArray.get(i).getNoiDung()%></div>
			</div>	
		<br/>
	<%} %>
	   </div>
</div>		
		<!-- 	////// -->
		<div class="row" align="center"><ul class="pagination">
		<%if(m>1){ %>
		 <li><a href="thongbao?page=<%=m-1%>" class="prev">&laquo</a></li>
		 <%} else{ %> <li><a href="" class="prev">&laquo</a></li>
		 <%} %>
		<%for(int i=0; i<=NotificationArray.size()/10;i++){ 
		if(i+1==m){%>
		  <li><a href="thongbao?page=<%=i+1%>" class="active"><%=i+1%></a></li>
		<%}
		else{%>  <li><a href="thongbao?page=<%=i+1%>"><%=i+1%></a></li>
 <%}} %>
  <%if(m+1<=NotificationArray.size()/10+1){ %>
		 <li><a href="thongbao?page=<%=m+1%>" class="next">&raquo</a></li>
		 <%} else{ %> <li><a href="" class="next">&raquo</a></li>
		 <%} %>
</ul>	</div>

			
 <%@include file="/footer.jsp"%>
</body>
</html>