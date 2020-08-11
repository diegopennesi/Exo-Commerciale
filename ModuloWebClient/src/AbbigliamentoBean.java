

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Abbigliamento;

@SuppressWarnings("deprecation")
@ManagedBean(name="abbigliamento", eager=true)
@SessionScoped
public class AbbigliamentoBean {
	
	private Abbigliamento abbigliamento = new Abbigliamento();

	public Abbigliamento getAbbigliamento() {
		return abbigliamento;
	}

	public void setAbbigliamento(Abbigliamento abbigliamento) {
		this.abbigliamento = abbigliamento;
	}
	
	

}
