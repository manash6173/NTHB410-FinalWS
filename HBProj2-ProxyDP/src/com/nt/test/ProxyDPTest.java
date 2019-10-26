package com.nt.test;

import com.nt.command.BankService;
import com.nt.factory.BankServcieFactory;

public class ProxyDPTest {

	public static void main(String[] args) {
		BankService service=null;
		try {
		service=BankServcieFactory.getInstance(true);
		System.out.println("service obj class name::"+service.getClass());
		System.out.println(service.withdraw(1001,300000));
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("=====================");
		try {
			service=BankServcieFactory.getInstance(true);
			System.out.println("service obj class name::"+service.getClass());
			System.out.println(service.withdraw(1001,100000));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		System.out.println("=====================");
		try {
			service=BankServcieFactory.getInstance(false);
			System.out.println("service obj class name::"+service.getClass());
			System.out.println(service.withdraw(1001,100000));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		System.out.println("=====================");
		try {
			service=BankServcieFactory.getInstance(false);
			System.out.println("service obj class name::"+service.getClass());
			System.out.println(service.withdraw(1001,2000000));
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		
		

	}

}
