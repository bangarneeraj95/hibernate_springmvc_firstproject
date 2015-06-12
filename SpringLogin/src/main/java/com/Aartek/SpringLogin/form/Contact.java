package com.Aartek.SpringLogin.form;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="teams")
public class Contact {
	  @Id
	    @Column(name="ID")
	    @GeneratedValue
	    private Integer id;
	    
	    @Column(name="firstname")
	    private String firstname;

	    @Column(name="lastname")
	    private String lastname;

	    @Column(name="email")
	    private String email;
	    
	    @Column(name="telephone")
	    private String telephone;
		public String getFirstname() {
			return firstname;
		}
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}
		public String getLastname() {
			return lastname;
		}
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}  
}
