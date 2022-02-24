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
$color1: #e51f1f;
$color2: #e51f1f;

body {
  display: flex;
  align-items: center;
  justify-content: center;
  min-height: 100vh;
}
 input[type='radio']:after {
        width: 12px;
        height: 12px;
        border-radius: 15px;
        top: -2px;
        left: -1px;
        position: relative;
        background-color: #ffffff;
        content: '';
        display: inline-block;
        visibility: visible;
        border: 2px solid green;
    }

    input[type='radio']:checked:after {
        width: 14px;
        height: 14px;
        border-radius: 15px;
        top: -2px;
        left: -1px;
        position: relative;
        background-color: #891ea0;
        content: '';
        display: inline-block;
        visibility: visible;
        border: 2px solid white;
    }
.radio {
  margin: 0rem;
  input[type="radio"] {
    position: absolute;
    opacity: 0;
    + .radio-label {
      &:before {
        content: '';
        background: $color1;
        border-radius: 100%;
        border: 1px solid darken($color1, 25%);
        display: inline-block;
        width: 1.4em;
        height: 1.4em;
        position: relative;
        top: -0.2em;
        margin-right: 1em; 
        vertical-align: top;
        cursor: pointer;
        text-align: center;
        transition: all 250ms ease;
      }
    }
    &:checked {
      + .radio-label {
        &:before {
          background-color: $color2;
          box-shadow: inset 0 0 0 4px $color1;
        }
      }
    }
    &:focus {
      + .radio-label {
        &:before {
          outline: none;
          border-color: $color2;
        }
      }
    }
    &:disabled {
      + .radio-label {
        &:before {
          box-shadow: inset 0 0 0 4px $color1;
          border-color: darken($color1, 25%);
          background: darken($color1, 25%);
        }
      }
    }
    + .radio-label {
      &:empty {
        &:before {
          margin-right: 0;
        }
      }
    }
  }
}
</style>
</head>
<body>
<%int i=0;%>
	<%@include file="headerStudent.jsp"%>
	   <form id="registerRoomForm" action="phidiennuoc" method="post">
	<div class="row">
		<div id="sidebar" class="span3">
			<%@include file="menu.jsp"%>
		</div>
		<div id="sidebar" class="span12">
			
				<div class="well well-small">
					<h4  align="center" style=" color: green; font-size:22px; ">Thông tin phí điện nước</h4>
					<hr class="soften" />
					<div class="well well-small"
						style="min-height: 70px; background: #ffffff; margin-bottom: 8px">
						
								<div class="row">
									<div class="span2"></div> 
									<div class="span1-5"><p>Thời gian: </p></div>
									<div class="span3"><b >${ charge.thoiGian } </b></div>
									
								</div>
								<div class="row">
									<div class="span2"></div> 
									<div class="span1-5"><p>Khu: </p></div>
									<div class="span3"><b> Nhà ${ room.nha }</b></div>
									<div class="span2"><p>Phòng: </p></div>
									<div class="span2"><b >${room.phong }</b></div>
								</div>
								<div class="row">
									<div class="span2"></div> 
									<div class="span1-5"><p>Số tiền: </p></div>
									<div class="span3"><b>${ tongtien }</b></div>
									<div class="span2"><p>Thời hạn: </p></div>
									<div class="span2"><b >${charge.thoiHan }</b></div>
								</div>
								<div class="row">
									<div class="span2"></div> 
									<div class="span1-5"><p>Trạng thái: </p></div>
									<c:choose>
									<c:when test="${charge.trangThai }">
									<div class="span3"><b >Đã thanh toán</b></div>
									</c:when>
									<c:otherwise>
									<div class="span3"><b >Chưa thanh toán</b></div>
									</c:otherwise>
									</c:choose>
									<div class="span2"><p>Người đại diện nộp: </p></div>
									<div class="span2"> <input type="text" id="daidien" name="daidien"  value="${charge.nguoiNop }"></div>
								</div>
								<div class="row">
									<div class="span2"></div> 
									<div class="span1-5"><p>Chọn hình thức thanh toán: </p></div>
									<div class="span3">	<div class="radio"><input type="radio" id="radio1" name="httt" value="0" /><label>Chuyển khoản</label></div></div>
									<div class="span3"><div class="radio"><input type="radio" id="radio1" name="httt" value="1" /><label>Thanh toán trực tiếp</label></div></div>
								</div>	
						</div>
								<table align="center">
					<tr>
						<td style="font-style: italic; color: red;">${message}</td>
					</tr>
				</table> 
				<div class="row-fluid">
					<div class="span7"></div>		
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
					<h3  align="center" style=" color: green; font-size:25px; ">Thông báo</h3>
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
<script type="text/javascript">
 function showPopUpBanner() {
  $('.popUpBannerBox').fadeIn("2000");
 }
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