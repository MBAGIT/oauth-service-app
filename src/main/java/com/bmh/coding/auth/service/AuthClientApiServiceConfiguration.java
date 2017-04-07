/**
 * 
 */
package com.bmh.coding.auth.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

/**
* Authorization server is the one responsible for verifying credentials and if credentials are OK, 
* providing the tokens[refresh-token as well as access-token]. 
* 
* It also contains information about registered clients and possible access scopes and grant types. 
* The token store is used to store the token. We will be using an in-memory token store.
* EnableAuthorizationServer enables an Authorization Server (i.e. an AuthorizationEndpoint and a TokenEndpoint) in the current application context. 
* Class AuthorizationServerConfigurerAdapter implements AuthorizationServerConfigurer which provides all the necessary methods to configure an Authorization server.
*
* @author Mohamed Babchia
*
*/
@Configuration
@EnableAuthorizationServer
public class AuthClientApiServiceConfiguration extends AuthorizationServerConfigurerAdapter {

	private final AuthenticationManager authenticationManager;

	/**
	 * @param authenticationManager
	 */
	AuthClientApiServiceConfiguration(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer)
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(this.authenticationManager);
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter#configure(org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer)
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
//		clients.inMemory()
//        .withClient("trusted-client")
//        .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
//        .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//        .scopes("read", "write", "trust")
//        .secret("secret")
//        .accessTokenValiditySeconds(180).//Access token is only valid for 3 minutes.
//        refreshTokenValiditySeconds(600);//Refresh token is only valid for 10 minutes.
		
		
		clients.inMemory()
		.withClient("apiTest")
		.secret("passwordTest")
		.scopes("session")
		.authorizedGrantTypes("password");
	}

}
