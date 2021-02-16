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

</head>
<body>
	<div data-role="page" id="page1">
		<div data-role="content">
			<label>계산일
			<input type="date" id="cal_date" name="cal_date" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${cal.cal_date}' />" readonly></label>
			<label>정산액
			<input type="text" name="cal_price" value="${cal.cal_price }" readonly></label>
			<label>결제은행
			<input type="text" name="cal_bank" value="${cal.cal_bank }" readonly></label>
			<label>통장 상호
			<input type="text" name="cal_name" value="${cal.cal_name }" readonly></label>
			<label>계산서 상태
			<input type="text" name="cal_state" value="${cal.cal_state }" readonly></label>
			<label>영수증
			<input type="text" name="cal_bill" value="${cal.cal_bill }" readonly></label>
			<label>임원확인
			<input type="text" name="cal_check" value="${cal.cal_check }" readonly></label>
			<label>임원 결제일
			<input type="date" id="cal_chkdate" name="cal_chkdate" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${cal.cal_chkdate}' />" readonly></label>
			<label>비고
			<input type="text" name="cal_note" value="${cal.cal_note }" readonly></label>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" >
			<ul>
				<li><button onclick="list()">결제 조회</button></li>
				<li><button onclick="back()" id="list">목록</button></li>
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
function list(){
	location.href="/m/list?id="+${cal.ordreq_id}
}
function back(){
	location.href="javascript:history.go(-1)"
}
$(document).ready(function(){
})
</script>
</body>
</html>