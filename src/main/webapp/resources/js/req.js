var now=new Date();
var day;
var state;
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
function searchlist(type_pm){	
	var formdata={
		"json":json,
		"page":page,
		"type":type_pm
	}
	$.ajax({
		  url:'/m/req/search_list',
		  data:formdata,
	  	  type:'post',
	  	  dataType:'json',
	  	  beforeSend:function(xhr){
	  		  xhr.setRequestHeader("Accept","application/json")
	  	  }
	  }).done(function(data){
			var bd=new Date("0");
			var str=""
			var list=data.list;
				
				if(type_pm=="req"){
					for(i in list){
						var d=new Date(list[i].ordreq_date);
						if(bd.getTime()=="0"){
							bd=new Date(list[i].ordreq_date);
							str+=date(d);
						}else if(bd.getDate()!=d.getDate()){
							bd=new Date(list[i].ordreq_date);
							str+=date(d);
						}
						
						if(list[i].ordreq_state=='1'){
							state="신청"
						}else if(list[i].ordreq_state=='2'){
							state="확인"
						}else if(list[i].ordreq_state=='3'){
							state="발주"
						}else if(list[i].ordreq_state=='4'){
							state="입고"
						}else if(list[i].ordreq_state=='5'){
							state="납품"
						}else if(list[i].ordreq_state=='6'){
							state="정산"
						}
						str+="<a data-ajax='false' class='ui-btn' href='/m/req/detail?id="+list[i].ordreq_id+"'><div class='ui-body ui-body-a'>"+
							list[i].emp_id+" - "+list[i].ordreq_name+" | "+state+
						"</div></a>"
					}
				}
				
				if(type_pm=="ord"){
					for(i in list){
						var d=new Date(list[i].ord_date);
						if(bd.getTime()=="0"){
							bd=new Date(list[i].ord_date);
							str+=date(d);
						}else if(bd.getDate()!=d.getDate()){
							bd=new Date(list[i].ord_date);
							str+=date(d);
						}
						
						if(list[i].ord_state=='1'){
							state="발주"
						}else if(list[i].ord_state=='2'){
							state="입고"
						}
						str+="<a data-ajax='false' class='ui-btn' href='/m/ord/detail?id="+list[i].ord_id+"'><div class='ui-body ui-body-a'>"+
							list[i].emp_id+" - "+list[i].ord_price+"원 | "+state+
						"</div></a>"
					}
				}
				
				if(type_pm=="pay"){
					for(i in list){
						var d=new Date(list[i].pay_date);
						if(bd.getTime()=="0"){
							bd=new Date(list[i].pay_date);
							str+=date(d);
						}else if(bd.getDate()!=d.getDate()){
							bd=new Date(list[i].pay_date);
							str+=date(d);
						}
						
						str+="<a data-ajax='false' class='ui-btn' href='/m/pay/detail?id="+list[i].pay_id+"'><div class='ui-body ui-body-a'>"+
							list[i].emp_id+" - "+list[i].pay_price+"원 "+ 
						"</div></a>"
					}
				}
				
				if(type_pm=="del"){
					for(i in list){
						var d=new Date(list[i].del_date);
						if(bd.getTime()=="0"){
							bd=new Date(list[i].del_date);
							str+=date(d);
						}else if(bd.getDate()!=d.getDate()){
							bd=new Date(list[i].del_date);
							str+=date(d);
						}
						
						if(list[i].del_state=='1'){
							state="납품"
						}else if(list[i].del_state=='2'){
							state="정산"
						}
						str+="<a data-ajax='false' class='ui-btn' href='/m/del/detail?id="+list[i].del_id+"'><div class='ui-body ui-body-a'>"+
							list[i].emp_id+" - "+list[i].del_customer+" | "+state+
						"</div></a>"
					}
				}
				
				if(type_pm=="cal"){
					for(i in list){
						var d=new Date(list[i].cal_date);
						if(bd.getTime()=="0"){
							bd=new Date(list[i].cal_date);
							str+=date(d);
						}else if(bd.getDate()!=d.getDate()){
							bd=new Date(list[i].cal_date);
							str+=date(d);
						}
						
						var cal_state;
						if(list[i].cal_check==null){
							cal_state="정산"
						}else{
							cal_state="임원확인"
						}
						str+="<a data-ajax='false' class='ui-btn' href='/m/cal/detail?id="+list[i].cal_id+"'><div class='ui-body ui-body-a'>"+
							list[i].emp_id+" - "+list[i].cal_price+" | "+cal_state+
						"</div></a>"
					}
				}
				
			$('#list').html(str);
			var pageMaker=data.pageMaker;
			ep=pageMaker.endPage;
			dpm=pageMaker.displayPageNum;
			var str="";
			str+="<ul>"
			if(pageMaker.prev){
				str+="<li><button class='ui-btn prev' page="+(pageMaker.startPage-5)+"> << </button></li>";
			};
			for(var i=pageMaker.startPage,len=pageMaker.endPage;i<=len;i++){
				var strClass=pageMaker.cri.page==i?"ui-btn-active ui-state-persist":'';
				str+="<li><button class='"+strClass+" ui-btn reppage'>"+i+"</button></li>";
			};
			if(pageMaker.next){
				str+="<li><button class='ui-btn next' page="+(pageMaker.endPage+1)+"> >> </button></li>";
			};
			str+="</ul>"
			$('#pagearea').html(str);
	  });   
}
