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
			<label>발주 상태
			<input type="text" name="ord_state" value="
				<c:if test="${ord.ord_state eq '1'}">
					발주
				</c:if>
				<c:if test="${ord.ord_state eq '2'}">
					입고
				</c:if>
			" readonly>
			</label>
			<label>발주자
			<input type="text" name="emp_id" value="${ord.emp_id }" readonly></label>
			<label>발주일
			<input type="date" id="ord_date" name="ord_date" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${ord.ord_date}' />" readonly></label>
			<label>발주 수량
			<input type="text" name="ord_amount" value="${ord.ord_amount }" readonly></label>
			<label>원가
			<input type="text" name="ord_cost" value="${ord.ord_cost }" readonly></label>
			<label>발주액
			<input type="text" name="ord_price" value="${ord.ord_price }" readonly></label>
			<label>입고일
			<input type="date" id="ord_indate" name="ord_indate" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${ord.ord_indate}' />" readonly></label>
			<label>입고 수량
			<input type="text" name="ord_inamount" value="${ord.ord_inamount }" readonly></label>
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
	location.href="/m/list?id="+${ord.ordreq_id}
}
function back(){
	location.href="javascript:history.go(-1)"
}
$(document).ready(function(){
})
</script>
</body>
</html>