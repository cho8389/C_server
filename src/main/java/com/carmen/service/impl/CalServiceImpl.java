package com.carmen.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.carmen.dao.CalDAO;
import com.carmen.dao.MemberDAO;
import com.carmen.dao.ReqDAO;
import com.carmen.domain.CalVO;
import com.carmen.domain.ReqVO;
import com.carmen.service.CalService;
import com.carmen.service.ReqService;

public class CalServiceImpl implements CalService {
	
	private CalDAO calDAO;
	
	public void setCalDAO(CalDAO calDAO) {
		this.calDAO=calDAO;
	}

	@Override
	public List<CalVO> selectcalall() throws SQLException {
		return calDAO.selectcalall();
	}

	@Override
	public List<CalVO> selectcalbyid(String emp_id) throws SQLException {
		return calDAO.selectcalbyid(emp_id);
	}

	@Override
	public List<CalVO> selectcalbyreqid(int ordreq_id) throws SQLException {
		return calDAO.selectcalbyreqid(ordreq_id);
	}

	@Override
	public void insertcal(CalVO cal) throws SQLException {
		calDAO.insertcal(cal);
	}

	@Override
	public void updatecal(CalVO cal) throws SQLException {
		calDAO.updatecal(cal);
	}

	@Override
	public void deletecal(int cal_id) throws SQLException {
		calDAO.deletecal(cal_id);
	}

	@Override
	public List<CalVO> searchsortcal(CalVO cal) throws SQLException {
		return calDAO.searchsortcal(cal);
	}

	@Override
	public int countsearchcal(CalVO cal) throws SQLException {
		return calDAO.countsearchcal(cal);
	}

}
