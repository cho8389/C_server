package com.carmen.dao;

import java.sql.SQLException;
import java.util.List;

import com.carmen.domain.OrdVO;
import com.carmen.domain.ReqVO;

public interface OrdDAO {
	List<OrdVO> selectordall() throws SQLException;
	OrdVO selectordone(int ord_id) throws SQLException;
	List<OrdVO> selectordbyid(String emp_id) throws SQLException;
	List<OrdVO> selectordbyreqid(int ordreq_id) throws SQLException;
	void insertord(OrdVO ord) throws SQLException;
	void updateord(OrdVO ord) throws SQLException;
	void updateordstate(OrdVO ord) throws SQLException;
	void deleteord(int ord_id) throws SQLException;
	List<OrdVO> searchsortord(OrdVO ord) throws SQLException;
	int countsearchord(OrdVO ord) throws SQLException;
	
	List<OrdVO> ordlist(OrdVO ord) throws SQLException;
	void deletebyreqid(int ordreq_id) throws SQLException;
}
