package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb_bollaCrud.BollaCRUD;

@SuppressWarnings("deprecation")
@ManagedBean(name="bollaacquistoelettronicabean",eager=true)
@SessionScoped
public class BollaacquistoElettronica {
	
	private BollaacquistoElettronica bollaelettronica = new BollaacquistoElettronica();
    
	private BollaCRUD blc = new BollaCRUD();
	
	public BollaCRUD getBlc() {
		return blc;
	}

	public void setBlc(BollaCRUD blc) {
		this.blc = blc;
	}

	public BollaacquistoElettronica getBollaelettronica() {
		return bollaelettronica;
	}

	public void setBollaelettronica(BollaacquistoElettronica bollaelettronica) {
		this.bollaelettronica = bollaelettronica;
	}
	
	public String prendiListaBolleElettronica() {
		
		blc.prendiListaBolleElettronica();
		
		return "";
	}
	
	

}
