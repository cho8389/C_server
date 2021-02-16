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
			<label>종류
			<input type="text" id="type" name="ordreq_type" value="" readonly></label>
			<label>신청일
			<input type="date" id="ordreq_date" name="ordreq_date" value="" readonly></label>
			<label>납기일
			<input type="date" id="ordreq_edate" name="ordreq_edate" value="" readonly></label>
			<label>고객상호명
			<input type="text" name="ordreq_customer" value="${req.ordreq_customer }" readonly></label>
			<label>지역
			<input type="text" name="ordreq_region" value="${req.ordreq_region }" readonly></label>
			<label>품명
			<input type="text" name="ordreq_name" value="${req.ordreq_name }" readonly></label>
			<label>매입원
			<input type="text" name="ordreq_purchase" value="${req.ordreq_purchase }" readonly></label>
			<label>예상단가
			<input type="text" name="ordreq_price" value="${req.ordreq_price }" readonly></label>
			<label>신청수량
			<input type="text" name="ordreq_amount" value="${req.ordreq_amount }" readonly></label>
			<label>원가
			<input type="text" name="ordreq_cost" value="${req.ordreq_cost }" readonly></label>
			<label>비용
			<input type="text" id="fullcost" name="ordreq_fullcost" value="" readonly></label>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" >
			<ul>
				<li><button onclick="req_delete()">삭제</button></li>
				<li><button onclick="update()" id="update">수정</button></li>
				<li><button onclick="list()" id="list">목록</button></li>
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
var state=${req.ordreq_state};
var id=${req.ordreq_id};
function req_delete(){
	if(state=='1'||state=='2'){
		var con=confirm("삭제하시겠습니까?")
		if(con){
			location.href="/m/req/delete?id="+id
		}
	}else{
		alert("권한이 없습니다")
	}
}
function update(){
	if(state=='1'||state=='2'){
		location.href="/m/req/update?id="+id
	}else{
		alert("권한이 없습니다")
	}
}
function list(){
	location.href="javascript:history.go(-1)"
}
$(document).ready(function(){
	$('#ordreq_date').val("<fmt:formatDate pattern='yyyy-MM-dd' value='${req.ordreq_date}' />")
	$('#ordreq_edate').val("<fmt:formatDate pattern='yyyy-MM-dd' value='${req.ordreq_edate}' />")
	var amount=${req.ordreq_amount };
	var cost=${req.ordreq_cost };
	var fullcost=amount*cost*1.1;
	$('#fullcost').val(fullcost);
	
	var type=${req.ordreq_type }
	if(type=="1"){
		$('#type').val("납품")
	}else if(type=="2"){
		$('#type').val("샘플")
	}
})
</script>
</body>
</html>