package com.carmen.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.carmen.dao.PayDAO;
import com.carmen.domain.PayVO;
import com.carmen.domain.ReqVO;
import com.carmen.service.PayService;

public class PayServiceImpl implements PayService {
	
	private PayDAO payDAO;
	
	public void setPayDAO(PayDAO payDAO) {
		this.payDAO=payDAO;
	}

	@Override
	public List<PayVO> selectpayall() throws SQLException {
		return payDAO.selectpayall();
	}

	@Override
	public List<PayVO> selectpaybyid(String emp_id) throws SQLException {
		return payDAO.selectpaybyid(emp_id);
	}

	@Override
	public List<PayVO> selectpaybyreqid(int ordreq_id) throws SQLException {
		return payDAO.selectpaybyreqid(ordreq_id);
	}

	@Override
	public void insertpay(PayVO pay) throws SQLException {
		payDAO.insertpay(pay);
	}

	@Override
	public void updatepay(PayVO pay) throws SQLException {
		payDAO.updatepay(pay);
	}

	@Override
	public void deletepay(int pay_id) throws SQLException {
		payDAO.deletepay(pay_id);
	}

	@Override
	public List<PayVO> searchsortpay(PayVO pay) throws SQLException {
		return payDAO.searchsortpay(pay);
	}

	@Override
	public int countsearchpay(PayVO pay) throws SQLException {
		return payDAO.countsearchpay(pay);
	}

}
