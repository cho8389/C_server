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

</head>
<body>
	<div data-role="page" id="page1">
		<div data-role="content">
		<form id="form" data-ajax="false" method="post">
			<label>종류
			<select name="ordreq_type" id="ordreq_type">
            	<option value="1">납품</option>
            	<option value="2">샘플</option>
        	</select></label>
			<label>납기일
			<input type="date" id="ordreq_edate" name="ordreq_edate" value=""></label>
			<label>고객상호명
			<input type="text" name="ordreq_customer" value=""></label>
			<label>지역
			<input type="text" id="region" name="ordreq_region" onclick="region12()" value=""></label>
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
				<li><button onclick="insert()" id="update">발주신청</button></li>
			</ul>
		</div>
		</div>
	</div>
	<div data-role="page" id="page2">
		<div data-role="content" id="layer" style="margin:0;padding:0;position:fixed;z-index:10;-webkit-overflow-scrolling:touch;width:100%;height:100%">
		<img src="//t1.daumcdn.net/localimg/localimages/07/postcode/320/close.png" id="btnCloseLayer" style="cursor:pointer;position:absolute;right:-3px;top:-3px;z-index:1" onclick="closeDaumPostcode()" alt="닫기 버튼">
		</div>
	</div>
<script>
Date.prototype.toDateInputValue = (function() {
    var local = new Date(this);
    local.setMinutes(this.getMinutes() - this.getTimezoneOffset());
    return local.toJSON().slice(0,10);
});
	function toJSONString( form ) {
		var obj = {};
		var elements = form.querySelectorAll( "input, select, textarea" );
		for( var i = 0; i < elements.length; ++i ) {
			var element = elements[i];
			var name = element.name;
			var value = element.value;

			if( name ) {
				obj[ name ] = value;
			}
		}

		return JSON.stringify( obj );
	}
var state;
var id;
var myWidth = 0, myHeight = 0;
function insert(){	
		var that=$('#form');
		var form=document.getElementById( "form" );
		var formData = toJSONString(form);
		var data='{"type":"req","json":'+formData+'}';
		
		Android.sendMessage(data);
		that.get(0).submit();
}
function list(){
	location.href="/m/main"
}
function alertSize() {
	  if( typeof( window.innerWidth ) == 'number' ) {
	    //Non-IE
	    myWidth = window.innerWidth;
	    myHeight = window.innerHeight;
	  } else if( document.documentElement && ( document.documentElement.clientWidth || document.documentElement.clientHeight ) ) {
	    //IE 6+ in 'standards compliant mode'
	    myWidth = document.documentElement.clientWidth;
	    myHeight = document.documentElement.clientHeight;
	  } else if( document.body && ( document.body.clientWidth || document.body.clientHeight ) ) {
	    //IE 4 compatible
	    myWidth = document.body.clientWidth;
	    myHeight = document.body.clientHeight;
	  }
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
var element_layer = document.getElementById('layer');
function region12(){
	location.href="#page2"
	sample2_execDaumPostcode()
}
function closeDaumPostcode() {
    location.href="#page1"
}
function sample2_execDaumPostcode() {
	var add
	alertSize()
	new daum.Postcode({
	oncomplete: function(data) {
		var type=data.userSelectedType;
		if(type=="R"){
			add=data.address
		}else if(type=="J"){
			add=data.jibunAddress;
		}
		$('#region').val(add);
		location.href="#page1";
	},
	width : myWidth,
    height : '100%',
    maxSuggestItems : 5
	}).embed(element_layer)
}
</script>
</body>
</html>