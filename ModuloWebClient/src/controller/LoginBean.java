package controller;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
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

import com.google.gson.Gson;

import ejb_accountcrud.IAccountCrud;
import model.Account;





import java.io.BufferedInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import org.apache.commons.io.IOUtils;





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



	public void logIn() throws IOException {
		
		
		//URL url = new URL ("http://localhost:8080/ModuloWebClientNuovo/rest/clientela/InserisciAccount");
//		HttpURLConnection con = (HttpURLConnection)url.openConnection();
//		con.setRequestMethod("GET");
//		con.setRequestProperty("Content-Type", "application/json; utf-8");
//		con.setRequestProperty("Accept", "application/json");
//		con.setDoOutput(true);
//		HttpURLConnection http = (HttpURLConnection)con;
//		Gson g = new Gson();
//		Account account = new Account();
//		String out=g.toJson(account, Account.class);
	//	int length = out.length();
//		http.setFixedLengthStreamingMode(length);
//		http.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
//		http.connect();

			
		
		
		
	  

	
	
			
	

         

	}
}
