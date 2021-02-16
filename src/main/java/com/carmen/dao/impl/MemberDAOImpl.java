package com.carmen.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.carmen.dao.MemberDAO;
import com.carmen.domain.MemberVO;
import com.carmen.domain.RoleVO;

public class MemberDAOImpl implements MemberDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	private static final String NAMESPACE="MemberMapper";

	@Override
	public List<MemberVO> selectmemall() throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectmem");
	}

	@Override
	public MemberVO selectmem(String emp_id) throws SQLException {
		return sqlSession.selectOne(NAMESPACE+".selectmembyid",emp_id);
	}

	@Override
	public void insertmem(MemberVO mem) throws SQLException {
		sqlSession.update(NAMESPACE+".insertmem",mem);
	}

	@Override
	public void updatemem(MemberVO mem) throws SQLException {
		sqlSession.update(NAMESPACE+".updatemem",mem);
	}

	@Override
	public void deletemem(String emp_id) throws SQLException {
		sqlSession.update(NAMESPACE+".deletemem",emp_id);
	}

	@Override
	public List<RoleVO> selectrole(String emp_id) throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectrole",emp_id);
	}

	@Override
	public void insertrole(RoleVO role) throws SQLException {
		sqlSession.update(NAMESPACE+".insertrole",role);
	}

	@Override
	public void deleterole(String emp_id) throws SQLException {
		sqlSession.update(NAMESPACE+".deleterole",emp_id);
	}

	@Override
	public List<MemberVO> searchmem(MemberVO mem) throws SQLException {
		return sqlSession.selectList(NAMESPACE+".searchmem",mem);
	}

}
