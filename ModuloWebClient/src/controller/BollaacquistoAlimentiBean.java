package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb_bollaCrud.BollaCRUD;
import model.BollaacquistoAlimenti;

@SuppressWarnings("deprecation")
@ManagedBean(name="bollaacquistoalimentibean",eager=true)
@SessionScoped
public class BollaacquistoAlimentiBean {
	
	private BollaacquistoAlimenti bollaalimenti = new BollaacquistoAlimenti();
 
	private BollaCRUD blc = new BollaCRUD();
	
	
	
	public BollaCRUD getBlc() {
		return blc;
	}

	public void setBlc(BollaCRUD blc) {
		this.blc = blc;
	}

	public BollaacquistoAlimenti getBollaalimenti() {
		return bollaalimenti;
	}

	public void setBollaalimenti(BollaacquistoAlimenti bollaalimenti) {
		this.bollaalimenti = bollaalimenti;
	}
	
	public String prendiListaBolleAlimenti() {
		
		blc.prendiListaBolleAlimenti();
		
		return "";
	}

}
