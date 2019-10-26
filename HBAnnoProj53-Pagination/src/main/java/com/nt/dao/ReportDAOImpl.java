package com.nt.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class ReportDAOImpl implements ReportDAO {

	@Override
	public List<Employee> getReportData(int statPos, int pageSize) {
		List<Employee> list = null;
		Session ses = null;
		CriteriaQuery<Employee> ctQuery = null;
		CriteriaBuilder builder = null;
		Query query=null;
		Root root = null;
		Transaction tx=null;
		// get Session
		ses = HibernateUtil.getSession();
		//begin Tx
		tx=ses.beginTransaction();
		// create CriteriaBuilder obj
		builder = ses.getCriteriaBuilder();
		// Create CriteriaQuery obj
		ctQuery = builder.createQuery(Employee.class);
		// Create Root obj
		root = ctQuery.from(Employee.class);
		//add Root obj CriteriaQuery obj
		ctQuery.select(root);
		//create Query obj
		query=ses.createQuery(ctQuery);
		//set Pagination params
		query.setFirstResult(statPos);
		query.setMaxResults(pageSize);
		//execute the Query
		list=query.getResultList();
		//conmit
		tx.commit();

		return list;
	}

	@Override
	public long getRecordsCount() {
		Session ses = null;
		CriteriaQuery<Object> ctQuery = null;
		CriteriaBuilder builder = null;
		Root root = null;
		Query query = null;
		List<Object> list = null;
		long count = 0;
		Transaction tx=null;
		
		// get Session
		ses = HibernateUtil.getSession();
		//begin Tx
		tx=ses.beginTransaction();
		// create CriteriaBuilder obj
		builder = ses.getCriteriaBuilder();
		// Create CriteriaQuery obj
		ctQuery = builder.createQuery(Object.class);
		// Create Root obj
		root = ctQuery.from(Employee.class);
		// add aggrate opeartion
		ctQuery.multiselect(builder.count(root.get("eno")));
		// get Query obj
		query = ses.createQuery(ctQuery);
		// execute Query
		list = query.getResultList();
		// process the Reuslt
		count = (Long) list.get(0);
		//commit Tx
		tx.commit();
		return count;
	}

}
