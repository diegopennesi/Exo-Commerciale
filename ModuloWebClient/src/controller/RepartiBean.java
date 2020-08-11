package controller;

import javax.faces.bean.ManagedBean;

import ejb_repartiCrud.RepartiEJB;
import model.Reparti;

@SuppressWarnings("deprecation")
@ManagedBean(name="repartibean",eager=true)
public class RepartiBean {
	
	private Reparti rep = new Reparti();
	
	private RepartiEJB rpj = new RepartiEJB();
	
	

	public RepartiEJB getRpj() {
		return rpj;
	}

	public void setRpj(RepartiEJB rpj) {
		this.rpj = rpj;
	}

	public Reparti getRep() {
		return rep;
	}

	public void setRep(Reparti rep) {
		this.rep = rep;
	}
	
	public String prendiReparti() {
		
		rpj.prendiReparti();
		
		return "eh nooo soo oh";
	}
	
	

}
