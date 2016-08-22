package orm.beans;

import com.google.gson.Gson;

public class Test {

	public static void main(String[] args) {
		
		Gson g = new Gson();
		PersonBean bean = new PersonBean();
		bean.setEmpType("New");
		bean.setFname("Hareesha");
		bean.setLname("Dandamudi");
		bean.setSalary(70000);
		System.out.println(g.toJson(bean));

	}

}
