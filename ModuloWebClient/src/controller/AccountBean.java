package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Account;

@SuppressWarnings("deprecation")
@ManagedBean(name="accountbean",eager=true)
@SessionScoped
public class AccountBean {
	
	private Account account = new Account();

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	
	

}
