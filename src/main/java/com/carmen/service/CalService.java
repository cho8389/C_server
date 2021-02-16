package com.carmen.service;

import java.sql.SQLException;
import java.util.List;

import com.carmen.domain.CalVO;
import com.carmen.domain.ReqVO;

public interface CalService {
	List<CalVO> selectcalall() throws SQLException;
	List<CalVO> selectcalbyid(String emp_id) throws SQLException;
	List<CalVO> selectcalbyreqid(int ordreq_id) throws SQLException;
	void insertcal(CalVO cal) throws SQLException;
	void updatecal(CalVO cal) throws SQLException;
	void deletecal(int cal_id) throws SQLException;
	List<CalVO> searchsortcal(CalVO cal) throws SQLException;
	int countsearchcal(CalVO cal) throws SQLException;
}
