package com.Aartek.SpringLogin.dao;
import com.Aartek.SpringLogin.form.*;
import org.springframework.orm.hibernate3.HibernateTemplate;  
import java.util.*;  
public class EmployeeDao {  
HibernateTemplate template;  
public void setTemplate(HibernateTemplate template) {  
    this.template = template;  
}  
//method to save employee  
public void saveEmployee(Contact e){  
    template.save(e);  
}  
//method to update employee  
public void updateEmployee(Contact e){  
    template.update(e);  
}  
//method to delete employee  
public void deleteEmployee(Contact e){  
    template.delete(e);  
}  
//method to return one employee of given id  
public Contact getById(int id){  
	Contact e=(Contact)template.get(Contact.class,id);  
    return e;  
}  
//method to return all employees  
public List<Contact> getEmployees(){  
    List<Contact> list=new ArrayList<Contact>();  
    list=template.loadAll(Contact.class);  
    return list;  
}  
}  