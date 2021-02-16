package com.carmen.dao.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.carmen.dao.PayDAO;
import com.carmen.domain.PayVO;
import com.carmen.utils.Convert;

public class PayDAOImpl implements PayDAO {
	
	private SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession=sqlSession;
	}
	
	private static final String NAMESPACE="PayMapper";

	@Override
	public List<PayVO> selectpayall() throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectpayall");
	}
	
	@Override
	public PayVO selectpayone(int pay_id) throws SQLException {
		return sqlSession.selectOne(NAMESPACE+".selectpayone",pay_id);
	}
	
	@Override
	public List<PayVO> selectpaybyid(String emp_id) throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectpaybyid",emp_id);
	}

	@Override
	public List<PayVO> selectpaybyreqid(int ordreq_id) throws SQLException {
		return sqlSession.selectList(NAMESPACE+".selectpaybyreqid",ordreq_id);
	}

	@Override
	public void insertpay(PayVO pay) throws SQLException {
		sqlSession.update(NAMESPACE+".insertpay",pay);
	}

	@Override
	public void updatepay(PayVO pay) throws SQLException {
		sqlSession.update(NAMESPACE+".updatepay",pay);
	}
	
	@Override
	public void updatepaystate(PayVO pay) throws SQLException {
		sqlSession.update(NAMESPACE+".updatepaystate",pay);
	}
	
	@Override
	public void deletepay(int pay_id) throws SQLException {
		sqlSession.update(NAMESPACE+".deletepay",pay_id);
	}

	@Override
	public List<PayVO> searchsortpay(PayVO pay) throws SQLException {
		int offset = pay.getPageStart();
		int limit = pay.getPerPageNum();
		RowBounds rowBounds = new RowBounds(offset, limit);

		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(pay);
		if(pay.getPay_date()!=null) {
			java.sql.Date pay_date_s=new java.sql.Date(pay.getPay_date().getTime());
			paramMap.replace("pay_date",pay_date_s);
		}
		if(pay.getPay_date_e()!=null) {
			java.sql.Date pay_date_e_s=new java.sql.Date(pay.getPay_date_e().getTime());
			paramMap.replace("pay_date_e",pay_date_e_s);
		}
		return sqlSession.selectList(NAMESPACE+".searchsortpay",paramMap,rowBounds);
	}

	@Override
	public int countsearchpay(PayVO pay) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(pay);
		if(pay.getPay_date()!=null) {
			java.sql.Date pay_date_s=new java.sql.Date(pay.getPay_date().getTime());
			paramMap.replace("pay_date",pay_date_s);
		}
		if(pay.getPay_date_e()!=null) {
			java.sql.Date pay_date_e_s=new java.sql.Date(pay.getPay_date_e().getTime());
			paramMap.replace("pay_date_e",pay_date_e_s);
		}
		return sqlSession.selectOne(NAMESPACE+".countsearchpay",paramMap);
	}

	@Override
	public List<PayVO> paylist(PayVO pay) throws SQLException {
		Map<String,Object> paramMap=new HashMap<String,Object>();
		paramMap=Convert.otm(pay);
		if(pay.getPay_date()!=null) {
			java.sql.Date pay_date_s=new java.sql.Date(pay.getPay_date().getTime());
			paramMap.replace("pay_date",pay_date_s);
		}
		if(pay.getPay_date_e()!=null) {
			java.sql.Date pay_date_e_s=new java.sql.Date(pay.getPay_date_e().getTime());
			paramMap.replace("pay_date_e",pay_date_e_s);
		}
		return sqlSession.selectList(NAMESPACE+".searchsortpay",paramMap);
	}

	@Override
	public void deletebyreqid(int ordreq_id) throws SQLException {
		sqlSession.update(NAMESPACE+".deletebyreqid",ordreq_id);
	}

}
