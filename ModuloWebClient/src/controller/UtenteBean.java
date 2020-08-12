package controller;

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
	
	public String registrazione(Utente ut,Account ac) {
		
		if(ut != null&&ac!=null) {
		
		userCr.inserisciutente(ut);
		accCr.inserisciAccount(ac);
		
		return "login"; //login.xhtml
		
		}else {
		
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
