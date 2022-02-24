<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<style>
	li{
	line-height:20px;
	font-family: calibri;
	font-color: #ffffff;
	}
	a{color:#3d1551; }
	body{
	color: #3d1551}
	a:hover {

		color: green;
		font-weight: bold;
		text-decoration: under-line;
		
		}
	</style>
	
	<div  style="padding-right: 20px; padding-left: 20px;">
			<div class="app-sidebar" style="font-size:20px; width:250px;background:#e3d6ea;padding-right: 15px; padding-left: 15px;" onmouseover="this.style.background='#d0dbd0';" onmouseout="this.style.background='#e3d6ea';">
		 <ul>
        <li>
            <a href="<%=request.getContextPath()%>/CheckThongTinCaNhan">Thông tin cá nhân</a>
        </li>
        <hr class="soften"/>
        <li>
            <a href="<%=request.getContextPath()%>/CheckDoiMatKhau">Đổi mật Khẩu</a>
        </li>
        <hr class="soften" />
        <li>
            <a href="#">Quản lý phòng</a>
            <ul>
             <hr class="soften"/>
            <li>
                    <a href="<%=request.getContextPath()%>/CheckQLP_TTPhong">Thông tin</a>
                </li>
                <hr class="soften"/>
                <li>
                   <a  href="<%=request.getContextPath()%>/CheckQLP_CPhong">Chuyển phòng</a>
                </li>
                <hr class="soften"/>
                <li>
                    <a href="<%=request.getContextPath()%>/Check_DSDK">Đăng ký</a>
                </li>
                <hr class="soften"/>
                 <li>
                    <a href="<%=request.getContextPath()%>/CheckQLP_TraPhong">Trả phòng</a>
                </li>
            </ul>
        </li>
        <hr class="soften"/>
        <li>
            <a href="<%=request.getContextPath()%>/CheckQL_TienDienNuoc">Quản lý điện nước</a>
            
        </li>
        <hr class="soften"/>
        <li>
            <a href="<%=request.getContextPath()%>/CheckQLSC_YeuCau">Quản lý sửa chữa</a>
             </li>
             <hr class="soften"/>
           <%--  <li>
            <a href="<%=request.getContextPath()%>/CheckThongKe">Thống kê</a>
           
      		</li> --%>
      		<!-- <hr class="soften"/> -->
         <li>
            <a href="<%=request.getContextPath()%>/CheckPhiThuePhong">Danh sách nộp phí</a>
        </li>
        <hr class="soften"/>
         <li>
            <a href="<%=request.getContextPath()%>/nvnhantin">Nhắn tin</a>
           
      		</li>
      		<hr class="soften"/>
      		 <li>
            <a href="<%=request.getContextPath()%>/CheckThongBao">Đăng thông báo</a>
           
      		</li>
      		<hr class="soften"/>
      		 <li>
            <a href="<%=request.getContextPath()%>/index.jsp">Đăng xuất</a>
           
      		</li>
    </ul>
			</div>
		
</div>