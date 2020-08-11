package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb_accountcrud.AccountEJB;
import model.Account;

@SuppressWarnings("deprecation")
@ManagedBean(name="accountbean",eager=true)
@SessionScoped
public class AccountBean {
	
	private Account account = new Account();
	
	private AccountEJB acj = new AccountEJB();
	
	public AccountEJB getAcj() {
		return acj;
	}

	public void setAcj(AccountEJB acj) {
		this.acj = acj;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	
	
	public String getAccount(Account account) {
		
		String username =account.getUsername();
		
		String password = account.getPassword();
		
		acj.getAccount(username, password);
		
		return "pooonf";
	}
	
	
	public String getAccountById(Account account) {
		
		int id = account.getId();
		
		acj.getAccountById(id);
		
		return "keyYo";
	}
	
	public String updateAccount(Account account) {
		
		acj.updateAccount(account);
		
		return "HeyHey";
		
	}
	
	public String deleteAccount(Account account) {
		
		int id = account.getId();
		
		acj.deleteAccount(id);
		
		return "Sbaaam";
		
	}
	
	
	
	
	
	

}
