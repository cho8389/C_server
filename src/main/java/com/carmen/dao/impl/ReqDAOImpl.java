package com.carmen.dao.impl;

import java.sql.Date;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.carmen.dao.ReqDAO;
import com.carmen.domain.ReqVO;
import com.carmen.utils.Convert;

public class ReqDAOImpl implements ReqDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	private static final String NAMESPACE="ReqMapper";
	
	@Override
	public List<ReqVO> selectreqall() throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectreqall");
	}

	@Override
	public List<ReqVO> selectreqbyid(String emp_id) throws SQLException {
		
		return sqlSession.selectList(NAMESPACE+".selectreqbyid",emp_id);
	}
	
	@Override
	public ReqVO selectreqbyreqid(int ordreq_id) throws SQLException {
		return sqlSession.selectOne(NAMESPACE+".selectreqbyreqid",ordreq_id);
	}
	
	@Override
	public void insertreq(ReqVO req) throws SQLException {
		sqlSession.update(NAMESPACE+".insertreq",req);
	}

	@Override
	public void updatereq(ReqVO req) throws SQLException {
		sqlSession.update(NAMESPACE+".updatereq",req);
	}
	
	@Override
	public void updatereqstate(ReqVO req) throws SQLException {
		sqlSession.update(NAMESPACE+".updatereqstate",req);
	}
	
	@Override
	public void updatereqtype(ReqVO req) throws SQLException {
		sqlSession.update(NAMESPACE+".updatereqtype",req);
	}

	@Override
	public void deletereq(int ordreq_id) throws SQLException {
		sqlSession.update(NAMESPACE+".deletereq",ordreq_id);
	}

	@Override
	public List<ReqVO> searchsortreq(ReqVO req) throws SQLException {
		int offset = req.getPageStart();
		int limit = req.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(req);
		if(req.getOrdreq_date()!=null) {
			java.sql.Date ordreq_date_s=new java.sql.Date(req.getOrdreq_date().getTime());
			paramMap.replace("ordreq_date",ordreq_date_s);
		}
		if(req.getOrdreq_date_e()!=null) {
			java.sql.Date ordreq_date_e_s=new java.sql.Date(req.getOrdreq_date_e().getTime());
			paramMap.replace("ordreq_date_e",ordreq_date_e_s);
		}
		if(req.getOrdreq_edate()!=null) {
			java.sql.Date ordreq_edate_s=new java.sql.Date(req.getOrdreq_edate().getTime());
			paramMap.replace("ordreq_edate",ordreq_edate_s);
		}
		return sqlSession.selectList(NAMESPACE+".searchsortreq",paramMap,rowBounds);
	}

	@Override
	public int countsearchreq(ReqVO req) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(req);
		if(req.getOrdreq_date()!=null) {
			java.sql.Date ordreq_date_s=new java.sql.Date(req.getOrdreq_date().getTime());
			paramMap.replace("ordreq_date",ordreq_date_s);
		}
		if(req.getOrdreq_date_e()!=null) {
			java.sql.Date ordreq_date_e_s=new java.sql.Date(req.getOrdreq_date_e().getTime());
			paramMap.replace("ordreq_date_e",ordreq_date_e_s);
		}
		if(req.getOrdreq_edate()!=null) {
			java.sql.Date ordreq_edate_s=new java.sql.Date(req.getOrdreq_edate().getTime());
			paramMap.replace("ordreq_edate",ordreq_edate_s);
		}
		return sqlSession.selectOne(NAMESPACE+".countsearchreq",paramMap);
	}

	@Override
	public List<ReqVO> reqlist(ReqVO req) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(req);
		if(req.getOrdreq_date()!=null) {
			java.sql.Date ordreq_date_s=new java.sql.Date(req.getOrdreq_date().getTime());
			paramMap.replace("ordreq_date",ordreq_date_s);
		}
		if(req.getOrdreq_date_e()!=null) {
			java.sql.Date ordreq_date_e_s=new java.sql.Date(req.getOrdreq_date_e().getTime());
			paramMap.replace("ordreq_date_e",ordreq_date_e_s);
		}
		if(req.getOrdreq_edate()!=null) {
			java.sql.Date ordreq_edate_s=new java.sql.Date(req.getOrdreq_edate().getTime());
			paramMap.replace("ordreq_edate",ordreq_edate_s);
		}
		return sqlSession.selectList(NAMESPACE+".searchsortreq",paramMap);
	}

}
