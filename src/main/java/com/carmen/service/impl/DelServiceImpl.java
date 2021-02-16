package com.carmen.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.carmen.dao.DelDAO;
import com.carmen.domain.DelVO;
import com.carmen.domain.ReqVO;
import com.carmen.service.DelService;

public class DelServiceImpl implements DelService {
	
	private DelDAO delDAO;
	
	public void setDelDAO(DelDAO delDAO) {
		this.delDAO=delDAO;
	}

	@Override
	public List<DelVO> selectdelall() throws SQLException {
		return delDAO.selectdelall();
	}

	@Override
	public List<DelVO> selectdelbyid(String emp_id) throws SQLException {
		return delDAO.selectdelbyid(emp_id);
	}

	@Override
	public List<DelVO> selectdelbyreqid(int ordreq_id) throws SQLException {
		return delDAO.selectdelbyreqid(ordreq_id);
	}

	@Override
	public void insertdel(DelVO del) throws SQLException {
		delDAO.insertdel(del);
	}

	@Override
	public void updatedel(DelVO del) throws SQLException {
		delDAO.updatedel(del);
	}

	@Override
	public void deletedel(int del_id) throws SQLException {
		delDAO.deletedel(del_id);
	}

	@Override
	public List<DelVO> searchsortdel(DelVO del) throws SQLException {
		return delDAO.searchsortdel(del);
	}

	@Override
	public int countsearchdel(DelVO del) throws SQLException {
		return delDAO.countsearchdel(del);
	}

}
