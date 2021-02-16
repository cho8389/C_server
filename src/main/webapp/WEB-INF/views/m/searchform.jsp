<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

</head>
<body>
	<div data-role="page" id="page1">
		<div data-role="header">
			<h1>검색</h1>
			<a data-ajax='false' href="/m/main">메인</a>
		</div>
		<div data-role="content">
			<div data-role="controlgroup">
				<button onclick="list('req')">발주 신청</button>
				<button onclick="list('ord')">발주</button>
				<button onclick="list('pay')">결제</button>
				<button onclick="list('del')">납품</button>
				<button onclick="list('cal')">정산</button>
			</div>
		</div>
	</div>
	<form id="form" data-ajax='false' method="post" action="/m/search">
		<input type="hidden" id="type" name="type" value="">
	</form>
<script>
function list(type){
	console.log(type)
	var that=$('#form');
	$('#type').val(type)
	that.get(0).submit();
}
</script>
</body>
</html>