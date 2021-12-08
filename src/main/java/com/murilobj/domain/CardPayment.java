package com.murilobj.domain;

import javax.persistence.Entity;

import com.murilobj.domain.enums.StatePayment;

@Entity
	public class CardPayment extends Payment{
	private static final long serialVersionUID = 1L;
	
	private Integer InstallmentsNumber;

	public CardPayment() {
		}

	public CardPayment(Integer id, StatePayment estado, Pedido pedido, Integer InstallmentsNumber) {
		super(id, estado, pedido);
		this.InstallmentsNumber = InstallmentsNumber;
		
		// TODO Auto-generated constructor stub
	}

	public Integer getInstallmentsNumber() {
		return InstallmentsNumber;
	}

	public void setInstallmentsNumber(Integer installmentsNumber) {
		InstallmentsNumber = installmentsNumber;
	}
	
	

}
