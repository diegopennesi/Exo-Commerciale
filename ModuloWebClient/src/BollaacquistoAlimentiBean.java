

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.BollaacquistoAlimenti;

@SuppressWarnings("deprecation")
@ManagedBean(name="bollaacquistoalimentibean",eager=true)
@SessionScoped
public class BollaacquistoAlimentiBean {
	
	private BollaacquistoAlimenti bollaalimenti = new BollaacquistoAlimenti();

	public BollaacquistoAlimenti getBollaalimenti() {
		return bollaalimenti;
	}

	public void setBollaalimenti(BollaacquistoAlimenti bollaalimenti) {
		this.bollaalimenti = bollaalimenti;
	}
	
	

}
