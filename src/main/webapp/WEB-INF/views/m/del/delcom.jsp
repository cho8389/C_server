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
		<form id="form" data-ajax="false" method="post">
        	<input type='hidden' id="ordreq_id" name='ordreq_id' value="${ordreq_id}">
			<label>고객상호명
			<input type="text" name="del_name" value=""></label>
			<label>고객부서
			<input type="text" name="del_customer" value=""></label>
			<label>납품수량
			<input type="number" pattern="[0-9]*" inputmode="numeric" class="fullcost" id="amount" name="del_amount" value=""></label>
			<label>단가
			<input type="number" pattern="[0-9]*" inputmode="numeric" class="fullcost" id="cost" name="del_cost" value=""></label>
			<label>예상액
			<input type="number" pattern="[0-9]*" inputmode="numeric" id="fullcost" name="del_fullcost" value="" readonly></label>
			<label>납품액
			<input type="number" pattern="[0-9]*" inputmode="numeric" class="fullcost" name="del_price" value=""></label>
			<label>판매방식
			<input type="text" name="del_type" value=""></label>
			</form>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" >
			<ul>
				<li><button onclick="list()" id="list">메인</button></li>
				<li><button onclick="insert()" id="update">납품 완료</button></li>
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
function insert(){
	var that=$('#form');
	$('#type').val("ord")
	that.get(0).submit();
}
function list(){
	location.href="/m/main"
}
$(document).ready(function(){
	var amount;
	var cost;
	var fullcost;
	var type;
	$("#ordreq_type").selectmenu("refresh", true);
	$('.fullcost').on('change',function(){
		cost=$('#cost').val()
		amount=$('#amount').val()
		fullcost=amount*cost*1.1;
		$('#fullcost').val(fullcost);
	})
})
</script>
</body>
</html>