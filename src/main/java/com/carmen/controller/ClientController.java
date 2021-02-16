package com.carmen.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carmen.domain.CalVO;
import com.carmen.domain.DelVO;
import com.carmen.domain.OrdVO;
import com.carmen.domain.PayVO;
import com.carmen.domain.ReqVO;
import com.carmen.service.MemberService;
import com.carmen.service.WebService;
import com.carmen.utils.Convert;
import com.google.gson.Gson;

@Controller
public class ClientController {

	@Autowired
	private MemberService ms;
	
	@Autowired
	private WebService ws;
	
	@RequestMapping(value = "/search_list", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> searchlist(@RequestParam Map<String, Object> param, Model model, HttpSession session) throws Exception {
		String type=(String) param.get("type");
		ResponseEntity<Map<String, Object>> re=ws.clist(type, param.get("json").toString());
		return re;
	}
	
	@RequestMapping(value = "/updatestate", method = RequestMethod.POST)
	@ResponseBody
	public void updatestate(@RequestParam Map<String, Object> param, Model model, HttpSession session) throws Exception {
		String type=(String) param.get("type");
		ws.cupdatestate(type,param.get("json").toString());
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public void update(@RequestParam Map<String, Object> param, Model model, HttpSession session) throws Exception {
		String type=(String) param.get("type");
		ws.cupdate(type,param.get("json").toString());
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	@ResponseBody
	public void insert(@RequestParam Map<String, Object> param, Model model, HttpSession session) throws Exception {
		String type=(String) param.get("type");
		ws.cinsert(type,param.get("json").toString());
	}
	
	@RequestMapping(value = "/AllList/{ordreq_id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> AllList(@PathVariable("ordreq_id")int ordreq_id, Model model, HttpSession session) throws Exception {
		ResponseEntity<Map<String, Object>> entity=null;
		Map<String, Object> map = ws.mlist(ordreq_id);
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		return entity;
	}
	@RequestMapping(value = "/mmemset/{emp_id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> mmemset(@PathVariable("emp_id")String emp_id, Model model, HttpSession session) throws Exception {
		ResponseEntity<Map<String, Object>> entity=null;
		Map<String, Object> map =new HashMap<String,Object>();
		map.put("mem", ms.selectmem(emp_id));
		map.put("role", ms.selectrole(emp_id));
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		return entity;
	}
	@RequestMapping(value = "/memlist", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> memlist(@RequestParam Map<String, Object> param, Model model, HttpSession session) throws Exception {
		ResponseEntity<Map<String, Object>> entity=null;
		Map<String, Object> map =new HashMap<String,Object>();
		map.put("list",ms.selectmemall());
		entity = new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
		return entity;
	}
	@RequestMapping(value = "/update_mem", method = RequestMethod.POST)
	@ResponseBody
	public void update_mem(@RequestParam Map<String, Object> param, Model model, HttpSession session) throws Exception {
		ws.cmemupdate(param.get("mem").toString(),param.get("role").toString());
	}
	@RequestMapping(value = "/insert_mem", method = RequestMethod.POST)
	@ResponseBody
	public void insert_mem(@RequestParam Map<String, Object> param, Model model, HttpSession session) throws Exception {
		ws.cmeminsert(param.get("mem").toString(),param.get("role").toString());
	}
	@RequestMapping(value = "/admin_del/{type}/{ordreq_id}/{target_id}", method = RequestMethod.GET)
	@ResponseBody
	public void admin_del(@PathVariable("type")String type,@PathVariable("ordreq_id")int ordreq_id,@PathVariable("target_id")int target_id, Model model, HttpSession session) throws Exception {
		Gson gson=new Gson();
		ReqVO req=new ReqVO();
		CalVO cal=new CalVO();
		DelVO del=new DelVO();
		PayVO pay=new PayVO();
		OrdVO ord=new OrdVO();
		
		req.setOrdreq_id(ordreq_id);
		cal.setOrdreq_id(ordreq_id);
		del.setOrdreq_id(ordreq_id);
		pay.setOrdreq_id(ordreq_id);
		ord.setOrdreq_id(ordreq_id);
		
		if(type.equals("cal")) {
			req.setOrdreq_state("5");
			pay.setPay_state("1");
			ws.delete(type, target_id);
			ws.cupdatestate("req",gson.toJson(req));
			ws.cupdatestate("pay",gson.toJson(pay));
		}else if(type.equals("del")) {
			req.setOrdreq_state("4");
			ws.delete(type, target_id);
			ws.deletebyordreq_id("cal", ordreq_id);
			ws.cupdatestate("req",gson.toJson(req));
		}else if(type.equals("pay")) {
			ord.setOrd_state("1");
			ws.delete(type, target_id);
			ws.cupdatestate("ord",gson.toJson(ord));
		}else if(type.equals("ord")) {
			req.setOrdreq_state("1");
			ws.delete(type, target_id);
			ws.deletebyordreq_id("cal", ordreq_id);
			ws.deletebyordreq_id("del", ordreq_id);
			ws.deletebyordreq_id("pay", ordreq_id);
			ws.cupdatestate("req",gson.toJson(req));
		}else if(type.equals("req")) {
			ws.deletebyordreq_id("cal", ordreq_id);
			ws.deletebyordreq_id("del", ordreq_id);
			ws.deletebyordreq_id("pay", ordreq_id);
			ws.deletebyordreq_id("ord", ordreq_id);
			ws.deletebyordreq_id("req", ordreq_id);
		}
	}
}
