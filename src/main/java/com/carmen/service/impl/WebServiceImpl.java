package com.carmen.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.carmen.dao.CalDAO;
import com.carmen.dao.DelDAO;
import com.carmen.dao.MemberDAO;
import com.carmen.dao.OrdDAO;
import com.carmen.dao.PayDAO;
import com.carmen.dao.ReqDAO;
import com.carmen.domain.CalVO;
import com.carmen.domain.DelVO;
import com.carmen.domain.MemberVO;
import com.carmen.domain.OrdVO;
import com.carmen.domain.PageMaker;
import com.carmen.domain.PayVO;
import com.carmen.domain.ReqVO;
import com.carmen.domain.RoleVO;
import com.carmen.service.WebService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

public class WebServiceImpl implements WebService {
	
	private ReqDAO reqDAO;
	
	public void setReqDAO(ReqDAO reqDAO) {
		this.reqDAO=reqDAO;
	}
	
	private CalDAO calDAO;
	
	public void setCalDAO(CalDAO calDAO) {
		this.calDAO=calDAO;
	}
	
	private DelDAO delDAO;
	
	public void setDelDAO(DelDAO delDAO) {
		this.delDAO=delDAO;
	}
	
	private OrdDAO ordDAO;
	
	public void setOrdDAO(OrdDAO ordDAO) {
		this.ordDAO=ordDAO;
	}
	
	private PayDAO payDAO;
	
	public void setPayDAO(PayDAO payDAO) {
		this.payDAO=payDAO;
	}
	
	private MemberDAO memDAO;
	
	public void setMemberDAO(MemberDAO memDAO) {
		this.memDAO=memDAO;
	}
	
	@Override
	public ResponseEntity<Map<String, Object>> searchlist(String type, String json, int page) throws SQLException {
		ResponseEntity<Map<String, Object>> entity = null;
		
		if(type.equals("req")) {
			Gson gson=new Gson();
			ReqVO req=gson.fromJson(json,ReqVO.class);
			PageMaker pm=new PageMaker();
			req.setPage(page);
			req.setPerPageNum(10);
			pm.setCri(req);
			pm.setTotalCount(reqDAO.countsearchreq(req));
			List<ReqVO> list=reqDAO.searchsortreq(req);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("json",json);
			map.put("list", list);
			map.put("pageMaker", pm);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			if(reqDAO.countsearchreq(req)==0) {
				entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			
		}
		
		if(type.equals("cal")) {
			Gson gson=new Gson();
			CalVO cal=gson.fromJson(json,CalVO.class);
			PageMaker pm=new PageMaker();
			cal.setPage(page);
			cal.setPerPageNum(10);
			pm.setCri(cal);
			pm.setTotalCount(calDAO.countsearchcal(cal));
			List<CalVO> list=calDAO.searchsortcal(cal);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("json",json);
			map.put("list", list);
			map.put("pageMaker", pm);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			if(calDAO.countsearchcal(cal)==0) {
				entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			
		}
		
		if(type.equals("del")) {
			Gson gson=new Gson();
			DelVO del=gson.fromJson(json,DelVO.class);
			PageMaker pm=new PageMaker();
			del.setPage(page);
			del.setPerPageNum(10);
			pm.setCri(del);
			pm.setTotalCount(delDAO.countsearchdel(del));
			List<DelVO> list=delDAO.searchsortdel(del);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("json",json);
			map.put("list", list);
			map.put("pageMaker", pm);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			if(delDAO.countsearchdel(del)==0) {
				entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			
		}
		
		if(type.equals("ord")) {
			Gson gson=new Gson();
			OrdVO ord=gson.fromJson(json,OrdVO.class);
			PageMaker pm=new PageMaker();
			ord.setPage(page);
			ord.setPerPageNum(10);
			pm.setCri(ord);
			pm.setTotalCount(ordDAO.countsearchord(ord));
			List<OrdVO> list=ordDAO.searchsortord(ord);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("json",json);
			map.put("list", list);
			map.put("pageMaker", pm);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			if(ordDAO.countsearchord(ord)==0) {
				entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			
		}
		
		if(type.equals("pay")) {
			Gson gson=new Gson();
			PayVO pay=gson.fromJson(json,PayVO.class);
			PageMaker pm=new PageMaker();
			pay.setPage(page);
			pay.setPerPageNum(10);
			pm.setCri(pay);
			pm.setTotalCount(payDAO.countsearchpay(pay));
			List<PayVO> list=payDAO.searchsortpay(pay);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("json",json);
			map.put("list", list);
			map.put("pageMaker", pm);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			if(payDAO.countsearchpay(pay)==0) {
				entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			
		}
		
		return entity;
	}

	@Override
	public void insert(String type,Object obj) throws SQLException {
		if(type.equals("req")) {
			reqDAO.insertreq((ReqVO) obj);
		}
		
		if(type.equals("ord")) {
			ordDAO.insertord((OrdVO) obj);
		}
		
		if(type.equals("pay")) {
			payDAO.insertpay((PayVO) obj);
		}
		
		if(type.equals("del")) {
			delDAO.insertdel((DelVO) obj);
		}
		
		if(type.equals("cal")) {
			calDAO.insertcal((CalVO) obj);
		}
	}

	@Override
	public void update(String type,Object obj) throws SQLException {
		if(type.equals("req")) {
			ReqVO req=(ReqVO) obj;
			reqDAO.updatereq(req);
		}
		
		if(type.equals("ord")) {
			OrdVO ord=(OrdVO) obj;
			ordDAO.updateord(ord);
		}
		
		if(type.equals("pay")) {
			PayVO pay=(PayVO) obj;
			payDAO.updatepay(pay);
		}
		
		if(type.equals("del")) {
			DelVO del=(DelVO) obj;
			delDAO.updatedel(del);
		}
		
		if(type.equals("cal")) {
			CalVO cal=(CalVO) obj;
			calDAO.updatecal(cal);
		}
	}

	@Override
	public void delete(String type,int id) throws SQLException {
		if(type.equals("req")) {
			reqDAO.deletereq(id);
		}
		
		if(type.equals("ord")) {
			ordDAO.deleteord(id);
		}
		
		if(type.equals("pay")) {
			payDAO.deletepay(id);
		}
		
		if(type.equals("del")) {
			delDAO.deletedel(id);
		}
		
		if(type.equals("cal")) {
			calDAO.deletecal(id);
		}
	}
	
	@Override
	public void deletebyordreq_id(String type,int ordreq_id) throws SQLException {
		if(type.equals("req")) {
			reqDAO.deletereq(ordreq_id);
		}
		
		if(type.equals("ord")) {
			ordDAO.deletebyreqid(ordreq_id);
		}
		
		if(type.equals("pay")) {
			payDAO.deletebyreqid(ordreq_id);
		}
		
		if(type.equals("del")) {
			delDAO.deletebyreqid(ordreq_id);
		}
		
		if(type.equals("cal")) {
			calDAO.deletebyreqid(ordreq_id);
		}
	}

	@Override
	public Map<String, Object> mlist(int ordreq_id) throws SQLException {
		Map<String, Object> map= new HashMap<String, Object>();
		map.put("req",reqDAO.selectreqbyreqid(ordreq_id));
		map.put("ord",ordDAO.selectordbyreqid(ordreq_id));
		map.put("pay",payDAO.selectpaybyreqid(ordreq_id));
		map.put("del",delDAO.selectdelbyreqid(ordreq_id));
		map.put("cal",calDAO.selectcalbyreqid(ordreq_id));
		return map;
	}

	@Override
	public Object selectone(String type, int id) throws SQLException {
		if(type.equals("req")) {
			return reqDAO.selectreqbyreqid(id);
		}
		
		if(type.equals("ord")) {
			return ordDAO.selectordone(id);
		}
		
		if(type.equals("pay")) {
			return payDAO.selectpayone(id);
		}
		
		if(type.equals("del")) {
			return delDAO.selectdelone(id);
		}
		
		if(type.equals("cal")) {
			return calDAO.selectcalone(id);
		}
		return null;
	}

	@Override
	public ResponseEntity<Map<String, Object>> clist(String type, String json) throws SQLException {
		ResponseEntity<Map<String, Object>> entity = null;
		
		if(type.equals("req")) {
			Gson gson=new Gson();
			ReqVO req=gson.fromJson(json,ReqVO.class);
			List<ReqVO> list=reqDAO.reqlist(req);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("json",json);
			map.put("list", list);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			if(reqDAO.countsearchreq(req)==0) {
				entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			
		}
		
		if(type.equals("cal")) {
			Gson gson=new Gson();
			CalVO cal=gson.fromJson(json,CalVO.class);
			List<CalVO> list=calDAO.callist(cal);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("json",json);
			map.put("list", list);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			if(calDAO.countsearchcal(cal)==0) {
				entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			
		}
		
		if(type.equals("del")) {
			Gson gson=new Gson();
			DelVO del=gson.fromJson(json,DelVO.class);
			List<DelVO> list=delDAO.dellist(del);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("json",json);
			map.put("list", list);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			if(delDAO.countsearchdel(del)==0) {
				entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			
		}
		
		if(type.equals("ord")) {
			Gson gson=new Gson();
			OrdVO ord=gson.fromJson(json,OrdVO.class);
			List<OrdVO> list=ordDAO.ordlist(ord);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("json",json);
			map.put("list", list);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			if(ordDAO.countsearchord(ord)==0) {
				entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			
		}
		
		if(type.equals("pay")) {
			Gson gson=new Gson();
			PayVO pay=gson.fromJson(json,PayVO.class);
			List<PayVO> list=payDAO.paylist(pay);
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("json",json);
			map.put("list", list);
			entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
			if(payDAO.countsearchpay(pay)==0) {
				entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
			}
			
		}
		
		return entity;
	}
	
	@Override
	public void cupdate(String type, String json) throws SQLException {
		
		if(type.equals("req")) {
			Gson gson=new Gson();
			ReqVO req=gson.fromJson(json,ReqVO.class);
			reqDAO.updatereq(req);
		}
		
		if(type.equals("del")) {
			Gson gson=new Gson();
			DelVO del=gson.fromJson(json,DelVO.class);
			delDAO.updatedelstate(del);
		}
		
		if(type.equals("ord")) {
			Gson gson=new Gson();
			OrdVO ord=gson.fromJson(json,OrdVO.class);
			ordDAO.updateord(ord);
		}
		
		if(type.equals("pay")) {
			Gson gson=new Gson();
			PayVO pay=gson.fromJson(json,PayVO.class);
			payDAO.updatepay(pay);
		}
		if(type.equals("cal")) {
			Gson gson=new Gson();
			CalVO cal=gson.fromJson(json,CalVO.class);
			calDAO.updatecal(cal);
		}
	}
	
	@Override
	public void cupdatestate(String type, String json) throws SQLException {
		
		if(type.equals("req")) {
			Gson gson=new Gson();
			ReqVO req=gson.fromJson(json,ReqVO.class);
			reqDAO.updatereqstate(req);
		}
		
		if(type.equals("del")) {
			Gson gson=new Gson();
			DelVO del=gson.fromJson(json,DelVO.class);
			delDAO.updatedelstate(del);
		}
		
		if(type.equals("ord")) {
			Gson gson=new Gson();
			OrdVO ord=gson.fromJson(json,OrdVO.class);
			ordDAO.updateordstate(ord);
		}
		
		if(type.equals("pay")) {
			Gson gson=new Gson();
			PayVO pay=gson.fromJson(json,PayVO.class);
			payDAO.updatepaystate(pay);
		}
	}
	@Override
	public void cinsert(String type, String json) throws SQLException {
		
		if(type.equals("req")) {
			Gson gson=new Gson();
			ReqVO req=gson.fromJson(json,ReqVO.class);
			reqDAO.insertreq(req);
		}
		
		if(type.equals("del")) {
			Gson gson=new Gson();
			DelVO del=gson.fromJson(json,DelVO.class);
			delDAO.insertdel(del);
		}
		
		if(type.equals("ord")) {
			Gson gson=new Gson();
			OrdVO ord=gson.fromJson(json,OrdVO.class);
			ordDAO.insertord(ord);
		}
		
		if(type.equals("pay")) {
			Gson gson=new Gson();
			PayVO pay=gson.fromJson(json,PayVO.class);
			payDAO.insertpay(pay);
		}
		
		if(type.equals("cal")) {
			Gson gson=new Gson();
			CalVO cal=gson.fromJson(json,CalVO.class);
			calDAO.insertcal(cal);
		}
	}
	@Override
	public ResponseEntity<Map<String, Object>> cmemlist(String json) throws SQLException {
		ResponseEntity<Map<String, Object>> entity = null;
		
		Gson gson=new Gson();
		MemberVO mem=gson.fromJson(json,MemberVO.class);
		List<MemberVO> list=new ArrayList<MemberVO>();
		MemberVO asd=new MemberVO();
		if(mem.equals(asd)) {
			list=memDAO.selectmemall();
		}else {
			list=memDAO.searchmem(mem);
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("json",json);
		map.put("list", list);
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		return entity;
	}

	@Override
	public void cmemupdate(String mem, String role) throws SQLException {
			Gson gson=new Gson();
			MemberVO memvo=gson.fromJson(mem,MemberVO.class);
			List<RoleVO> rl=new ArrayList<RoleVO>();
			JsonParser parser = new JsonParser();
			JsonElement tradeElement = parser.parse(role);
			JsonArray ra=tradeElement.getAsJsonArray();
			for(int i=0;i<ra.size();i++) {
				rl.add(gson.fromJson(ra.get(i).toString().substring(1,ra.get(i).toString().length()-1).replace("\\",""),RoleVO.class));
			}
		memDAO.updatemem(memvo);
		memDAO.deleterole(memvo.getEmp_id());
		for(int i=0;i<rl.size();i++) {
			memDAO.insertrole(rl.get(i));
		}
	}
	
	@Override
	public void cmeminsert(String mem, String role) throws SQLException {
			Gson gson=new Gson();
			MemberVO memvo=gson.fromJson(mem,MemberVO.class);
			List<RoleVO> rl=new ArrayList<RoleVO>();
			JsonParser parser = new JsonParser();
			JsonElement tradeElement = parser.parse(role);
			JsonArray ra=tradeElement.getAsJsonArray();
			for(int i=0;i<ra.size();i++) {
				rl.add(gson.fromJson(ra.get(i).toString().substring(1,ra.get(i).toString().length()-1).replace("\\",""),RoleVO.class));
			}
		memDAO.insertmem(memvo);
		for(int i=0;i<rl.size();i++) {
			memDAO.insertrole(rl.get(i));
		}
	}
}
