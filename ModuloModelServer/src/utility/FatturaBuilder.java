package utility;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import ejb_repartiCrud.Ireparti;
import model.Abbigliamento;
import model.Account;
import model.Alimentari;
import model.Elettronica;
import model.Fattura;
import model.Reparti;

@Stateless
public class FatturaBuilder {
	@EJB
	Ireparti x;
	
	public Fattura fatturaBuilderAlimentari(Account a,Alimentari s,int id_scontrino,int iva,Reparti reparto) {
		Fattura fattura = new Fattura();
		fattura.setId_scontrino(id_scontrino);
		fattura.setDescrizione(s.getDescrizione());
		fattura.setQuantita(s.getQuantita());
		fattura.setAccount(a);
		fattura.setPrezzo(s.getPrezzo());
		fattura.setIva(iva);
		fattura.setReparti(reparto);
		return fattura;
	}
	public Fattura fatturaBuilderAbbigliamento(Account a,Abbigliamento s,int id_scontrino,int iva,Reparti reparto) {
		Fattura fattura = new Fattura();
		fattura.setId_scontrino(id_scontrino);
		fattura.setDescrizione(s.getDescrizione());
		fattura.setQuantita(s.getQuantita());
		fattura.setAccount(a);
		fattura.setPrezzo(s.getPrezzo());
		fattura.setIva(iva);
		fattura.setReparti(reparto);
		return fattura;
	}
	public Fattura fatturaBuilderElettronica(Account a,Elettronica s,int id_scontrino,int iva,Reparti reparto) {
		Fattura fattura = new Fattura();
		fattura.setId_scontrino(id_scontrino);
		fattura.setDescrizione(s.getDescrizione());
		fattura.setQuantita(s.getQuantita());
		fattura.setAccount(a);
		fattura.setPrezzo(s.getPrezzo());
		fattura.setIva(iva);
		fattura.setReparti(reparto);
		return fattura;
	}

}
