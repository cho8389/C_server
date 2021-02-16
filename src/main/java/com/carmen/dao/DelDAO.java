package com.carmen.dao;

import java.sql.SQLException;
import java.util.List;

import com.carmen.domain.DelVO;
import com.carmen.domain.ReqVO;

public interface DelDAO {
	List<DelVO> selectdelall() throws SQLException;
	DelVO selectdelone(int del_id) throws SQLException;
	List<DelVO> selectdelbyid(String emp_id) throws SQLException;
	List<DelVO> selectdelbyreqid(int ordreq_id) throws SQLException;
	void insertdel(DelVO del) throws SQLException;
	void updatedel(DelVO del) throws SQLException;
	void updatedelstate(DelVO del) throws SQLException;
	void deletedel(int del_id) throws SQLException;
	List<DelVO> searchsortdel(DelVO del) throws SQLException;
	int countsearchdel(DelVO del) throws SQLException;
	
	List<DelVO> dellist(DelVO del) throws SQLException;
	void deletebyreqid(int ordreq_id) throws SQLException;
}
