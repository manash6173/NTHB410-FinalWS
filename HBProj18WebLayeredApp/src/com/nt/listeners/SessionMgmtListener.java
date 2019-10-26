package com.nt.listeners;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

import com.nt.utility.HibernateUtil;

public class SessionMgmtListener implements ServletRequestListener {

	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		System.out.println("SessionMgmtListener.requestDestroyed(-)");
		HibernateUtil.closeSession();
	}
}
