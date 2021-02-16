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
			<label>상태
			<select name="ordreq_state" id="ordreq_state">
            	<option value="1">신청</option>
            	<option value="2">확인</option>
            	<option value="3">발주</option>
            	<option value="4">입고</option>
            	<option value="5">납품</option>
            	<option value="6">정산</option>
        	</select></label>
			<label>종류
			<select name="ordreq_type" id="ordreq_type">
            	<option value="1">납품</option>
            	<option value="2">샘플</option>
        	</select></label>
        	<input type='hidden' name='page' value="1">
        	<input type='hidden' name='type' value="req">
        	<label>신청일</label>
        	<label>시작일
			<input type="date" id="ordreq_date" name="ordreq_date" value=""></label>
			<label>종료일
			<input type="date" id="ordreq_date_e" name="ordreq_date_e" value=""></label>
			<label>납기일
			<input type="date" id="ordreq_edate" name="ordreq_edate" value=""></label>
			<label>고객상호명
			<input type="text" name="ordreq_customer" value=""></label>
			<label>지역
			<input type="text" name="ordreq_region" onclick="" value=""></label>
			<label>품명
			<input type="text" name="ordreq_name" value=""></label>
			<label>매입원
			<input type="text" name="ordreq_purchase" value=""></label>
			<label>예상단가
			<input type="number" pattern="[0-9]*" inputmode="numeric" name="ordreq_price" value=""></label>
			<label>신청수량
			<input type="number" pattern="[0-9]*" inputmode="numeric" class="fullcost" id="amount" name="ordreq_amount" value=""></label>
			<label>원가
			<input type="number" pattern="[0-9]*" inputmode="numeric" class="fullcost" id="cost" name="ordreq_cost" value=""></label>
			<label>비용
			<input type="number" pattern="[0-9]*" inputmode="numeric" id="fullcost" name="ordreq_fullcost" value="" readonly></label>
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
var state;
var id;
var now=new Date();
var day;
function list(){
	location.href="/m/main"
}
function date(as){
	a=new Date(as)
	if(a.getDay()=='0'){
		day='일요일'
	}else if(a.getDay()=='1'){
		day='월요일'
	}else if(a.getDay()=='2'){
		day='화요일'
	}else if(a.getDay()=='3'){
		day='수요일'
	}else if(a.getDay()=='4'){
		day='목요일'
	}else if(a.getDay()=='5'){
		day='금요일'
	}else if(a.getDay()=='6'){
		day='토요일'
	}
	return " - "+a.getFullYear()+"년 "+(a.getMonth()+1)+"월 "+a.getDate()+"일 "+day+" - "
}
function search(){
	event.preventDefault();
	var that=$('#form');
	var str="";
	that.get(0).submit();
}
$(document).ready(function(){
	var amount;
	var cost;
	var fullcost;
	var type;
	$("#ordreq_type").selectmenu("refresh", true);
	$("#ordreq_state").selectmenu("refresh", true);
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