package com.carmen.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.carmen.dao.DelDAO;
import com.carmen.domain.DelVO;
import com.carmen.domain.ReqVO;
import com.carmen.utils.Convert;

public class DelDAOImpl implements DelDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	private static final String NAMESPACE="DelMapper";

	@Override
	public List<DelVO> selectdelall() throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectdelall");
	}

	@Override
	public DelVO selectdelone(int del_id) throws SQLException {
		return sqlSession.selectOne(NAMESPACE+".selectdelone",del_id);
	}
	
	@Override
	public List<DelVO> selectdelbyid(String emp_id) throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectdelbyid",emp_id);
	}

	@Override
	public List<DelVO> selectdelbyreqid(int ordreq_id) throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectdelbyreqid",ordreq_id);
	}

	@Override
	public void insertdel(DelVO del) throws SQLException {
		sqlSession.update(NAMESPACE+".insertdel",del);
	}

	@Override
	public void updatedel(DelVO del) throws SQLException {
		sqlSession.update(NAMESPACE+".updatedel",del);
	}
	
	@Override
	public void updatedelstate(DelVO del) throws SQLException {
		sqlSession.update(NAMESPACE+".updatedelstate",del);
	}

	@Override
	public void deletedel(int del_id) throws SQLException {
		sqlSession.update(NAMESPACE+".deletedel",del_id);
	}

	@Override
	public List<DelVO> searchsortdel(DelVO del) throws SQLException {
		int offset = del.getPageStart();
		int limit = del.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(del);
		if(del.getDel_date()!=null) {
			java.sql.Date del_date_s=new java.sql.Date(del.getDel_date().getTime());
			paramMap.replace("del_date",del_date_s);
		}
		if(del.getDel_date_e()!=null) {
			java.sql.Date del_date_e_s=new java.sql.Date(del.getDel_date_e().getTime());
			paramMap.replace("del_date_e",del_date_e_s);
		}
		return sqlSession.selectList(NAMESPACE+".searchsortdel",paramMap,rowBounds);
	}

	@Override
	public int countsearchdel(DelVO del) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(del);
		if(del.getDel_date()!=null) {
			java.sql.Date del_date_s=new java.sql.Date(del.getDel_date().getTime());
			paramMap.replace("del_date",del_date_s);
		}
		if(del.getDel_date_e()!=null) {
			java.sql.Date del_date_e_s=new java.sql.Date(del.getDel_date_e().getTime());
			paramMap.replace("del_date_e",del_date_e_s);
		}
		return sqlSession.selectOne(NAMESPACE+".countsearchdel",paramMap);
	}

	@Override
	public List<DelVO> dellist(DelVO del) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(del);
		if(del.getDel_date()!=null) {
			java.sql.Date del_date_s=new java.sql.Date(del.getDel_date().getTime());
			paramMap.replace("del_date",del_date_s);
		}
		if(del.getDel_date_e()!=null) {
			java.sql.Date del_date_e_s=new java.sql.Date(del.getDel_date_e().getTime());
			paramMap.replace("del_date_e",del_date_e_s);
		}
		return sqlSession.selectList(NAMESPACE+".searchsortdel",paramMap);
	}

	@Override
	public void deletebyreqid(int ordreq_id) throws SQLException {
		sqlSession.update(NAMESPACE+".deletebyreqid",ordreq_id);
	}
}
