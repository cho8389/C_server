package com.carmen.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.carmen.dao.OrdDAO;
import com.carmen.domain.OrdVO;
import com.carmen.domain.ReqVO;
import com.carmen.utils.Convert;

public class OrdDAOImpl implements OrdDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	private static final String NAMESPACE="OrdMapper";

	@Override
	public List<OrdVO> selectordall() throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectordall");
	}
	
	@Override
	public OrdVO selectordone(int ord_id) throws SQLException {
		return sqlSession.selectOne(NAMESPACE+".selectordone",ord_id);
	}
	
	@Override
	public List<OrdVO> selectordbyid(String emp_id) throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectordbyid",emp_id);
	}

	@Override
	public List<OrdVO> selectordbyreqid(int ordreq_id) throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectordbyreqid",ordreq_id);
	}

	@Override
	public void insertord(OrdVO ord) throws SQLException {
		sqlSession.update(NAMESPACE+".insertord",ord);
	}

	@Override
	public void updateord(OrdVO ord) throws SQLException {
		sqlSession.update(NAMESPACE+".updateord",ord);
	}
	
	@Override
	public void updateordstate(OrdVO ord) throws SQLException {
		sqlSession.update(NAMESPACE+".updateordstate",ord);
	}

	@Override
	public void deleteord(int ord_id) throws SQLException {
		sqlSession.update(NAMESPACE+".deleteord",ord_id);
	}

	@Override
	public List<OrdVO> searchsortord(OrdVO ord) throws SQLException {
		int offset = ord.getPageStart();
		int limit = ord.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(ord);
		if(ord.getOrd_date()!=null) {
			java.sql.Date ord_date_s=new java.sql.Date(ord.getOrd_date().getTime());
			paramMap.replace("ord_date",ord_date_s);
		}
		if(ord.getOrd_date_e()!=null) {
			java.sql.Date ord_date_e_s=new java.sql.Date(ord.getOrd_date_e().getTime());
			paramMap.replace("ord_date_e",ord_date_e_s);
		}
		if(ord.getOrd_indate()!=null) {
			java.sql.Date ord_indate_s=new java.sql.Date(ord.getOrd_indate().getTime());
			paramMap.replace("ord_indate",ord_indate_s);
		}
		return sqlSession.selectList(NAMESPACE+".searchsortord",paramMap,rowBounds);
	}

	@Override
	public int countsearchord(OrdVO ord) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(ord);
		if(ord.getOrd_date()!=null) {
			java.sql.Date ord_date_s=new java.sql.Date(ord.getOrd_date().getTime());
			paramMap.replace("ord_date",ord_date_s);
		}
		if(ord.getOrd_date_e()!=null) {
			java.sql.Date ord_date_e_s=new java.sql.Date(ord.getOrd_date_e().getTime());
			paramMap.replace("ord_date_e",ord_date_e_s);
		}
		if(ord.getOrd_indate()!=null) {
			java.sql.Date ord_indate_s=new java.sql.Date(ord.getOrd_indate().getTime());
			paramMap.replace("ord_indate",ord_indate_s);
		}
		return sqlSession.selectOne(NAMESPACE+".countsearchord",paramMap);
	}

	@Override
	public List<OrdVO> ordlist(OrdVO ord) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(ord);
		if(ord.getOrd_date()!=null) {
			java.sql.Date ord_date_s=new java.sql.Date(ord.getOrd_date().getTime());
			paramMap.replace("ord_date",ord_date_s);
		}
		if(ord.getOrd_date_e()!=null) {
			java.sql.Date ord_date_e_s=new java.sql.Date(ord.getOrd_date_e().getTime());
			paramMap.replace("ord_date_e",ord_date_e_s);
		}
		if(ord.getOrd_indate()!=null) {
			java.sql.Date ord_indate_s=new java.sql.Date(ord.getOrd_indate().getTime());
			paramMap.replace("ord_indate",ord_indate_s);
		}
		return sqlSession.selectList(NAMESPACE+".searchsortord",paramMap);
	}

	@Override
	public void deletebyreqid(int ordreq_id) throws SQLException {
		sqlSession.update(NAMESPACE+".deletebyreqid",ordreq_id);
	}

}
