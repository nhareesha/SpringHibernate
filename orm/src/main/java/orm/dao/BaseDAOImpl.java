package orm.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import orm.beans.Person;

public class BaseDAOImpl implements Base {
	
	
	private SessionFactory sessionFactory;
	private Session session;
	
	public void addPerson(Person person) {
		try{	
			Session session = sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(person); //persists the person object to database
			tx.commit();
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			session.close();
			sessionFactory.close();
		}
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
