package com.ejb.entity.session;

import java.util.List;

import javax.ejb.Local;

import com.ejb.entity.Account;
@Local
public interface IBanqueLocal {
	
	public Account getBy(String id);
	public List<Account> findAll();
	public void add(Account a);
	public void update(Account a);
	public void delete(String code);
	public void debit(String code,double amount);
	public void credit(String code,double amount);
	public void transfert(String sourceid,double amount,String destid);

}
