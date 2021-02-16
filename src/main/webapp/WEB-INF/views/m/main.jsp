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
			<h1>Carmen</h1>
			<a data-ajax='false' onclick="logout()" href="/logout">로그아웃</a>
		</div>
		<div data-role="content">
			<div data-role="controlgroup">
				<a data-ajax='false' href="/m/req" data-role="button">발주 목록</a>
				<a data-ajax='false' href="/m/req/insert" data-role="button">발주 신청</a>
				<a data-ajax='false' href="/m/req/dellist" data-role="button">납품 대기</a>
				<a data-ajax='false' href="/m/searchform" data-role="button">검색</a>
			</div>
		</div>
	</div>
<script>
Android.setWS();
Android.setMem('${emp_id}');
function logout(){
	Android.saveconfig("1","0");
}
</script>
</body>
</html>