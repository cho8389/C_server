package com.carmen.service;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.carmen.domain.CalVO;

public interface WebService {
	ResponseEntity<Map<String, Object>> searchlist(String type,String json,int page) throws SQLException;
	void insert(String type,Object obj) throws SQLException;
	void update(String type,Object obj) throws SQLException;
	void delete(String type,int ordreq_id) throws SQLException;
	Object selectone(String type,int id) throws SQLException;
	Map<String,Object> mlist(int ordreq_id) throws SQLException;
	
	ResponseEntity<Map<String, Object>> clist(String type,String json) throws SQLException;
	void cupdatestate(String type, String json) throws SQLException;
	void cupdate(String type, String json) throws SQLException;
	void cinsert(String type, String json) throws SQLException;
	ResponseEntity<Map<String, Object>> cmemlist(String json) throws SQLException;
	void cmemupdate(String mem,String role) throws SQLException;
	void cmeminsert(String mem,String role) throws SQLException;
	void deletebyordreq_id(String type,int ordreq_id) throws SQLException;
}
