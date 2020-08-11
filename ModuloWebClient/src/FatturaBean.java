

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Fattura;

@SuppressWarnings("deprecation")
@ManagedBean(name="fatturabean",eager=true)
@SessionScoped
public class FatturaBean {
	
	private Fattura fattura = new Fattura();

	public Fattura getFattura() {
		return fattura;
	}

	public void setFattura(Fattura fattura) {
		this.fattura = fattura;
	}
	
	

}
