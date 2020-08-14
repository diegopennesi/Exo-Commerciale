package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb_accountcrud.IAccountCrud;
import ejb_utenteCrud.Iutenti;
import ejb_utenteCrud.UtentiEJB;
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
	
	public String registrazione(Account ac,Utente ut) {
		
		if(ut != null&&ac!=null) {
			String percorso="http://localhost:8080/progettoestateserver/rest/cliente/inserisciutente";
			URL url;
			try {
				url = new URL(percorso);
			
			HttpURLConnection conn;
				conn = (HttpURLConnection) url.openConnection();
			
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Accept", "application/json");
			if(conn.getResponseCode()!=200) {
				throw new RuntimeException("Failed: Codice di errore HTTP:"+
						+conn.getResponseCode());
			}
			BufferedReader br= new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String output;
			while ((output=br.readLine())!=null) {
				System.out.println(output);
			}
			conn.disconnect();
			return "login";
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return "error"; //login.xhtml
		}	else {
		
		return "error"; //error.xhtml
			}
		
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
