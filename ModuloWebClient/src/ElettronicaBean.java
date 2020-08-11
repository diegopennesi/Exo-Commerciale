

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Elettronica;

@SuppressWarnings("deprecation")
@ManagedBean(name="elettronicabean",eager=true)
@SessionScoped
public class ElettronicaBean {
	
	private Elettronica elettronica = new Elettronica();

	public Elettronica getElettronica() {
		return elettronica;
	}

	public void setElettronica(Elettronica elettronica) {
		this.elettronica = elettronica;
	}
	
	
	
	

}
