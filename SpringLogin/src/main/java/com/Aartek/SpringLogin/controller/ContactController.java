package com.Aartek.SpringLogin.controller;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;  
import org.springframework.web.bind.annotation.ModelAttribute;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestMethod;  
import org.springframework.web.bind.annotation.SessionAttributes;  
import org.springframework.web.servlet.ModelAndView;  

 
import com.Aartek.SpringLogin.dao.EmployeeDao;
import com.Aartek.SpringLogin.form.*;  
 
@Controller  
@SessionAttributes  
public class ContactController {  
  /*  @RequestMapping(value = "/addContact", method = RequestMethod.POST)  
    public String addContact(@ModelAttribute("contact") Contact contact, BindingResult result) {  
        //write the code here to add contact  
        return "redirect:contact.html";  
    }  */
      
    @RequestMapping("/contact")  
    public ModelAndView showContacts() {  
        return new ModelAndView("contact", "command", new Contact());  
    }  
    @RequestMapping("/hello")  
    public ModelAndView helloWorld() {  
        String message = "Hello World, Spring MVC @ Javatpoint";  
        return new ModelAndView("hello", "message", message);  
    }  
    
   
    
    @RequestMapping(value = "/addContact", method = RequestMethod.POST)
    public ModelAndView addContact(@ModelAttribute("contact")
                            Contact contact, BindingResult result, ModelMap model) {
         
        System.out.println("First Name:" + contact.getFirstname() + 
                    "Last Name:" + contact.getLastname());
        model.addAttribute("firstname", contact.getFirstname());  
        model.addAttribute("lastname", contact.getLastname());  
        model.addAttribute("email",contact.getEmail());  
        model.addAttribute("telephone", contact.getTelephone());  
        
    	Resource r = new ClassPathResource("spring-servlet.xml");
		BeanFactory factory = new XmlBeanFactory(r);
    	EmployeeDao dao = (EmployeeDao) factory.getBean("d");

    	Contact c = new Contact();
    	 c.setId(1);
  c.setFirstname(contact.getFirstname());
  c.setLastname(contact.getLastname());
  c.setEmail(contact.getEmail());
  c.setTelephone(contact.getTelephone());
	dao.saveEmployee(c);

	
        
        return new ModelAndView("contacts", "command", new Contact());  
    }
     
    
}
