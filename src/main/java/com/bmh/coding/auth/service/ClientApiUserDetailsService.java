/**
 * 
 */
package com.bmh.coding.auth.service;

import java.lang.reflect.Constructor;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bmh.coding.auth.repository.ClientApiRepository;

/**
 * 
 * Class to override the implementation of 
 * UserDetailsService spring security
 * 
 * 
 * @author Mohamed Babchia
 *
 */
@Service
public class ClientApiUserDetailsService implements UserDetailsService {

	private final ClientApiRepository clientApiRepository;

	/**
	 * {@link Constructor} with fields
	 * @param clientApiInfoRepository
	 */
	public ClientApiUserDetailsService(ClientApiRepository clientApiInfoRepository) {
		this.clientApiRepository = clientApiInfoRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		/**
		 *  search for the user (client Api)  by username
		 *  return the userDetails if exist
		 *  else throw UsernameNotFoundException
		 */
		return clientApiRepository.findByUserName(userName)
				.map(usr -> new User(usr.getUserName(), usr.getPassword(), usr.isActive(), usr.isActive(),
						usr.isActive(), usr.isActive(),
						AuthorityUtils.createAuthorityList("SUPER-USER", "ADMIN-USER", "BACKEND-USER")))
				.orElseThrow(() -> new UsernameNotFoundException("Api Client Not Found ...."));
	}

}
