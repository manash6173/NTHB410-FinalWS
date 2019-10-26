package com.nt.factory;

import com.nt.command.BankService;
import com.nt.command.BankServiceImpl;
import com.nt.helper.ProxyHelper;

import net.sf.cglib.proxy.Enhancer;

public class BankServcieFactory {
	
	public static  BankService  getInstance(boolean RBIMonitoring) {
		BankService service=null;
		if(RBIMonitoring)
			service=(BankService) Enhancer.create(BankServiceImpl.class,new ProxyHelper());
		else
			service=new BankServiceImpl();
		return service;
			
		
	}

}
