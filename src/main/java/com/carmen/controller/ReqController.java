package com.carmen.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.carmen.domain.CalVO;
import com.carmen.domain.DelVO;
import com.carmen.domain.MemberVO;
import com.carmen.domain.OrdVO;
import com.carmen.domain.PayVO;
import com.carmen.domain.ReqVO;
import com.carmen.domain.RoleVO;
import com.carmen.service.MemberService;
import com.carmen.service.ReqService;
import com.carmen.service.WebService;
import com.carmen.utils.Convert;
import com.google.gson.Gson;

@Controller
public class ReqController {

	@Autowired
	private MemberService ms;

	@Autowired
	private ReqService rs;
	
	@Autowired
	private WebService ws;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat time = new SimpleDateFormat("hh:mm");
		SimpleDateFormat timestamp = new SimpleDateFormat("yyyy-MM-dd hh:mm");
		binder.registerCustomEditor(Date.class, "ordreq_date", new CustomDateEditor(date, true));
		binder.registerCustomEditor(Date.class, "ordreq_edate", new CustomDateEditor(date, true));
		
	}

	@RequestMapping(value = "/m/req", method = RequestMethod.GET)
	public String mreq(HttpSession session,RedirectAttributes rttr) throws Exception {
		MemberVO mem = (MemberVO) session.getAttribute("loginUser");
		ReqVO req= new ReqVO();
		req.setEmp_id(mem.getEmp_id());
		Gson gson=new Gson();
		rttr.addFlashAttribute("json", gson.toJson(req));
		rttr.addFlashAttribute("page", 1);
		rttr.addFlashAttribute("type","req");
		return "redirect:/m/req/searchlist";
	}
	
	@RequestMapping(value = "/m/req/dellist", method = RequestMethod.GET)
	public String mreqdel(HttpSession session,RedirectAttributes rttr) throws Exception {
		MemberVO mem = (MemberVO) session.getAttribute("loginUser");
		ReqVO req= new ReqVO();
		req.setEmp_id(mem.getEmp_id());
		req.setOrdreq_state("4");
		Gson gson=new Gson();
		rttr.addFlashAttribute("json", gson.toJson(req));
		rttr.addFlashAttribute("page", 1);
		rttr.addFlashAttribute("type","req");
		return "redirect:/m/req/searchlist";
	}

	@RequestMapping(value = "/m/req/detail", method = RequestMethod.GET)
	public void mreqdetail(@RequestParam("id") int ordreq_id, HttpSession session, Model model) throws Exception {
		ReqVO req = rs.selectreqbyreqid(ordreq_id);
		model.addAttribute("req", req);
	}

	@RequestMapping(value = "/m/req/delete", method = RequestMethod.GET)
	public String mreqdelete(@RequestParam("id") int ordreq_id, Model model) throws Exception {
		rs.deletereq(ordreq_id);
		return "redirect:/m/req";
	}

	@RequestMapping(value = "/m/req/update", method = RequestMethod.GET)
	public void mrequpdate(@RequestParam("id") int ordreq_id, Model model) throws Exception {
		ReqVO req = rs.selectreqbyreqid(ordreq_id);
		model.addAttribute("req", req);
	}

	@RequestMapping(value = "/m/req/update", method = RequestMethod.POST)
	@ResponseBody
	public String mrequpdate(ReqVO req, HttpSession session, HttpServletRequest request) throws Exception {
		String msg = "";
		ReqVO reqbf = rs.selectreqbyreqid(req.getOrdreq_id());
		String state = reqbf.getOrdreq_state();
		if (state.equals("1") || state.equals("2")) {
			req.setOrdreq_state("1");
			rs.updatereq(req);
			msg = "1";
		} else {
			msg = "2";
		}
		return msg;
	}

	@RequestMapping(value = "/m/req/insert", method = RequestMethod.GET)
	public void mreqinsert() throws Exception {
	}

	@RequestMapping(value = "/m/req/insert", method = RequestMethod.POST)
	public String mreqinsert(ReqVO req, HttpSession session, HttpServletRequest request) throws Exception {
		MemberVO mem = (MemberVO) session.getAttribute("loginUser");
		List<RoleVO> rolel = (List<RoleVO>) session.getAttribute("role");
		int rc=0;
		for(int i=0;i<rolel.size();i++) {
			if(rolel.get(i).getRole().equals("sales")) {
				rc=1;
			}
		}
		req.setEmp_id(mem.getEmp_id());
		req.setOrdreq_state("1");
		if(rc==1) {
			ws.insert("req",req);
			return "redirect:/m/req";
		}
		return null;
		
	}

	@RequestMapping(value = "/m/req/search", method = RequestMethod.GET)
	public void mreqsearch() throws Exception {
	}

	@RequestMapping(value = "/m/req/search", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String mreqsearch(@RequestParam Map<String, Object> param,
			HttpSession session,RedirectAttributes rttr) throws Exception {
		ReqVO req1 = new ReqVO();
		req1 = (ReqVO) Convert.mto(param, req1);
		MemberVO mem = (MemberVO) session.getAttribute("loginUser");
		String emp_id = mem.getEmp_id();
		req1.setEmp_id(emp_id);
		Gson gson=new Gson();
		String req=gson.toJson(req1);
		rttr.addFlashAttribute("json", req);
		rttr.addFlashAttribute("page", 1);
		rttr.addFlashAttribute("type","req");
		return "redirect:/m/req/searchlist";
	}
	
	@RequestMapping(value = "/m/req/searchlist", method = RequestMethod.GET)
	public void searchlist() throws Exception {
	}
	
	@RequestMapping(value = "/m/req/search_list", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> searchlist(@RequestParam Map<String, Object> param,@RequestParam("type")String type,@RequestParam("page")int page, Model model, HttpSession session) throws Exception {
		String json=param.get("json").toString();
		return ws.searchlist(type, json, page);
	}
	
	@RequestMapping(value = "/m/del/list", method = RequestMethod.GET)
	public String mdellist(RedirectAttributes rttr) throws Exception {
		DelVO del=new DelVO();
		del.setDel_state("1");
		Gson gson=new Gson();
		rttr.addFlashAttribute("json",gson.toJson(del));
		rttr.addFlashAttribute("page", 1);
		rttr.addFlashAttribute("type","del");
		return "redirect:/m/req/searchlist";
	}
	
	@RequestMapping(value = "/m/del/delcom", method = RequestMethod.GET)
	public void mdelcom(@RequestParam("id") int ordreq_id, Model model) throws Exception {
		model.addAttribute("ordreq_id",ordreq_id);
	}
	
	@RequestMapping(value = "/m/del/delcom", method = RequestMethod.POST)
	public String mdelcom(DelVO del,HttpSession session,Model model) throws Exception {
		MemberVO mem = (MemberVO) session.getAttribute("loginUser");
		
		List<RoleVO> rolel = (List<RoleVO>) session.getAttribute("role");
		ReqVO req=new ReqVO();
		req.setOrdreq_state("5");
		req.setOrdreq_id(del.getOrdreq_id());
		int rc=0;
		for(int i=0;i<rolel.size();i++) {
			if(rolel.get(i).getRole().equals("sales")) {
				rc=1;
			}
		}
		
		del.setEmp_id(mem.getEmp_id());
		if(rc==1) {
			ws.insert("del",del);
			Gson gson=new Gson();
			ws.cupdatestate("req",gson.toJson(req).toString());
			return "redirect:/m/main";
		}
		return null;
	}
	
	@RequestMapping(value = "/m/searchform", method = RequestMethod.GET)
	public void msearchform() throws Exception {
	}
	
	@RequestMapping(value = "/m/search", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	public String msearch(@RequestParam Map<String, Object> param,
			HttpSession session,RedirectAttributes rttr) throws Exception {
		String type=(String) param.get("type");
		String emp_id = ((MemberVO) session.getAttribute("loginUser")).getEmp_id();
		Gson gson=new Gson();
		ReqVO req=new ReqVO();
		CalVO cal=new CalVO();
		DelVO del=new DelVO();
		OrdVO ord=new OrdVO();
		PayVO pay=new PayVO();
		String json = null;
		
		if(type.equals("req")) {
			req=(ReqVO) Convert.mto(param, req);
			req.setEmp_id(emp_id);
			json=gson.toJson(req);
		}
		if(type.equals("cal")) {
			cal=(CalVO) Convert.mto(param, cal);
			json=gson.toJson(cal);
		}
		if(type.equals("del")) {
			del=(DelVO) Convert.mto(param, del);
			json=gson.toJson(del);
		}
		if(type.equals("ord")) {
			ord=(OrdVO) Convert.mto(param, ord);
			json=gson.toJson(ord);
		}
		if(type.equals("pay")) {
			pay=(PayVO) Convert.mto(param, pay);
			json=gson.toJson(pay);
		}
		
		rttr.addFlashAttribute("json", json);
		rttr.addFlashAttribute("page", 1);
		rttr.addFlashAttribute("type",type);
		return "redirect:/m/req/searchlist";
	}
	
	@RequestMapping(value = "/m/list", method = RequestMethod.GET)
	public void mlist(@RequestParam("id") int ordreq_id, Model model) throws Exception {
		Map<String, Object> map=ws.mlist(ordreq_id);
		model.addAttribute("req",map.get("req"));
		model.addAttribute("ord",map.get("ord"));
		model.addAttribute("pay",map.get("pay"));
		model.addAttribute("del",map.get("del"));
		model.addAttribute("cal",map.get("cal"));
	}
	
	@RequestMapping(value = "/m/cal/detail", method = RequestMethod.GET)
	public void mcaldetail(@RequestParam("id") int id, Model model) throws Exception {
		model.addAttribute("cal",(CalVO)ws.selectone("cal", id));
	}
	@RequestMapping(value = "/m/del/detail", method = RequestMethod.GET)
	public void mdeldetail(@RequestParam("id") int id, Model model) throws Exception {
		model.addAttribute("del",(DelVO)ws.selectone("del", id));
	}
	@RequestMapping(value = "/m/ord/detail", method = RequestMethod.GET)
	public void morddetail(@RequestParam("id") int id, Model model) throws Exception {
		model.addAttribute("ord",(OrdVO)ws.selectone("ord", id));
	}
	@RequestMapping(value = "/m/pay/detail", method = RequestMethod.GET)
	public void mpaydetail(@RequestParam("id") int id, Model model) throws Exception {
		model.addAttribute("pay",(PayVO)ws.selectone("pay", id));
	}
	
	@RequestMapping(value = "/m/cal/search", method = RequestMethod.GET)
	public void mcalsearch() throws Exception {
	}
	@RequestMapping(value = "/m/del/search", method = RequestMethod.GET)
	public void mdelsearch() throws Exception {
	}
	@RequestMapping(value = "/m/ord/search", method = RequestMethod.GET)
	public void mordsearch() throws Exception {
	}
	@RequestMapping(value = "/m/pay/search", method = RequestMethod.GET)
	public void mpaysearch() throws Exception {
	}
	
	@RequestMapping(value = "/m/list", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String, Object>> mlist(@RequestParam Map<String, Object> param,@RequestParam("type")String type,@RequestParam("page")int page, Model model, HttpSession session) throws Exception {
		String json=param.get("json").toString();
		return ws.searchlist(type, json, page);
	}
}
