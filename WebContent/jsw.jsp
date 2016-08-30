<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="jquery-3.1.0.min.js">  
</script> 
<script type="text/javascript" src="jquery.json-2.4.js">  
</script> 
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ok</title>
</head>
<body>

<h1></h1>
<h2></h2>
<div id = "1">222</div>
<div id = "2">333</div>
</body>
<script>
	var namec = $("#1").text();
	var passwordc = $("#2").text();
	var userc = {"name":namec,"password":passwordc};
	var productc = {"productid":namec,"name":namec,"baseprice":namec};
	var map = {}; // Map map = new HashMap();
	map["user"] = userc; // map.put(key, value);
	map["p"]=productc;
	$(function() {
		alert("Hello World 3 !"+map["user"].name);
	});

	$.ajax({
		type : 'POST',
		contentType : "application/json",  
		//这句是描述请求包内容格式的,默认采用form形式
		url : "jsw.do",
		data : JSON.stringify(map),
		dataType : 'json',
		success : function(data) {
			alert("data" + data.success);
			$("h1").text(data.success);
		},
		errro : function() {
			alert("aaa");
		}
	});
</script>
</html>