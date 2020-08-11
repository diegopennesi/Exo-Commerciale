package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb_abbigliamentoCrud.AbbigliamentoEJB;
import model.Abbigliamento;
import model.BollaacquistoAbbigliamento;

@SuppressWarnings("deprecation")
@ManagedBean(name="abbigliamento", eager=true)
@SessionScoped
public class AbbigliamentoBean {
	
	private Abbigliamento abbigliamento = new Abbigliamento();
	
	private AbbigliamentoEJB abj = new AbbigliamentoEJB();
	
	private BollaacquistoAbbigliamento bolla = new BollaacquistoAbbigliamento();
	
	
	
	public BollaacquistoAbbigliamento getBolla() {
		return bolla;
	}

	public void setBolla(BollaacquistoAbbigliamento bolla) {
		this.bolla = bolla;
	}

	public AbbigliamentoEJB getAbj() {
		return abj;
	}

	public void setAbj(AbbigliamentoEJB abj) {
		this.abj = abj;
	}

	public Abbigliamento getAbbigliamento() {
		return abbigliamento;
	}

	public void setAbbigliamento(Abbigliamento abbigliamento) {
		this.abbigliamento = abbigliamento;
	}
	
	
	public String inserisciabbigliamento(Abbigliamento abbigliamento) {
		
		abj.inserisciabbigliamento(abbigliamento);
		
		return "";
	}
	
	public String cancellaabbigliamento(Abbigliamento abbigliamento) {
		
		abj.cancellaabbigliamento(abbigliamento);
		
		return "";
	}
	
	public String modificaabbigliamento(Abbigliamento abbigliamento) {
		
		abj.modificaabbigliamento(abbigliamento);
		
		return "";
		
	}
	
	public String cercaabbigliamentoperid(Abbigliamento abbigliamento) {
		
		abj.cercaabbigliamentoperid(abbigliamento);
		
		return "";
	}
	
	public String inseriscibolla(BollaacquistoAbbigliamento bolla) {
		
		abj.inseriscibolla(bolla);
		
		return "";
	}
	
	public String prendiLista() {
		
		abj.prendiLista();
		
		return "";
	}
	
	

}
