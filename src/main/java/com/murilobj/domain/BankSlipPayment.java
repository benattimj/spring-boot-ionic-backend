package com.murilobj.domain;

import java.util.Date;

import com.murilobj.domain.enums.StatePayment;

public class BankSlipPayment extends Payment {
	private static final long serialVersionUID = 1L;
	
	private Date DueDate;
	private Date PaymentDate;
	
	public BankSlipPayment() {
		}

	public BankSlipPayment(Integer id, StatePayment estado, Pedido pedido, Date DueData, Date PaymentDate) {
		super(id, estado, pedido);
		this.DueDate = DueData;
		this.PaymentDate = PaymentDate;
		
		// TODO Auto-generated constructor stub
	}

	public Date getDueDate() {
		return DueDate;
	}

	public void setDueDate(Date dueDate) {
		DueDate = dueDate;
	}

	public Date getPaymentDate() {
		return PaymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		PaymentDate = paymentDate;
	}

	
}
