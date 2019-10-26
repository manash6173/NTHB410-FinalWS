package com.nt.factory;

import com.nt.command.BankService;
import com.nt.command.BankServiceImpl;
import com.nt.proxy.BankServiceProxy;

public class BankServcieFactory {
	
	public static  BankService  getInstance(boolean RBIMonitoring) {
		BankService service=null;
		if(RBIMonitoring)
			service=new BankServiceProxy();
		else
			service=new BankServiceImpl();
		return service;
			
		
	}

}
