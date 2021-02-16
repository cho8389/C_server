<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="initial-scale=1.0, width=device-width">
<title>carmen 로그인</title>

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
			<img src="/resources/ui/title.png" style="width:70%;margin:1% 5%;"/>
		</div>
		<div data-role="content">
			<div class="ui-body ui-body-a">
				<form id="login" method="post" action="/loginRequest">
					<div class="ui-field-contain">
						<input type="text" name="uid" id="id" placeholder="아이디">
						<input type="password" name="upwd" id="pw" placeholder="비밀번호">
					</div>
					<div data-role="controlgroup" data-type="horizontal">
						<label id="idlabel">
        					<input onclick="idcheck()" id="idbox" type="checkbox" name="checkbox-0 ">아이디 저장
    					</label>
    					<label id="autolabel">
        					<input onclick="saveck()" id="autobox" type="checkbox" name="checkbox-0 ">자동 로그인
    					</label>
					</div>
					<input type="button" onclick="login_go()" data-inline="true" value="로그인">
				</form>
			</div>
		</div>
	</div>
<script>
function login_go(){
	var idsave="0";
	var autologin="0";
	if($("#idbox").is(":checked")){
		idsave="1";
	}
	if($("#autobox").is(":checked")){
		autologin="1";
	}
	  $.ajax({
		  url:'loginRequest',
		  data:$('form input').serialize(),
	  	  type:'post',
	  	  dataType:'json',
	  	  beforeSend:function(xhr){
	  		  xhr.setRequestHeader("Accept","application/json")
	  	  }
	  }).done(function(body){
		 var message=body.response.message;
		 var error=body.response.error;
		 var returl=body.response.returl;
		 if (error){
			 Android.Toast(message);
			 $('input[name=returl]').val(returl);
		 }else{
			 Android.saveconfig(idsave,autologin);
			 if(returl==''){
				 returl="<c:url value="/logincheck" />";
			 }
			 location.href=returl;    				 
		 }
	  });    		  
};
function idcheck(){
	if(!$("idbox").is(":checked")){
		$("#autobox").prop("checked",false).checkboxradio('refresh');
	}
}
function saveck(){
	if($("#autobox").is(":checked")){
		$("#idbox").prop("checked",true).checkboxradio('refresh');
	}else{
		$("#idbox").prop("checked",false).checkboxradio('refresh');
	}
}
function idck(){
	$("#idbox").prop("checked",true).checkboxradio('refresh');
}
function savecheck(){
	$("#autobox").prop("checked",true).checkboxradio('refresh');
}
$(document).ready(function(){
	if($("#autobox").is(":checked")){
		//login_go();
	}
})
</script>
</body>
</html>