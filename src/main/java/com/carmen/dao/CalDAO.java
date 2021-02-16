package com.carmen.dao;

import java.sql.SQLException;
import java.util.List;

import com.carmen.domain.CalVO;

public interface CalDAO {
	List<CalVO> selectcalall() throws SQLException;
	CalVO selectcalone(int cal_id) throws SQLException;
	List<CalVO> selectcalbyid(String emp_id) throws SQLException;
	List<CalVO> selectcalbyreqid(int ordreq_id) throws SQLException;
	void insertcal(CalVO cal) throws SQLException;
	void updatecal(CalVO cal) throws SQLException;
	void deletecal(int cal_id) throws SQLException;
	List<CalVO> searchsortcal(CalVO cal) throws SQLException;
	int countsearchcal(CalVO cal) throws SQLException;
	
	List<CalVO> callist(CalVO cal) throws SQLException;
	void deletebyreqid(int ordreq_id) throws SQLException;
}
