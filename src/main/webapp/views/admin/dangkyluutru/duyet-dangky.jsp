<%@page import="model.bean.DangKyLuuTru"%>
<%@page import="util.DateUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Admin | Duyệt đăng ký lưu trú</title>
	<link href="<%=request.getContextPath() %>/assets/css/style2.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath() %>/assets/css/style.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath() %>/assets/css/style3.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath() %>/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/assets/css/bootstrap-responsive.css" rel="stylesheet" type="text/css"> 
	<link href="<%=request.getContextPath() %>/assets/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css"> 
	<link href="<%=request.getContextPath() %>/assets/css/style1.css" rel="stylesheet" type="text/css">
	<link href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome-ie7.css" rel="stylesheet">
	<link href="<%=request.getContextPath() %>/assets/font-awesome/css/font-awesome.ie7.min.css" rel="stylesheet">
	<link rel="shortcut icon" href="<%=request.getContextPath() %>/assets/ico/lg.ico">
	<link href="<%=request.getContextPath() %>/assets/css/view.css" rel="stylesheet" type="text/css">
	<script src="<%=request.getContextPath() %>/assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath() %>/assets/js/jquery-3.5.1.min.js"></script>
</head>

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
	    width: 70%;
	    margin-right: 60px;
	    border-radius: 5px;
	    background-color: #e6f7ff;
	    padding: 20px;
	}
</style>

<body>
<div><%@include file="header.jsp"%></div>
    <div>
    	<div class="topnav">
    		<a  href="<%=request.getContextPath() %>/admin/nhan-vien">Quản lý nhân viên</a>
    		<a class="active" href="<%=request.getContextPath() %>/admin/sinh-vien">Quản lý sinh viên</a>
    		<a href="<%=request.getContextPath() %>/admin/CheckThongKe">Thống kê</a>
			<a href="<%=request.getContextPath() %>/admin/doi-mat-khau">Đổi mật khẩu</a>
			<a href="<%=request.getContextPath() %>/admin/logout">Đăng xuất</a>
		</div>
		<div class="content">
			<div>
				<h3 style = "margin-left: 20px">
					Duyệt đăng ký lưu trú của sinh viên
				</h3>
				
				<div class="content-box-large" style="margin: 20px 100px">
					<div class="row">
						<div class="col-md-6"></div>
	                	<div class="col-md-6">
	                	<form action="<%=request.getContextPath() %>/admin/dang-ky-luu-tru" method="get">
		                 	 <div class="input-group form">
		                 	   <%
		                       		String keyword = "";
		                       		if (request.getAttribute("keyword") != null) {
		                       			keyword = (String) request.getAttribute("keyword");
		                       		}
		                       %>
		                       <input type="text" class="form-control" id="keyword" name="keyword" value="<%=keyword %>" placeholder="Nhập tên sinh viên cần tìm" style="height: 34px; width: 60%; float: right" >
		                       <span class="input-group-btn">
		                         <button class="btn btn-primary" type="submit" onclick="return validate()">Tìm kiếm</button>
		                       </span>
		                  	 </div>
	                  	</form>
	                  	</div>
					</div>
	
					<div class="row">
		  				<div class="panel-body">
		  					<%
		  						if (request.getParameter("err") != null) {
		  							int err = Integer.parseInt(request.getParameter("err"));
		  							if (err == 1) {
		  					%>
		  					<div class="alert alert-danger" role="alert">
							  	Số trang không hợp lệ
							</div>
		  					<%
		  							} else if (err == 2) {
		  					%>
		  					<div class="alert alert-danger" role="alert">
							  	Không có dữ liệu tương ứng
							</div>
		  					<%			
		  							}
		  						}
		  						if (request.getParameter("msg") != null) {
		  							String msg = request.getParameter("msg");
		  							if (msg.equals("success")) {
		  					%>
		  					<div class="alert alert-success" role="alert">
							  	Duyệt đăng ký lưu trú thành công
							</div>
							<%
		  							} else if (msg.equals("error")) {
							%>
							<div class="alert alert-danger" role="alert">
							  	Có lỗi xảy ra khi duyệt đăng ký lưu trú
							</div>
		  					<%
		  							}
		  						}
			  					int currentPage = 1, totalPage = 1;
								if (request.getAttribute("currentPage") != null) {
									currentPage = (int) request.getAttribute("currentPage");
								}
								if (request.getAttribute("totalPage") != null) {
									totalPage = (int) request.getAttribute("totalPage");
								}
		  						if (request.getAttribute("listSV") != null) {
		  							List<DangKyLuuTru> listSV = (ArrayList<DangKyLuuTru>) request.getAttribute("listSV");
		  							if (listSV.size() > 0) {
		  					%>
		  					<table class="table table-striped table-bordered" id="example">
								<thead>
									<tr>
										<th width="7%">MSSV</th>
										<th>Họ Tên</th>
										<th>Giới tính</th>
										<th>Ngày sinh</th>
										<th>Lớp</th>
										<th>Ngành</th>
										<th>Số điện thoại</th>
										<th width="10%">Chức năng</th>
									</tr>
								</thead>
								<tbody>
									<%
										for (DangKyLuuTru sv : listSV) {
									%>
									<tr class="odd gradeX">
										<td><%=sv.getMaSV() %></td>
										<td><%=sv.getHoTen() %></td>
										<td><%=sv.getGioiTinh() %></td>
										<td><%=sv.getNgaySinh() %></td>
										<td><%=sv.getLop() %></td>
										<td><%=sv.getNganh() %></td>
										<td><%=sv.getSoDienThoai() %></td>
										<td style="text-align: center">
											<a href="<%=request.getContextPath() %>/admin/duyet-dang-ky-luu-tru?id=<%=sv.getId() %>" title="" class="btn btn-primary" onclick="return confirm('Xác nhận duyệt đăng ký lưu trú của sinh viên \'<%=sv.getHoTen() %>\'?')">Duyệt</a>
										</td>
									</tr>
									<%
										}
									%>
									<tr>
										<td colspan="7"></td>
										<td style="text-align: center">
											<a href="<%=request.getContextPath() %>/admin/duyet-tat-ca-dang-ky-luu-tru" title="" class="btn btn-success" onclick="return confirm('Xác nhận duyệt tất cả đăng ký lưu trú?')">Duyệt tất cả</a>
										</td>
									</tr>
								</tbody>
							</table>
		
							<!-- Pagination -->
							<nav class="text-center" aria-label="...">
							   <ul class="pagination">
							   	  <%
							   			String url = request.getContextPath() + "/admin/dang-ky-luu-tru?";
									   	if (!keyword.equals("")) {
							   	  			url += "keyword=" + keyword + "&";
							   	  		}
							   	  		int pagePrevious = currentPage - 1;
							   	  		if (currentPage == 1) {
							   	  			pagePrevious = currentPage;
							   	  		}
							   	  %>
							      <li><a href="<%=url %>page=<%=pagePrevious %>" aria-label="Previous"><span aria-hidden="true">«</span></a></li>
							      <%
							      		for (int i = 1; i <= totalPage; i++) {
							      			String active = "";
							      			if (i == currentPage) {
							      				active = "class=\"active\"";
							      			}
							      %>
							      <li ><a <%=active %> href="<%=url %>page=<%=i %>"><%=i %></a></li>
							      <%
							      		}
							      %>
							      <%
							   	  		int pageNext = currentPage + 1;
							   	  		if (currentPage == totalPage) {
							   	  			pageNext = currentPage;
							   	  		}
							   	  %>
							      <li><a href="<%=url %>page=<%=pageNext %>" aria-label="Next"><span aria-hidden="true">»</span></a></li>
							   </ul>
							</nav>
							<!-- /.pagination -->
							<%
		  							} else {
		  					%>
		  					<div class="alert alert-info" role="alert">
							  	Không có dữ liệu
							</div>
		  					<%
		  							}
		  						}
							%>
		  				</div>
	  				</div>
				</div>
			</div>
		</div>
    </div>
<div><%@include file="/footer.jsp"%></div>
<script type="text/javascript">
	function validate() {
		var keyword = $("#keyword").val();
		if (keyword == '') {
			alert('Nhập nội dung tìm kiếm và chọn thuộc tính trước khi tìm');
			return false;
		}
		return true;
	}
</script>
</body>
</html>