package controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.Alimentari;

@SuppressWarnings("deprecation")
@ManagedBean(name="alimentaribean",eager=true)
@SessionScoped
public class AlimentariBean {
	
	private Alimentari alimentari = new Alimentari();

	public Alimentari getAlimentari() {
		return alimentari;
	}

	public void setAlimentari(Alimentari alimentari) {
		this.alimentari = alimentari;
	}
	
	
	

}
