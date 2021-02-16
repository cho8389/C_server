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
<style>
ul {list-style:none;} 
#pagearea li {float:left}
</style>
</head>
<body>
	<div data-role="page" id="page1">
		<input type='hidden' id="page" name='page' value="1">
		<input type='hidden' id="pagenum" name='pagenum' value="10">
		<div data-role="header">
			<a data-ajax='false' href="/m/main">메인</a>
			<h1>Carmen</h1>
			<c:if test="${type eq 'req'}">
				<a data-ajax='false' href="/m/req/search">상세검색</a>
			</c:if>
			<c:if test="${type eq 'ord'}">
				<a data-ajax='false' href="/m/ord/search">상세검색</a>
			</c:if>
			<c:if test="${type eq 'pay'}">
				<a data-ajax='false' href="/m/pay/search">상세검색</a>
			</c:if>
			<c:if test="${type eq 'del'}">
				<a data-ajax='false' href="/m/del/search">상세검색</a>
			</c:if>
			<c:if test="${type eq 'cal'}">
				<a data-ajax='false' href="/m/cal/search">상세검색</a>
			</c:if>
		</div>
		<div data-role="content" id="list">
		결과가 없습니다
		</div>
		<div data-role="footer" data-position="fixed">
			<div id='pagearea' data-role="navbar">
			</div>
		</div>
	</div>
<script>
var json='${json}';
var type="${type}";
var page="${page}";
	$(document).ready(function(){
		searchlist(type)
		$('#pagearea').on('click','ul>li>.reppage',function(index){
			page=$(this).text()
			searchlist(type)
		})
		$('#pagearea').on('click','ul>li>.prev',function(){
			page=$(this).attr("page");
			searchlist(type)
		})
		$('#pagearea').on('click','ul>li>.next',function(){
			page=$(this).attr("page");
			searchlist(type)
		})
	})
</script>
<script src="/resources/js/req.js"></script>
</body>
</html>