package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import ejb_bollaCrud.BollaCRUD;
import model.BollaacquistoAbbigliamento;

@SuppressWarnings("deprecation")
@ManagedBean(name="bollaacquistabbigliamentobean",eager=true)
@SessionScoped
public class BollaacquistoAbbigliamentoBean {
	
	private BollaacquistoAbbigliamento bollaabbigliamento = new BollaacquistoAbbigliamento();
	
	private BollaCRUD blc = new BollaCRUD();
	
	

	public BollaCRUD getBlc() {
		return blc;
	}

	public void setBlc(BollaCRUD blc) {
		this.blc = blc;
	}

	public BollaacquistoAbbigliamento getBollaabbigliamento() {
		return bollaabbigliamento;
	}

	public void setBollaabbigliamento(BollaacquistoAbbigliamento bollaabbigliamento) {
		this.bollaabbigliamento = bollaabbigliamento;
	}
	
	public String prendiListaBolleAbbigliamento() {
		
		blc.prendiListaBolleAbbigliamento();
		
		return "";
	}

}
