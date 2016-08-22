package orm.dao;

import java.util.List;

import orm.beans.Person;

public interface Base {
	public void addPerson(Person person);
	public List getPerson();
}
