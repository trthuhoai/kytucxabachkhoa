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
</head>
<body>
	<%@include file="headerStudent.jsp"%>
	<!--  style="margin-left:-30px ;"   -->

	<div class="row">
		<div id="sidebar" class="span3">
			<%@include file="menu.jsp"%>
		</div>
		<div id="sidebar" class="span12">
			<form id="personalInfoForm" action="updateInfoProcess" method="post">
				<div class="well well-small">
					<h4>THÔNG TIN CÁ NHÂN</h4>
					<hr class="soften" />
					<div class="well well-small"
						style="min-height: 70px; background: #ffffff; margin-bottom: 8px">
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Họ và tên:</p>
							</div>
							<div class="span3">
								<p> ${ student.tenSV }</p>
							</div>
							<div class="span2">
								<p>Quê quán:</p>
							</div>
							<div class="span2">
								<p>${ student.diaChi }</p>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Số CMND/CCCD:</p>
							</div>
							<div class="span3">
								<p> ${ student.soCCCD }</p>
							</div>
							<div class="span2">
								<p>Email:</p>
							</div>
							<div class="span3">
							 <input type="text" name="email" value="${ student.email }"> 
								<%-- <p>${ student.email }</p> --%>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Ngày sinh:</p>
							</div>
							<div class="span3">
								<p>${ student.ngaySinh }</p>
							</div>
							<div class="span2">
								<p>Số điện thoại:</p>
								 
							</div>
							<div class="span3">
								 <input type="text" name="sdt" value="${ student.SDT }"> 
							</div>
						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Ngành:</p>
							</div>
							<div class="span3">
								<p>${ student.nganh }</p>
							</div>
							<div class="span2">
								<p>Số tài khoản cá nhân: </p>
							</div>
							<div class="span3">
								 <input type="text" name="sotaikhoan" value="${ student.soTaiKhoan }"> 
							</div>
						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Lớp:</p>
							</div>
							<div class="span3">
								<p>${ student.lop }</p>
							</div>
							<div class="span2">
								<p>Ngân hàng: </p>
							</div>
							<div class="span3">
								 <input type="text" name="nganhang" value="${ student.nganHang }"> 
							</div>
						</div>
					</div>

				</div>
				<div class="well well-small">
					<h4>THÔNG TIN THÂN NHÂN</h4>
					<hr class="soften" />
					<div class="well well-small"
						style="min-height: 70px; background: #ffffff; margin-bottom: 8px">
						<div class="row-fluid">
							<div class="span2">Gia đình:</div>
							<div class="span2">
								<p>Họ và tên cha:</p>
							</div>
							<div class="span3">
								<input type="text" name="tencha" value="${ student.tenCha }"></input>
							</div>
							<div class="span2">
								<p>Ngày sinh cha:</p>
							</div>
							<div class="span3">
								<input type="text" name="ngaysinhcha" id="datepickerNgaySinh" value="${ student.ngaySinhCha }"></input>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Họ và tên mẹ: </p>
							</div>
							<div class="span3">
								<input type="text" name="tenme" value="${ student.tenMe }"></input>
							</div>
							<div class="span2">
								<p>Ngày sinh mẹ: </p>
							</div>
							<div class="span3">
								<input type="text" name="ngaysinhme" id="datepickerNgaySinhMe" value="${ student.ngaySinhMe }"></input>
							</div>
						</div>
						</div>
						<div class="well well-small"
						style="min-height: 70px; background: #ffffff; margin-bottom: 8px">
						<div class="row-fluid">
							<div class="span3">Khi khẩn cấp báo tin cho:</div>

						</div>
						<div class="row-fluid">
							<div class="span1"></div>
							<div class="span4">
								<p>Họ tên:</p>			
								 <input type="text" name="tennguoibaotin" value="${ student.tenNguoiBaoTin }"> </input>
							</div>
							<div class="span4">
								<p>Quan hệ: </p>			
							
								<input type="text" name="quanhe" value="${ student.quanHeNguoiBaoTin }" > </input>
							</div>
							<div class="span3">
								<p>Số điện thoại:</p>

								<input type="text" name="sodienthoainbt" value="${ student.SDTNguoiBaoTin }" > </input>

							</div>
						</div>
						<div class="row-fluid">
							<div class="span1"></div>
							<div class="span4">
								<p>Tỉnh/Thành phố</p>
								<select name="calc_shipping_provinces" ></select>
							</div>
							<div class="span4">
								<p>Quận/Huyện</p>
								<select name="calc_shipping_district" >
	  								<option selected="selected">${ student.quan_HuyenNBT }</option>
								</select>
<!-- <input class="billing_address_1" name="" type="hidden" value="">
<input class="billing_address_2" name="" type="hidden" value=""> -->
							</div>
							<div class="span3">
								<p>Xã/Phường/Số nhà, tên đường</p>
								<input type="text" name="diachinbt" value="${ student.diaChiNguoiBaoTin }" > </input>
								
							</div>
						</div>
					</div>
				</div>
				 	<table align="center">
		<tr>
			<td style="font-style: italic; color: red;">${message}</td>
		</tr>
	</table> 
				<div class="row-fluid">
			<div class="span8"></div>
			
			<div class="span4"><button onclick="return validate();"   align="center" id="update" name="update" class="snip1457"
						>Lưu thông tin</button></div>
			
		</div>
			</form>
		</div>
	</div>


	<%@include file="/footer.jsp"%>


	
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
<script>

 $('#datepickerNgaySinh').datepicker(
	      {
	        dateFormat: 'dd/mm/yy'    
	      }
	    );
  $(' #datepickerNgaySinhMe').datepicker(
	      {
	        dateFormat: 'dd/mm/yy'   
	      }
	    );
if (address_2 = localStorage.getItem('address_2_saved')) {
  $('select[name="calc_shipping_district"] option').each(function() {
    if ($(this).text() == address_2) {
      $(this).attr('selected', '')
    }
  })
  $('input.billing_address_2').attr('value', address_2)
}

$('select[name="calc_shipping_provinces"]').each(function() {
  var $this = $(this),
    stc = ''
  c.forEach(function(i, e) {
    e += +1
    console.log(i);
    if(e=="${ student.thanhPho_TinhNBT }"){
    	 stc += '<option value=' + e + ' selected>' + i + '</option>'
    }
    else{
    	 stc += '<option value=' + e + '>' + i + '</option>'
    }
   
    $this.html('<option value="">Chọn Tỉnh/Thành phố</option>' + stc)
    $this.on('change', function(i) {
      i = $this.children('option:selected').index() - 1
      var str = '',
        r = $this.val()
      if (r != '') {
        arr[i].forEach(function(el) {
          str += '<option value="' + el + '">' + el + '</option>'
          $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>' + str)
        })
        var address_1 = $this.children('option:selected').text()
        var district = $('select[name="calc_shipping_district"]').html()
        $('select[name="calc_shipping_district"]').on('change', function() {
          var target = $(this).children('option:selected')
          target.attr('selected', '')
          $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
          var address_2 = target.text()
          $('input.billing_address_2').attr('value', address_2)
          district = $('select[name="calc_shipping_district"]').html()
          localStorage.setItem('district', district)
          localStorage.setItem('address_2_saved', address_2)
        })
      } else {
        $('select[name="calc_shipping_district"]').html('<option value="">Quận / Huyện</option>')
        district = $('select[name="calc_shipping_district"]').html()
      }
    })
    
  })
})
 //]]></script> 
</body>
</html>