/**
 * 
 */
package com.bmh.coding.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Mohamed Babchia
 *
 */

@Entity
public class ClientApi {

	@Id
	@GeneratedValue
	private Long id;

	private String userName;

	private String password;

	private boolean active;
	
	
	
	

	

	/**
	 *  JPA Needs!!!!
	 */
	public ClientApi() {

	}

	/**
	 * @param userName
	 * @param password
	 * @param active
	 */
	public ClientApi(String userName, String password, boolean active) {
		this.userName = userName;
		this.password = password;
		this.active = active;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

}
