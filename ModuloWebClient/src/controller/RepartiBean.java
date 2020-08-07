package controller;

import javax.faces.bean.ManagedBean;

import model.Reparti;

@SuppressWarnings("deprecation")
@ManagedBean(name="repartibean",eager=true)
public class RepartiBean {
	
	private Reparti rep = new Reparti();

	public Reparti getRep() {
		return rep;
	}

	public void setRep(Reparti rep) {
		this.rep = rep;
	}
	
	

}
