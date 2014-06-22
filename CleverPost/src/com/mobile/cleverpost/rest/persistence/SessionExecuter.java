package com.mobile.cleverpost.rest.persistence;

import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mobile.cleverpost.rest.persistence.dao.HibernateUtil;

public class SessionExecuter {

	private static Object monitor = new Object();

	public static synchronized void execute(IAction action) throws Exception {
		synchronized (monitor) {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.setFlushMode(FlushMode.COMMIT);
			session.setCacheMode(CacheMode.IGNORE);
			session.flush();
			session.clear();

			Transaction tr = null;
			try {
				tr = session.beginTransaction();

				action.execute(session);
			} catch (Exception e) {
				if (tr != null && tr.isActive()) {
					tr.rollback();
				}

				action.onException(e);
			} finally {
				if (tr != null && tr.isActive() && !tr.wasRolledBack()) {
					try {
						tr.commit();
					} catch (Exception e) {
						action.onException(e);
					}
				}

				if (session != null) {
					session.close();
					session = null;
				}
				action.onExecuted();
			}
		}
	}

}
