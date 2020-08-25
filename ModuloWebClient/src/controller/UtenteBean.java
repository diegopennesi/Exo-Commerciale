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
import ejb_utenteCrud.Iutenti;

import model.Account;
import model.Utente;
import modelDTO.UtenteDTO;
import utility.Universal_HTTPREQUEST;

@SuppressWarnings("deprecation")
@ManagedBean(name="utentebean",eager=true)
@SessionScoped
public class UtenteBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2861043598871376189L;
    private UtenteDTO utdto = new UtenteDTO();
    private Utente ut= new Utente();
    private Account ac = new Account();


	public UtenteDTO getUtdto() {
		return utdto;
	}
	public void setUtdto(UtenteDTO utdto) {
		this.utdto = utdto;
	}
	public Utente getUt() {
		return ut;
	}
	public void setUt(Utente ut) {
		this.ut = ut;
	}
	public Account getAc() {
		return ac;
	}
	public void setAc(Account ac) {
		this.ac = ac;
	}
	public String registrazione(Account ac,UtenteDTO ut) throws IOException {
		    String query_url = "http://localhost:8080/ModuloWebClientNuovo/rest/clientela/InserisciAccount";
		    Gson g = new Gson();
		    String out=g.toJson(ac, Account.class); 
		    Universal_HTTPREQUEST httprequest = new Universal_HTTPREQUEST();
		    HttpURLConnection conn = httprequest.HTTPSENDJSON(query_url, out,"PUT");
		    // leggiamo risposta di Account (serve sempre a qualcosa!)
		    String result=httprequest.HTTPREADJSON(conn);
		    Account acRisp=g.fromJson(result, Account.class);
		    conn.disconnect();
			String query_url_utente = "http://localhost:8080/ModuloWebClientNuovo/rest/clientela/InserisciUtente";
			ut.setId_account(acRisp.getId());
			String out_utenteDTO=g.toJson(ut, UtenteDTO.class); 
			HttpURLConnection conn2 = httprequest.HTTPSENDJSON(query_url_utente, out_utenteDTO,"PUT");			    
			result=httprequest.HTTPREADJSON(conn2);			   
			Utente utRisp=g.fromJson(result, Utente.class);		 //??	  
		    conn2.disconnect();
		    return "login";
	}
	public String modifica() throws IOException {
		Universal_HTTPREQUEST httprequest = new Universal_HTTPREQUEST();
		String url= "http://localhost:8080/ModuloWebClientNuovo/rest/clientela/modifica/account/"+ac.getId()+"";
		Gson g = new Gson();
		String out=g.toJson(ac, Account.class);
		HttpURLConnection conn=httprequest.HTTPSENDJSON(url, out,"PUT");
		String result = httprequest.HTTPREADJSON(conn);		
		conn.disconnect();
		
		String url2="http://localhost:8080/ModuloWebClientNuovo/rest/clientela/modifica/utente";
		UtenteDTO dto= new UtenteDTO();//magari usiamo udtDTO del bean!?
		dto.setId(ut.getId());
		dto.setNome(ut.getNome());
		dto.setCognome(ut.getCognome());
		dto.setIndirizzo(ut.getIndirizzo());
		dto.setId_account(ac.getId());
		String out2=g.toJson(dto, UtenteDTO.class);
		HttpURLConnection conn2 = httprequest.HTTPSENDJSON(url2, out2,"PUT");
		String result1 = httprequest.HTTPREADJSON(conn2);		
		conn2.disconnect();
		
		return "login"; //login.xhtml	
	}
	public String findUtenteForName(Utente ut) {
	//	userCr.cercautenteperNome(ut);
		return "boooooh"; //non ne ho idea!
	}
	
	public String findUtenteForId(Utente ut) {
	//	userCr.cercautenteperid(ut);
		return "i have not idea"; //!!!!!!
	}

	public void onload(Account a) throws IOException {//metodo generico per richiamare ogni volta DAL DATABASE i dati dell'utenza a partire dal proiprio ID account!
		this.ac=a;
		Universal_HTTPREQUEST httprequest = new Universal_HTTPREQUEST();
		String percorso= "http://localhost:8080/ModuloWebClientNuovo/rest/clientela/prendiutenteperid_account/"+ac.getId()+"";
		Gson g = new Gson();
		String out="";
		HttpURLConnection con=httprequest.HTTPSENDJSON(percorso, out, "PUT");
		String response=httprequest.HTTPREADJSON(con);
		this.ut=g.fromJson(response, Utente.class);
	}
      
      
      
	public UtenteBean() {
		
	}
	  

}
