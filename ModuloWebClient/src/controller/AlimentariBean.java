package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb_alimentariCrud.AlimentariEJB;
import model.Alimentari;
import model.BollaacquistoAlimenti;

@SuppressWarnings("deprecation")
@ManagedBean(name="alimentaribean",eager=true)
@SessionScoped
public class AlimentariBean {
	
	private Alimentari alimentari = new Alimentari();
	
	private AlimentariEJB alj = new AlimentariEJB();
	
	private BollaacquistoAlimenti bolla = new BollaacquistoAlimenti();
	
	

	public BollaacquistoAlimenti getBolla() {
		return bolla;
	}

	public void setBolla(BollaacquistoAlimenti bolla) {
		this.bolla = bolla;
	}

	public AlimentariEJB getAlj() {
		return alj;
	}

	public void setAlj(AlimentariEJB alj) {
		this.alj = alj;
	}

	public Alimentari getAlimentari() {
		return alimentari;
	}

	public void setAlimentari(Alimentari alimentari) {
		this.alimentari = alimentari;
	}
	
	public String inseriscialimento(Alimentari alimentari) {
		
		alj.inseriscialimento(alimentari);
		
		return "";
	}
	
	public String cancellaalimento(Alimentari alimentari) {
		
		alj.cancellaalimento(alimentari);
		
		return "";
	}
	
	public String modificaalimento(Alimentari alimentari) {
		
		alj.modificaalimento(alimentari);
		
		return "";
	}
	
	public String cercaalimentoperid(Alimentari alimentari) {
		
		alj.cercaalimentoperid(alimentari);
		
		return "";
	}
	
	public String inseriscbolla() {
		
		alj.inseriscibolla(bolla);
		
		return "";
	}
	
	public String prendiLista() {
		
		alj.prendiLista();
		
		return "";
	}
	
	
	
	
	

}
