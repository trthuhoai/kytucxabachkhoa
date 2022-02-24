<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
</style>
</head>
<body>
<%int i=0;%>
	<%@include file="headerStudent.jsp"%>
	   <form id="registerCheckoutForm" action="traphong" method="post">
	<div class="row">
		<div id="sidebar" class="span3">
			<%@include file="menu.jsp"%>
		</div>
		<div id="sidebar" class="span12">
			
				<div class="well well-small">
					<h4  align="center" style=" color: green; font-size:22px; ">Đăng ký trả phòng</h4>
					<hr class="soften" />
					<div class="well well-small"
						style="min-height: 70px; background: #ffffff; margin-bottom: 8px">
					
								<div class="row-fluid">
									<div class="span4"> </div> 
									<div class="span2"> <p>Sinh viên: </p></div>
									<div class="span4"><p > ${ student.tenSV } - ${sessionScope.user }</p></div>
									<div class="span1"></div>
								</div>
								<div class="row-fluid">
									<div class="span4"> </div> 
									<div class="span2"> <p>Học kỳ: </p></div>
									<div class="span4"><p > Kỳ 1 - Năm học 2021-2022</p></div>
									<div class="span1"></div>
								</div>
								<c:choose>
							 <c:when test="${empty detail }">
								<div class="row-fluid">
									<div class="span4"> </div> 
									<div class="span2"> <p>Thời gian trả phòng: </p></div>
									<div class="span4">	<input type="text" name="ngay" id="datepicker" ></input> </div>
									<div class="span1"></div>
								</div>
							
								<div class="row-fluid">
									<div class="span4"> </div> 
									<div class="span2"> <p>Lý do trả phòng: </p></div>
									<div class="span4"> <textarea rows="4" cols="50" name="lydo" form="registerCheckoutForm"></textarea></div>
									<div class="span1"></div>
								</div>
								</c:when>
								 <c:otherwise>	
								 <div class="row-fluid">
									<div class="span4"> </div> 
									<div class="span2"> <p>Thời gian trả phòng: </p></div>
									<div class="span4">	<input type="text" name="ngay" id="datepicker" value="${ detail.ngayTraPhong }"></input> </div>
									<div class="span1"></div>
								</div>
							
								<div class="row-fluid">
									<div class="span4"> </div> 
									<div class="span2"> <p>Lý do trả phòng: </p></div>
									<div class="span4"> <textarea rows="4" cols="50" name="lydo" form="registerCheckoutForm">${ detail.lyDoTraPhong }</textarea></div>
									<div class="span1"></div>
								</div>
								</c:otherwise>
								 </c:choose>
									
						</div>
								<table align="center">
					<tr>
						<td style="font-style: italic; color: red;">${message}</td>
					</tr>
				</table> 
				<div class="row-fluid">
					<div class="span6"></div>		
					<div class="span4"><button onclick="return validate();"   align="center" id="update" name="update" class="snip1457"
								>Đăng ký</button></div>
				</div>
					</div>
				
	
		</div>
	</div>
	<%@include file="/footer.jsp"%>
	<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>

<div id="popup-giua-man-hinh">
<div class="popUpBannerBox">
 <div class="popUpBannerInner">
  <div class="popUpBannerContent">
   <p><a href="#" class="closeButton">Close</a></p>

	<div class="well well-small" style=" background: #643544;">
					<h3  align="center" style=" color: green; font-size:18px; ">Thông báo</h3>
					<hr class="soften" />
						<div class="well well-small" style="border-radius:0px; background: #ffffff;">
							<h5 style=" color: #643544; font-weight: 10px">Bạn có chắc chắn muốn đăng ký Phòng <span id="p" name="phong"></span> Nhà <span name="khu" id="k"></span> không? </h5>
						</div>
			
				<div class="row-fluid">
					<div class="span3"></div>		
					<div class="span4"><button  align="center" id="huy" name="huy" class="btn btn-danger"
								>Hủy</button></div>	
					<div class="span4"><button    align="center" class="btn btn-info"
								>Đăng ký</button></div>
				</div>
					</div>
							
  </div>
 </div>
</div>
	</form>
	<script src="assets/js/dictrict.js"></script>
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
	<script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
	<script src="assets/js/shop.js"></script>
	<script src="assets/js/shop.js"></script>
  	<script src="assets/jquery/jquery-ui.js"></script> 
   	<script src="assets/jquery/jquery-ui.min.js"></script> 
   	 <link href="assets/jquery/jquery-ui.min.css" type="text/css" rel="stylesheet"/> 
<script type="text/javascript">

 $('#datepicker').datepicker(
	      {
	        dateFormat: 'dd/mm/yy'    
	      }
	    );

 function showPopUpBanner() {
  $('.popUpBannerBox').fadeIn("2000");
 }
/*  $('#press').click(function() {
	 console.log("fffff");

} */
	/* console.log("fffff"); */
/* setTimeout(showPopUpBanner, 1000);   */ //thời gian popup bắt đầu hiển thị

 $('.popUpBannerBox').click(function(e) {
  if ( !$(e.target).is('.popUpBannerContent, .popUpBannerContent *' ) ) {
   $('.popUpBannerBox').fadeOut("2000");
   return false;
  }
 });
 $('.clo').click(function() {
	  $('.popUpBannerBox').fadeIn("2000");
	 });
 $('.closeButton').click(function() {
  $('.popUpBannerBox').fadeOut("2000");
  return false;
 });
 $('#huy').click(function() {
	  $('.popUpBannerBox').fadeOut("2000");
	  return false;
	 });
</script>
</div>
	<script src="assets/js/dictrict.js"></script>
	<script src="assets/js/jquery.js"></script>
	<script src="assets/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.easing-1.3.min.js"></script>
	<script src="assets/js/jquery.scrollTo-1.4.3.1-min.js"></script>
	<script src="assets/js/shop.js"></script>
	<script src="assets/js/shop.js"></script>
  	<script src="assets/jquery/jquery-ui.js"></script> 
   	<script src="assets/jquery/jquery-ui.min.js"></script> 
   	
	<script  src="assets/jquery/jquery.blockUI.js"></script>

 <script>

	function getValue(id){
		return document.getElementById(id).value.trim();
	}
	
	function validate(){
		var flag=true;
		var khu=getValue("khu");
 		var phong=getValue("phong");
		if(khu==''||phong==''){
			window.alert("Vui lòng nhập đầy đủ thông tin");
			flag=false; 
		} 
		else if(phong.length!=3){
			window.alert("Bạn đã nhập sai phòng");
			flag=false; 
		}
		else{
			document.getElementById("p").innerHTML = phong;
			document.getElementById("k").innerHTML = khu;
			 $('.popUpBannerBox').fadeIn("2000");
		}
	
 	return false; 
	}
	</script>
</body>
</html>