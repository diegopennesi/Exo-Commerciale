package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
	private IAccountCrud accountServ;

	private Account account = new Account();

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public LoginBean() {
	}



	public String logIn() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Account temp = accountServ.getAccount(account.getUsername(),account.getPassword());
			HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
			session.setAttribute("temp", temp);
			
			String percorso="http://localhost:8080/progettoestateserver/rest/cliente/login";
			URL url = new URL(percorso);
			HttpURLConnection conn=(HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			if(conn.getResponseCode()!=200) {
				throw new RuntimeException("Failed: Codice di errore HTTP:"+
						+conn.getResponseCode());
			}
			BufferedReader br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
			conn.disconnect();

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (account==null) {
			account=new Account();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,"Account non trovato!","Errore Login"));
			return "/registrazione";
		}else {
			return "/account-acquisti";
		}

	}


}
