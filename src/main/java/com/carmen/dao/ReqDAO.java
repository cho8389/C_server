package com.carmen.dao;

import java.sql.SQLException;
import java.util.List;

import com.carmen.domain.ReqVO;

public interface ReqDAO {
	List<ReqVO> selectreqall() throws SQLException;
	List<ReqVO> selectreqbyid(String emp_id) throws SQLException;
	ReqVO selectreqbyreqid(int ordreq_id) throws SQLException;
	void insertreq(ReqVO req) throws SQLException;
	void updatereq(ReqVO req) throws SQLException;
	void updatereqstate(ReqVO req) throws SQLException;
	void updatereqtype(ReqVO req) throws SQLException;
	void deletereq(int ordreq_id) throws SQLException;
	List<ReqVO> searchsortreq(ReqVO req) throws SQLException;
	int countsearchreq(ReqVO req) throws SQLException;
	
	List<ReqVO> reqlist(ReqVO req) throws SQLException;
}
