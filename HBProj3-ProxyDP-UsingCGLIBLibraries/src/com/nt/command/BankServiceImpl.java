package com.nt.command;

public class BankServiceImpl implements BankService {

	@Override
	public String withdraw(int acno, float amt) {
		System.out.println("BankServiceImpl.withdraw() (real obj)");
		return "withdrawing "+amt+" from the account number::"+acno;
	}

}
