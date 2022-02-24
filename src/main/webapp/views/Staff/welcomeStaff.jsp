<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <%@ page language="java" import="model.bean.Staff" %>
    <%@ page language="java" import="java.util.ArrayList" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>

<style>
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
</head>
<body>
 <ul>
        <li>
            <a href="<%=request.getContextPath()%>/CheckThongTinCaNhan">Thông tin cá nhân</a>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/CheckDoiMatKhau">Đổi Mật Khẩu</a>
        </li>
        <li>
            <a href="#">Quản lý phòng</a>
            <ul>
            <li>
                    <a href="<%=request.getContextPath()%>/CheckQLP_TTPhong">thong tin phong</a>
                </li>
                <li>
                   <a href="<%=request.getContextPath()%>/CheckQLP_CPhong">Danh sach chuyen phong</a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/Check_DSDK">Danh sach dang ky</a>
                </li>
                 <li>
                    <a href="<%=request.getContextPath()%>/CheckQLP_TraPhong">Danh sach trả</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/CheckQL_TienDienNuoc">Quản lý điện nước</a>
            
        </li>
        <li>
            <a href="<%=request.getContextPath()%>/CheckQLSC_YeuCau">Quản lý sửa chữa</a>
             </li>
            <li>
            <a href="<%=request.getContextPath()%>/CheckThongKe">Thông kê</a>
           
      		</li>
         <li>
            <a href="<%=request.getContextPath()%>/CheckPhiThuePhong">Danh sách nộp phí</a>
        </li>
         <li>
            <a href="#">Nhắn tin</a>
           
      		</li>
      		 <li>
            <a href="<%=request.getContextPath()%>/CheckThongBao">Đăng thông báo</a>
           
      		</li>
      		 <li>
            <a href="<%=request.getContextPath()%>/login.jsp">Đăng xuất</a>
           
      		</li>
    </ul>
    
</body>
</html>