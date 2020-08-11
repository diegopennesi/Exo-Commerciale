

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Utente;

@SuppressWarnings("deprecation")
@ManagedBean(name="utentebean",eager=true)
@SessionScoped
public class UtenteBean {
	
    private Utente ut = new Utente();

	public Utente getUt() {
		return ut;
	}

	public void setUt(Utente ut) {
		this.ut = ut;
	}
	
	public String login(){
		
		return "";
		
	}
      
      
      
      
	
	  

}
