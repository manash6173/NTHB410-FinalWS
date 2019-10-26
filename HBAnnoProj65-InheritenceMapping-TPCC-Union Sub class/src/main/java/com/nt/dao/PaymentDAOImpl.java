package com.nt.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.CardPayment;
import com.nt.entity.ChequePayment;
import com.nt.entity.Payment;
import com.nt.utility.HibernateUtil;

public class PaymentDAOImpl implements PaymentDAO {

	@Override
	public void saveData() {
		Session ses=null;
		CardPayment ptm1=null;
		ChequePayment ptm2=null;
		Transaction tx=null;
		boolean flag=false;
		//get Session
		ses=HibernateUtil.getSession();
		//prepare Objects
		ptm1=new CardPayment();
		ptm1.setAmount(10000);
		ptm1.setLocation("hyd");
		ptm1.setCardNo(90000001);
		ptm1.setCardType("VISA-DEBIT");
		ptm1.setCvvNo(991);
		
		ptm2=new ChequePayment();
		ptm2.setAmount(1000);
		ptm2.setLocation("hyd");
		ptm2.setChequeNo(897899);
		ptm2.setChequeType("Barer");
		ptm2.setBankName("SBI");
		try {
		  //begin Tx
			tx=ses.beginTransaction();
			//save objs
			ses.save(ptm1);
			ses.save(ptm2);
		    flag=true;	
		}//try
		catch(HibernateException he) {
			flag=false;
			he.printStackTrace();
		}
		finally {
			if(flag) {
				tx.commit();
				System.out.println("Objects are saved");
			}
			else {
				tx.rollback();
				System.out.println("Objects not saved");
			}
			//close SEssion obj
			HibernateUtil.closeSession(ses);
		}//finally

	}//method
	
	@Override
	public void loadData() {
		Session ses=null;
		Query query1=null,query2=null,query3=null;
		List<Payment> list1=null;
		List<CardPayment> list2=null;
		List<ChequePayment> list3=null;
		//get Session
		ses=HibernateUtil.getSession();
		try {
		//Load Objects
		query1=ses.createQuery("from Payment");
		list1=query1.getResultList();
		list1.forEach(payment->{
			System.out.println(payment);
		});
		System.out.println("....................");
		query2=ses.createQuery("from CardPayment");
		list2=query2.getResultList();
		list2.forEach(card->{
			System.out.println(card);
		});
		System.out.println("....................");
		query3=ses.createQuery("from ChequePayment");
		list3=query3.getResultList();
		list3.forEach(cheque->{
			System.out.println(cheque);
		});
		}//try
		catch(HibernateException he) {
			he.printStackTrace();
		}
		finally {
			HibernateUtil.closeSession(ses);
		}
	}//method
}//class
