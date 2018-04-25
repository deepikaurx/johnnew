package com.qa.integrate;

import javax.inject.Inject;
import javax.ws.rs.Path;

import com.qa.repository.AccountRepository;

@Path("/accounts")
public class AccountEndPoint {

	@Inject
	private AccountRepository repo;
	
	public String getAllAccounts() {
		
		return repo.findall();
	}
	
}
