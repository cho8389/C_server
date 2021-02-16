package com.carmen.service;

import java.sql.SQLException;
import java.util.List;

import com.carmen.domain.OrdVO;
import com.carmen.domain.ReqVO;

public interface OrdService {
	List<OrdVO> selectordall() throws SQLException;
	List<OrdVO> selectordbyid(String emp_id) throws SQLException;
	List<OrdVO> selectordbyreqid(int ordreq_id) throws SQLException;
	void insertord(OrdVO ord) throws SQLException;
	void updateord(OrdVO ord) throws SQLException;
	void deleteord(int ord_id) throws SQLException;
	List<OrdVO> searchsortord(OrdVO ord) throws SQLException;
	int countsearchord(OrdVO ord) throws SQLException;
	
	
}
