<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!DOCTYPE html>
<html>
<style>
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  background-color: #58257b;
}

li {
  float: left;
}

li a, .dropbtn {
  display: inline-block;
  color: white;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

li a:hover, .dropdown:hover .dropbtn {
  background-color: #ce3e6e;
  color: white;
  font-weight: bold;
}

li.dropdown {
  display: inline-block;
}

.dropdown-content {
  display: none;
  position: absolute;
  background-color: #e9d8f4;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
  z-index: 1;
}

.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
  text-align: left;
}

.dropdown-content a:hover {
  background-color: #db7093;
  color: white;
}

.dropdown:hover .dropdown-content {
  display: block;
}
</style>

<ul>
  <li><a href="https://quantrimang.com/">Trang chủ</a></li>
  <li class="dropdown">
    <a href="https://quantrimang.com/lang-cong-nghe" class="dropbtn">
    Làng Công nghệ</a>
    <div class="dropdown-content">
      <a href="#">Tấn công mạng</a>
      <a href="#">Chuyện Công nghệ</a>
      <a href="#">Trí tuệ nhân tạo</a>
    </div>
  </li>
  <li class="dropdown">
    <a href="https://quantrimang.com/cong-nghe" class="dropbtn">Công nghệ</a>
    <div class="dropdown-content">
      <a href="#">Ứng dụng</a>
      <a href="#">Lập trình</a>
      <a href="#">Game - Trò chơi</a>
    </div>
  </li>
  <li><a href="https://quantrimang.com/khoa-hoc">Khoa học</a></li>
</ul>

<h3>Dropdown Menu nằm bên trong Navigation Bar</h3>

</body>
</html>