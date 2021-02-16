package com.carmen.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.carmen.dao.CalDAO;
import com.carmen.domain.CalVO;
import com.carmen.domain.ReqVO;
import com.carmen.utils.Convert;

public class CalDAOImpl implements CalDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	private static final String NAMESPACE="CalMapper";

	@Override
	public List<CalVO> selectcalall() throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectcalall");
	}
	
	@Override
	public CalVO selectcalone(int cal_id) throws SQLException {
		return sqlSession.selectOne(NAMESPACE+".selectcalone",cal_id);
	}
	
	@Override
	public List<CalVO> selectcalbyid(String emp_id) throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectcalbyid",emp_id);
	}

	@Override
	public List<CalVO> selectcalbyreqid(int ordreq_id) throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectcalbyreqid",ordreq_id);
	}

	@Override
	public void insertcal(CalVO cal) throws SQLException {
		sqlSession.update(NAMESPACE+".insertcal",cal);
	}

	@Override
	public void updatecal(CalVO cal) throws SQLException {
		sqlSession.update(NAMESPACE+".updatecal",cal);
	}

	@Override
	public void deletecal(int cal_id) throws SQLException {
		sqlSession.update(NAMESPACE+".deletecal",cal_id);
	}

	@Override
	public List<CalVO> searchsortcal(CalVO cal) throws SQLException {
		int offset = cal.getPageStart();
		int limit = cal.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(cal);
		if(cal.getCal_date()!=null) {
			java.sql.Date cal_date_s=new java.sql.Date(cal.getCal_date().getTime());
			paramMap.replace("cal_date",cal_date_s);
		}
		if(cal.getCal_date_e()!=null) {
			java.sql.Date cal_date_e_s=new java.sql.Date(cal.getCal_date_e().getTime());
			paramMap.replace("cal_date_e",cal_date_e_s);
		}
		if(cal.getCal_chkdate()!=null) {
			java.sql.Date cal_chkdate_s=new java.sql.Date(cal.getCal_chkdate().getTime());
			paramMap.replace("cal_chkdate",cal_chkdate_s);
		}
		return sqlSession.selectList(NAMESPACE+".searchsortcal",paramMap,rowBounds);
	}

	@Override
	public int countsearchcal(CalVO cal) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(cal);
		if(cal.getCal_date()!=null) {
			java.sql.Date cal_date_s=new java.sql.Date(cal.getCal_date().getTime());
			paramMap.replace("cal_date",cal_date_s);
		}
		if(cal.getCal_date_e()!=null) {
			java.sql.Date cal_date_e_s=new java.sql.Date(cal.getCal_date_e().getTime());
			paramMap.replace("cal_date_e",cal_date_e_s);
		}
		if(cal.getCal_chkdate()!=null) {
			java.sql.Date cal_chkdate_s=new java.sql.Date(cal.getCal_chkdate().getTime());
			paramMap.replace("cal_chkdate",cal_chkdate_s);
		}
		return sqlSession.selectOne(NAMESPACE+".countsearchcal",paramMap);
	}

	@Override
	public List<CalVO> callist(CalVO cal) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(cal);
		if(cal.getCal_date()!=null) {
			java.sql.Date cal_date_s=new java.sql.Date(cal.getCal_date().getTime());
			paramMap.replace("cal_date",cal_date_s);
		}
		if(cal.getCal_date_e()!=null) {
			java.sql.Date cal_date_e_s=new java.sql.Date(cal.getCal_date_e().getTime());
			paramMap.replace("cal_date_e",cal_date_e_s);
		}
		if(cal.getCal_chkdate()!=null) {
			java.sql.Date cal_chkdate_s=new java.sql.Date(cal.getCal_chkdate().getTime());
			paramMap.replace("cal_chkdate",cal_chkdate_s);
		}
		return sqlSession.selectList(NAMESPACE+".searchsortcal",paramMap);
	}

	@Override
	public void deletebyreqid(int ordreq_id) throws SQLException {
		sqlSession.update(NAMESPACE+".deletebyreqid",ordreq_id);
	}

}
