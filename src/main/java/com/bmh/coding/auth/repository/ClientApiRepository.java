/**
 * 
 */
package com.bmh.coding.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmh.coding.auth.model.ClientApi;

/**
 * @author Mohamed Babchia
 *
 */
public interface ClientApiRepository extends JpaRepository<ClientApi, Long> {
	
	Optional<ClientApi>  findByUserName(String userName);

}
