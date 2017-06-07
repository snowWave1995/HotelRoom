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
  <style type="text/css">@import url(main.css);</style>
  <style >
  .addRoom{
  margin-left:600px; 
  }
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
      <li ><a href="checkout" id="aaa">退房</a></li>
      <li class="active"><a href="roominfo" id="aaa">房间信息</a></li>
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
      							<th>房间类型</th>
      							<th>价格</th>
      							<th>楼层</th>
      							<th>朝向</th>
      							<th>服务员编号</th>
      							<th>修改</th>
      							<th>删除</th>
    						</tr>
  					</thead>
		  		<tbody>	
						
							<c:forEach var="room" items="${rooms}">
								<tr>
									<td>${room.Rno}</td>
									<td>${room.Rtype}</td>
									<td>${room.Rprice}</td>
									<td>${room.Rfloor}</td>
									<td>${room.Rdri}</td>
									<td>${room.RSno}</td>
									<td><button  data-reveal-id="myModal${room.Rno}" class="Button tiny round">修改</button>
									<div id="myModal${room.Rno}" class="reveal-modal tiny" data-reveal>
  			 							<form method="POST" action="?type=updata&Rno=${room.Rno}">
  			 								重新输入类型：
  			 								<select class="Rtype" name="Rtype">
  			 								<option>标准间</option>
  			 								<option>单间</option>
  			 								<option>双人间</option>
  			 								<option>大床房</option>
  			 								<option>三人间</option>
  			 								<option>豪华间</option>
  			 								<option>总统套</option>
  			 								</select>
  											重新输入价格：
  											<input type="text" placeholder="Rprice" name="Rprice">
  											重新输入服务员电话：
  											<select class="RSno" name="RSno">
  											<c:forEach var="waiter" items="${waiters}">
  											<option>${waiter.Wno}</option>
  											</c:forEach>
  											</select>
  										<input type="submit" class="button tiny round" style=" float:right;" value="确定">
									 </form>
  									</div>
									</td>
									<td>
									<form method="POST" action="?type=delete&Rno=${room.Rno}">
									<button  class="button round tiny" >删除</button>
									</form>
									</td>
								</tr>
							</c:forEach>
						
		 		</tbody>
		</table>
	</div>
</div>
<div class="addRoom">
	<button type="button" class="button" data-reveal-id="myModal"> 增加房间</button>

  		<div id="myModal" class="reveal-modal tiny" data-reveal>
  			 <form method="POST" action="?type=add">
 					  房间编号:
  					<input type="text" placeholder="Rno" name="Rno">
  					房间类型:
  					<select class="Rtype" name="Rtype">
  			 								<option>标准间</option>
  			 								<option>单间</option>
  			 								<option>双人间</option>
  			 								<option>大床房</option>
  			 								<option>三人间</option>
  			 								<option>豪华间</option>
  			 								<option>总统套</option>
  			 		</select>
  					房间价格:
  					<input type="text" placeholder="Rprice" name="Rprice">
  					房间楼层：
  					<input type="text" name="Rfloor">
  					房间朝向：
  					<select class="Rdri" name="Rdri">
    					<option>w</option>
    					<option>e</option>
    					<option>s</option>
    					<option>n</option>
  					</select>
  					服务员电话：
  					<select class="RSno" name="RSno">
  											<c:forEach var="waiter" items="${waiters}">
  											<option>${waiter.Wno}</option>
  											</c:forEach>
  					</select>
  					<input type="submit" value="确定">
			</form>
  	</div>

			<script>
				$(document).ready(function() {
   					 $(document).foundation();
					})
			</script>

</div>
<div class="example">
	<div class="text-center medium-12 columns" style="background-color:#31a7b9">
		<p class="foot">2016 @Snowave</p>
		<p> All Rights Reserved</p>
	</div>
</div>
</body>
</html>