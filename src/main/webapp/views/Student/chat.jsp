<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!--  <script type="text/javascript" src="assets/js/load.js"></script> -->
<!-- <meta http-equiv="refresh" content="10;url=http://localhost:9090/kytucxabachkhoa/nhantin"> -->
<title>Ký túc xá bách khoa</title>
<!-- 	<script src="assets/js/dictrict.js"></script> -->

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
<style type="text/css">
#popup-giua-man-hinh .headerContainer,#popup-giua-man-hinh .bodyContainer,#popup-giua-man-hinh .footerContainer{max-width:960px;margin:0 auto;background:#FFF}
#popup-giua-man-hinh .padding{padding:20px}
#popup-giua-man-hinh .bodyContainer{min-height:500px}
#popup-giua-man-hinh .popUpBannerBox{position:fixed;background:rgba(0,0,0,0.9);width:100%;height:100%;top:0;left:0;color:#FFF;z-index:999999;display:none}
#popup-giua-man-hinh .popUpBannerInner{max-width:500px;margin:0 auto}
#popup-giua-man-hinh .popUpBannerContent{position:fixed;top:150px}
#popup-giua-man-hinh .closeButton{color:red;text-decoration:none;font-size:18px}
#popup-giua-man-hinh a.closeButton{float:right}
#chatDiv{
height:600px;
width:100%;
overflow:auto; 
}
			
.fancy-btn{
  display:inline-block;
  position:relative;
  padding:10px 20px;
  border:2px solid #98358c;
  color:#98358c;
  font-family:'Dancing Script',serif;
  font-style:italic;
  font-size:30px;
  text-decoration:none;
  margin:20px auto;
  transition: color 0.4s
}
.fancy-btn:after{
  content:" ";
  border:2px solid rgba(0,0,0,0);
  display:inline-block;
  width:100%;
  height:100%;
  position:absolute;
  top:0;
  left:0;
  right:0;
  bottom:0;
  margin:auto;
  transition:all 0.4s;
}
.fancy-btn:hover{
  color:green
}
.fancy-btn:hover:after{  
  border:2px solid #98358c;
  width: calc(100% - 10px);
  height: calc(100% + 10px); 
}



/* follow me @nodws */
#btn-twtr{
  clear:both;
  color:#98358c;
  border:2px solid;
  border-radius:3px;
  text-align:center;
  text-decoration:none;
  display:block;
  font-family:sans-serif;
  font-size:14px;
  width:13em;
  padding:5px 10px;
  font-weight:600;
  margin:90px auto;
  background:rgba(0,0,0,0.2);
  box-shadow:0 0 0px 3px rgba(0,0,0,0.2);
  opacity:0.6
}#btn-twtr:hover{color:#98358c;opacity:1}
			
			
</style>

</head>
<body onload="cuon();">
<%int i=0;%>
	<%@include file="headerStudent.jsp"%>
<% String nhanvien = (String) request.getAttribute("nv"); %>
	 <form id="chatForm" action="nhantin" method="post"> 
	<div class="row">
		<div id="sidebar" class="span3">
			<%@include file="menu.jsp"%>
		</div>

		<div id="sidebar" class="span12">
	<input type="hidden" name="nhanvien" value="<%=nhanvien%>">
			<div class="row">
			<div class="span2">	</div>
			<div class="span3">	<a href="nhantin?nhanvien=10218" class="fancy-btn">Bộ phận tài chính</a>  <br></div>
	<div class="span3">	
<a href="nhantin?nhanvien=10219" class="fancy-btn">Bộ phận sửa chữa</a> <br></div>
	<div class="span3">	
<a href="nhantin?nhanvien=10217" class="fancy-btn">Đội tự quản</a> <br></div>
</div>
			<div class="well well-small" style="margin-bottom:2px; background: #e3e3e3;">
				<h4  style=" color: green; font-size:22px; "><%if(nhanvien==null||nhanvien.equals("10218")){
					out.print("Bộ phận tài chính");} else if(nhanvien.equals("10219")){out.print("Bộ phận sửa chữa");}
					else{
						out.print("Đội tự quản");
					}
					%></h4>
				
				<div id="chatDiv" style="margin-bottom:2px; background: #ffffff;" >
				<hr class="soften" />	
				<c:forEach var="item" items="${ chat }" varStatus="index">
				<div class="row" align="center">${ item.thoiGian }</div>
				<c:choose>
					<c:when test="${ item.nguoiGui==sessionScope.user  }">
						<c:choose>
							<c:when test="${ item.lenNoiDung<8  }">
								<div class="row" >
									<div class="span10"></div>
									<div class="span1" align="right">
										 <div class="well well-small" style="padding: 9px;color: #ffffff; font-size: 16px; min-height: 0px; background: #6d4579; margin-bottom: 0px">${ item.noiDung }
												<%-- <div align="right" class="row"  style="color: #ffffff; font-size: 10px;">${ item.thoiGian }</div> --%></div>
										</div>
								</div>
								</c:when>
								<c:when test="${ item.lenNoiDung>=8 && item.lenNoiDung<20  }">
								<div class="row" >
									<div class="span9"></div>
									<div class="span2" align="right">
										 <div class="well well-small"
										style="padding: 9px;color: #ffffff; font-size: 16px; min-height: 0px; background: #6d4579; margin-bottom: 0px">${ item.noiDung }
												<%-- <div align="right" class="row"  style="color: #ffffff; font-size: 10px;">${ item.thoiGian }</div> --%></div>
										</div>
								</div>
								</c:when>
								<c:when test="${ item.lenNoiDung>=20 && item.lenNoiDung<30  }">
								<div class="row" >
									<div class="span8"></div>
									<div class="span3" align="right">
										 <div class="well well-small"
										style="padding: 9px;color: #ffffff; font-size: 16px; min-height: 0px; background: #6d4579; margin-bottom: 0px">${ item.noiDung }
												<%-- <div align="right" class="row"  style="color: #ffffff; font-size: 10px;">${ item.thoiGian }</div> --%></div>
										</div>
								</div>
								</c:when>
								<c:when test="${ item.lenNoiDung>=30 && item.lenNoiDung<60  }">
								<div class="row" >
									<div class="span7"></div>
									<div class="span4" align="right">
										 <div class="well well-small"
										style="padding: 9px;color: #ffffff; font-size: 16px; min-height: 0px; background: #6d4579; margin-bottom: 0px">${ item.noiDung }
												<%-- <div align="right" class="row"  style="color: #ffffff; font-size: 10px;">${ item.thoiGian }</div> --%></div>
										</div>
								</div>
								</c:when>
									<c:otherwise>
									<div class="row" >
									<div class="span6"></div>
									<div class="span5" align="right">
										 <div class="well well-small"
										style="padding: 9px;color: #ffffff; font-size: 16px; min-height: 0px; background: #6d4579; margin-bottom: 0px">${ item.noiDung }
												<%-- <div align="right" class="row"  style="color: #ffffff; font-size: 10px;">${ item.thoiGian }</div> --%></div>
										</div>
								</div>
									</c:otherwise>
								</c:choose>
					</c:when>
					<c:otherwise>
					<c:choose>
								<c:when test="${ item.lenNoiDung<8  }">
									<div class="row">
										<div class="span1">					
											<div class="well well-small" style="padding: 9px;font-size: 16px;;min-height: 0px; background: #dbd2dc; margin-bottom:0px">${ item.noiDung }</div>
										</div>
									</div>
								</c:when>
								<c:when test="${ item.lenNoiDung>=8 && item.lenNoiDung<20  }">
									<div class="row">
										<div class="span2">					
											<div class="well well-small" style="padding: 9px;font-size: 16px;;min-height: 0px; background: #dbd2dc; margin-bottom:0px">${ item.noiDung }</div>
										</div>
									</div>
								</c:when>
								<c:when test="${ item.lenNoiDung>=20 && item.lenNoiDung<30  }">
									<div class="row">
											<div class="span3">					
												<div class="well well-small" style="padding: 9px;font-size: 16px;;min-height: 0px; background: #dbd2dc; margin-bottom:0px">${ item.noiDung }</div>
											</div>
										</div>
									</c:when>
								<c:when test="${ item.lenNoiDung>=30 && item.lenNoiDung<60  }">
									<div class="row">
											<div class="span4">					
												<div class="well well-small" style="padding: 9px;font-size: 16px;;min-height: 0px; background: #dbd2dc; margin-bottom:0px">${ item.noiDung }</div>
											</div>
										</div>
								</c:when>
									<c:otherwise>
										<div class="row">
											<div class="span5">					
												<div class="well well-small" style="padding: 9px;font-size: 16px;;min-height: 0px; background: #dbd2dc; margin-bottom:0px">${ item.noiDung }</div>
											</div>
										</div>
									</c:otherwise>
								</c:choose>
					</c:otherwise>
				</c:choose>
			</c:forEach> 
			<div id="nt" class="row" ></div>
			</div>
				</div>
			<div id="ntDiv" class="well well-small" style="padding: 9px;font-size: 16px;;min-height: 60px; background: #ffffff; margin-bottom:0px">
		<!-- <div class="span1"></div>  -->
		<div class="row">
			<div class="span10"> <input autocomplete="off"  class="input-text" name="mess" placeholder="Nhập tin nhắn..."  spellcheck="false" type="text" style="padding:20px;" /></div>
			 <div class="span1"></div>  
			 <div class="span1"><button class="snip1457">Gửi</button>	</div>
			</div>
 
</div>
				
				
	</div>
			
		
	</div>
				
	 </form>		
	<%@include file="/footer.jsp"%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="assets/js/dictrict.js"></script>
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
	<script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
	<script src="assets/js/shop.js"></script>
	<script src="assets/js/shop.js"></script>
  	<script src="assets/jquery/jquery-ui.js"></script> 
   	<script src="assets/jquery/jquery-ui.min.js"></script> 
   	 <script type="text/javascript" src="assets/js/load.js"></script>
	<script  src="assets/jquery/jquery.blockUI.js"></script>
    <script>

 setInterval(Load, 2000);
function cuon(){
	document.getElementById("nt").scrollIntoView();
}
function Load() {
	var nhanvien =<%= nhanvien%>;
    /* var amount = document.getElementsByClassName("product").length; */
    $.ajax({
        url: "/kytucxabachkhoa/load?nhanvien="+nhanvien,
        type: "get", //send it through get method
        success: function (data) {
            var row = document.getElementById("chatDiv");
            row.innerHTML = data;
        },
        error: function (xhr) {
            //Do Something to handle error
        }
    });
}
</script>
</body>
</html>