package orm.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import orm.beans.Person;
import orm.beans.PersonBean;
import orm.dao.Base;

@RestController
public class HomeController {
	
	@Autowired
	private Person person;
	
	@Autowired
	private Base dao;
	
	@RequestMapping(value="/createEnquiry", method=RequestMethod.POST, 
			consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String createEntry(@RequestBody PersonBean bean){
		String result=null;
		if(bean !=null){
			person.setEmpId(UUID.randomUUID().toString());
			person.setFname(bean.getFname());
			person.setLname(bean.getLname());
			person.setSalary(bean.getSalary());
			person.setEmpType(bean.getEmpType());
			dao.addPerson(person);
			result="Inserted";
			
		}else{
			result="Required data is missing";
		}
		
		return result;
	}
	
	@RequestMapping(value="/getList", method=RequestMethod.GET)
	public void getList(){
		
		List<Person> p = dao.getPerson();
		if(p!=null && p.size()>0){
			System.out.println(p.toString());
		}
		
	}
	
	@RequestMapping("*")
	public String fallbackHandler(){
		return "Requested resource not avaliable";
	}

}
