<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<link href="assets/css/style2.css" rel="stylesheet" type="text/css">
<link href="assets/css/style.css" rel="stylesheet" type="text/css">
<link href="assets/css/style3.css" rel="stylesheet" type="text/css">
<link href="assets/css/style4.css" rel="stylesheet" type="text/css"> 
<link href="assets/css/style5.css" rel="stylesheet" type="text/css"> 
<link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.min.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome-ie7.css" rel="stylesheet">
<link href="assets/font-awesome/css/font-awesome.ie7.min.css" rel="stylesheet">
<link rel="shortcut icon" href="assets/ico/lg.ico">
<title>Trang chủ</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<div class="row">
		<div id="sidebar" class="span3">

		</div>
		<div class="span10">
		<div class="container-fluid">
		</div>
		</div>
		<div class="well well-small">
		<!-- 	<h3>Thông tin tiêm vắc xin Covid-19</h3> -->
			<hr class="soften" />
			<div class="row-fluid">
				<div id="newProductCar" class="carousel slide">
					<div class="carousel-inner">
						<div class="item active">
							<ul class="thumbnails">
								<li class="span12">
									<div class="thumbnail">
										<img style="width:450px;height:600px;"
											src="assets/img/a1.jpg"
											alt="bootstrap-ring"></a>
									</div>
								</li>
							</ul>
						</div>
						<div class="item">
							<ul class="thumbnails">
								<li class="span12">
									<div class="thumbnail">
										<img style="width:450px;height:600px;"
											src="assets/img/a2.jpg" alt=""></a>
									</div>
								</li>

							</ul>
						</div>
									<div class="item">
							<ul class="thumbnails">
								<li class="span12">
									<div class="thumbnail">
										<img style="width:700px;height:700px;"
											src="assets/img/a3.jpg" alt=""></a>
									</div>
								</li>

							</ul>
						</div>
									<div class="item">
							<ul class="thumbnails">
								<li class="span12">
									<div class="thumbnail">
										<img style="width:450px;height:600px;"
											src="assets/img/a4.jpg" alt=""></a>
									</div>
								</li>

							</ul>
						</div>
									<div class="item">
							<ul class="thumbnails">
								<li class="span12">
									<div class="thumbnail">
										<img style="width:450px;height:600px;"
											src="assets/img/a5.jpg" alt=""></a>
									</div>
								</li>

							</ul>
						</div>
									<div class="item">
							<ul class="thumbnails">
								<li class="span12">
									<div class="thumbnail">
										<img style="width:450px;height:600px;"
											src="assets/img/a6.jpg" alt=""></a>
									</div>
								</li>

							</ul>
						</div>
					</div>
					<a class="left carousel-control" href="#newProductCar"
						data-slide="prev">&lsaquo;</a> <a class="right carousel-control"
						href="#newProductCar" data-slide="next">&rsaquo;</a>
				</div>
			</div>
			<div class="row-fluid">
				<ul class="thumbnails">
					<li class="span4">
						<div class="thumbnail">

							<a class="zoomTool" href="product_details.html"
								title="xem chi tiết"><span class="icon-search"></span> QUICK
								VIEW</a> <a href="product_details.html"><img
								src="/assets/img/vn1.jpg"/>" alt=""></a>
							<div class="caption cntr">
								<!-- <p><strong>Tỷ lệ tiêm chủng trên số vắc xin phân bổ</strong></p>
									<a class="snip1457" href="#" title="Xem chi tiết"> Xem chi tiết </a> -->
								<br class="clr">
							</div>
						</div>
					</li>
					<li class="span4">
						<div class="thumbnail">
							<a class="zoomTool" href="product_details.html"
								title="xem chi tiết"><span class="icon-search"></span> QUICK
								VIEW</a> <a href="product_details.html"><img
								src="/assets/img/tile.jpg"/>" alt=""></a>
							<div class="caption cntr">
							<!-- 	<p><strong>Tỷ lệ phân bổ vắc xin (Tính đến 11/2021)</strong></p>
									<a class="snip1457" href="#" title="Xem chi tiết"> Xem chi tiết </a> -->
								<br class="clr">
							</div>
						</div>
					</li>
					<li class="span4">
						<div class="thumbnail">
							<a class="zoomTool" href="product_details.html"
								title="xem chi tiết"><span class="icon-search"></span> QUICK
								VIEW</a> <a href="product_details.html"><img
								src="/assets/img/mui1.jpg"/>" alt=""></a>
							<div class="caption cntr">
				<!-- 				<p><strong>Tỷ lệ đã tiêm ít nhất 1 mũi</strong></p>
									<a class="snip1457" href="#" title="Xem chi tiết"> Xem chi tiết </a> -->
								<br class="clr">
							</div>
						</div>
					</li>
				</ul>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp"%>
</body>
</html>
