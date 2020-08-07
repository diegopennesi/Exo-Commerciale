package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.BollaacquistoAbbigliamento;

@SuppressWarnings("deprecation")
@ManagedBean(name="bollaacquistabbigliamentobean",eager=true)
@SessionScoped
public class BollaacquistoAbbigliamentoBean {
	
	private BollaacquistoAbbigliamento bollaabbigliamento = new BollaacquistoAbbigliamento();

	public BollaacquistoAbbigliamento getBollaabbigliamento() {
		return bollaabbigliamento;
	}

	public void setBollaabbigliamento(BollaacquistoAbbigliamento bollaabbigliamento) {
		this.bollaabbigliamento = bollaabbigliamento;
	}
	
	

}
