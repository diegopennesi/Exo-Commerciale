package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb_elettronicaCrud.ElettronicaEJB;
import model.BollaacquistoElettronica;
import model.Elettronica;

@SuppressWarnings("deprecation")
@ManagedBean(name="elettronicabean",eager=true)
@SessionScoped
public class ElettronicaBean {
	
	private Elettronica elettronica = new Elettronica();
	
	private ElettronicaEJB elj = new ElettronicaEJB();
	
	private BollaacquistoElettronica bolla = new BollaacquistoElettronica();
	
	

	public BollaacquistoElettronica getBolla() {
		return bolla;
	}

	public void setBolla(BollaacquistoElettronica bolla) {
		this.bolla = bolla;
	}

	public ElettronicaEJB getElj() {
		return elj;
	}

	public void setElj(ElettronicaEJB elj) {
		this.elj = elj;
	}

	public Elettronica getElettronica() {
		return elettronica;
	}

	public void setElettronica(Elettronica elettronica) {
		this.elettronica = elettronica;
	}
	
	public String inseriscielettronica(Elettronica elettronica) {
		
		elj.inseriscielettronica(elettronica);
		
		return "";
	}
	
	public String cancellaelettronica(Elettronica elettronica) {
		
		elj.cancellaelettronica(elettronica);
		
		return "";
	}
	
	public String modificaelettronica(Elettronica elettronica) {
		
		elj.modificaelettronica(elettronica);
		
		return "";
	}
	
	public String cercaelettronicaperid(Elettronica elettronica) {
		
		elj.cercaelettronicaperid(elettronica);
		
		return "";
	}
	
	public String inseriscibolla(BollaacquistoElettronica bolla) {
		
		elj.inseriscibolla(bolla);
		
		return "";
	}
	
	public String prendiLista() {
		
		elj.prendilista();
		
		return "";
	}
	
	
	
	
	
	

}
