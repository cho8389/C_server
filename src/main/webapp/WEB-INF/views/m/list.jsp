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
	<div data-role="page" id="req">
		<div data-role="header">
			<div data-role="navbar">
				<ul>
					<li><a class="ui-btn-active ui-state-persist" href="#req">발주요청</a></li>
					<li><a href="#ord">발주</a></li>
					<li><a href="#pay">결제</a></li>
					<li><a href="#del">납품</a></li>
					<li><a href="#cal">정산</a></li>
				</ul>
			</div>
		</div>
		<div data-role="content" id="list">
			<c:if test="${empty req}">
				결과가 없습니다
			</c:if>
			<a data-ajax='false' class='ui-btn' href='/m/req/detail?id=${req.ordreq_id }'>
				<div class='ui-body ui-body-a'>
					${req.ordreq_customer } - ${req.ordreq_name } | 
					<c:if test="${req.ordreq_state eq '1'}">
						신청
					</c:if>
					<c:if test="${req.ordreq_state eq '2'}">
						확인
					</c:if>
					<c:if test="${req.ordreq_state eq '3'}">
						발주
					</c:if>
					<c:if test="${req.ordreq_state eq '4'}">
						입고
					</c:if>
					<c:if test="${req.ordreq_state eq '5'}">
						납품
					</c:if>
					<c:if test="${req.ordreq_state eq '6'}">
						정산
					</c:if>
				</div>
			</a>	
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" >
			<ul>
				<li><a data-ajax='false' href="/m/main">메인</a></li>
			</ul>
			</div>
			<div id='pagearea' data-role="navbar">
			</div>
		</div>
	</div>
	<div data-role="page" id="ord">
		<div data-role="header">
			<div data-role="navbar">
				<ul>
					<li><a href="#req">발주요청</a></li>
					<li><a class="ui-btn-active ui-state-persist" href="#ord">발주</a></li>
					<li><a href="#pay">결제</a></li>
					<li><a href="#del">납품</a></li>
					<li><a href="#cal">정산</a></li>
				</ul>
			</div>
		</div>
		<div data-role="content" id="list">
			<c:if test="${empty ord}">
				결과가 없습니다
			</c:if>
			<c:forEach items="${ord}" var="ord">
				<a data-ajax='false' class='ui-btn' href='/m/ord/detail?id=${ord.ord_id }'>
					<div class='ui-body ui-body-a'>
						${req.ordreq_name } - ${ord.ord_amount } | 
						<c:if test="${ord.ord_state eq '1'}">
							발주
						</c:if>
						<c:if test="${ord.ord_state eq '2'}">
							입고
						</c:if>
					</div>
				</a>	
			</c:forEach>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" >
				<ul>
				<li><a data-ajax='false' href="/m/main">메인</a></li>
			</ul>
			</div>
			<div id='pagearea' data-role="navbar">
			</div>
		</div>
	</div>
	<div data-role="page" id="pay">
		<div data-role="header">
			<div data-role="navbar">
				<ul>
					<li><a href="#req">발주요청</a></li>
					<li><a href="#ord">발주</a></li>
					<li><a class="ui-btn-active ui-state-persist" href="#pay">결제</a></li>
					<li><a href="#del">납품</a></li>
					<li><a href="#cal">정산</a></li>
				</ul>
			</div>
		</div>
		<div data-role="content" id="list">
			<c:if test="${empty pay}">
				결과가 없습니다
			</c:if>
			<c:forEach items="${pay}" var="pay">
				<a data-ajax='false' class='ui-btn' href='/m/pay/detail?id=${pay.pay_id }'>
					<div class='ui-body ui-body-a'>
						${req.ordreq_name } - ${pay.pay_price }
					</div>
				</a>	
			</c:forEach>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" >
				<ul>
				<li><a data-ajax='false' href="/m/main">메인</a></li>
			</ul>
			</div>
			<div id='pagearea' data-role="navbar">
			</div>
		</div>
	</div>
	<div data-role="page" id="del">
		<div data-role="header">
			<div data-role="navbar">
				<ul>
					<li><a href="#req">발주요청</a></li>
					<li><a href="#ord">발주</a></li>
					<li><a href="#pay">결제</a></li>
					<li><a class="ui-btn-active ui-state-persist" href="#del">납품</a></li>
					<li><a href="#cal">정산</a></li>
				</ul>
			</div>
		</div>
		<div data-role="content" id="list">
			<c:if test="${empty del}">
				결과가 없습니다
			</c:if>
			<c:forEach items="${del}" var="del">
				<a data-ajax='false' class='ui-btn' href='/m/del/detail?id=${del.del_id }'>
					<div class='ui-body ui-body-a'>
						${req.ordreq_name } 
						<c:if test="${del.del_state eq '1'}">
							- ${del.del_customer } | 납품
						</c:if>
						<c:if test="${del.del_state eq '2'}">
							- ${del.del_customer } | 정산
						</c:if>
					</div>
				</a>	
			</c:forEach>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" >
				<ul>
				<li><a data-ajax='false' href="/m/main">메인</a></li>
			</ul>
			</div>
			<div id='pagearea' data-role="navbar">
			</div>
		</div>
	</div>
	<div data-role="page" id="cal">
		<div data-role="header">
			<div data-role="navbar">
				<ul>
					<li><a href="#req">발주요청</a></li>
					<li><a href="#ord">발주</a></li>
					<li><a href="#pay">결제</a></li>
					<li><a href="#del">납품</a></li>
					<li><a class="ui-btn-active ui-state-persist" href="#cal">정산</a></li>
				</ul>
			</div>
		</div>
		<div data-role="content" id="list">
			<c:if test="${empty cal}">
				결과가 없습니다
			</c:if>
			<c:forEach items="${cal}" var="cal">
				<a data-ajax='false' class='ui-btn' href='/m/cal/detail?id=${cal.cal_id }'>
					<div class='ui-body ui-body-a'>
						${req.ordreq_name } 
						<c:if test="${cal.cal_state eq '1'}">
							 | 정산 대기
						</c:if>
						<c:if test="${cal.cal_state eq '2'}">
							- ${cal.cal_price } | 정산완료
						</c:if>
						<c:if test="${cal.cal_state eq '3'}">
							- ${cal.cal_price } | 임원 확인 완료
						</c:if>
					</div>
				</a>	
			</c:forEach>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar" >
				<ul>
				<li><a data-ajax='false' href="/m/main">메인</a></li>
			</ul>
			</div>
			<div id='pagearea' data-role="navbar">
			</div>
		</div>
	</div>
<script>
	$(document).ready(function(){
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
</body>
</html>