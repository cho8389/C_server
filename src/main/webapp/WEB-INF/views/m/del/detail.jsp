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
			<label>납품 상태
			<input type="text" name="del_state" value="
				<c:if test="${del.del_state eq '1'}">
					납품
				</c:if>
				<c:if test="${del.del_state eq '2'}">
					정산
				</c:if>
			" readonly>
			</label>
			<label>납품자
			<input type="text" name="emp_id" value="${del.emp_id }" readonly></label>
			<label>납품일
			<input type="date" name="del_date" value="<fmt:formatDate pattern='yyyy-MM-dd' value='${del.del_date}' />" readonly></label>
			<label>거래상호명
			<input type="text" name="del_name" value="${del.del_name }" readonly></label>
			<label>고객부서
			<input type="text" name="del_customer" value="${del.del_customer }" readonly></label>
			<label>납품수량
			<input type="text" name="del_amount" value="${del.del_amount }" readonly></label>
			<label>단가
			<input type="text" name="del_cost" value="${del.del_cost }" readonly></label>
			<label>납품액
			<input type="text" name="del_price" value="${del.del_price }" readonly></label>
			<label>판매방식
			<input type="text" name="del_type" value="${del.del_type }" readonly></label>
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
	location.href="/m/list?id="+${del.ordreq_id}
}
function back(){
	location.href="javascript:history.go(-1)"
}
$(document).ready(function(){
})
</script>
</body>
</html>