package com.ejb.entity.service;

import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.ejb.entity.Account;
import com.ejb.entity.session.IBanqueLocal;
@Stateless
@WebService
public class BanqueSoap {
	
	@EJB(beanName = "BK")
	private IBanqueLocal metier;
	@WebMethod
	public void add(@WebParam(name="code") String code,@WebParam(name="solde") double solde) {
		Account a =new Account(code, solde, new Date(), true);
		metier.add(a);
	}
	
	public void get(@WebParam(name="code") String code) {		
		metier.getBy(code);
	}
	public List<Account> findAll() {		
		return metier.findAll();
	}
	
	public void credit(@WebParam(name="code") String code,@WebParam(name="amount") double amount) {
		metier.credit(code, amount);
	}

	public void debit(@WebParam(name="code") String code,@WebParam(name="amount") double amount) {
		metier.debit(code, amount);
	}
	public void transfert(@WebParam(name="code1") String code1,@WebParam(name="code2") String code2,@WebParam(name="amount") double amount) {
		metier.transfert(code1, amount, code2);
	}


}
