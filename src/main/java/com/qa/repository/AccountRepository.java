package com.qa.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.qa.domain.Account;
import com.qa.util.JSONUtil;

@Transactional
public class AccountRepository {

	

	@PersistenceContext(unitName = "primary")
	private EntityManager em;
	
	@Inject
	private JSONUtil util;
	

	public Account find(Long id) {
		return em.find(Account.class, id);
	}
	
	@Transactional(Transactional.TxType.REQUIRED)
	public Account create(Account account) {
		em.persist(account);
		return account;
	}
	
	
	@Transactional(Transactional.TxType.REQUIRED)
    public Account update(Account account ) {
    	em.merge(account);
    	return account;
    }
    
	@Transactional(Transactional.TxType.REQUIRED)
    public void delete(Long id) {
    	em.remove(em.getReference(Account.class, id));
    }
    

	public String findall(){
		
		Query query = em.createQuery( "SELECT a FROM Account a order by a.firstname");
		return util.getJSONForObject(query);
	}
	
	
	public void setEm(EntityManager em) {
		this.em = em;
	}
	
 
}
	

	
	
	
	

