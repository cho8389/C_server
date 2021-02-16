package com.carmen.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.carmen.dao.MemberDAO;
import com.carmen.domain.MemberVO;
import com.carmen.domain.RoleVO;
import com.carmen.service.MemberService;

public class MemberServiceImpl implements MemberService {
	
	private MemberDAO memDAO;
	
	public void setMemberDAO(MemberDAO memDAO) {
		this.memDAO=memDAO;
	}
	
	@Override
	public List<MemberVO> selectmemall() throws SQLException {
		return memDAO.selectmemall();
	}

	@Override
	public MemberVO selectmem(String emp_id) throws SQLException {
		return memDAO.selectmem(emp_id);
	}

	@Override
	public void insertmem(MemberVO mem) throws SQLException {
		memDAO.insertmem(mem);
	}

	@Override
	public void updatemem(MemberVO mem) throws SQLException {
		memDAO.updatemem(mem);
	}

	@Override
	public void deletemem(String emp_id) throws SQLException {
		memDAO.deletemem(emp_id);
	}

	@Override
	public List<RoleVO> selectrole(String emp_id) throws SQLException {
		return memDAO.selectrole(emp_id);
	}

	@Override
	public void insertrole(RoleVO role) throws SQLException {
		memDAO.insertrole(role);
	}

	@Override
	public void deleterole(String emp_id) throws SQLException {
		memDAO.deleterole(emp_id);
	}

}
