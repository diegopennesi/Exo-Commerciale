package controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.google.gson.Gson;

import ejb_accountcrud.IAccountCrud;
import model.Account;
import utility.Universal_HTTPREQUEST;





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



	public String logIn() throws IOException {
	
		if (account!= null) {
		String percorso= "http://localhost:8080/ModuloWebClientNuovo/rest/login/login";
		Gson g = new Gson();
		String out=g.toJson(account, Account.class);
		Universal_HTTPREQUEST httprequest = new Universal_HTTPREQUEST();
	    HttpURLConnection con = httprequest.HTTPSENDJSON(percorso, out);
//		con.setRequestMethod("GET");
//		String auth = account.getUsername()+":"+account.getPassword();
//		byte[] encodedAuth= Base64.getEncoder().encode(auth.getBytes(StandardCharsets.UTF_8));
//		String authHeaderValue = "Basic " + new String(encodedAuth);
		con.disconnect();
		return "account";
		}else {
			return "error";
		}
			
	}
}
