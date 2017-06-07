<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="/WEB-INF/tld/c.tld" %>
<%@ taglib prefix="fmt" uri="/WEB-INF/tld/fmt.tld" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>酒店管理系统</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
   <link rel="stylesheet" href="http://static.runoob.com/assets/foundation-5.5.3/foundation.min.css">
   <link rel="stylesheet" href="http://static.runoob.com/assets/foundation-icons/foundation-icons.css">
  <script src="http://static.runoob.com/assets/jquery/2.0.3/jquery.min.js"></script>
  <script src="http://static.runoob.com/assets/foundation-5.5.3/js/foundation.min.js"></script>
  <script src="http://static.runoob.com/assets/foundation-5.5.3/js/vendor/modernizr.js"></script>
  <style type="text/css">@import url(main.css);
  .example {

    max-width: 100%;
    color:white;
  }
.foot{
	margin-top:4px;
  	margin-bottom: 3px;
  }
  </style>
</head>
<body>
<div class="header">
      <h1 class="aa" ><strong>酒店客房管理系统</strong></h1>	
	</div>
	
	<div class="row xuanze" >
  <div class="medium-3 columns" style="background-color:#f1f1f1;">
    <ul class="side-nav">
      <li ><a href="index" id="aaa">订房</a></li>
      <li class="active"><a href="checkout.jsp" id="aaa">退房</a></li>
      <li><a href="roominfo" id="aaa">房间信息</a></li>
      <li><a href="guest" id="aaa">顾客信息</a></li>
        <li><a href="waiter" id="aaa">服务员信息</a></li> 
    </ul>
  </div>
</div>
<div class="row">
	<div class="test">
		 	<table>
			 		<thead>
    						<tr>
      							<th>房间号</th>
      							<th>房间状态</th>
      							<th>客人</th>
      							<th>入住时间</th>
      							<th>退房时间</th>
      							<th>退房</th>
      							
    						</tr>
  					</thead>
		  		<tbody>	
						
							<c:forEach var="room" items="${rooms}">
								<tr>
									<td>${room.Rno}</td>
									<td>${room.Rstate}</td>
									<td>${room.Gno}</td>
									<td>${room.Rin}</td>
									<td>${room.Rout}</td>
									<td>
									<form method="POST" action="?type=checkout&Rno=${room.Rno}">
									<button  class="button round tiny" >退房</button>
									</form>
									</td>
									
								</tr>
							</c:forEach>
						
		 		</tbody>
		</table>
	</div>
</div>
<div class="example">
	<div class="text-center medium-12 columns" style="background-color:#31a7b9">
		<p class="foot">2016 @Snowave</p>
		<p> All Rights Reserved</p>
	</div>
</div>
</body>
</html>