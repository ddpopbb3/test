<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-3.1.0.min.js">  
</script>  
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1></h1>
<h2></h2>
<span>
<img id="img1" src="data:image/jpg;base64,"/>

<form action="app.do" method="post">
<input type  = "text" name = "name"/>
<input type  = "password" name = "password"/>
<input type  = "text" name = "captcha"/>
<input type  = "submit" value = "gg"/>
</form>

</span>
<div id = "info"></div>
</body>  
<script>
$(function(){  
    alert("Hello World 2 !");});
    	
	$.ajax({
		type : "GET",
		url : "Captcha2.do",
		dataType:"json",
		success:function(data){
			alert("data"+data);
			$("h1").text(data.lala);
			$("h2").text(data.list[0].name);
			$("#info").text(data.list[0].password);
			var img = document.getElementById("img1");
	        img1.src = "data:image/jpg;base64,"+data.lilia;
		},
		errro:function(){
			alert("aaa");
		}
	});
</script>
</html>