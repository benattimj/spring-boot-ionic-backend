package com.murilobj.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.murilobj.domain.BankSlipPayment;

@Service
public class BankSlipService {

	public void fillBankSlypPayment(BankSlipPayment bsp, Date instanteDoPedido) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(instanteDoPedido);
		cal.add(Calendar.DAY_OF_MONTH, 7);
		bsp.setPaymentDate(cal.getTime());
		
		
	}
		
	
}
