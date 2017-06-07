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
  .addWaiter{
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
      <li><a href="roominfo" id="aaa">房间信息</a></li>
      <li ><a href="guest" id="aaa">顾客信息</a></li>
        <li class="active"><a href="waiter" id="aaa">服务员信息</a></li> 
    </ul>
  </div>
</div>
<div class="row">

	<div class="test">
    	
			<table>
			 		<thead>
    						<tr>
      							<th>服务员编号</th>
      							<th>服务员姓名</th>
      							<th>性别</th>
      							<th>服务员电话</th>
      							<th>修改</th>
      							<th>删除</th>
    						</tr>
  					</thead>
		  		<tbody>	
						
							<c:forEach var="waiter" items="${waiters}">
								<tr>
									<td>${waiter.Wno}</td>
									<td>${waiter.Wname}</td>
									<td>${waiter.Wsex}</td>
									<td>${waiter.Wtel}</td>
									<td><button  data-reveal-id="myModal${waiter.Wno }" class="Button tiny round">修改</button>
									<div id="myModal${waiter.Wno }" class="reveal-modal tiny" data-reveal>
  			 							<form method="POST" action="?type=updata&Wno=${waiter.Wno}">	 
  											重新输入电话：
  											<input type="text" placeholder="Wtel" name="Wtel">
  										<input type="submit" style=" float:right;" class="button tiny round" value="确定">
										</form>
  									</div>
									</td>
									
			
									<td><form method="POST" action="?type=delete&Wno=${waiter.Wno}"><button  class="button round tiny" >删除</button></form></td>
								</tr>
							</c:forEach>
		 		</tbody>
		</table>
	</div>
</div>
<div class="addWaiter">
	<a  class="button" data-reveal-id="myModal"> 增加服务员</a>

  		<div id="myModal" class="reveal-modal tiny" data-reveal>
  			 <form method="POST" action="?type=add">
 					  服务员编号:
  						<input type="text" placeholder="Wno" name="Wno">

  					服务员姓名:
  					<input type="text" placeholder="Wname" name="Wname">
  					性别:
  					<select class="Wsex" name="Wsex">
    					<option>男</option>
    					<option>女</option>
  					</select>
  					电话：
  					<input type="text" placeholder="Wtel" name="Wtel">
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