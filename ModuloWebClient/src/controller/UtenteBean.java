package controller;

import java.io.BufferedInputStream;

import java.io.IOException;
import java.io.InputStream;

import java.io.OutputStream;
import java.net.HttpURLConnection;

import java.net.URL;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import ejb_accountcrud.IAccountCrud;
import ejb_utenteCrud.Iutenti;

import model.Account;
import model.Utente;

@SuppressWarnings("deprecation")
@ManagedBean(name="utentebean",eager=true)
@SessionScoped
public class UtenteBean {
	
    private Utente ut = new Utente();
    
    private Account ac = new Account();
    
    
    @EJB
    private IAccountCrud accCr;
    
    @EJB
    private Iutenti userCr;
    

	

	public Utente getUt() {
		return ut;
	}

	public void setUt(Utente ut) {
		this.ut = ut;
	}
	
	public String registrazione(Account ac) throws IOException {
		
		    String query_url = "http://localhost:8080/ModuloWebClientNuovo/rest/clientela/InserisciAccount";
		    Gson g = new Gson();
		    String out=g.toJson(ac, Account.class); 
		    URL url = new URL(query_url);
		    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		    conn.setConnectTimeout(5000);
		    conn.setRequestProperty("Content-Type", "application/json");
		    conn.setDoOutput(true);
		    conn.setDoInput(true);
		    conn.setRequestMethod("PUT");
		    OutputStream os = conn.getOutputStream();
		    os.write(out.getBytes("UTF-8"));
		    os.close();
		    // read the response
		    InputStream in = new BufferedInputStream(conn.getInputStream());
		    String result = IOUtils.toString(in, "UTF-8");//da mettere in un oggetto! serve creare un parsing in model account 
		    System.out.println(result);
		    System.out.println("result after Reading JSON Response");
		    Gson responseGson = new Gson();
		    Account rispostaaccount=responseGson.fromJson(result, Account.class);
		    in.close();
		    conn.disconnect();
		    return "login";
	}
				
		
	
		
	
	
	public String deleteUtente(Utente ut) {
		
		userCr.cancellautente(ut);
		
		return "cancella";//utente-modifica
		
		
		
	}
	
	public String modificaUt(Utente ut) {
		
		
		userCr.modificautente(ut);
		
		return "login"; //login.xhtml
		
	}
	
	
	public String findUtenteForName(Utente ut) {
		
		userCr.cercautenteperNome(ut);
		
		return "boooooh"; //non ne ho idea!
		
	}
	
	public String findUtenteForId(Utente ut) {
		
		userCr.cercautenteperid(ut);
		
		return "i have not idea"; //!!!!!!
	}

	public Account getAc() {
		return ac;
	}

	public void setAc(Account ac) {
		this.ac = ac;
	}
      
      
      
      
	
	  

}
