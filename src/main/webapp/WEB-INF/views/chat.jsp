<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<input type="button" id="send" value="asd">
<script src="/resources/js/sockjs.min.js"></script>
<script
  src="https://code.jquery.com/jquery-3.3.1.slim.js"
  integrity="sha256-fNXJFIlca05BIO2Y5zh1xrShK3ME+/lYZ0j+ChxX2DA="
  crossorigin="anonymous"></script>
<script>
var sock=null;
$(document).ready(function(){
	sock=new SockJS("/echo");
	sock.onopen=function(){
		sock.send("open");
	}
	sock.onmessage=function(e){
		alert(e.data)
	}
	sock.onclose=function(){
		sock.send("close")
	}
	$("#send").click(function(){
		console.log("asd")
		sock.send("send")
	})
})
</script>
</body>
</html>