package orm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import orm.beans.Person;

public class BaseDAOImpl implements Base {
	
	
	private SessionFactory sessionFactory;
	private Session session;
	Transaction tx;
	
	public void addPerson(Person person) {
		try{	
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			session.save(person); //persists the person object to database
			tx.commit();
		}catch(Exception ex){
			ex.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
