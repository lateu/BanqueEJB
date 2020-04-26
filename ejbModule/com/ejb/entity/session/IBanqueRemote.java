package com.ejb.entity.session;

import java.util.List;

import javax.ejb.Remote;

import com.ejb.entity.Account;

@Remote
public interface IBanqueRemote {
	
	public Account getBy(String id);
	public List<Account> findAll();
	public void add(Account a);
	public void update(Account a);
	public void delete(String code);
	public void debit(String id,double amount);
	public void credit(String id,double amount);
	public void transfert(String sourceid,double amount,String destid);

}
