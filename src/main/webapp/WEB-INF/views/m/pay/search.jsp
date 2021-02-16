<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="initial-scale=1.0, width=device-width">
<title>Insert title here</title>

<link rel="stylesheet"
	href="/resources/jquery.mobile/jquery.mobile-1.4.5.min.css" />
<script src="/resources/jquery.mobile/jquery-1.11.1.min.js"></script>
<script src="/resources/jquery.mobile/jquery.mobile-1.4.5.min.js"></script>
<!-- <script src="/resources/js/cordova.js"></script> -->

<script src="/resources/ui/min/jquery.ui.map.full.min.js"></script>
<script src="/resources/ui/jquery.ui.map.extensions.js"></script>

<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>

<style>
ul {list-style:none;} 
#pagearea li {float:left}
</style>
</head>
<body>
	<div data-role="page" id="page1">
		<div data-role="content">
			<form id="form" method="post" action="/m/search">
        	<input type='hidden' name='type' value="pay">
			<label>결제자
			<input type="text" name="emp_id" value=""></label>
			<label>결제 금액
			<input type="text" name="pay_price" value=""></label>
			<label>결제일</label>
			<label>시작일
			<input type="date" id="pay_date" name="pay_date" value=""></label>
			<label>종료일
			<input type="date" id="pay_date_e" name="pay_date_e" value=""></label>
			</form>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" >
			<ul>
				<li><button onclick="list()" id="list">메인</button></li>
				<li><input type="submit" onclick="search()" value="검색"></li>
			</ul>
		</div>
		</div>
	</div>
<script>
Date.prototype.toDateInputValue = (function() {
    var local = new Date(this);
    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
    return local.toJSON().slice(0,10);
});
var id;
var now=new Date();
function list(){
	location.href="/m/main"
}
function search(){
	event.preventDefault();
	var that=$('#form');
	that.get(0).submit();
}
$(document).ready(function(){
})
</script>
</body>
</html>