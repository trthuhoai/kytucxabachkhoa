<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ page language="java" import="model.bean.Staff" %>
    <%@ page language="java" import="java.util.ArrayList" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link href="assets/css/style2.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">
<link href="assets/css/style1.css" rel="stylesheet" type="text/css">
<link href="assets/css/style3.css" rel="stylesheet" type="text/css">
<link href="assets/css/style4.css" rel="stylesheet" type="text/css"> 
<link href="assets/css/style5.css" rel="stylesheet" type="text/css"> 
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome-ie7.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.ie7.min.css" rel="stylesheet">
<link rel="shortcut icon" href="assets/ico/lg.ico">
<title>Ký túc xá bách khoa</title>

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
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="row">
	<div class="span3"><%@include file="menu.jsp"%></div>
	<div class="span12">
	 <form action="<%=request.getContextPath()%>/CheckThongTinCaNhan" method="post" >
				<div class="well well-small">
					<h4>Thông tin cá nhân </h4>
			<%ArrayList<Staff> StaffArray=(ArrayList<Staff>)request.getAttribute("StaffArray");
	for (int i=0;i<StaffArray.size();i++){
		%>
			
				<%} %>
					<hr class="soften" />
					<div class="well well-small"
						style="min-height: 70px; background: #ffffff; margin-bottom: 8px">
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Họ và tên:</p>
							</div>
							<div class="span3">
								<p> ${StaffArray.get(i).getTennv()}</p>
							</div>
							<div class="span2">
								<p>Địa chỉ:</p>
							</div>
							<div class="span3">
							 <input type="text" name="diachi" value="${StaffArray.get(i).getDiachi()}"> 
							
							</div>
						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Số CMND/CCCD:</p>
							</div>
							<div class="span3">
								<p> ${StaffArray.get(i).getSocccd()}</p>
							</div>
							<div class="span2">
								<p>Email:</p>
							</div>
							<div class="span3">
							 <input type="text" name="email" value="${StaffArray.get(i). getEmail()}"> 
								<%-- <p>${ student.email }</p> --%>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Ngày sinh:</p>
							</div>
							<div class="span3">
								<p>${StaffArray.get(i).getNgaysinh()}</p>
							</div>
							<div class="span2">
								<p>Số điện thoại:</p>
								 
							</div>
							<div class="span3">
								 <input type="text" name="sdt" value="${StaffArray.get(i).getSdt()}"> 
							</div>
						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Mã số:</p>
							</div>
							<div class="span3">
								<p>${StaffArray.get(i).getManv()}</p>
							</div>
							<div class="span2">
								<p>Số tài khoản cá nhân: </p>
							</div>
							<div class="span3">
								 <input type="text" name="stk" value="${StaffArray.get(i).getStk()}"> 
							</div>
						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Chức vụ:</p>
							</div>
							<div class="span3">
							<input type="text" name="chucvu" value="${StaffArray.get(i).getChucvu()}"> 
							</div>
							<div class="span2">
								<p>Ngân hàng: </p>
							</div>
							<div class="span3">
								 <input type="text" name="tennh" value="${StaffArray.get(i).getTennh()}"> 
							</div>
						</div>
					</div>

				</div>
				<div class="well well-small">
					<h4>Thông tin thân nhân</h4>
					<hr class="soften" />
					<div class="well well-small"
						style="min-height: 70px; background: #ffffff; margin-bottom: 8px">
						<div class="row-fluid">
							<div class="span2">Gia đình:</div>
							<div class="span2">
								<p>Họ và tên cha:</p>
							</div>
							<div class="span3">
								<input type="text" name="tencha" value="${StaffArray.get(i).getTencha()}"></input>
							</div>
							<div class="span2">
								<p>Ngày sinh cha:</p>
							</div>
							<div class="span3">
								<input type="text" name="ngaycha" id="datepickerNgaySinh" value="${StaffArray.get(i).getNgaycha()}"></input>
						<%-- 		 <%java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/yyyy"); %>
								<h1>Current Date: <%= df.format(new java.util.Date()) %> </h1> --%>
							</div>
						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">
								<p>Họ và tên mẹ: </p>
							</div>
							<div class="span3">
								<input type="text" name="tenme" value="${StaffArray.get(i).getTenme()}"></input>
							</div>
							<div class="span2">
								<p>Ngày sinh mẹ: </p>
							</div>
							<div class="span3">
								<input type="text" name="ngayme" id="datepickerNgaySinhMe" value="${StaffArray.get(i).getNgayme()}"></input>
							</div>
						</div>
						</div>
						<div class="well well-small"
						style="min-height: 70px; background: #ffffff; margin-bottom: 8px">
						<div class="row-fluid">
							<div class="span3">Khi khẩn cấp báo tin cho:</div>

						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2"><p>Họ tên:</p>	</div>
							<div class="span3"> <input type="text" name="tennguoibt" value="${StaffArray.get(i).getTennguoibt()}"> </input></div>
							<div class="span2"><p>Quan hệ: </p>	</div>
							<div class="span3"><input type="text" name="quanhe" value="${StaffArray.get(i).getQuanhe()}" > </input></div>
							
						</div>
						<div class="row-fluid">
							<div class="span2"></div>
							<div class="span2">	<p>Số điện thoại:</p></div>
							<div class="span3">	<input type="text" name="sdtbt" value="${StaffArray.get(i).getSdtbt()}" > </input>
							</div>
							<div class="span2"><p>Địa chỉ: </p></div>
							<div class="span3"><input type="text" name="diachibt" value="${StaffArray.get(i).getSdtbt()}" > </input></div>
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
	<%@include file="footer.jsp"%>
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
	        dateFormat: 'yy-mm-dd'    
	      }
	    );
  $(' #datepickerNgaySinhMe').datepicker(
	      {
	        dateFormat: 'yy-mm-dd'   
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
/* if (district = localStorage.getItem('district')) {
  $('select[name="calc_shipping_district"]').html(district)
  $('select[name="calc_shipping_district"]').on('change', function() {
    var target = $(this).children('option:selected')
    target.attr('selected', '')
    $('select[name="calc_shipping_district"] option').not(target).removeAttr('selected')
    address_2 = target.text()
    $('input.billing_address_2').attr('value', address_2)
    district = $('select[name="calc_shipping_district"]').html()
    localStorage.setItem('district', district)
    localStorage.setItem('address_2_saved', address_2)
  })
} */

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
/*      if (address_1 =  ${ student.thanhPho_TinhNBT }) {
      $('select[name="calc_shipping_provinces"] option').each(function() {
        if ($(this).text() == address_1) {
          $(this).attr('selected', '')
        }
      })
      $('input.billing_address_1').attr('value', address_1)
    }  */
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
   /*      localStorage.setItem('address_1_saved', address_1)
        localStorage.setItem('district', district) */
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
 /*        localStorage.setItem('district', district)
        localStorage.removeItem('address_1_saved', address_1) */
      }
    })
    
  })
})
 //]]></script> 
</body>
</html>