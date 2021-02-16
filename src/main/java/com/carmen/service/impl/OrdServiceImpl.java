package com.carmen.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.carmen.dao.OrdDAO;
import com.carmen.domain.OrdVO;
import com.carmen.domain.ReqVO;
import com.carmen.service.OrdService;
import com.carmen.service.ReqService;

public class OrdServiceImpl implements OrdService {
	
	private OrdDAO ordDAO;
	
	public void setOrdDAO(OrdDAO ordDAO) {
		this.ordDAO=ordDAO;
	}

	@Override
	public List<OrdVO> selectordall() throws SQLException {
		return ordDAO.selectordall();
	}

	@Override
	public List<OrdVO> selectordbyid(String emp_id) throws SQLException {
		return ordDAO.selectordbyid(emp_id);
	}

	@Override
	public List<OrdVO> selectordbyreqid(int ordreq_id) throws SQLException {
		return ordDAO.selectordbyreqid(ordreq_id);
	}

	@Override
	public void insertord(OrdVO ord) throws SQLException {
		ordDAO.insertord(ord);
	}

	@Override
	public void updateord(OrdVO ord) throws SQLException {
		ordDAO.updateord(ord);
	}

	@Override
	public void deleteord(int ord_id) throws SQLException {
		ordDAO.deleteord(ord_id);
	}

	@Override
	public List<OrdVO> searchsortord(OrdVO ord) throws SQLException {
		return ordDAO.searchsortord(ord);
	}

	@Override
	public int countsearchord(OrdVO ord) throws SQLException {
		return ordDAO.countsearchord(ord);
	}

}
