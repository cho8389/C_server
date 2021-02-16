package com.carmen.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.carmen.dao.MemberDAO;
import com.carmen.dao.ReqDAO;
import com.carmen.domain.ReqVO;
import com.carmen.service.ReqService;

public class ReqServiceImpl implements ReqService {
	
	private ReqDAO reqDAO;
	
	public void setReqDAO(ReqDAO reqDAO) {
		this.reqDAO=reqDAO;
	}
	
	@Override
	public List<ReqVO> selectreqall() throws SQLException {
		return reqDAO.selectreqall();
	}

	@Override
	public List<ReqVO> selectreqbyid(String emp_id) throws SQLException {
		return reqDAO.selectreqbyid(emp_id);
	}
	
	@Override
	public ReqVO selectreqbyreqid(int ordreq_id) throws SQLException {
		return reqDAO.selectreqbyreqid(ordreq_id);
	}
	
	@Override
	public void insertreq(ReqVO req) throws SQLException {
		reqDAO.insertreq(req);
	}

	@Override
	public void updatereq(ReqVO req) throws SQLException {
		reqDAO.updatereq(req);
	}

	@Override
	public void deletereq(int ordreq_id) throws SQLException {
		reqDAO.deletereq(ordreq_id);
	}

	@Override
	public List<ReqVO> searchsortreq(ReqVO req) throws SQLException {
		return reqDAO.searchsortreq(req);
	}

	@Override
	public int countsearchreq(ReqVO req) throws SQLException {
		return reqDAO.countsearchreq(req);
	}

}
