package controller;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import ejb_accountcrud.IAccountCrud;
import model.Account;


@SuppressWarnings("deprecation")
@Stateless
@ManagedBean(name="loginbean",eager=true)
@SessionScoped
public class LoginBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6146784484686975074L;

	@EJB
	IAccountCrud accountServ;
	
	private Account account = new Account();
	
	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}

	public LoginBean() {
	}
	
	
	
//	public String logIn() {
//		FacesContext context = FacesContext.getCurrentInstance();
//		Account Atemp = accountServ.getAccount(account.getUsername(),account.getPassword());
//		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
//		session.setAttribute("account", account);
//		if (account==null) {
//			account=new Account();
//			FacesContext.getCurrentInstance().addMessage(null,
//					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Account non trovato!","Errore Login"));
//			return "/registrazione";
//		}else {
//			return "/account-acquisti";
//		}
//
//	}


}
