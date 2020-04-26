package com.ejb.entity.session;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.ejb.entity.Account;

@Stateless(name = "BK")
public class BanqueEJBImp  implements IBanqueLocal,IBanqueRemote{
	@PersistenceContext(unitName = "UP_BANQUE")
	private EntityManager em;

	@Override
	public Account getBy(String code) {
		// TODO Auto-generated method stub
		
		Query qr=em.createQuery(" SELECT a FROM Account a where a.code=:code",Account.class);
		Account c1= (Account) qr.setParameter("code", code).getSingleResult();

		if (c1==null) throw new RuntimeException("Account not found");
		return c1;
	}

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		Query qr=em.createQuery(" SELECT a FROM Account a where a.active=true");
		return qr.getResultList();
	}

	@Override
	public void add(Account a) {
		// TODO Auto-generated method stub
		em.persist(a);
		
	}

	@Override
	public void update(Account a) {
		// TODO Auto-generated method stub
		em.merge(a);
		
	}

	@Override
	public void delete(String code) {
		// TODO Auto-generated method stub
		em.remove(code);
		
	}

	@Override
	public void debit(String code, double amount) {
		// TODO Auto-generated method stub
		Account ac=this.getBy(code);
		ac.setSolde(ac.getSolde()-amount);
		em.merge(ac);
		
	}

	@Override
	public void credit(String code, double amount) {
		// TODO Auto-generated method stub
		Account ac=this.getBy(code);
		ac.setSolde(ac.getSolde()+amount);
		em.merge(ac);
	}

	@Override
	public void transfert(String sourceid, double amount, String destid) {
		// TODO Auto-generated method stub
		 debit(sourceid, amount);
		 credit(destid, amount) ;
	}

}
