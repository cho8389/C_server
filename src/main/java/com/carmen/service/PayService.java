package com.carmen.service;

import java.sql.SQLException;
import java.util.List;

import com.carmen.domain.PayVO;
import com.carmen.domain.ReqVO;

public interface PayService {
	List<PayVO> selectpayall() throws SQLException;
	List<PayVO> selectpaybyid(String emp_id) throws SQLException;
	List<PayVO> selectpaybyreqid(int ordreq_id) throws SQLException;
	void insertpay(PayVO pay) throws SQLException;
	void updatepay(PayVO pay) throws SQLException;
	void deletepay(int pay_id) throws SQLException;
	List<PayVO> searchsortpay(PayVO pay) throws SQLException;
	int countsearchpay(PayVO pay) throws SQLException;
	
	
}
