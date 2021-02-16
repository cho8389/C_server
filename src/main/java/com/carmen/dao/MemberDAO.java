package com.carmen.dao;

import java.sql.SQLException;
import java.util.List;

import com.carmen.domain.MemberVO;
import com.carmen.domain.RoleVO;

public interface MemberDAO {
	List<MemberVO> selectmemall() throws SQLException;
	MemberVO selectmem(String emp_id) throws SQLException;
	void insertmem(MemberVO mem) throws SQLException;
	void updatemem(MemberVO mem) throws SQLException;
	void deletemem(String emp_id) throws SQLException;
	
	List<RoleVO> selectrole(String emp_id) throws SQLException;
	void insertrole(RoleVO role) throws SQLException;
	void deleterole(String emp_id) throws SQLException;
	
	List<MemberVO> searchmem(MemberVO mem) throws SQLException;
}
