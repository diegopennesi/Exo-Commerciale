package controller;

import java.io.IOException;
import java.io.Serializable;
import java.net.HttpURLConnection;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.google.gson.Gson;
import model.Account;
import utility.Universal_HTTPREQUEST;

@SuppressWarnings("deprecation")
@ManagedBean(name="loginbean",eager=true)
@SessionScoped
public class LoginBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6146784484686975074L;
	public LoginBean() {
	}
	private Account account = new Account();

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	public String logIn() throws IOException {
		
		Universal_HTTPREQUEST httprequest = new Universal_HTTPREQUEST();

		String percorso= "http://localhost:8080/ModuloWebClientNuovo/rest/login/log-in";
		Gson g = new Gson();
		String out=g.toJson(account, Account.class);		
	    HttpURLConnection con = httprequest.HTTPSENDJSON(percorso, out,"POST");
	    String result=httprequest.HTTPREADJSON(con);
	    account=g.fromJson(result, Account.class);
	    System.out.println(account.toString());
		con.disconnect();
		return "account";
		}
	}
