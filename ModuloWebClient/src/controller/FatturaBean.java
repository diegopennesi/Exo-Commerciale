package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb_fatturaCrud.FatturaEJB;
import model.Account;
import model.Fattura;

@SuppressWarnings("deprecation")
@ManagedBean(name="fatturabean",eager=true)
@SessionScoped
public class FatturaBean {
	
	private Fattura fattura = new Fattura();
	
	private FatturaEJB fj = new FatturaEJB();
	
	

	public FatturaEJB getFj() {
		return fj;
	}

	public void setFj(FatturaEJB fj) {
		this.fj = fj;
	}

	public Fattura getFattura() {
		return fattura;
	}

	public void setFattura(Fattura fattura) {
		this.fattura = fattura;
	}
	
	
	public String inserisciFattura(Fattura fattura) {
		
		fj.inseriscifattura(fattura);
		
		return "";
	}
	
	public String cercafatturaperId(Fattura fattura) {
		
		fj.cercafatturaperId(fattura);
		
		return "";
	}
	
	public String cercafatturaperIdUtente(Account a) {
		
		fj.cercafatturaperIdUtente(a);
		
		return "";
	}
	
	public String cancellaFattura(Fattura fattura) {
		
		fj.cancellafattura(fattura);
		
		return "";
	}
	
	

}
