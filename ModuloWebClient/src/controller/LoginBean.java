package controller;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import ejb_accountcrud.IAccountCrud;
import model.Account;

@SuppressWarnings("deprecation")
@ManagedBean
@SessionScoped
public class LoginBean {
	
	@EJB
	private IAccountCrud accountServ;
	
	private Account account =new Account();
	
	public String logIn() {
		 FacesContext context = FacesContext.getCurrentInstance();
		account = accountServ.getAccount(account.getUsername(), account.getPassword());
		HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
		session.setAttribute("account", account);
		if (account==null) {
			account=new Account();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Account non trovato!","Errore Login"));
			return "/registrazione";
		}else {
			return "/account-acquisti";
		}
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
