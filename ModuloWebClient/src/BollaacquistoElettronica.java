

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@SuppressWarnings("deprecation")
@ManagedBean(name="bollaacquistoelettronicabean",eager=true)
@SessionScoped
public class BollaacquistoElettronica {
	
	private BollaacquistoElettronica bollaelettronica = new BollaacquistoElettronica();

	public BollaacquistoElettronica getBollaelettronica() {
		return bollaelettronica;
	}

	public void setBollaelettronica(BollaacquistoElettronica bollaelettronica) {
		this.bollaelettronica = bollaelettronica;
	}
	
	

}
