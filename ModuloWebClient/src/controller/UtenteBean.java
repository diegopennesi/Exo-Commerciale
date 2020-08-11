package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb_utenteCrud.UtentiEJB;
import model.Utente;

@SuppressWarnings("deprecation")
@ManagedBean(name="utentebean",eager=true)
@SessionScoped
public class UtenteBean {
	
    private Utente ut = new Utente();
    
    private UtentiEJB utj = new UtentiEJB();
    
    

	public UtentiEJB getUtj() {
		return utj;
	}

	public void setUtj(UtentiEJB utj) {
		this.utj = utj;
	}

	public Utente getUt() {
		return ut;
	}

	public void setUt(Utente ut) {
		this.ut = ut;
	}
	
	public String registrazione(Utente ut) {
		
		if(ut != null) {
		
		utj.inserisciutente(ut);
		
		return "login"; //login.xhtml
		
		}else {
		
		return "error"; //error.xhtml
		
		}
	}
	
	
	public String deleteUtente(Utente ut) {
		
		utj.cancellautente(ut);
		
		return "cancella";//utente-modifica
		
		
		
	}
	
	public String modificaUt(Utente ut) {
		
		
		utj.modificautente(ut);
		
		return "login"; //login.xhtml
		
	}
	
	
	public String findUtenteForName(Utente ut) {
		
		utj.cercautenteperNome(ut);
		
		return "boooooh"; //non ne ho idea!
		
	}
	
	public String findUtenteForId(Utente ut) {
		
		utj.cercautenteperid(ut);
		
		return "i have not idea"; //!!!!!!
	}
      
      
      
      
	
	  

}
