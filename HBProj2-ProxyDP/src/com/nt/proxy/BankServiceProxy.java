package com.nt.proxy;

import com.nt.command.BankService;
import com.nt.command.BankServiceImpl;

public class BankServiceProxy implements BankService {
	private BankService service=null;
	public BankServiceProxy() {
		service=new BankServiceImpl();
	}

	@Override
	public String withdraw(int acno, float amt) {
		System.out.println("BankServiceProxy.withdraw( )(proxy)");
		String result=null;
		if(amt<=200000)
			result=service.withdraw(acno, amt);
		else
			throw new IllegalArgumentException("Amount is > 200000 and getApproval from RBI");
		
		return result;
	}

}
