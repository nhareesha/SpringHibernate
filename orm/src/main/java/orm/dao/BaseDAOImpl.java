package orm.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	/**
	 *This method retrives the records that has salary less than 50K
	 */
	public List<String> getPerson() {
		
		session = sessionFactory.openSession();
		tx=session.beginTransaction();
		Criteria cr = session.createCriteria(Person.class);
		cr.add(Restrictions.le("salary", (double)50000));
		List list = cr.list();
		Iterator<Person> it = list.iterator();
		List<String> res = new ArrayList<String>();
		for(;it.hasNext();){
			Person p = (Person)it.next();
			System.out.println(p.getFname()+","+p.getLname());
		}
		
		return res;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
